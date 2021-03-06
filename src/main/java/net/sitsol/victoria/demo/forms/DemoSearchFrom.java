/**
 *
 */
package net.sitsol.victoria.demo.forms;

import org.apache.commons.lang.StringUtils;

import net.sitsol.victoria.forms.VctForm;
import net.sitsol.victoria.log4j.VctLogger;

/**
 * デモマスタ検索フォーム
 * 
 * @author shibano
 */
public class DemoSearchFrom extends VctForm {

	private static final long serialVersionUID = -1292672257885710969L;
	
	/** フォーム名 */
	public static final String NAME = "DemoSearchFrom";


	// -------------------------------------------------------------------------
	//  field
	// -------------------------------------------------------------------------

	private String demoId = StringUtils.EMPTY;
	private String demoName = StringUtils.EMPTY;
	private String demoFlg = "0";


	// -------------------------------------------------------------------------
	//  method
	// -------------------------------------------------------------------------

	/**
	 * コンストラクタ
	 */
	public DemoSearchFrom() {
		super();
		
		if ( VctLogger.getLogger().isDebugEnabled() ) {
			VctLogger.getLogger().debug("★DemoSeatchFromコンストラクタ");
		}
	}


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

	public String getDemoFlg() {
		return demoFlg;
	}

	public void setDemoFlg(String demoFlg) {
		this.demoFlg = demoFlg;
	}

}
