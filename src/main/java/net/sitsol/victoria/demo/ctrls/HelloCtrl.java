/**
 *
 */
package net.sitsol.victoria.demo.ctrls;

import net.sitsol.victoria.log4j.VctLogger;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author shibano
 */
@Controller
@RequestMapping("/hello")
public class HelloCtrl {

	@RequestMapping(value = "/world.do", method = RequestMethod.GET)
	public String world(Model model) {

		VctLogger.getLogger().info("HelloController-world.doメソッド実行開始");

//		String msg = VctMessageResource.getMessage("errors.orver", "スイカ", "2つ");
//		VctLogger.getLogger().info(" -> メッセージ取得テスト：[" + msg + "]");
//		
//		String usMsg = VctMessageResource.getMessage(Locale.US, "errors.orver", "SUIKA", "2");
//		VctLogger.getLogger().info(" -> USメッセージ取得テスト：[" + usMsg + "]");
//		
//		String koMsg = VctMessageResource.getMessage(Locale.KOREA, "errors.orver", "SUIKA", "2");
//		VctLogger.getLogger().info(" -> KOメッセージ取得テスト：[" + koMsg + "]");
//		
//		msg = VctMessageResource.getMessage(null, null, null);
//		VctLogger.getLogger().info(" -> エラーメッセージ(ロケ無し)取得テスト：[" + msg + "]");
//		
//		msg = VctMessageResource.getMessage(Locale.JAPAN, null, "SUIKA", "2");
//		VctLogger.getLogger().info(" -> JPエラーメッセージ(キー無し)取得テスト：[" + msg + "]");
//		
//		msg = VctMessageResource.getMessage(Locale.JAPAN, "errors.orver", null);
//		VctLogger.getLogger().info(" -> JPエラーメッセージ(置換文字列不足)取得テスト：[" + msg + "]");
//		
//		msg = VctMessageResource.getMessage(Locale.JAPAN, "errors.orver", "SUIKA", "2", "err");
//		VctLogger.getLogger().info(" -> JPエラーメッセージ(置換文字列過剰)取得テスト：[" + msg + "]");
		
		// vmのファイルパス(拡張子なし)を返す
		return "helloworld";
	}

}
