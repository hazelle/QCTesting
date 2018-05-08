package com.humuson.support;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropRead extends CustomLogging {

	private String propfile = "\\..\\..\\..\\resources.properties";
	private String proppath = "";
	private static Properties props = new Properties();

	public PropRead() throws IOException {
		// \\DESKTOP-OOH11GR\Git\AutoTesting\target\classes\com\humuson\selenium\..\..\..\..\classes\resources.properties
		// this.getClass().getResource("").getPath()
		this.proppath = this.getClass().getResource("").getPath() + propfile;
		setProp();
	}

	public void setPropPath(String propfilename) throws IOException {
		this.proppath = getClass().getResource(propfilename).getPath();
		setProp();
	}

	public void setProp() throws IOException {
		FileInputStream fis = new FileInputStream(this.proppath);
		PropRead.props.load(new java.io.BufferedInputStream(fis));
	}

	public String getPropValue(String propname) {
		return PropRead.props.getProperty(propname);
	}

	public void setPropValue(String propname, String newvalue) {
		PropRead.props.setProperty(propname, newvalue);
		try {
			PropRead.props.store(new FileOutputStream(proppath), "");
		} catch (IOException e) {
			simpleLog("properties 파일 수정 실패");
		}
	}

}
