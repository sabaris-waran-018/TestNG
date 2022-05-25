package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FormAuthenticationPage {
	
	WebDriver driver;
	
	public FormAuthenticationPage (WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(id="username")
	WebElement userName;
	
	@FindBy(id="password")
	WebElement userPassword;

	@FindBy(xpath="//button[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(id="flash")
	WebElement flashMSG;
	
	@FindBy(linkText="/logout")
	WebElement logoutBtn;
	
	public void enterUserName(String name) {
		userName.clear();
		userName.sendKeys(name);
	}
	
	public void enterPassword (String psw) {
		userPassword.clear();
		userPassword.sendKeys(psw);
	}
	
	public void clickOn(String buttonName) {
		
		if(buttonName.contains("login")) {
			loginBtn.click();
		}else {
			logoutBtn.click();
		}
		
	}
	
	
	
	
	
}
