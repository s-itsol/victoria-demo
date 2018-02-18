/**
 *
 */
package net.sitsol.victoria.demo.servlet.spring;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sitsol.victoria.setvlet.spring.VctSpringDispatcherServlet;

/**
 * デモ用-Spring-Dispatcherサーブレット
 *
 * @author shibano
 */
public class DemoSpringDispatcherServlet extends VctSpringDispatcherServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * 認証判定
	 * @param request HTTPサーブレットリクエスト
	 * @param response HTTPサーブレットレスポンス
	 * @return 判定結果 ※true：認証OK ／ false：認証NG
	 */
	@Override
	protected boolean isAuth(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO：認証処理はサイト毎にカスタム実装になるはずだが、まだ未実装
		return super.isAuth(request, response);
	}

	/**
	 * 例外ハンドラ実行
	 * @param request HTTPサーブレットリクエスト
	 * @param response HTTPサーブレットレスポンス
	 * @param exception 発生例外
	 */
	@Override
	protected void doExceptionHanler(HttpServletRequest request, HttpServletResponse response, Exception exception) {
		// TODO：サイト独自の例外ページ遷移などがあればカスタム実装になるはずだが、まだ未実装
		super.doExceptionHanler(request, response, exception);
	}

}
