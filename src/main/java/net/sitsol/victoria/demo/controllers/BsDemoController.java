/**
 * 
 */
package net.sitsol.victoria.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import net.sitsol.victoria.annotation.servlet.VctNoAuth;
import net.sitsol.victoria.annotation.servlet.VctSuccessForward;
import net.sitsol.victoria.controllers.VctController;
import net.sitsol.victoria.demo.consts.DemoUrlPathConst;

/**
 * デモサイト共通-コントローラ 基底クラス
 * 
 * @author rei_shibano
 */
@Controller																	// springのコントローラであることを示す
@RequestMapping(DemoUrlPathConst.Root.DIR)									// リクエストURLとのマッピング ※APコンテキストからのディレクトリ
public abstract class BsDemoController extends VctController {

	/**
	 * システムエラー
	 * @return モデル＆ビュー情報
	 */
	@RequestMapping(value = DemoUrlPathConst.SYSTEMERROR_DO, method = RequestMethod.GET)
	@VctSuccessForward(url = DemoUrlPathConst.Root.Errors.SYSTEMERROR_VM)
	@VctNoAuth
	public ModelAndView systemerror() {
		// ビューへフォワードするだけ
		return this.succsessForward();
	}

	/**
	 * セッションタイムアウト
	 * @return モデル＆ビュー情報
	 */
	@RequestMapping(value = DemoUrlPathConst.SESSIONTIMEOUT_DO, method = RequestMethod.GET)
	@VctSuccessForward(url = DemoUrlPathConst.Root.Errors.SESSIONTIMEOUT_VM)
	@VctNoAuth
	public ModelAndView sessiontimeout() {
		// ビューへフォワードするだけ
		return this.succsessForward();
	}

}
