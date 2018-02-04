/**
 *
 */
package net.sitsol.victoria.demo.ctrls.demomanage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.sitsol.victoria.demo.consts.DemoHttpConst;
import net.sitsol.victoria.demo.facades.DemoMasterFacade;
import net.sitsol.victoria.demo.forms.DemoEditFrom;
import net.sitsol.victoria.demo.models.demo.DemoModel;

/**
 * デモ用マスタ管理-編集コントローラ
 *
 * @author shibano
 */
//@Controller											// springのコントローラであることを示す
//@RequestMapping("/demomanage")						// リクエストURLとのマッピング ※APコンテキストからのディレクトリ
//@SessionAttributes(types = DemoEditFrom.class)		// セッション格納するフォーム群のクラス型 ※.vmにて「${先頭だけ小文字にしたクラス名}」で得られる
// ※1クラス版の動作を試すため、こちらはコメントアウト
public class DemoEditCtrl {

	/**
	 * デモマスタ更新
	 * @param form デモマスタ編集フォーム
	 * @param demoId デモID
	 * @return 応答結果vmパス
	 */
	@RequestMapping(value = "/demoupdate.do", method = RequestMethod.GET)
	public String demoupdate(DemoEditFrom form, @RequestParam(DemoHttpConst.DEMO_ID) String demoId) {

		// モデル１件検索
		DemoModel model = DemoMasterFacade.getInstance().findDemoModel(demoId);

		// モデル→フォームへ
		form.modelToFrom(model);

		return "demoedit";
	}

	/**
	 * デモマスタ更新実行
	 * @param sessionStatus セッションステータス
	 * @param form デモマスタ編集フォーム
	 * @param redirect リダイレクト属性モデル
	 * @return 応答結果vmパス
	 */
	@RequestMapping(value = "/demoupdateexec.do", method = RequestMethod.POST)
	public String demoupdateexec(SessionStatus sessionStatus, DemoEditFrom form, RedirectAttributes redirect) {

		// フォーム→モデルへ
		DemoModel demoModel = form.formToModel();

		// １件更新
		DemoMasterFacade.getInstance().updateDemoModel(demoModel);

		sessionStatus.setComplete();			// @SessionAttributesのフォーム群をセッションからクリア

		redirect.addFlashAttribute(DemoHttpConst.COMP_MESSAGE, "更新が完了しました");		// リダイレクト先画面でも1度だけ有効な値を設定

		// 編集画面へリダイレクト
		String redirectUrl = "/demomanage/demoupdate.do" + "?" + DemoHttpConst.DEMO_ID + "=" + demoModel.getDemoId();

		return "redirect:" + redirectUrl;
	}

}
