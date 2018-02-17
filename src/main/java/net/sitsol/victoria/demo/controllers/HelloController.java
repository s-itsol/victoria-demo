/**
 *
 */
package net.sitsol.victoria.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.sitsol.victoria.demo.consts.DemoUrlPathConst;
import net.sitsol.victoria.log4j.VctLogger;

/**
 * お試しコントローラ
 *
 * @author shibano
 */
@Controller
@RequestMapping(DemoUrlPathConst.Root.DIR)
public class HelloController extends BsDemoController {

	@RequestMapping(value = DemoUrlPathConst.WORLD_DO, method = RequestMethod.GET)
	public String world(Model model) {
		
		VctLogger.getLogger().info("HelloController-world.doメソッドが実行されました。");
		
		// vmのファイルパスへフォワード
		return DemoUrlPathConst.HELLOWORLD_VM;
	}

}
