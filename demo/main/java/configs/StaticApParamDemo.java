/**
 *
 */

package configs;
import demotools.BsDemoExecute;
import net.sitsol.victoria.configs.VctStaticApParam;
import net.sitsol.victoria.demo.configs.DemoStaticApParam;
import net.sitsol.victoria.log4j.VctLogger;
import net.sitsol.victoria.utils.statics.VctBeanUtils;


/**
 * 静的アプリケーション・パラメータクラス-プログラミング使用例
 *
 * @author shibano
 */
public class StaticApParamDemo extends BsDemoExecute {

	/**
	 * メインメソッド
	 * @param args
	 */
	public static void main(String[] args) {
		// メソッド実行要求
		BsDemoExecute.doExecute(new StaticApParamDemo(), true, args);
	}

	/**
	 * 静的APパラメータテスト
	 */
	@Override
	public void execute(String[] args) {

		VctLogger.getLogger().info("");
		VctLogger.getLogger().info("---静的APパラメータ有効値確認");
		VctLogger.getLogger().info("警告SQL実行時間 ：[" + DemoStaticApParam.getInstance().getWarningSqlExecuteMillis() + "](ms) ※デフォルト値そのままなパラメータ値");
		VctLogger.getLogger().info("環境名          ：[" + DemoStaticApParam.getInstance().getDispEnvName() + "] ※デモ環境で上書きしたパラメータ値");
		VctLogger.getLogger().info("デモ用ユーザーID：[" + DemoStaticApParam.getInstance().getDemoUserId() + "] ※デモ環境独自のパラメータ値");
		VctLogger.getLogger().info("");

		// アプリケーション・パラメータ読込み内容の全ログ出力
		VctBeanUtils.writePropertiesInfoLog(VctStaticApParam.getInstance());
	}

}
