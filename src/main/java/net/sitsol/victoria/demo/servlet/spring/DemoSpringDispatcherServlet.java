/**
 *
 */
package net.sitsol.victoria.demo.servlet.spring;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

}
