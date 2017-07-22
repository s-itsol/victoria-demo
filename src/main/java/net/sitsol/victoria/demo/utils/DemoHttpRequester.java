/**
 *
 */
package net.sitsol.victoria.demo.utils;

import java.net.HttpURLConnection;

import net.sitsol.victoria.utils.VctHttpRequester;

/**
 * デモ用-HTTPリクエスト支援クラス
 *
 * @author shibano
 */
public class DemoHttpRequester extends VctHttpRequester {

	/**
	 * 基本-接続設定
	 * @param con IN/OUT：HTTPコネクション
	 */
	@Override
	protected void settingConnectionBase(HttpURLConnection con) {
		super.settingConnectionBase(con);

		con.setConnectTimeout(3000);
		con.setReadTimeout(1000);
	}

}
