package com.scripts;
import java.io.IOException;
import java.time.Duration;
import java.util.*;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class javaProgram extends javascriptActions{
 
	@Test
	public void NSEAutomation() throws EncryptedDocumentException, IOException, InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.nseindia.com/");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		zoomUsingJavascript(driver);
		
		performClickUsingJavascript(driver.findElement(By.cssSelector("a#Derivatives")),driver);
		
		List<WebElement> table = driver.findElements(By.cssSelector("table#eqtyDerVolTable>tbody>tr>td"));
		wait.until(ExpectedConditions.visibilityOfAllElements(table));
		
		driver.close();
	}
}
