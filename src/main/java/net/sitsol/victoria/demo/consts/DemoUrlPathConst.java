/**
 *
 */
package net.sitsol.victoria.demo.consts;


/**
 * デモ用-URLパス定数クラス
 * @author shibano
 */
public class DemoUrlPathConst {

	// -------------------------------------------------------------------------
	//  ディレクトリ階層構造
	// -------------------------------------------------------------------------

	/** APコンテキストルート */
	public class Root {
		public static final String DIR = "/";
		
		/** Hello */
		public class Hello {
			public static final String DIR = Root.DIR + "hello/";
		}
		
		/** デモマスタ管理 */
		public class DemoManage {
			public static final String DIR = Root.DIR + "demomanage/";
		}
	}

	/** コンストラクタ */
	protected DemoUrlPathConst() {}


	// -------------------------------------------------------------------------
	//  Hello World
	// -------------------------------------------------------------------------

	// サーブレット
	public static final String WORLD_DO				= "world.do";

	// ビュー
	public static final String HELLOWORLD_VM		= "helloworld.vm";


	// -------------------------------------------------------------------------
	//  デモマスタ管理
	// -------------------------------------------------------------------------

	// サーブレット
	public static final String DEMOMANAGETOP_DO		= "demomanagetop.do";		// デモマスタ管理トップ
	public static final String DEMOSEARCH_DO		= "demosearch.do";			// デモマスタ検索
	public static final String DEMOLIST_DO			= "demolist.do";			// デモマスタ一覧
	public static final String DEMOUPDATE_DO		= "demoupdate.do";			// デモマスタ更新
	public static final String DEMOUPDATEEXEC_DO	= "demoupdateexec.do";		// デモマスタ更新実行

	// ビュー
	public static final String DEMOMANAGETOP_VM		= "demomanagetop.vm";		// デモマスタ管理トップ
	public static final String DEMOSEARCH_VM		= "demosearch.vm";			// デモマスタ検索
	public static final String DEMOLIST_VM			= "demolist.vm";			// デモマスタ一覧
	public static final String DEMOEDIT_VM			= "demoedit.vm";			// デモマスタ編集

}
