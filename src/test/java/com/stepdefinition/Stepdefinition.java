package com.stepdefinition;

import static org.testng.Assert.assertEquals;

import org.baseClass.BaseLogics;
import org.driver.RemoteDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Stepdefinition {

	@Given("user verifies the launched application")
	public void user_verifies_the_launched_application() {
		RemoteDriver.chromeDriverLaunch();
	}

	@When("User enters the {string} in the searchbar and clicks on the search button")
	public void userEntersTheMobileModalandClicksOnTheSearchButton(String deviceName) {
		boolean enterAndClicksOnTheDeviceName = BaseLogics
				.userEntersTheMobileModalandClicksOnTheSearchButton(deviceName);
		assertEquals(enterAndClicksOnTheDeviceName, true, "userEntersTheDeviceNameAndClicksOnTheSeachButton");
	}

	@Then("^User verifies the display of the iphone and verifies it$")
	public void userVerifiesTheDisplayOfTheIponeAndVerifiesIt() throws Throwable {
		boolean displayOfIphone = BaseLogics.userVerifiesTheDisplayOfTheIponeAndVerifiesIt();
		assertEquals(displayOfIphone, true, "iPhoneIsGettinglistedinthelist");
	}

	@When("^user tries to open a new tab and enters the \"([^\"]*)\"$")
	public void userTriesToClickTheNewTabAndEntersTheNewUrl(String newurl) throws Throwable {
		boolean newUrlAndTab = BaseLogics
				.userTriesToClickTheNewTabAndEntersTheNewUrl(newurl);
		assertEquals(newUrlAndTab, true, "URL is not getting opened as expected");
	}
	
    @Then("^User verifies the display of iphonemini and clicks on it$")
    public void userVerifiesDisplayOfIphoneminiAndClicksOnIt() throws Throwable {
       
    	boolean displayOfIphoneMini = BaseLogics.userVerifiesDisplayOfIphoneminiAndClicksOnIt();
		assertEquals(displayOfIphoneMini, true, "iPhoneMini is getting displayed");
    }
    
    @Then("^User verifies the different storage options for different colors$")
    public void userVerifiesDifferentStorageOptionsForDifferentColors() throws Throwable {
        System.out.println("into my method");
    	boolean displayOfIphoneMiniStorage = BaseLogics.userVerifiesDifferentStorageOptionsForDifferentColors();
		assertEquals(displayOfIphoneMiniStorage, true, "iPhoneMini with storage options getting displayed");
    }
    
    @Then("^User switches to second tab and enter \"([^\"]*)\" in search bar$")
    public void userSwitchesToSecondTabAndEnterStringInSearchBar(String internet) throws Throwable {
    	BaseLogics.userSwitchesToSecondTabAndEnterStringInSearchBar(internet);
    }
    
    

}