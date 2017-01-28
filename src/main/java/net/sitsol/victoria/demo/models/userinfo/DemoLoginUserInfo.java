/**
 *
 */
package net.sitsol.victoria.demo.models.userinfo;

import net.sitsol.victoria.models.userinfo.SimpleUserInfoModel;

/**
 * デモ用-ログインユーザー情報モデル
 *
 * @author shibano
 */
public class DemoLoginUserInfo extends SimpleUserInfoModel {

	// ------------------------------------------------------------------------
	//  field
	// ------------------------------------------------------------------------

	private String userName			= null;		// ユーザー名


	// ------------------------------------------------------------------------
	//  method
	// ------------------------------------------------------------------------

	/**
	 * コンストラクタ
	 * @param userId ユーザーID
	 * @param userName ユーザー名
	 */
	public DemoLoginUserInfo(String userId, String userName) {
		super(userId);

		this.userName = userName;
	}

	/**
	 * ユーザー名の取得
	 * @return ユーザー名
	 */
	public String getUserName() {
		return this.userName;
	}

}
