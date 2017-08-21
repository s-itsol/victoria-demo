/**
 *
 */
package net.sitsol.victoria.demo.forms;

import java.io.Serializable;

import org.apache.commons.lang.StringUtils;

import net.sitsol.victoria.log4j.VctLogger;

/**
 *
 * @author shibano
 */
public class DemoSearchFrom implements Serializable {

	private static final long serialVersionUID = -1292672257885710969L;

	private String demoId = StringUtils.EMPTY;
	private String demoName = StringUtils.EMPTY;


	public DemoSearchFrom() {
		super();

		VctLogger.getLogger().info("★DemoSeatchFromコンストラクタ");
	}

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
