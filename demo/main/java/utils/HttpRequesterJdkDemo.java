/**
 *
 */
package utils;


import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.time.StopWatch;

import com.sun.org.apache.xalan.internal.xsltc.runtime.Parameter;

import demotools.BsDemoExecute;
import net.sitsol.victoria.demo.configs.DemoStaticApParam;
import net.sitsol.victoria.demo.utils.DemoHttpRequester;
import net.sitsol.victoria.log4j.VctLogger;

/**
 * HTTPリクエスト支援クラス(JDK標準を使用したVctHttpRequester版)-プログラミング使用例
 *
 * @author shibano
 */
public class HttpRequesterJdkDemo extends BsDemoExecute {

	/**
	 * メインメソッド
	 * @param args
	 */
	public static void main(String[] args) {
		// メソッド実行要求
		BsDemoExecute.doExecute(new HttpRequesterJdkDemo(), true, args);
	}

	/**
	 * HTTPリクエストテスト
	 */
	@Override
	protected void execute(String[] args) {

		{
			VctLogger.getLogger().info("＜エラー応答例＞");

			String url = "http://s-itsol.net/unnown_page.html";		// ※存在しないURL
			// POSTパラメータリスト生成
			List<Parameter> parameterList = new ArrayList<>();
			{
				parameterList.add( new Parameter("dummy", "0") );
			}

			try {
				// HTTPリクエスト実行
				new DemoHttpRequester().httpPost(url, parameterList);

			} catch ( Exception ex ) {
				// エラーログを出力して処理は継続
				VctLogger.getLogger().error("あえて発生させたHTTP実行エラー！URL：[" + url + "]", ex);
			}
		}

		VctLogger.getLogger().info("＜正常応答例＞");

		{
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
			String retText = new DemoHttpRequester().httpGet(url.toString());

			stopWatch.stop();

			VctLogger.getLogger().info("GETリクエスト成功！"
											+ "処理時間：[" + stopWatch.getTime() + "](ms)"
											+ ", 応答結果：[" + retText + "]"
										);
		}

		{
			String targetZipCode = "1600023";

			// リクエストURL生成
			String url = DemoStaticApParam.getInstance().getZipApiBaseUrl() + DemoStaticApParam.getInstance().getZipApiXmlPageUrl();
			// POSTパラメータリスト生成
			List<Parameter> parameterList = new ArrayList<>();
			{
				parameterList.add( new Parameter("zn", targetZipCode) );
				parameterList.add( new Parameter("ver", "0") );
			}

			org.apache.commons.lang.time.StopWatch stopWatch = new StopWatch();
			stopWatch.start();

			// HTTPリクエスト実行
			String retText = new DemoHttpRequester().httpPost(url, parameterList);

			stopWatch.stop();

			VctLogger.getLogger().info("POSTリクエスト成功！"
											+ "処理時間：[" + stopWatch.getTime() + "](ms)"
											+ ", 応答結果：[" + retText + "]"
										);
		}

		{
			String url = "http://www.s-itsol.net/keireki/keireki_index.html";

			org.apache.commons.lang.time.StopWatch stopWatch = new StopWatch();
			stopWatch.start();

			String retText = new DemoHttpRequester().httpGet(url);

			stopWatch.stop();

			VctLogger.getLogger().info("GETリクエスト成功！"
											+ "処理時間：[" + stopWatch.getTime() + "](ms)"
											+ ", 応答結果：[" + retText + "]"
										);
		}
	}

}
