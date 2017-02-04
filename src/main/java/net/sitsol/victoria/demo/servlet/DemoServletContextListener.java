/**
 *
 */
package net.sitsol.victoria.demo.servlet;

import javax.servlet.ServletContextEvent;

import net.sitsol.victoria.setvlet.VctServletContextListener;

/**
 * デモ用-サーブレット・コンテキスト・リスナー
 *
 * @author shibano
 */
public class DemoServletContextListener extends VctServletContextListener {

	/**
	 * コンテキスト初期イベント
	 */
	@Override
	public void contextInitialized(ServletContextEvent event) {
		super.contextInitialized(event);
	}

	/**
	 * コンテキスト解放イベント
	 */
	@Override
	public void contextDestroyed(ServletContextEvent event) {
		super.contextDestroyed(event);
	}

}
