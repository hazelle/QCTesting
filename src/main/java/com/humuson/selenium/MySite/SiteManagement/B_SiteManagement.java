package com.humuson.selenium.MySite.SiteManagement;

import com.humuson.support.Scenario;

/**
 * ADMIN
 * @대분류 MySite
 * @중분류 사이트 관리 (사이트 선택 & 사이트 등록,수정,삭제)
 * */
public class B_SiteManagement extends Scenario {
	public B_SiteManagement(String title) {
		this.title = title;
	}
	
	protected void makeScenario() {
		addChildScenario(new E_ClickMySite("MySite 메뉴 클릭"));
		addChildScenario(new E_ClickNewSite("신규 사이트 등록 버튼 클릭"));
		addChildScenario(new E_RegisterSite("사이트 등록"));
		addChildScenario(new E_ModifySite("사이트 수정"));
		addChildScenario(new E_DeleteSite("사이트 삭제"));
	}
	
	protected void DO() {
		execute();
	}
}
