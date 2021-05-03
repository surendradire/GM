package com.gm.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC1_Page {

	WebDriver driver;

	@FindBy(xpath = "//*[@id='vgm-app']/div/main/section/section/article[5]/section[1]/ul/li[1]/a")
	WebElement lnkOntdek_de_collective;

	@FindBy(xpath = "//*[@id='vgm-app']/div/main/section/section[1]/div/h1")
	WebElement lblCollectie;

	public TC1_Page(WebDriver driver) {
		
		super();
		
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	
	public String link_Click() throws InterruptedException {

		//click on lnkOntdek_de_collective link
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(lnkOntdek_de_collective));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", lnkOntdek_de_collective);

		lnkOntdek_de_collective.click();

		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(lblCollectie));

		System.out.println("**************" + lblCollectie.getText());

		return lblCollectie.getText();

	}

}
