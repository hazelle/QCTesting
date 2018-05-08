package com.humuson.selenium.MySite.ChannelManagement;

import java.util.regex.Pattern;

import org.openqa.selenium.By;

import com.humuson.support.Scenario;

/**
 * ADMIN
 * 
 * @대분류 MySite
 * @중분류 채널 관리
 * @시나리오명 E-mail 계정등록
 */
public class E_EmailAccount extends Scenario {
	public E_EmailAccount(String title) {
		this.title = title;
	}

	protected void DO() {
		if (Pattern.compile("/site/account").matcher(driver.getCurrentUrl()).find()) {
			click();

			boolean result = true;
			result &= register();
			result &= modify();
			result &= delete();

			CHECK(result);
		} else {
			CHECK(false);
		}
	}

	private void click() {
		FEB("id", "regEmail", "E-mail 계정등록 탭").click();
	}

	private boolean register() {
		clear();
		FEB("id", "userName", "보내는 사람 이름 입력칸").sendKeys(pr.getPropValue("site.sender.name"));
		FEB("id", "userEmail", "보내는 이메일 입력칸").sendKeys(pr.getPropValue("site.sender.email"));
		FEB("id", "return", "리턴 메일 입력칸").sendKeys(pr.getPropValue("site.return.email"));
		FEB("id", "btnRegisterUser", "등록 버튼").click();
		if (FEB("xpath", "//*[@id=\"resultBody\"]/tr[1]/td[1]/input", "유저 리스트의 첫번째 보내는 사람 이름 입력칸").getAttribute("value").equals(pr.getPropValue("site.sender.name"))) {
			return true;
		} else {
			FAIL("유저 등록");
			return false;
		}
	}

	private boolean modify() {
		CustomWait(10);
		clear();
		FEB("id", "userName", "보내는 사람 이름 입력칸").sendKeys("수정용");
		FEB("id", "userEmail", "보내는 이메일 입력칸").sendKeys("heejae2@humuson.com");
		FEB("id", "return", "리턴 메일 입력칸").sendKeys("heejae2@humuson.com");
		FEB("id", "btnRegisterUser", "등록 버튼").click();
		
		driver.navigate().refresh();

		FEB("xpath", "//*[@id=\"resultBody\"]/tr[1]/td[1]/input", "유저 리스트의 첫번째 보내는 사람 이름 입력칸").clear();
		FEB("xpath", "//*[@id=\"resultBody\"]/tr[1]/td[1]/input", "유저 리스트의 첫번째 보내는 사람 이름 입력칸").sendKeys("삭제용");
		FEB("xpath", "//*[@id=\"resultBody\"]/tr[1]/td[2]/input", "유저 리스트의 첫번째 보내는 이메일 입력칸").clear();
		FEB("xpath", "//*[@id=\"resultBody\"]/tr[1]/td[2]/input", "유저 리스트의 첫번째 보내는 이메일 입력칸")
				.sendKeys("heejae2@humuson.com");
		FEB("xpath", "//*[@id=\"resultBody\"]/tr[1]/td[3]/input", "유저 리스트의 첫번째 리턴 이메일 입력칸").clear();
		FEB("xpath", "//*[@id=\"resultBody\"]/tr[1]/td[3]/input", "유저 리스트의 첫번째 리턴 이메일 입력칸")
				.sendKeys("heejae2@humuson.com");
		FEB("xpath", "//*[@id=\"resultBody\"]/tr[1]/td[6]/button", "유저 리스트의 첫번째 수정 버튼").click();

		driver.navigate().refresh();
		
		boolean result = true;
		result &= FEB("xpath", "//*[@id=\"resultBody\"]/tr[1]/td[1]/input", "유저 리스트의 첫번째 보내는 사람 이름 입력칸")
				.getAttribute("value").equals("삭제용");
		result &= FEB("xpath", "//*[@id=\"resultBody\"]/tr[1]/td[2]/input", "유저 리스트의 첫번째 보내는 이메일 입력칸")
				.getAttribute("value").equals("heejae2@humuson.com");
		result &= FEB("xpath", "//*[@id=\"resultBody\"]/tr[1]/td[3]/input", "유저 리스트의 첫번째 리턴 이메일 입력칸")
				.getAttribute("value").equals("heejae2@humuson.com");

		if (result) {
			return true;
		} else {
			FAIL("유저 수정");
			return false;
		}
	}

	private boolean delete() {
		int cnt = FEB("id", "resultBody", "유저 리스트").findElements(By.tagName("tr")).size();

		if (FEB("xpath", "//*[@id=\"resultBody\"]/tr[1]/td[1]/input", "유저 리스트의 첫번째 보내는 사람 이름 입력칸").getAttribute("value")
				.equals("삭제용"))
			FEB("xpath", "//*[@id=\"resultBody\"]/tr[1]/td[7]/button", "유저 리스트의 첫번째 삭제 버튼").click();

		driver.navigate().refresh();
		if (cnt == FEB("id", "resultBody", "유저 리스트").findElements(By.tagName("tr")).size() + 1)
			return true;
		else {
			FAIL("유저 삭제");
			return false;
		}
	}

	private void clear() {
		FEB("id", "userName", "보내는 사람 이름 입력칸").clear();
		FEB("id", "userEmail", "보내는 이메일 입력칸").clear();
		FEB("id", "return", "리턴 메일 입력칸").clear();
	}
}
