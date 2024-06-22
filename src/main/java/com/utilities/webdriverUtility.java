package com.utilities;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class webdriverUtility {

	private WebDriver driver;
	private WebDriverWait wait;
	private JavascriptExecutor js;
	private Actions act;
	
	public void launchChromeBrowser()
	{
		driver = new ChromeDriver();
	}
	
	public void launchFirefoxBrowser()
	{
		driver = new FirefoxDriver();
	}
	
	public void loadUrl(String url)
	{
		driver.get(url);
	}
	
	public void implicitWait()
	{
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
	}
	
	public void maximizeWindow()
	{
		driver.manage().window().maximize();
	}
	
	public void minimizeWindow()
	{
		driver.manage().window().minimize();
	}
	
	public void doClick(WebElement ele)
	{
		ele.click();
	}
	
	public void enteringData(WebElement ele, String data)
	{
		ele.sendKeys(data);
	}
	
	public void clearingData(WebElement ele)
	{
		ele.clear();
	}
	
	public ChromeOptions disabledNotificationPopUp(String browserName)
	{
		 ChromeOptions  opt = new ChromeOptions();
		 opt.addArguments("--disabled-notifications");
		 return opt;
	}
	
	public void waitForVisibilityOfElement(WebDriver driver, WebElement ele)
	{
	    wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	    wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public void waitForElementToBeClickable(WebDriver driver, WebElement ele)
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}
	
	public void performClickUsingJavascript(WebElement ele)
	{
		js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", ele);
	}
	
	public void enteringDataUsingJavascript(WebElement ele, String data)
	{
		js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].value='"+data+"'", ele);
	}
	
	public void zoomUsingJavascript()
	{
		js = (JavascriptExecutor)driver;
		js.executeScript("document.body.style.zoom='45%'");
	}
	
	public void scrollingUsingJavascript()
	{
		js = (JavascriptExecutor)driver;
		js.executeScript("document.scrollBy(0,300)");
	}
	
	public void scrollingUsingJavascript(WebElement ele)
	{
		js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", ele);
	}
	
	public void performMouseHover(WebElement ele)
	{
		act = new Actions(driver);
		act.moveToElement(ele).perform();
	}
	
	public void performRightClickOnWebelement(WebElement ele)
	{
		act = new Actions(driver);
		act.contextClick(ele).perform();
	}
	
	public void perfromDoubleClick(WebElement ele)
	{
		act = new Actions(driver);
		act.doubleClick(ele).perform();
	}
	
	public void switchToFrameUsingId(String id)
	{
		driver.switchTo().frame(id);
	}
	
	public void switchToFrameUsingIndex(int index)
	{
		driver.switchTo().frame(index);
	}
	
	public void switchToFrameUsingWebElement(WebElement ele)
	{
		driver.switchTo().frame(ele);
	}
	
	public void switchToDefaultFrame()
	{
		driver.switchTo().defaultContent();
	}
	
}
