package com.gm.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.gm.pages.TC1_Page;
import com.gm.pages.TC2_Page;
import com.gm.pages.TC3_Page;
import com.gm.utils.Utils;

public class Testcases extends Utils {

	public WebDriver driver;

	TC1_Page tc1Obj;
	TC2_Page tc2Obj;
	TC3_Page tc3Obj;
	
	String url1="https://www.vangoghmuseum.nl";
	String url2="https://www.vangoghmuseum.nl/nl/collectie";
	

	@BeforeMethod
	public void setUp() {

		System.setProperty("webdriver.chrome.driver", "src//test//resources//chromeDriver//chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

	}

	@Test(priority = 1, enabled = true)
	public void TC1() throws InterruptedException {
		
		//Launch application
		launchApplication(driver, url1);
	
		//handle cookie
		handleCookie();

		tc1Obj = new TC1_Page(driver);

		String verifyText = tc1Obj.link_Click();

		//Verify link text
		if ((verifyText).equalsIgnoreCase("collectie"))
			Assert.assertTrue(true);
		else
			Assert.assertTrue(false);

	}

	@Test(priority = 2, enabled = true)
	public void TC2() throws InterruptedException {

		//Launch application
		launchApplication(driver, url2);

		//click to accept cookie
		handleCookie();

		tc2Obj = new TC2_Page(driver);

		//Verify count/result
		int count = tc2Obj.resultCount();
		if (count > 700)
			Assert.assertTrue(true);
		else
			Assert.assertTrue(false);

	}

	@Test(priority = 3, enabled = true)
	public void TC3() throws InterruptedException {

		//driver.get("https://www.vangoghmuseum.nl/nl/collectie");
		launchApplication(driver, url2);

		// to click on the accept cookie button
		handleCookie();
		
		tc3Obj = new TC3_Page(driver);

		//Verify image
		boolean flag = tc3Obj.imageVeification();

		Assert.assertTrue(flag);

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	public void handleCookie(){
		//handle cookie
		try {
			new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id='vgm-app']/div/footer/div/section/div[2]/button[1]"))));
			
			driver.findElement(By.xpath("//*[@id='vgm-app']/div/footer/div/section/div[2]/button[1]")).click();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
}
