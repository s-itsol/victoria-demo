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
import net.sitsol.victoria.log4j.VctLogger;

/**
 * デモ用マスタ管理-トップコントローラ
 *
 * @author shibano
 */
@Controller																		// springのコントローラであることを示す
@RequestMapping("/demomanage")													// リクエストURLとのマッピング ※APコンテキストからのディレクトリ
@SessionAttributes(types = { DemoSearchFrom.class, DemoEditFrom.class })		// セッション格納するフォーム群のクラス型
public class DemoTopCtrl {

	/**
	 * デモ用マスタ管理トップ
	 * @param sessionStatus セッションステータス
	 * @return 応答結果vmパス
	 */
	@RequestMapping(value = "/demomanagetop.do", method = RequestMethod.GET)
	public String demomanagetop(SessionStatus sessionStatus) {

		VctLogger.getLogger().info("HelloController-demomanagetop.doメソッド実行開始");

		sessionStatus.setComplete();			// @SessionAttributesのフォーム群をセッションからクリア

		return "demomanagetop";				// フォワードする
	}

}
