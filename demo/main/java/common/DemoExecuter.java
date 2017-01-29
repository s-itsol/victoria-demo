/**
 *
 */
package common;

import org.apache.commons.lang.StringUtils;

import net.sitsol.victoria.demo.configs.DemoStaticApParam;
import net.sitsol.victoria.demo.models.userinfo.DemoLoginUserInfo;
import net.sitsol.victoria.log4j.VctLogger;
import net.sitsol.victoria.models.userinfo.IUserInfo;
import net.sitsol.victoria.spring.VctBeanFactory;
import net.sitsol.victoria.threadlocals.ThreadLog4jNdc;
import net.sitsol.victoria.threadlocals.ThreadUserInfo;

/**
 * デモ用-コマンドライン実行クラス
 *
 * @author shibano
 */
public class DemoExecuter {

	/**
	 * メソッド実行要求
	 *  共通処理制御を行って各デモメソッドを実行する
	 */
	public static void doExecute(IDemo demoExecute, boolean isApContextInitMode, String[] args) {

		// ログ初期処理 ※実行結果が確認できないので常に実行される
		VctLogger.initialize();

		String userId		= StringUtils.EMPTY;			// ユーザーID
		String userName		= StringUtils.EMPTY;			// ユーザー名

		// アプリケーション・コンテキスト初期処理実行モードの場合
		if ( isApContextInitMode ) {
			// アプリケーション・コンテキスト初期処理
			VctBeanFactory.initialize();
			// デモ環境用-ユーザーID・ユーザー名は静的パラメータの値を使う
			userId		= DemoStaticApParam.getInstance().getDemoUserId();
			userName	= DemoStaticApParam.getInstance().getDemoUserName();
		}

		// デモ用-ログインユーザー情報生成
		IUserInfo loginUserInfo = new DemoLoginUserInfo(userId, userName);

		VctLogger.getLogger().info("▼▼▼開始▼▼▼");

		// ※try-with-resourceコーディングにて、スレッド毎の共通情報を使えるようにする
		try ( ThreadLog4jNdc threadLog4jNdc = new ThreadLog4jNdc(userId);
				ThreadUserInfo threadUserInfo = new ThreadUserInfo(loginUserInfo);
		) {
			// 各デモメソッド実行
			demoExecute.execute(args);

		} catch (Exception ex) {
			VctLogger.getLogger().error("エラーあり", ex);

		} finally {
			VctLogger.getLogger().info("▲▲▲終了▲▲▲");
		}
	}

}
