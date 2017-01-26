/**
 * 
 */
package net.sitsol.victoria.demo.configs;

import net.sitsol.victoria.configs.VctInitApParam;

/**
 * 
 * @author shibano
 */
public class DemoInitApParam extends VctInitApParam {

	/* -- static ----------------------------------------------------------- */
	
	private static final long serialVersionUID = 3086205686859952955L;


	/**
	 * アプリケーションで唯一のインスタンスを取得する
	 */
	public static DemoInitApParam getInstance() {
		return (DemoInitApParam) VctInitApParam.getInstance();
	}
	
	
	// -------------------------------------------------------------------------
	//  field
	// -------------------------------------------------------------------------
	
	
	// -------------------------------------------------------------------------
	//  method
	// -------------------------------------------------------------------------

	/**
	 * デフォルトコンストラクタ
	 *  ※外部からはインスタンス化させない
	 */
	protected DemoInitApParam() {}

}
