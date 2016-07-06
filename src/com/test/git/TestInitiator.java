package com.test.git;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import com.test.action.TestClass;

public class TestInitiator {
	
	static WebDriver driver;
	public TestClass home;
	
	public TestInitiator(WebDriver driver){
		this.driver= new FirefoxDriver();
		driver=this.driver;
		//init();
	}
/*
	private void init() {
		home = new HomePage(driver);
		
		
	}
	*/

}
