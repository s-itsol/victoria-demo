/**
 *
 */

package threads;
import common.DemoExecuter;
import common.IDemo;
import net.sitsol.victoria.exceptions.VctRuntimeException;
import net.sitsol.victoria.log4j.VctLogger;
import net.sitsol.victoria.utils.threads.SimpleMultiThreadExecuter;


/**
 * マルチスレッド実行支援クラス-プログラミング使用例
 *
 * @author shibano
 */
public class MultiThreadExecuterDemo implements IDemo {

	/**
	 * 動作検証用スレッドパラメータ
	 */
	private class ThreadParam {

		private int seqNo = Integer.MAX_VALUE;

		public ThreadParam(int seqNo) {
			this.seqNo = seqNo;
		}

		public int getSeqNo() {
			return seqNo;
		}

	}

	/**
	 * メインメソッド
	 * @param args
	 */
	public static void main(String[] args) {
		// メソッド実行要求
		DemoExecuter.doExecute(new MultiThreadExecuterDemo(), true, args);
	}

	/**
	 * 簡易版マルチスレッドテスト
	 */
	@Override
	public void execute(String[] args) {

		final int count = 100;					// 総処理数
		final int threadCount = 10;			// 並列スレッド数

		final Boolean[] retSts = {null};		// 最終的な実行ステータス
		final boolean[] dummyFlgs = {true};

		try(
			// マルチスレッド実行支援クラス生成
				SimpleMultiThreadExecuter<ThreadParam> multiThreadExecuter = new SimpleMultiThreadExecuter<ThreadParam>(threadCount, "マルチスレッド-デモ") {

				/**
				 * スレッド実行処理コールバック
				 * @param threadNo スレッド番号
				 * @param executeParam スレッド実行パラメータ
				 */
				@Override
				protected void doWokerThreadExecute(int threadNo, ThreadParam executeParam) {

					// ※ここで並列実行させる各スレッド処理を実装する

					// あえて、スレッドNo3の1回目だけ例外を発生させてみる ※他のスレッドは継続しつつ「エラーあり」のハンドリングを確認できる
					if ( threadNo == 3 && dummyFlgs[0] ) {
						// 2回目以降は実行しないよう、フラグOFF
						dummyFlgs[0] = false;
						try {
							// ※インデックス範囲外例外が発生する処理
							VctLogger.getLogger().info(dummyFlgs[1]);
						} catch ( Exception ex ) {
							throw new VctRuntimeException("コールバックされたアプリ側での処理でエラー発生！", ex);
						}
					}

					// あえて、スレッド番号が偶数なら100ms待たせる ※偶数スレッドは待機する分、実行件数が少なくなることを確認できる
					if ( threadNo % 2 == 0 ) {
						try {
							Thread.sleep(100);

						} catch ( Exception ex ) {
							new VctRuntimeException("スレッドスリープエラー", ex);
						}
					}

					// 各スレッド側でログ出力
					VctLogger.getLogger().info("コールバックされたアプリ側での処理 スレッド番号：[" + threadNo + "]"
													+ ", 処理連番：[" + executeParam.getSeqNo() + "／" + count + "]"
												);
				}

				/**
				 * 全スレッド実行完了イベント通知
				 * @param totalExecCount 処理実行件数
				 * @param totalErrorCount エラー件数
				 */
				@Override
				protected void noticeAllThreadCompleted(int totalExecCount, int totalErrorCount) {

					// ※ここで全ての並列実行が終わった後のエラーハンドリングなどを実装する

					// 実行ステータス判定 ※エラー0件以下なら「成功」、それ以外は「エラーあり」
					boolean sts = ( totalErrorCount <= 0 );
					retSts[0] = sts;

					// 完了イベント通知ログ出力
					VctLogger.getLogger().info("全スレッド実行完了イベント通知あり - 実行結果：[" + sts + "]");
				}

			}
		) {
			// 実行回数ループ
			for ( int idx = 0; idx < count; idx++ ) {
				// スレッドパラメータ生成＆スレッド実行要求
				multiThreadExecuter.requestExecute( new ThreadParam(idx) );
			}

			VctLogger.getLogger().info("全スレッド実行要求終了");
		}

		// ※全ての並列スレッド実行が完了してから処理される
		VctLogger.getLogger().info("同期型分散処理-全スレッド実行完了 - 実行結果：[" + retSts[0] + "] ※バッチアプリなら「エラーあり」のリターンを返す");
	}

}
