/**
 * 
 */
package net.sitsol.victoria.demo.servlet.spring;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import net.sitsol.victoria.log4j.VctLogger;
import net.sitsol.victoria.setvlet.spring.VctHandlerInterceptor;

/**
 * デモ用-ハンドラ・インターセプタ
 * 
 * @author shibano
 */
public class DemoHandlerInterceptor extends VctHandlerInterceptor {

	/**
	 * コントローラ処理前イベント通知
	 * @param handler ハンドラのインスタンス
	 * @return 処理継続フラグ ※true：処理を継続する ／ false：処理を中断する(＝以降の処理を実施しない)
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		if ( VctLogger.getLogger().isDebugEnabled() ) {
			VctLogger.getLogger().debug(" -> コントローラ処理前イベント通知 - ハンドラクラス名：[" + handler.getClass().getSimpleName() + "]");
		}
		
		// 基底クラスのメソッド実行
		return super.preHandle(request, response, handler);
	}

	/**
	 * コントローラ処理後イベント通知
	 * @param handler ハンドラのインスタンス
	 * @param modelAndView モデル＆ビュー情報 ※コントローラ処理で当該インスタンスを返していない場合はnull
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		
		if ( VctLogger.getLogger().isDebugEnabled() ) {
			VctLogger.getLogger().debug(" -> コントローラ処理後イベント通知 - ハンドラクラス名：[" + handler.getClass().getSimpleName() + "], モデル＆ビュー情報(ビュー名)：[" + ( modelAndView == null ? null : modelAndView.getViewName() ) + "]");
		}
		
		// 基底クラスのメソッド実行
		super.postHandle(request, response, handler, modelAndView);
	}

	/**
	 * リクエスト完了イベント通知
	 * @param handler ハンドラのインスタンス
	 * @param ex スローされた例外 ※スローされていない場合はnull
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		
		if ( VctLogger.getLogger().isDebugEnabled() ) {
			VctLogger.getLogger().debug(" -> リクエスト完了イベント通知 - ハンドラクラス名：[" + handler.getClass().getSimpleName() + "], 例外クラス名：[" + ( ex == null ? null : ex.getClass().getSimpleName() ) + "]");
		}
		
		// 基底クラスのメソッド実行
		super.afterCompletion(request, response, handler, ex);
	}


}
