/**
 *
 */
package net.sitsol.victoria.demo.servlet;

import javax.servlet.http.HttpSessionBindingEvent;

import net.sitsol.victoria.log4j.VctLogger;
import net.sitsol.victoria.setvlet.VctHttpSessionAttributeListener;

/**
 * デモ用-サーブレット・HTTPセッション属性・リスナー
 *
 * @author shibano
 */
public class DemoHttpSessionAttributeListener extends VctHttpSessionAttributeListener {

	/**
	 * セッション属性追加イベント
	 */
	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {

		// ※デモ用なので、動作がわかるようログ出力しておく
		VctLogger.getLogger().info(" ---> セッション属性追加 - 属性名：[" + event.getName() + "]");

		super.attributeAdded(event);
	}

	/**
	 * セッション属性破棄イベント
	 */
	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {

		// ※デモ用なので、動作がわかるようログ出力しておく
		VctLogger.getLogger().info(" ---> セッション属性破棄 - 属性名：[" + event.getName() + "]");

		super.attributeRemoved(event);
	}

	/**
	 * セッション属性置換イベント
	 */
	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {

		// ※デモ用なので、動作がわかるようログ出力しておく
		VctLogger.getLogger().info(" ---> セッション属性置換 - 属性名：[" + event.getName() + "]");

		super.attributeReplaced(event);
	}

}
