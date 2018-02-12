/**
 * 
 */
package net.sitsol.victoria.demo.servlet.spring;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import net.sitsol.victoria.log4j.VctLogger;
import net.sitsol.victoria.setvlet.spring.VctHandlerInterceptor;
import net.sitsol.victoria.utils.statics.VctStringUtils;

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
			
			StringBuilder message = new StringBuilder();
			message.append(" -> コントローラ処理後イベント通知");
			message.append(" - ハンドラクラス名：[").append(handler.getClass().getSimpleName()).append("]");
			
			if ( modelAndView != null ) {
				
				message.append(", ビュー名：[").append(modelAndView.getViewName()).append("]");
				
				ModelMap modelMap = modelAndView.getModelMap();
				
				if ( modelMap != null ) {
					
					List<String> modelKeyList = new ArrayList<>();
					
					for ( String modelKey : modelMap.keySet() ) {
						// springバリデーション系モデルは使わないので、ログ出力からは除外
						if ( StringUtils.startsWith(modelKey, "org.springframework.validation.BindingResult") ) {
							continue;
						}
						
						modelKeyList.add(modelKey);
					}
					
					message.append(", モデル名CSV：[").append(VctStringUtils.createCsvString(modelKeyList.toArray())).append("]");
				}
			}
			
			VctLogger.getLogger().debug(message.toString());
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
			VctLogger.getLogger().debug(" -> リクエスト完了イベント通知"
											+ " - ハンドラクラス名：[" + handler.getClass().getSimpleName() + "]"
											+ ", 例外クラス名：[" + ( ex == null ? null : ex.getClass().getSimpleName() ) + "]"
										);
		}
		
		// 基底クラスのメソッド実行
		super.afterCompletion(request, response, handler, ex);
	}

}
