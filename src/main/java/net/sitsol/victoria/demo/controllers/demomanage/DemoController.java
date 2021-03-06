/**
 *
 */
package net.sitsol.victoria.demo.controllers.demomanage;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.sitsol.victoria.annotation.servlet.VctFromMapping;
import net.sitsol.victoria.annotation.servlet.VctInputForward;
import net.sitsol.victoria.annotation.servlet.VctNoAuth;
import net.sitsol.victoria.annotation.servlet.VctSuccessForward;
import net.sitsol.victoria.controllers.VctController;
import net.sitsol.victoria.demo.beans.cond.DemoSearchCond;
import net.sitsol.victoria.demo.beans.dto.DemoDto;
import net.sitsol.victoria.demo.consts.DemoHttpConst;
import net.sitsol.victoria.demo.consts.DemoUrlPathConst;
import net.sitsol.victoria.demo.facades.DemoMasterFacade;
import net.sitsol.victoria.demo.forms.DemoEditFrom;
import net.sitsol.victoria.demo.forms.DemoSearchFrom;
import net.sitsol.victoria.demo.models.demo.DemoModel;

/**
 * デモ用マスタ管理-コントローラ
 *
 * @author shibano
 */
@Controller																		// springのコントローラであることを示す
@RequestMapping(DemoUrlPathConst.Root.DemoManage.DIR)							// リクエストURLとのマッピング ※APコンテキストからのディレクトリ
@SessionAttributes(names = {													// セッション格納するフォーム群の属性名
						DemoSearchFrom.NAME
						, DemoEditFrom.NAME
					}
					, types = {													// セッション格納するフォーム群のクラス型
						DemoSearchFrom.class
						, DemoEditFrom.class
					}
				)
public class DemoController extends VctController {

	// ページ内パラメータ名 ※requestの属性名、GET・POSTパラメータ名
	public static final String DEMO_DTO_LIST				= "demoDtoList";		// デモDTOリスト

	/**
	 * デモ用マスタ管理トップ
	 * @param form デモマスタ検索フォーム
	 * @param sessionStatus セッションステータス
	 * @return モデル＆ビュー情報
	 */
	@RequestMapping(value = DemoUrlPathConst.DEMOMANAGETOP_DO, method = RequestMethod.GET)
	@VctSuccessForward(url = DemoUrlPathConst.DEMOMANAGETOP_VM)
	@VctFromMapping(name = DemoSearchFrom.NAME)
	@VctNoAuth
	public ModelAndView demomanagetop(DemoSearchFrom form, SessionStatus sessionStatus) {
		
		// @SessionAttributesのフォーム群をセッションからクリア
		sessionStatus.setComplete();
		
		return this.succsessForward();
	}

	/**
	 * デモマスタ検索
	 * @param form デモマスタ検索フォーム
	 * @return モデル＆ビュー情報
	 */
	@RequestMapping(value = DemoUrlPathConst.DEMOSEARCH_DO, method = RequestMethod.GET)
	@VctSuccessForward(url = DemoUrlPathConst.DEMOSEARCH_VM)
	@VctFromMapping(name = DemoSearchFrom.NAME)
	@VctNoAuth
	public ModelAndView demosearch(DemoSearchFrom form) {
		
		return this.succsessForward();
	}

	/**
	 * デモマスタ一覧
	 * @param form デモマスタ検索フォーム
	 * @param requestAttrs リクエスト属性モデル
	 * @return モデル＆ビュー情報
	 */
	@RequestMapping(value = DemoUrlPathConst.DEMOLIST_DO, method = { RequestMethod.GET, RequestMethod.POST })
	@VctSuccessForward(url = DemoUrlPathConst.DEMOLIST_VM)
	@VctFromMapping(name = DemoSearchFrom.NAME)
	@VctNoAuth
	public ModelAndView demolist(DemoSearchFrom form, Model requestAttrs) {
		
		// フォーム入力値→検索条件ビーン生成
		DemoSearchCond cond = new DemoSearchCond();
		{
			cond.setDemoId(form.getDemoId());
		}
		
		// 一覧検索
		List<DemoDto> dtoList = DemoMasterFacade.getInstance().searchDemoDtoList(cond);
		
		requestAttrs.addAttribute(DEMO_DTO_LIST, dtoList);		// リクエストスコープでの値の設定 ※.vmにて「${第1引数の属性名}」で得られる
		
		return this.succsessForward();
	}

	/**
	 * デモマスタ更新
	 * @param form デモマスタ編集フォーム
	 * @param demoId デモID
	 * @return モデル＆ビュー情報
	 */
	@RequestMapping(value = DemoUrlPathConst.DEMOUPDATE_DO, method = RequestMethod.GET)
	@VctSuccessForward(url = DemoUrlPathConst.DEMOEDIT_VM)
	@VctFromMapping(name = DemoEditFrom.NAME)
	@VctNoAuth
	public ModelAndView demoupdate(DemoEditFrom form, @RequestParam(DemoHttpConst.DEMO_ID) String demoId) {
		
		// モデル１件検索
		DemoModel model = DemoMasterFacade.getInstance().findDemoModel(demoId);
		
		// モデル→フォームへ
		form.modelToFrom(model);
		
		return this.succsessForward();
	}

	/**
	 * デモマスタ更新実行
	 * @param request HTTPサーブレットリクエスト
	 * @param form デモマスタ編集フォーム
	 * @param redirectAttrs リダイレクト属性モデル
	 * @return モデル＆ビュー情報
	 */
	@RequestMapping(value = DemoUrlPathConst.DEMOUPDATEEXEC_DO, method = RequestMethod.POST)
	@VctInputForward(url = DemoUrlPathConst.DEMOEDIT_VM)
	@VctFromMapping(name = DemoEditFrom.NAME)
	@VctNoAuth
	public ModelAndView demoupdateexec(HttpServletRequest request, DemoEditFrom form, RedirectAttributes redirectAttrs) {
		
		// TODO：妥当性チェックと、NG時に@VctInputForwardへのフォワードをここに実装する予定
		
		// フォーム→モデルへ
		DemoModel demoModel = form.formToModel();
		
		// １件更新
		DemoMasterFacade.getInstance().updateDemoModel(demoModel);
		
		// 編集フォームをセッションからクリア
		this.removeSessionFrom(request, DemoEditFrom.NAME);
		
		redirectAttrs.addFlashAttribute(DemoHttpConst.COMP_MESSAGE, "更新が完了しました");		// リダイレクト先画面でも1度だけ有効な値を設定
		
		// 編集画面URL生成
		String redirectUrl = DemoUrlPathConst.DEMOUPDATE_DO
								+ "?" + DemoHttpConst.DEMO_ID + "=" + demoModel.getDemoId()
		;
		
		// リダイレクト
		return this.sendRedirectForApp(redirectUrl);
	}

}
