package org.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.utility.ConfigReader;

import io.github.bonigarcia.wdm.WebDriverManager;


public class RemoteDriver {
	public static WebDriver driver;
	
	public static void chromeDriverLaunch() {	
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
        driver.get(ConfigReader.readConfigFile().getProperty("url"));
        
	}
	
}
