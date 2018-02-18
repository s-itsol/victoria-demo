/**
 *
 */
package net.sitsol.victoria.demo.forms;

import net.sitsol.victoria.demo.models.demo.DemoModel;
import net.sitsol.victoria.forms.VctFrom;
import net.sitsol.victoria.log4j.VctLogger;

/**
 * デモマスタ編集フォーム
 * 
 * @author shibano
 */
public class DemoEditFrom extends VctFrom {

	private static final long serialVersionUID = -526320656401787846L;

	/** フォーム名 */
	public static final String NAME = "demoEditFrom";


	// -------------------------------------------------------------------------
	//  field
	// -------------------------------------------------------------------------

	private DemoModel model = new DemoModel();


	// -------------------------------------------------------------------------
	//  method
	// -------------------------------------------------------------------------

	/**
	 * コンストラクタ
	 */
	public DemoEditFrom() {
		super();
		
		if ( VctLogger.getLogger().isDebugEnabled() ) {
			VctLogger.getLogger().debug("★DemoEditFromコンストラクタ");
		}
	}

	/**
	 * モデル→フォーム
	 * @param model デモモデル
	 */
	public void modelToFrom(DemoModel demoModel) {
		
		// ※編集が必要なものがあれば、ここで行う
		
		this.setModel(demoModel);
	}

	/**
	 * フォーム→モデル
	 * @return デモモデル
	 */
	public DemoModel formToModel() {
		
		DemoModel demoModel = this.getModel();
		
		// ※編集が必要なものがあれば、ここで行う
		
		return demoModel;
	}


	/*-- setter・getter ------------------------------------------------------*/

	public String getDemoId() {
		return this.getModel().getDemoId();
	}

	public void setDemoId(String demoId) {
		this.getModel().setDemoId(demoId);
	}

	public String getDemoName() {
		return this.getModel().getDemoName();
	}

	public void setDemoName(String demoName) {
		this.getModel().setDemoName(demoName);
	}

	public String getDemoDetail() {
		return this.getModel().getDemoDetail();
	}

	public void setDemoDetail(String demoDetail) {
		this.getModel().setDemoDetail(demoDetail);
	}

	public DemoModel getModel() {
		return model;
	}

	public void setModel(DemoModel model) {
		this.model = model;
	}

}
