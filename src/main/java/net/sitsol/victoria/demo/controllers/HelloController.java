/**
 *
 */
package net.sitsol.victoria.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.sitsol.victoria.controllers.VctController;
import net.sitsol.victoria.demo.consts.DemoUrlPathConst;
import net.sitsol.victoria.log4j.VctLogger;

/**
 *
 * @author shibano
 */
@Controller
@RequestMapping(DemoUrlPathConst.Root.Hello.DIR)
public class HelloController extends VctController {

	@RequestMapping(value = DemoUrlPathConst.WORLD_DO, method = RequestMethod.GET)
	public String world(Model model) {
		
		VctLogger.getLogger().info("HelloController-world.doメソッド実行開始");
		
		// vmのファイルパスへフォワード
		return DemoUrlPathConst.HELLOWORLD_VM;
	}

}
