package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Helper.BaseNewLook;

public class LginPage extends BaseNewLook {

	public void user_launch_site_url() {
		
	   
	}
	
	public void verify_the_new_look_logo_is_present_or_not() {
		WebElement LogoVerify=driver.findElement(By.id("NewLookLogo"));
		LogoVerify.isDisplayed();
		
	    
	}

	
	public void click_on_the_user_account_button() throws InterruptedException {
		WebElement useraccount=driver.findElement(By.xpath("//span[@class='masthead__icon-text']//following::div[@class='masthead-account__wrapper']"));
	    useraccount.click();
	    Thread.sleep(2000);
	}

	
	public void user_enter_unvalid_username_and_password() throws InterruptedException {
	WebElement username=driver.findElement(By.xpath("//input[@id='j_username']"));
	username.sendKeys(prop.getProperty("username"));
	Thread.sleep(2000);
	WebElement password=driver.findElement(By.xpath("//input[@id='j_password']"));
	password.sendKeys(prop.getProperty("password"));
	Thread.sleep(2000);
	}

	
	public void user_click_on_login_button() {
		WebElement signin=driver.findElement(By.xpath("//div[@class='form-group']//button[@type='submit']"));
		signin.click();
	  
	}

	public void verify_the_error_message() {
		String ErrorMessageActual=driver.findElement(By.xpath("//li[@class='alert__item alert__item--rendered']")).getText();
		String ErrorMessageExpected="Your email or password was incorrect";
		Assert.assertEquals(ErrorMessageActual, ErrorMessageExpected);
		driver.quit();
		
		
		
	}


}
