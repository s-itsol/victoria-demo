/**
 *
 */
package net.sitsol.victoria.demo.ctrls.demomanage;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import net.sitsol.victoria.demo.beans.cond.DemoSearchCond;
import net.sitsol.victoria.demo.beans.dto.DemoDto;
import net.sitsol.victoria.demo.facades.DemoMasterFacade;
import net.sitsol.victoria.demo.forms.DemoSearchFrom;

/**
 * デモ用マスタ管理-検索コントローラ
 *
 * @author shibano
 */
//@Controller												// springのコントローラであることを示す
//@RequestMapping("/demomanage")							// リクエストURLとのマッピング ※APコンテキストからのディレクトリ
//@SessionAttributes(types = DemoSearchFrom.class)		// セッション格納するフォーム群のクラス型 ※.vmにて「${先頭だけ小文字にしたクラス名}」で得られる
//※1クラス版の動作を試すため、こちらはコメントアウト
public class DemoSerachCtrl {

	/**
	 * デモマスタ検索
	 * @param form デモマスタ検索フォーム
	 * @return 応答結果vmパス
	 */
	@RequestMapping(value = "/demosearch.do", method = RequestMethod.GET)
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

}
