package org.baseClass;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.constants.ConstantData;
import org.driver.RemoteDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.utility.ConfigReader;
import org.utility.LocatorReader;
import org.utility.Utility;
import org.openqa.selenium.WindowType;
import org.testng.Assert;

import io.github.sukgu.Shadow;

public class BaseLogics implements ConstantData {

	public static JavascriptExecutor js = (JavascriptExecutor) RemoteDriver.driver;
	public static Shadow shadow = new Shadow(RemoteDriver.driver);

	public static boolean userEntersTheMobileModalandClicksOnTheSearchButton(String deviceName) {
		boolean deviceNameUpdated = true;
		try {
			WebElement acceptButton = LocatorReader.getInstance().getDemo1Locator().acceptButton;
			acceptButton.click();
			Utility.staticWait(5000);
			WebElement element = shadow.findElement("span[class='icon icon--s2 icon-search']");
			element.click();
			WebElement inputBox = shadow.findElement("input[placeholder='Search for…']");
			inputBox.sendKeys(deviceName);
			WebElement searchBar = shadow.findElement("span[class='icon icon-search icon--s3']");
			searchBar.click();
		} catch (Exception e) {

			e.printStackTrace();
		}

		return deviceNameUpdated;
	}

	public static boolean userVerifiesTheDisplayOfTheIponeAndVerifiesIt() throws Throwable {
		boolean displayPhone = true;
		try {
			List<WebElement> iphone = LocatorReader.getInstance().getDemo1Locator().iphone;
			for (int i = 0; i < iphone.size(); i++) {
				if (iphone.get(i).getText().contains(ConstantData.IPHONE_TYPE)) {
					displayPhone = iphone.get(i).isDisplayed();
				} else {
					System.out.println("Iphone is not getting listed");

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return displayPhone;
	}

	public static boolean userTriesToClickTheNewTabAndEntersTheNewUrl(String newurl) throws Throwable {
		boolean url = true;
		try {
			RemoteDriver.driver.switchTo().newWindow(WindowType.TAB);
			RemoteDriver.driver.get(ConfigReader.readConfigFile().getProperty("url"));
			Utility.staticWait(3000);
			System.out.println(RemoteDriver.driver.getTitle());
			String Parent_id = RemoteDriver.driver.getWindowHandle();
			System.out.println(Parent_id);
			Set<String> windowHandles = RemoteDriver.driver.getWindowHandles();
			List<String> ls = new ArrayList<String>(windowHandles);
			String Parent = ls.get(0);
			String Child = ls.get(1);
			System.out.println(Parent);
			System.out.println(Child);
			RemoteDriver.driver.switchTo().window(Parent);
			System.out.println(RemoteDriver.driver.getTitle());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return url;

	}

	public static boolean userVerifiesDisplayOfIphoneminiAndClicksOnIt() {
		boolean displayiPhoneMini = true;
		try {
			WebElement iphoneMini = LocatorReader.getInstance().getDemo1Locator().iphoneMini;
			if (iphoneMini.getText().contains(ConstantData.APPLE_IPHONEMINI)) {
				System.out.println("IphoneMini is getting displayed");
				iphoneMini.click();
				Utility.staticWait(5000);
			} else {
				System.out.println("Iphone is not getting listed");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return displayiPhoneMini;
	}

	public static boolean userVerifiesDifferentStorageOptionsForDifferentColors() throws InterruptedException {

		Utility.staticWait(3000);
		boolean displayiPhoneMiniColor = true;
		try {
			List<WebElement> iphoneMiniColor = LocatorReader.getInstance().getDemo1Locator().iphoneMiniColors;

			for (int index = 0; index < iphoneMiniColor.size(); index++) {
				iphoneMiniColor.get(index).click();
				Utility.staticWait(3000);
				WebElement iphoneMiniColorSelected = LocatorReader.getInstance()
						.getDemo1Locator().iphoneMiniColorSelected;
				System.out.println("iPhone mini selected color is " + iphoneMiniColorSelected.getText().trim());
				Assert.assertTrue(iphoneStorageValidation(iphoneMiniColorSelected.getText().trim()),
						"Incorrect iphone color storages");
			}

		} catch (Exception exception) {
			throw exception;
		}
		return displayiPhoneMiniColor;

	}

	public static boolean iphoneStorageValidation(String selectedIphoneColor) {
		String expectedAvailableStorage = null;
		switch (selectedIphoneColor) {
		case ConstantData.IPHONE_MINI_PINK:
			expectedAvailableStorage = ConstantData.IPHONE_MINI_PINK_STORAGES;
			break;
		case ConstantData.IPHONE_MINI_BLUE:
			expectedAvailableStorage = ConstantData.IPHONE_MINI_BLUE_STORAGES;
			break;
		case ConstantData.IPHONE_MINI_MIDNIGHT:
			expectedAvailableStorage = ConstantData.IPHONE_MINI_MIDNIGHT_STORAGES;
			break;
		case ConstantData.IPHONE_MINI_STARLIGHT:
			expectedAvailableStorage = ConstantData.IPHONE_MINI_STARLIGHT_STORAGES;
			break;
		case ConstantData.IPHONE_MINI_GREEN:
			expectedAvailableStorage = ConstantData.IPHONE_MINI_GREEN_STORAGES;
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + selectedIphoneColor);
		}

		String[] expectedStorage = expectedAvailableStorage.split(",");
		List<WebElement> iphoneMiniColorsWithStorage = LocatorReader.getInstance()
				.getDemo1Locator().iphoneMiniColorsWithStorage;
		String availableStorage = null;
		Assert.assertEquals(iphoneMiniColorsWithStorage.size(), expectedStorage.length,
				"Actual and expected storages element sizes mismatched");
		for (int storage = 0; storage < iphoneMiniColorsWithStorage.size(); storage++) {
			availableStorage = iphoneMiniColorsWithStorage.get(storage).getText().trim();
			System.out.println("Available Storage " + availableStorage);
			Assert.assertEquals(availableStorage, expectedStorage[storage], "Incorrect available storage");
		}
		return true;
	}

	public static void userSwitchesToSecondTabAndEnterStringInSearchBar(String text) throws Exception {
		try {
			Utility.switchToWindow();
			System.out.println("To be searched");
			Utility.staticWait(4000);
			WebElement element = shadow.findElement("span[class='icon icon--s2 icon-search']");
			element.click();
			WebElement inputBox = shadow.findElement("input[placeholder='Search for…']");
			inputBox.sendKeys(text);
			WebElement searchBar = shadow.findElement("span[class='icon icon-search icon--s3']");
			searchBar.click();
			System.out.println("Searched text :" + text);
			Utility.staticWait(3000);
			WebElement searchedResults = LocatorReader.getInstance().getDemo1Locator().searchedResults;
			Assert.assertTrue(searchedResults.getText().trim().contains(text), "Incorrect search results");
			System.out.println("Searched text result: " + searchedResults);
			RemoteDriver.driver.close();
		} catch (Exception exception) {
			throw exception;
		}
	}
}
