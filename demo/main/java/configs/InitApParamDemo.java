/**
 *
 */

package configs;
import net.sitsol.victoria.configs.VctInitApParam;
import net.sitsol.victoria.demo.configs.DemoInitApParam;
import net.sitsol.victoria.log4j.VctLogger;
import net.sitsol.victoria.spring.VctBeanFactory;
import net.sitsol.victoria.utils.VctStopWatch;
import net.sitsol.victoria.utils.statics.VctBeanUtils;


/**
 * アプリケーション・パラメータクラス-プログラミング使用例
 *
 * @author shibano
 */
public class InitApParamDemo {

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

		VctLogger.getLogger().info("▼▼▼開始▼▼▼");

		try {
			// APパラメータ性能テスト
			apInitParamTest();

		} catch (Exception ex) {
			VctLogger.getLogger().error("エラーあり", ex);
		} finally {
			VctLogger.getLogger().info("▲▲▲終了▲▲▲");
		}

	}

	/**
	 * APパラメータ性能テスト
	 */
	private static void apInitParamTest() {

		int maxCnt = 100;

		{
			VctStopWatch stopWatch = new VctStopWatch("APパラメータ処理", true);

			for (int cnt = 0; cnt < maxCnt; cnt++) {

				int viewCnt = cnt + 1;

				String envName = DemoInitApParam.getInstance().getDispEnvName();

				VctLogger.getLogger().info(viewCnt + "回目" + envName);

				stopWatch.countUp();
			}

			stopWatch.stopAndOutputLog();
		}

	}

}
