/**
 *
 */
package net.sitsol.victoria.demo.ctrls;

import net.sitsol.victoria.log4j.VctLogger;
import net.sitsol.victoria.messages.VctMessage;

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

		String msg = VctMessage.getMessage("errors.orver", "スイカ", "2つ");
		VctLogger.getLogger().info(" -> メッセージ取得テスト：[" + msg + "]");
		
		// vmのファイルパス(拡張子なし)を返す
		return "helloworld";
	}

}
