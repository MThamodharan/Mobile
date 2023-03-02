package com.mobile.testrunner;

import com.utility.SeleniumCommands;

import io.cucumber.java.Before;

public class Hooks extends SeleniumCommands{

	
	@Before
	public void before() throws Throwable {
		
		launchBrowser("Chrome");

	}
	
	@io.cucumber.java.After
	public void After() throws Throwable {
		
		driver.quit();

	}
}
