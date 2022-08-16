package org.utility;

import org.driver.RemoteDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class Utility {
	public void startApp() throws IOException {
        RemoteDriver.chromeDriverLaunch();
        
        
    }
	private static String homeWindow = null;
	
public static void switchToWindow() {
		
		homeWindow = RemoteDriver.driver.getWindowHandle();
		for(String window : RemoteDriver.driver.getWindowHandles()) {
			RemoteDriver.driver.switchTo().window(window);
		}
	}
	
public static void switchToMainWindow() {
		for(String window : RemoteDriver.driver.getWindowHandles()) {
			if(!window.equals(homeWindow)) {
				RemoteDriver.driver.switchTo().window(window);
				RemoteDriver.driver.close();
			}
			RemoteDriver.driver.switchTo().window(homeWindow);
		}
	}
	
//Highlight and Unhighlight elements
	
public static void highLightAndUnhighlightElements(RemoteDriver driver, WebElement element ) throws InterruptedException{
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red';');", element);
			Thread.sleep(1000);
			js.executeScript("arguments[0].removeAttribute('style,'')", element);
		
		
	}

public static void staticWait(long milliseconds) throws InterruptedException {
	Thread.sleep(milliseconds);

}
}
