package com.scripts;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class javascriptActions {

	static JavascriptExecutor js;
	
	public static void performClickUsingJavascript(WebElement ele, WebDriver driver)
	{
		js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", ele);
	}
	
	public static void enteringDataUsingJavascript(WebElement ele, String data, WebDriver driver)
	{
		js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].value='"+data+"'", ele);
	}
	
	public static void zoomUsingJavascript(WebDriver driver)
	{
		js = (JavascriptExecutor)driver;
		js.executeScript("document.body.style.zoom='60%'");
	}
	
	public static void scrollingUsingJavascript(WebDriver driver)
	{
		js = (JavascriptExecutor)driver;
		js.executeScript("document.scrollBy(0,300)");
	}
	
	public static void scrollingUsingJavascript(WebElement ele,WebDriver driver)
	{
		js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", ele);
	}
}
