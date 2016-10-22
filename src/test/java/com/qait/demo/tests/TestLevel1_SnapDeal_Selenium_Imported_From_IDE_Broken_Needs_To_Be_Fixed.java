/**
* This is a sample test recorded in selenium ide and exported to eclipse
* Step 1 : Open snapdeal.com
* Step 2 : Search A product - Mobile
* Step 3 : Select First Product
* Step 4 : Add the product to cart
* Step 5 : Verify the product has been added to cart
* 
* Task : You have to fix this test and run it.
*/



package com.qait.demo.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.javascript.host.Set;

import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TestLevel1_SnapDeal_Selenium_Imported_From_IDE_Broken_Needs_To_Be_Fixed {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeMethod
@BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://www.snapdeal.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  
  // Launch snapdeal application
  @Test()
  
  public void testECommerceSite() throws Exception 
  {
    driver.get(baseUrl + "/");
    
  
  // Search a Product i.e. Mobile
  
	  driver.findElement(By.id("inputValEnter")).click();
	  driver.findElement(By.id("inputValEnter")).click();
	  driver.findElement(By.id("inputValEnter")).clear();
	  driver.findElement(By.id("inputValEnter")).sendKeys("mobile");
	  driver.findElement(By.xpath("//button[@onclick=\"submitSearchForm('go_header');\"]")).click();

  
  // First Product in the search Results selected
  
    driver.findElement(By.xpath("(//img[contains(@class,'product-image')])[1]")).click();
    
    java.util.Set<String> windows = driver.getWindowHandles();
    for(String window : windows)
    driver.switchTo().window(window);
 
  
  // Add the selected product to cart  
    driver.findElement(By.xpath("//div[@id='add-cart-button-id']/span")).click();
    driver.findElement(By.linkText("Proceed To Checkout")).click();
  
  }

  @AfterMethod
public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      Assert.fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
