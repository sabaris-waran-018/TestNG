package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DashboardPage {

	WebDriver driver;
	
	public DashboardPage (WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(how=How.LINK_TEXT,using ="Form Authentication")
	WebElement formAuthenticationLnk;
	
	public void selectLnk(String link) throws InterruptedException {
		
		switch(link.toUpperCase()) {
		  case "FORM AUTHENTICATION":
			  formAuthenticationLnk.click();
			  Thread.sleep(2000);
		    break;
		  case "x":
		    //will be developed in future
		    break;
		  default:
		    // no default is set for now
			 
		}
		
	}
	
}
