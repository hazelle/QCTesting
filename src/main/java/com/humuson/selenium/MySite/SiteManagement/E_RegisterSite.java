package com.humuson.selenium.MySite.SiteManagement;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

import com.humuson.support.Scenario;

/**
 * ADMIN
 * @대분류 MySite
 * @중분류 사이트 관리
 * @시나리오명 사이트 등록
 */
public class E_RegisterSite extends Scenario {
	private Map<String, Boolean> channel = ii.getChannel();
	private String[] chns = ii.chns;
	private static String sitename = "";

	public E_RegisterSite(String title) {
		this.title = title;
	}

	public void DO() {
		fillOut();
		click();
		CHECK(check());
	}
	
	private void click() {
		CustomWait(10);
		FEB("xpath", "//*[@id=\"btnSave\"]", "저장 버튼").click();
		CustomWait(10);
	}

	private void fillOut() {
		image();
		name();
		channel();
	}

	private void image() {
		FEB("xpath", "//*[@id=\"siteImageFile\"]", "이미지 Upload 버튼").sendKeys(pr.getPropValue("site.image.path"));
	}

	private void name() {
		sitename = pr.getPropValue("site.name")+"_"+currentTime();
		pr.setPropValue("site.name", sitename);
		FEB("xpath", "//*[@id=\"siteName\"]", "사이트명 입력칸").sendKeys(sitename);
	}

	private void channel() {
		for (int i = 0; i < 4; i++) {
			WebElement w = FEB("id", chns[i] + "Flag", chns[i] + " 체크박스");
			if (channel.get(chns[i])) {
				if (!w.isSelected()) {	w.click();	}
			} else {
				if (w.isSelected()) {	w.click();	}
			}
		}
	}
	
	private String currentTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm"); 
		return sdf.format(new Date()).toString();
	}
	
	private boolean check() {
		try{
			FEB("xpath", "//*[@id=\"container\"]/div/h3", "채널별 발송계정 등록");
			return true;
		} catch(WebDriverException e) {
			return false;
		}
	}
}

