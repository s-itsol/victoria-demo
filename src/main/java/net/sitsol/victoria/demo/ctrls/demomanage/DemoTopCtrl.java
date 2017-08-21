/**
 *
 */
package net.sitsol.victoria.demo.ctrls.demomanage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import net.sitsol.victoria.demo.forms.DemoEditFrom;
import net.sitsol.victoria.demo.forms.DemoSearchFrom;

/**
 * デモ用マスタ管理-トップコントローラ
 *
 * @author shibano
 */
@Controller																		// springのコントローラであることを示す
@RequestMapping("/demomanage")													// リクエストURLとのマッピング ※APコンテキストからのディレクトリ
@SessionAttributes(types = { DemoSearchFrom.class, DemoEditFrom.class })		// セッション格納するフォーム群のクラス型 ※.vmにて「${先頭だけ小文字にしたクラス名}」で得られる
public class DemoTopCtrl {

	/**
	 * デモ用マスタ管理トップ
	 * @param sessionStatus セッションステータス
	 * @param searchForm デモマスタ検索フォーム ※セッションからクリアさせるために引数として指定
	 * @param editForm デモマスタ編集フォーム ※セッションからクリアさせるために引数として指定
	 * @return 応答結果vmパス
	 */
	@RequestMapping(value = "/demomanagetop.do", method = RequestMethod.GET)
	public String demomanagetop(SessionStatus sessionStatus, DemoSearchFrom searchForm, DemoEditFrom editForm) {

		sessionStatus.setComplete();			// @SessionAttributesのフォーム群をセッションからクリア

		return "demomanagetop";
	}

}
