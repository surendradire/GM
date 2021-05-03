package com.gm.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC2_Page {

	WebDriver driver;

	@FindBy(xpath = "//*[@id='vgm-app']/div/main/section/section[2]/div[1]/div/div[1]/form/div/input")
	WebElement searchFld;

	@FindBy(xpath = "//*[@id='vgm-app']/div/main/section/div[1]/p/span")
	WebElement seachCount;

	public TC2_Page(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public int resultCount() throws InterruptedException {

		//click on lnkOntdek_de_collective link
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(searchFld));
		
		searchFld.clear();
		
		searchFld.sendKeys("Het Gele Huis");
		
		searchFld.sendKeys(Keys.ENTER);
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(seachCount));
		
		int count = (Integer.parseInt(seachCount.getText()));
		
		return count;

	}

}
