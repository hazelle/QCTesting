package com.humuson.selenium.Login;

import com.humuson.support.Scenario;

/**
 * ADMIN
 * @대분류 로그인
 * */
public class A_Login extends Scenario {
	
	public A_Login(String title) {
		this.title = title;
		setCategory(title);
//		StartTesting.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	protected void makeScenario() {
		addChildScenario(new E_InputIDPWAndLogin("아이디, 패스워드 입력하여 로그인 성공"));
		addChildScenario(new E_CheckRememberMe("remember me 체크"));
		addChildScenario(new E_Logout("로그아웃 버튼을 눌러 로그아웃 성공"));
		addChildScenario(new E_NonexistentUser("존재하지 않는 사용자일 경우"));
		addChildScenario(new E_WrongPassword("비밀번호 틀린 경우"));
//		addChildScenario(new E_LockedUser("잠금처리된 계정일 경우"));
	}
	
	protected void DO() {
		if(cp.movePage("/login")) {
			execute();
		}
	}
}

