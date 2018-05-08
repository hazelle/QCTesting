package com.humuson.selenium;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.humuson.selenium.Login.A_Login;
import com.humuson.selenium.MySite.A_MySite;
import com.humuson.selenium.System.A_System;
import com.humuson.support.ControlPage;
import com.humuson.support.InputInfo;
import com.humuson.support.CustomLogging;
import com.humuson.support.Excel;
import com.humuson.support.PropRead;
import com.humuson.support.Scenario;

/**
 * @version 2.0 201805
 * @author heejae
 * */
public class StartTesting extends CustomLogging {

	public static WebDriver driver;
	public static InputInfo ii;
	public static PropRead pr;
	public static WebDriverWait wait;
	public static ControlPage cp;
	public static CustomLogging cl;
	
	public static boolean DetailedLog = true;
	
	private static int rownum = 0;

	public static void main(String[] args) throws IOException {
		StartTesting st = new StartTesting();
		setting();
		cl.headerLog();
		
		start();
//		st.lastLogExcel();
	}
	
	public static void start() {
		forTest();
		
		new Excel();
		
		new A_Login("로그인").action();		// Login 실행
		System.out.println("A_Login 끝남");
		new A_System("System");
		System.out.println("A_System 끝남"); 
		new A_MySite("MySite").action();
		System.out.println("A_MySite 끝남");
	}
	
	public static void setting() throws IOException {
		pr = new PropRead();
		ii = new InputInfo();
		driver = ii.getDriver();
		
		cp = new ControlPage();
		cl = new CustomLogging();
		
		wait = new WebDriverWait(driver, 20);
	}

	private void lastLogExcel() {
		if(Scenario.xlsxContent.size()>0) {
			new Excel().modify(Scenario.xlsxContent);
		}
	}

	public static int getRownum() {
		return rownum;
	}

	public static void setRownum(int rownum) {
		StartTesting.rownum = rownum;
	}

	/**
	 * 개발 중에만 필요한 부분이므로 나중엔 지워야 함
	 * */
	private static void forTest() {
		pr.setPropValue("site.name", "TEST");
		pr.setPropValue("site.name2", "TES2");
	}
}








