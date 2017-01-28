/**
 *
 */

package threads;
import org.apache.log4j.NDC;

import net.sitsol.victoria.configs.VctInitApParam;
import net.sitsol.victoria.demo.models.userinfo.DemoLoginUserInfo;
import net.sitsol.victoria.exceptions.VctRuntimeException;
import net.sitsol.victoria.log4j.VctLogger;
import net.sitsol.victoria.spring.VctBeanFactory;
import net.sitsol.victoria.threadlocals.ThreadUserInfo;
import net.sitsol.victoria.utils.statics.VctBeanUtils;
import net.sitsol.victoria.utils.threads.SimpleMultiThreadExecuter;


/**
 * マルチスレッド実行支援クラス-プログラミング使用例
 *
 * @author shibano
 */
public class MultiThreadExecuterDemo {

	/**
	 * メインメソッド
	 * @param args
	 */
	public static void main(String[] args) {

		// ログ初期処理
		VctLogger.initialize();
		// ビーンファクトリー初期処理
		VctBeanFactory.initialize();
		// アプリケーション・パラメータ読込み内容のログ出力
		VctBeanUtils.writePropertiesInfoLog(VctInitApParam.getInstance());

		DemoLoginUserInfo loginUserInfo = new DemoLoginUserInfo("demo-user", "デモユーザー");
		NDC.push(loginUserInfo.getUserId());

		VctLogger.getLogger().info("▼▼▼開始▼▼▼");

		try ( ThreadUserInfo threadUserInfo = new ThreadUserInfo(loginUserInfo) ) {
			// 簡易版マルチスレッドテスト
			simpleMurtiThreadTest();

		} catch (Exception ex) {
			VctLogger.getLogger().error("エラーあり", ex);

		} finally {
			VctLogger.getLogger().info("▲▲▲終了▲▲▲");
			NDC.remove();
		}

	}

	/**
	 * 簡易版マルチスレッドテスト
	 */
	private static void simpleMurtiThreadTest() {

		/**
		 * 動作検証用スレッドパラメータ
		 */
		class ThreadParam {

			private int seqNo = Integer.MAX_VALUE;

			public ThreadParam(int seqNo) {
				this.seqNo = seqNo;
			}

			public int getSeqNo() {
				return seqNo;
			}

		}

		final int count = 100;				// 総処理数
		final int threadCount = 10;		// 並列スレッド数

		try(
			// マルチスレッド実行支援クラス生成
			SimpleMultiThreadExecuter<ThreadParam> multiThreadExecuter = new SimpleMultiThreadExecuter<ThreadParam>(threadCount) {

				/**
				 * スレッド実行処理コールバック
				 * @param threadNo スレッド番号
				 * @param executeParam スレッド実行パラメータ
				 */
				@Override
				protected void doWokerThreadExecute(int threadNo, ThreadParam executeParam) {

					// スレッド番号が偶数なら100ms待つ
					if ( threadNo % 2 == 0 ) {
						try {
							Thread.sleep(100);

						} catch ( Exception ex ) {
							new VctRuntimeException("スレッドスリープエラー", ex);
						}
					}

					// 各スレッド側でログ出力
					VctLogger.getLogger().info(	"スレッド実行 スレッド番号：[" + threadNo + "]"
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
					// 完了イベント通知ログ出力
					VctLogger.getLogger().info("全スレッド実行完了イベント通知あり");
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
	}

}
