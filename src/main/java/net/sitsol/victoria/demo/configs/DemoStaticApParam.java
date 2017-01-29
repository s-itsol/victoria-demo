/**
 *
 */
package net.sitsol.victoria.demo.configs;

import net.sitsol.victoria.configs.VctStaticApParam;

/**
 * デモ用-静的アプリケーション・パラメータ
 *
 * @author shibano
 */
public class DemoStaticApParam extends VctStaticApParam {

	/* -- static ----------------------------------------------------------- */

	private static final long serialVersionUID = 3086205686859952955L;

	/**
	 * アプリケーションで唯一のインスタンスを取得する
	 */
	public static DemoStaticApParam getInstance() {
		return (DemoStaticApParam) VctStaticApParam.getInstance();
	}


	// -------------------------------------------------------------------------
	//  field
	// -------------------------------------------------------------------------

	private String demoUserId				= "demo-user-id";			// デモ用ユーザーID
	private String demoUserName			= "デモユーザー";			// デモ用ユーザー名


	// -------------------------------------------------------------------------
	//  method
	// -------------------------------------------------------------------------

	/**
	 * デフォルトコンストラクタ
	 *  ※外部からはインスタンス化させない
	 */
	protected DemoStaticApParam() {}

	public String getDemoUserId() {
		return demoUserId;
	}

	public void setDemoUserId(String demoUserId) {
		this.demoUserId = demoUserId;
	}

	public String getDemoUserName() {
		return demoUserName;
	}

	public void setDemoUserName(String demoUserName) {
		this.demoUserName = demoUserName;
	}

}
