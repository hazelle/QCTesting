package com.humuson.selenium.MySite;

import com.humuson.selenium.MySite.ChannelManagement.B_ChannelManagement;
import com.humuson.selenium.MySite.SiteManagement.B_SiteManagement;
import com.humuson.support.Scenario;

/**
 * ADMIN
 * @대분류 MySite
 * */
public class A_MySite extends Scenario {
	public A_MySite(String title) {
		this.title = title;
	}
	
	protected void makeScenario() {
		addChildScenario(new B_SiteManagement("사이트 관리"));
		addChildScenario(new B_ChannelManagement("채널 관리"));
	}
	
	protected void DO() {
		execute();
	}
}
