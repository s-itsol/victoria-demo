/**
 *
 */
package net.sitsol.victoria.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.sitsol.victoria.log4j.VctLogger;

/**
 *
 * @author rei_shibano
 */
@Controller
@RequestMapping("/hello")
public class HelloController {

	@RequestMapping(value = "/world.do", method = RequestMethod.GET)
	public String world() {

		VctLogger.getLogger().info("HelloController-world.doメソッド実行開始");

		// vmのファイルパス(拡張子なし)を返す
		return "helloworld";
	}

}
