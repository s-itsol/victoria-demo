/**
 *
 */
package utils;


import org.apache.commons.lang.time.StopWatch;

import demotools.BsDemoExecute;
import net.sitsol.victoria.demo.configs.DemoStaticApParam;
import net.sitsol.victoria.log4j.VctLogger;
import net.sitsol.victoria.utils.HttpRequester;

/**
 * HTTPリクエスト支援クラス-プログラミング使用例
 *
 * @author shibano
 */
public class HttpRequesterDemo extends BsDemoExecute {

	/**
	 * メインメソッド
	 * @param args
	 */
	public static void main(String[] args) {
		// メソッド実行要求
		BsDemoExecute.doExecute(new HttpRequesterDemo(), true, args);
	}

	/**
	 * HTTPリクエストテスト
	 */
	@Override
	protected void execute(String[] args) {

		{
			VctLogger.getLogger().info("＜エラー応答例＞");

			String url = "http://s-itsol.net/unnown_page.html";		// ※存在しないURL

			try {
				// HTTPリクエスト実行
				HttpRequester requester = new HttpRequester();
				requester.httpGet(url);

			} catch ( Exception ex ) {
				// エラーログを出力して処理は継続
				VctLogger.getLogger().error("あえて発生させたHTTP実行エラー！URL：[" + url + "]", ex);
			}
		}

		{
			VctLogger.getLogger().info("＜正常応答例＞");

			String targetZipCode = "1600023";

			// リクエストURL生成
			StringBuilder url = new StringBuilder();
			{
				url.append(DemoStaticApParam.getInstance().getZipApiBaseUrl()).append(DemoStaticApParam.getInstance().getZipApiXmlPageUrl());
				url.append("?").append("zn").append("=").append(targetZipCode);
				url.append("&").append("ver").append("=").append("0");

				VctLogger.getLogger().info("リクエストURL：[" + url + "]");
			}

			org.apache.commons.lang.time.StopWatch stopWatch = new StopWatch();
			stopWatch.start();

			// HTTPリクエスト実行
			HttpRequester requester = new HttpRequester();
			String retText = requester.httpGet(url.toString());

			stopWatch.stop();

			VctLogger.getLogger().info("GETリクエスト成功！"
											+ "処理時間：[" + stopWatch.getTime() + "](ms)"
											+ ", 応答結果：[" + retText + "]"
										);
		}
	}

}
