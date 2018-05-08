package com.humuson.selenium.System;

import com.humuson.selenium.System.CodeManagement.B_CodeManagement;
import com.humuson.selenium.System.Setting.B_Setting;
import com.humuson.support.LoginFunction;
import com.humuson.support.Scenario;

/**
 * ADMIN
 * @대분류 System
 * */
public class A_System extends Scenario {
	public A_System(String title) {
		this.title = title;
		setCategory(title);
	}
	
	protected void makeScenario() {
		new LoginFunction();
		addChildScenario(new B_CodeManagement("코드 관리"));
		addChildScenario(new B_Setting("환경설정"));
	}
	
	protected void DO() {
		execute();
	}
}
