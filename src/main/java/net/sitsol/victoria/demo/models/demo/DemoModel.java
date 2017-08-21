/**
 *
 */
package net.sitsol.victoria.demo.models.demo;

import java.io.Serializable;

/**
 *
 * @author rei_shibano
 */
public class DemoModel implements Serializable {

	private static final long serialVersionUID = -4261821604308874879L;


	// -------------------------------------------------------------------------
	//  フィールド
	// -------------------------------------------------------------------------

	private String demoId					= null;
	private String demoName				= null;
	private String demoDetail				= null;


	// -------------------------------------------------------------------------
	//  メソッド
	// -------------------------------------------------------------------------

	/**
	 * コンストラクタ
	 */
	public DemoModel() {}


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

	public String getDemoDetail() {
		return demoDetail;
	}

	public void setDemoDetail(String demoDetail) {
		this.demoDetail = demoDetail;
	}

}
