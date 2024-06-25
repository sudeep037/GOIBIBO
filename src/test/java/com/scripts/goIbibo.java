package com.scripts;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class goIbibo extends javascriptActions {

	static WebDriver driver;
	static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	 
	@Test
	public void test() throws InterruptedException
	{
		//WebDriverManager.firefoxdriver().create();
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.goibibo.com");
		
		Actions act = new Actions(driver);
		
		//Close the popup
		try {
			driver.findElement(By.cssSelector("span[class='logSprite icClose']")).click();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			driver.findElement(By.cssSelector("p[class='sc-jlwm9r-1 ewETUe']")).click();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		//Perform zooming
		zoomUsingJavascript(driver);
		
		//Entering from location
		WebElement fromTxt = driver.findElement(By.xpath("//div[@class='sc-12foipm-2 eTBlJr fswFld ' and contains(.,'From')]"));
		wait.until(ExpectedConditions.elementToBeClickable(fromTxt));
		performClickUsingJavascript(fromTxt, driver);
		WebElement enterData = driver.findElement(By.cssSelector("div[class='sc-12foipm-25 fbAAhv'] input[type='text']"));
		wait.until(ExpectedConditions.visibilityOf(enterData));
        String boarding = "Kolkata";
		enterData.sendKeys(boarding);
		
		//Selecting suggestion
		Thread.sleep(1000);
		WebElement board = driver.findElement(By.xpath("//ul[@id='autoSuggest-list']/li/descendant::span[@class='autoCompleteTitle ' and contains(.,'"+boarding+"')]"));
		wait.until(ExpectedConditions.visibilityOf(board));
		performClickUsingJavascript(board, driver);
		
		// Entering To Location
		WebElement toEnterData = driver.findElement(By.cssSelector("div[class='sc-12foipm-25 fbAAhv'] input[type='text']"));
		wait.until(ExpectedConditions.visibilityOf(toEnterData));
		String dest = "Delhi";
		toEnterData.sendKeys(dest);
		
		//Selecting Suggestion
		Thread.sleep(1000);
		WebElement destination = driver.findElement(By.xpath("//ul[@id='autoSuggest-list']/li/descendant::span[@class='autoCompleteTitle ' and contains(.,'"+dest+"')]"));
		wait.until(ExpectedConditions.visibilityOf(destination));
		performClickUsingJavascript(destination, driver);
		
		//Click on departure
		performClickUsingJavascript(driver.findElement(By.xpath("//span[text()='Departure']")), driver);
		
		//Select date from Calendar
		List<WebElement> allDepartDates = driver.findElements(By.xpath("//div[@class='DayPicker-Month' and contains(.,'June')]/child::div[@class='DayPicker-Body']/child::div[*]/descendant::p[@class='fsw__date']"));
		
		for(WebElement date : allDepartDates)
		{
			if(date.getText().equals("25"))
			{
				performClickUsingJavascript(date, driver);
				break;
			}
		}
	    
		//Click on Return
		performClickUsingJavascript(driver.findElement(By.xpath("//span[text()='Return']")), driver);
		
		List<WebElement> allReturnDates = driver.findElements(By.xpath("//div[@class='DayPicker-Month' and contains(.,'June')]/child::div[@class='DayPicker-Body']/child::div[*]/descendant::p[@class='fsw__date']"));
		
		for(WebElement date : allReturnDates)
		{
			if(date.getText().equals("27"))
			{
				performClickUsingJavascript(date, driver);
				break;
			}
		}
		
		//Click on Search
		performClickUsingJavascript(driver.findElement(By.xpath("//span[text()='SEARCH FLIGHTS']")),driver);
		
		Thread.sleep(15000);
		
		System.out.println(driver.getTitle());
		driver.close();
	}
}
