package TestCases;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.DashboardPage;
import pages.FormAuthenticationPage;

import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class NewTest {
 
	WebDriver driver = null;
	FormAuthenticationPage formAuthenticationPage = null;
	DashboardPage dashboardPage = null;

  @BeforeTest
  public void beforeMethod() {
	 WebDriverManager.chromedriver().setup();
	 driver = new ChromeDriver();
	 
	 driver.manage().window().maximize();
	 driver.manage().deleteAllCookies();
	 
	 driver.get("https://the-internet.herokuapp.com/");
	 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
  }

  @AfterTest
  public void afterMethod() {
	  driver.quit();
  }

  
  @Test
  public void testCase2() throws InterruptedException {
	  
	  dashboardPage = new DashboardPage(driver);
	  dashboardPage.selectLnk("FORM AUTHENTICATION");
	  
	  formAuthenticationPage = new FormAuthenticationPage(driver);
	  formAuthenticationPage.enterUserName("tomsmith");
	  Thread.sleep(1000);
	  formAuthenticationPage.enterPassword("SuperSecretPassword!");
	  formAuthenticationPage.clickOn("login");
	  
  }
  
  @Test
  public void testCase1() {
	  
	  
	  driver.findElement(By.linkText("Form Authentication")).click();
	  driver.findElement(By.name("username")).sendKeys("tomsmith");
	  driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
	  driver.findElement(By.xpath("//button[@type='submit']")).click();
	  Assert.assertTrue(driver.findElement(By.id("flash-messages")).isDisplayed());
  }

}
