package com.humuson.selenium.System.CodeManagement.MappingManagement;

import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.humuson.support.LoginFunction;
import com.humuson.support.Scenario;

/**
 * ADMIN
 * ADMIN
 * @대분류 System
 * @중분류 코드 관리
 * @소분류 매핑 관리
 * @시나리오명 매핑 관리 메뉴 클릭
 * */
public class E_ClickMManagement extends Scenario {
	public E_ClickMManagement(String title) {
		this.title = title;
	}
	
	protected void DO() {
		if (cp.detectLogin())
			clickMenu();
		else {
			new LoginFunction();
			clickMenu();
		}
		CHECK(cp.checkPage("/sys/mapping"));
	}
	
	private void clickMenu() {
		WebElement w = FEB("xpath", "/html/body/header/header/div/div[2]/div/a[2]", "우측상단 드롭메뉴");
		if (driver.findElement(By.xpath("/html/body/header/header/div/div[2]/div")).getAttribute("class").equals("btn-group")) {
			w.click();
		}
		FEB("xpath", "/html/body/header/header/div/div[2]/div/ul/li[8]/a", "System 메뉴").click();

		if (Pattern.compile("sys").matcher(driver.getCurrentUrl()).find()) {
			w = FEB("xpath", "//*[@id=\"nav_side_list\"]/li[1]/ul", "코드 관리 메뉴(열린 부분)");
			if (!w.getCssValue("display").equals("block")) {
				FEB("xpath", "//*[@id=\"nav_side_list\"]/li[1]/a", "코드 관리 메뉴").click();
			}
			FEB("xpath", "//*[@id=\"nav_side_list\"]/li[1]/ul/li[2]/a", "매핑 관리 메뉴").click();
		} else {
			cp.movePage("/sys/code");
		}
	}

}
