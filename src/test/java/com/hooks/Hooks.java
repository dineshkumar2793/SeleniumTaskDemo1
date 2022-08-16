package com.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.driver.RemoteDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.utility.Utility;

import java.io.IOException;
import java.net.MalformedURLException;

public class Hooks extends Utility {


    @Before(order = 0)
    public void openBrowser_EnterUrl(Scenario sc) throws MalformedURLException {
        try {
            startApp();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        String strScenario = sc.getName();
//
//		log.info("===================================================Scenario - " + strScenario
//				+ " Started================================================");

    }

    @After(order = 1)
    public void tearDown(Scenario sc) {
        if (sc.isFailed()) {
            String scenarioName = sc.getName().replaceAll(" ", "_");
            byte[] source = ((TakesScreenshot) RemoteDriver.driver).getScreenshotAs(OutputType.BYTES);
            sc.attach(source, "image/png", scenarioName);
        }
    }

    @After(order = 0)
    public void close_Browser(Scenario sc) {

        String strScenario = sc.getName();
        RemoteDriver.driver.close();

    }

}
