/**
 *
 */
package net.sitsol.victoria.demo.beans.dto;

import java.io.Serializable;

/**
 *
 * @author shibano
 */
public class DemoDto implements Serializable {

	private static final long serialVersionUID = -8509013036709910007L;


	// -------------------------------------------------------------------------
	//  フィールド
	// -------------------------------------------------------------------------

	private String demoId					= null;
	private String demoName				= null;


	// -------------------------------------------------------------------------
	//  メソッド
	// -------------------------------------------------------------------------

	/**
	 * コンストラクタ
	 */
	public DemoDto() {}


	/*-- setter・getter ------------------------------------------------------*/

	public String getDemoId() {
		return demoId;
	}

	public void setDemoId(String demoId) {
		this.demoId = demoId;
	}

	public String getDemoName() {
		return demoName;
	}

	public void setDemoName(String demoName) {
		this.demoName = demoName;
	}

}
