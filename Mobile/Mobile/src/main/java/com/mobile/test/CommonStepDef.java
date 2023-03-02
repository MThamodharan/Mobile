package com.mobile.test;

import com.utility.SeleniumCommands;

import io.cucumber.java.en.Given;

public class CommonStepDef extends SeleniumCommands{
	

	@Given("user is on chromeBrowser")
	public void launch() throws Throwable {
		launchBrowser("Chrome");
		
	}
	
	@Given("user is on reactjs page")
	public void user_is_on_google_page() {
	openApp("https://reactjs.org/");
		
	}
	
	

}
