/**
 *
 */
package net.sitsol.victoria.demo.servlet;

import javax.servlet.http.HttpSessionEvent;

import net.sitsol.victoria.log4j.VctLogger;
import net.sitsol.victoria.setvlet.VctHttpSessionListener;

/**
 * デモ用-サーブレット・HTTPセッション・リスナー
 *
 * @author shibano
 */
public class DemoHttpSessionListener extends VctHttpSessionListener {

	/**
	 * セッション生成イベント
	 */
	@Override
	public void sessionCreated(HttpSessionEvent event) {

		// ※デモ用なので、動作がわかるようログ出力しておく
		VctLogger.getLogger().info(" -> セッション生成 - セッションID：[" + event.getSession().getId() + "]");

		super.sessionCreated(event);
	}

	/**
	 * セッション破棄イベント
	 */
	@Override
	public void sessionDestroyed(HttpSessionEvent event) {

		// ※デモ用なので、動作がわかるようログ出力しておく
		VctLogger.getLogger().info(" -> セッション破棄 - セッションID：[" + event.getSession().getId() + "]");

		super.sessionDestroyed(event);
	}

}
