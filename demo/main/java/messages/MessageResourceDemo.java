/**
 *
 */
package messages;

import java.util.Locale;

import demotools.BsDemoExecute;
import net.sitsol.victoria.log4j.VctLogger;
import net.sitsol.victoria.messages.VctMessageResource;

/**
 * メッセージリソースクラス-プログラミング使用例
 *
 * @author shibano
 */
public class MessageResourceDemo extends BsDemoExecute {

	/**
	 * メインメソッド
	 * @param args
	 */
	public static void main(String[] args) {
		// メソッド実行要求
		BsDemoExecute.doExecute(new MessageResourceDemo(), true, args);
	}

	/**
	 * メッセージリソーステスト
	 */
	@Override
	public void execute(String[] args) {

		// メッセージリソース初期処理
		VctMessageResource.initialize(Locale.JAPAN);
		VctMessageResource.initialize(Locale.US);

		// メッセージ取得
		String msg = VctMessageResource.getInstance().getMessage("errors.orver", "スイカ", "2つ");
		VctLogger.getLogger().info(" -> ●デフォルトロケーション-メッセージ取得テスト：[" + msg + "]");

		String usMsg = VctMessageResource.getInstance().getMessage(Locale.US, "errors.orver", "SUIKA", "2");
		VctLogger.getLogger().info(" -> ●USメッセージ取得テスト：[" + usMsg + "]");

		VctLogger.getLogger().info("＞＞＞ ここからはメッセージ取得実装を間違えた場合のフェールセーフ動作確認");

		String koMsg = VctMessageResource.getInstance().getMessage(Locale.KOREA, "errors.orver", "SUIKA", 2);
		VctLogger.getLogger().info(" -> ★KOメッセージ取得テスト：[" + koMsg + "]");

		Locale nullLocale = null;
		msg = VctMessageResource.getInstance().getMessage(nullLocale, null);
		VctLogger.getLogger().info(" -> ★エラーメッセージ(ロケ無し)取得テスト：[" + msg + "]");

		msg = VctMessageResource.getInstance().getMessage(Locale.JAPAN, null, "SUIKA", 2);
		VctLogger.getLogger().info(" -> ★JPエラーメッセージ(キー無し)取得テスト：[" + msg + "]");

		msg = VctMessageResource.getInstance().getMessage(Locale.JAPAN, "errors.orver");
		VctLogger.getLogger().info(" -> ★JPエラーメッセージ(置換文字列不足)取得テスト：[" + msg + "]");

		msg = VctMessageResource.getInstance().getMessage(Locale.JAPAN, "errors.orver", "SUIKA", 2, "err");
		VctLogger.getLogger().info(" -> ★JPエラーメッセージ(置換文字列過剰)取得テスト：[" + msg + "]");

	}


}
