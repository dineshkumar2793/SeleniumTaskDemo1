package org.locators;

import java.util.List;

import org.driver.RemoteDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Demo1Locators {
	
	public Demo1Locators() {
		PageFactory.initElements(RemoteDriver.driver, this);
	}
	
	
	@FindBy(xpath="//button[text()='Accept']")
	public WebElement acceptButton;
	
	@FindBy(xpath="//h2[@class='result-item__link-wrapper']")
	public List<WebElement> iphone;
	
	@FindBy(xpath="//h2[@class='result-item__link-wrapper']/a[contains(text(),'Apple iPhone 13 mini – Smartphones')]")
	public WebElement iphoneMini;
	

	@FindBy(css="div.color-tile")
	public List<WebElement> iphoneMiniColors;
	
	@FindBy(css="div [class='memory-list'] label")
	public List<WebElement> iphoneMiniColorsWithStorage;
	
	@FindBy(css="span.device-color-selected")
	public WebElement iphoneMiniColorSelected;
	
	@FindBy(css="p.result-info__left-panel")
	public WebElement searchedResults;

}
