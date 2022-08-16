package org.utility;

import org.locators.Demo1Locators;

public class LocatorReader {

	private static LocatorReader reader = new LocatorReader();
	
	private static Demo1Locators demo1Locator;
	
	private LocatorReader() {
		
	}
	public static LocatorReader getInstance() {
		return reader;
	}
	public Demo1Locators getDemo1Locator() {
		return (demo1Locator ==null)?new Demo1Locators():demo1Locator;
	}
}
