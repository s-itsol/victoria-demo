/**
 *
 */
package net.sitsol.victoria.demo.ctrls.demomanage;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.sitsol.victoria.demo.beans.cond.DemoSearchCond;
import net.sitsol.victoria.demo.beans.dto.DemoDto;
import net.sitsol.victoria.demo.consts.DemoHttpConst;
import net.sitsol.victoria.demo.facades.DemoMasterFacade;
import net.sitsol.victoria.demo.forms.DemoEditFrom;
import net.sitsol.victoria.demo.forms.DemoSearchFrom;
import net.sitsol.victoria.demo.models.demo.DemoModel;
import net.sitsol.victoria.setvlet.spring.annotation.PreHandleNoAuth;

/**
 * デモ用マスタ管理-コントローラ
 *  ※主にstrutsからの移行を想定し、1つのクラス内にまとめた形
 *
 * @author shibano
 */
@Controller																		// springのコントローラであることを示す
@RequestMapping("/demomanage")													// リクエストURLとのマッピング ※APコンテキストからのディレクトリ
@SessionAttributes(names = { "demoSearchFrom", "demoEditFrom" }					// セッション格納するフォーム群の名前
					, types = { DemoSearchFrom.class, DemoEditFrom.class }		// セッション格納するフォーム群のクラス型
				)																//  ※.vmにて「${フォーム名}」で得られる
public class DemoCtrl {

	/**
	 * デモ用マスタ管理トップ
	 * @param sessionStatus セッションステータス
	 * @param searchForm デモマスタ検索フォーム ※セッションからクリアさせるために引数として指定
	 * @param editForm デモマスタ編集フォーム ※セッションからクリアさせるために引数として指定
	 * @return 応答結果vmパス
	 */
	@RequestMapping(value = "/demomanagetop.do", method = RequestMethod.GET)
	@PreHandleNoAuth
	public String demomanagetop(SessionStatus sessionStatus, DemoSearchFrom searchForm, DemoEditFrom editForm) {

		sessionStatus.setComplete();			// @SessionAttributesのフォーム群をセッションからクリア

		return "demomanagetop";
	}

	/**
	 * デモマスタ検索
	 * @param form デモマスタ検索フォーム
	 * @return 応答結果vmパス
	 */
	@RequestMapping(value = "/demosearch.do", method = RequestMethod.GET)
	@PreHandleNoAuth
	public String demosearch(DemoSearchFrom form) {

		return "demosearch";
	}

	/**
	 * デモマスタ一覧
	 * @param form デモマスタ検索フォーム
	 * @param model リクエスト属性モデル
	 * @return 応答結果vmパス
	 */
	@RequestMapping(value = "/demolist.do", method = { RequestMethod.GET, RequestMethod.POST })
	@PreHandleNoAuth
	public String demolist(DemoSearchFrom form, Model model) {

		// フォーム入力値→検索条件ビーン生成
		DemoSearchCond cond = new DemoSearchCond();
		{
			cond.setDemoId(form.getDemoId());
		}

		// 一覧検索
		List<DemoDto> dtoList = DemoMasterFacade.getInstance().searchDemoDtoList(cond);

		model.addAttribute("demoDtoList", dtoList);		// リクエストスコープでの値の設定 ※.vmにて「${第1引数の属性名}」で得られる

		return "demolist";
	}

	/**
	 * デモマスタ更新
	 * @param form デモマスタ編集フォーム
	 * @param demoId デモID
	 * @return 応答結果vmパス
	 */
	@RequestMapping(value = "/demoupdate.do", method = RequestMethod.GET)
	@PreHandleNoAuth
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
	@PreHandleNoAuth
	public String demoupdateexec(HttpSession session, DemoEditFrom form, RedirectAttributes redirect) {

		// フォーム→モデルへ
		DemoModel demoModel = form.formToModel();

		// １件更新
		DemoMasterFacade.getInstance().updateDemoModel(demoModel);

		session.removeAttribute("demoEditFrom");		// 編集フォームをセッションからクリア ※セッションにリテラル記述で直接編集なので、ここの実装は要検討

		redirect.addFlashAttribute(DemoHttpConst.COMP_MESSAGE, "更新が完了しました");		// リダイレクト先画面でも1度だけ有効な値を設定

		// 編集画面へリダイレクト
		String redirectUrl = "/demomanage/demoupdate.do" + "?" + DemoHttpConst.DEMO_ID + "=" + demoModel.getDemoId();

		return "redirect:" + redirectUrl;
	}

}
