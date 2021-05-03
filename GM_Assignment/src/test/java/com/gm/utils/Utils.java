package com.gm.utils;

import org.openqa.selenium.WebDriver;

public class Utils {
	
	//Launch application
	public void launchApplication(WebDriver driver, String url){
		
		//Launch application
		driver.get(url);
	}

}
