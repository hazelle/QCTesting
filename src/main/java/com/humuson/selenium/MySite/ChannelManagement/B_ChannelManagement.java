package com.humuson.selenium.MySite.ChannelManagement;

import com.humuson.support.Scenario;

/**
 * ADMIN
 * @대분류 MySite
 * @중분류 채널 관리
 * */
public class B_ChannelManagement extends Scenario {
	public B_ChannelManagement(String title) {
		this.title = title;
	}
	
	protected void makeScenario() {
		addChildScenario(new E_ClickChnManagement("채널 관리 버튼 클릭"));
		if(ii.getChannel().get("email"))	addChildScenario(new E_EmailAccount("E-mail 계정등록"));
//		if(ii.getChannel().get("sms"))		addChildScenario(new E_SMSAccount("SMS 계정등록"));
	}
	
	protected void DO() {
		execute();
	}
}
