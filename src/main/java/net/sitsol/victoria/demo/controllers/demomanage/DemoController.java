/**
 *
 */
package net.sitsol.victoria.demo.controllers.demomanage;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.sitsol.victoria.controllers.VctController;
import net.sitsol.victoria.demo.beans.cond.DemoSearchCond;
import net.sitsol.victoria.demo.beans.dto.DemoDto;
import net.sitsol.victoria.demo.consts.DemoHttpConst;
import net.sitsol.victoria.demo.consts.DemoUrlPathConst;
import net.sitsol.victoria.demo.facades.DemoMasterFacade;
import net.sitsol.victoria.demo.forms.DemoEditFrom;
import net.sitsol.victoria.demo.forms.DemoSearchFrom;
import net.sitsol.victoria.demo.models.demo.DemoModel;
import net.sitsol.victoria.setvlet.spring.annotation.PreHandleNoAuth;

/**
 * デモ用マスタ管理-コントローラ
 *
 * @author shibano
 */
@Controller																		// springのコントローラであることを示す
@RequestMapping(DemoUrlPathConst.DEMOMANAGE)									// リクエストURLとのマッピング ※APコンテキストからのディレクトリ
@SessionAttributes(types = {													// セッション格納するフォーム群のクラス型 ※フォーム名はデフォルトを使うので「names」パラメータは未指定
						DemoSearchFrom.class
						, DemoEditFrom.class
					}
				)																//  ※.vmにて「${フォーム名}」で得られる
public class DemoController extends VctController {

	// ページ内パラメータ名 ※requestの属性名、GET・POSTパラメータ名
	public static final String DEMO_DTO_LIST				= "demoDtoList";		// デモDTOリスト

	/**
	 * デモ用マスタ管理トップ
	 * @param sessionStatus セッションステータス
	 * @return モデル＆ビュー情報
	 */
	@RequestMapping(value = DemoUrlPathConst.DEMOMANAGETOP_DO, method = RequestMethod.GET)
	@PreHandleNoAuth
	public ModelAndView demomanagetop(SessionStatus sessionStatus) {
		
		// @SessionAttributesのフォーム群をセッションからクリア
		sessionStatus.setComplete();
		
		return this.forwardForApp("demomanagetop.vm");
	}

	/**
	 * デモマスタ検索
	 * @param form デモマスタ検索フォーム
	 * @return モデル＆ビュー情報
	 */
	@RequestMapping(value = DemoUrlPathConst.DEMOSEARCH_DO, method = RequestMethod.GET)
	@PreHandleNoAuth
	public ModelAndView demosearch(DemoSearchFrom form) {
		
		return this.forwardForApp("demosearch.vm");
	}

	/**
	 * デモマスタ一覧
	 * @param form デモマスタ検索フォーム
	 * @param requestAttrs リクエスト属性モデル
	 * @return モデル＆ビュー情報
	 */
	@RequestMapping(value = DemoUrlPathConst.DEMOLIST_DO, method = { RequestMethod.GET, RequestMethod.POST })
	@PreHandleNoAuth
	public ModelAndView demolist(DemoSearchFrom form, Model requestAttrs) {
		
		// フォーム入力値→検索条件ビーン生成
		DemoSearchCond cond = new DemoSearchCond();
		{
			cond.setDemoId(form.getDemoId());
		}
		
		// 一覧検索
		List<DemoDto> dtoList = DemoMasterFacade.getInstance().searchDemoDtoList(cond);
		
		requestAttrs.addAttribute(DEMO_DTO_LIST, dtoList);		// リクエストスコープでの値の設定 ※.vmにて「${第1引数の属性名}」で得られる
		
		return this.forwardForApp("demolist.vm");
	}

	/**
	 * デモマスタ更新
	 * @param form デモマスタ編集フォーム
	 * @param demoId デモID
	 * @return モデル＆ビュー情報
	 */
	@RequestMapping(value = DemoUrlPathConst.DEMOUPDATE_DO, method = RequestMethod.GET)
	@PreHandleNoAuth
	public ModelAndView demoupdate(DemoEditFrom form, @RequestParam(DemoHttpConst.DEMO_ID) String demoId) {
		
		// モデル１件検索
		DemoModel model = DemoMasterFacade.getInstance().findDemoModel(demoId);
		
		// モデル→フォームへ
		form.modelToFrom(model);
		
		return this.forwardForApp("demoedit.vm");
	}

	/**
	 * デモマスタ更新実行
	 * @param sessionStatus セッションステータス
	 * @param form デモマスタ編集フォーム
	 * @param redirectAttrs リダイレクト属性モデル
	 * @return モデル＆ビュー情報
	 */
	@RequestMapping(value = DemoUrlPathConst.DEMOUPDATEEXEC_DO, method = RequestMethod.POST)
	@PreHandleNoAuth
	public ModelAndView demoupdateexec(HttpSession session, DemoEditFrom form, RedirectAttributes redirectAttrs, ModelAndView modelAndView) {
		
		// フォーム→モデルへ
		DemoModel demoModel = form.formToModel();
		
		// １件更新
		DemoMasterFacade.getInstance().updateDemoModel(demoModel);
		
		session.removeAttribute(form.getDefaultName());		// 編集フォームをセッションからクリア ※TODO：セッション直接編集なので、ここの実装は要検討
		
		redirectAttrs.addFlashAttribute(DemoHttpConst.COMP_MESSAGE, "更新が完了しました");		// リダイレクト先画面でも1度だけ有効な値を設定
		
		// 編集画面URL生成
		String redirectUrl = DemoUrlPathConst.DEMOMANAGE + DemoUrlPathConst.DEMOUPDATE_DO
								+ "?" + DemoHttpConst.DEMO_ID + "=" + demoModel.getDemoId()
		;
		
		// リダイレクト
		return this.sendRedirectForApp(redirectUrl, modelAndView);
	}

}
