/**
 *
 */
package net.sitsol.victoria.demo.servlet.spring;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sitsol.victoria.demo.consts.DemoUrlPathConst;
import net.sitsol.victoria.log4j.VctLogger;
import net.sitsol.victoria.setvlet.spring.VctSpringDispatcherServlet;

/**
 * デモ用-Spring-Dispatcherサーブレット
 *
 * @author shibano
 */
public class DemoSpringDispatcherServlet extends VctSpringDispatcherServlet {

	private static final long serialVersionUID = 5478210285799598883L;

	/**
	 * サービス実行
	 * @param request HTTPサーブレットリクエスト
	 * @param response HTTPサーブレットレスポンス
	 */
	@Override
	protected void doService(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		if ( VctLogger.getLogger().isDebugEnabled() ) {
			VctLogger.getLogger().debug(" -> サービス実行");
		}
		
		// 基底クラスのメソッド実行
		super.doService(request, response);
	}

	/**
	 * ディスパッチ実行
	 * @param request HTTPサーブレットリクエスト
	 * @param response HTTPサーブレットレスポンス
	 */
	@Override
	protected void doDispatch(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		if ( VctLogger.getLogger().isDebugEnabled() ) {
			VctLogger.getLogger().debug(" -> ディスパッチ実行");
		}
		
		// 基底クラスのメソッド実行
		super.doDispatch(request, response);
	}

	/**
	 * 認証判定
	 * @param request HTTPサーブレットリクエスト
	 * @param response HTTPサーブレットレスポンス
	 * @return 判定結果 ※true：認証OK ／ false：認証NG
	 */
	@Override
	protected boolean isAuth(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 
		return super.isAuth(request, response);
	}

	/**
	 * セッションタイムアウト実行
	 * @param request HTTPサーブレットリクエスト
	 * @param response HTTPサーブレットレスポンス
	 */
	@Override
	protected void doSessionTimeout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 
		super.doSessionTimeout(request, response);
	}

	/**
	 * セッションタイムアウト-フォワード先URL取得
	 * @return フォワード先URL
	 */
	protected String getSessionTimeoutForwardUrl() {
		// セッションタイムアウト・ビューをフォワード先とする
		return DemoUrlPathConst.Root.Errors.SESSIONTIMEOUT_VM;
	}

}
