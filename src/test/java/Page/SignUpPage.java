package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Helper.BaseNewLook;

public class SignUpPage extends BaseNewLook {
	LginPage login=new LginPage();

	public void user_launch_the_site_url() {
		
		  
	}

	public void click_on_the_user_account_button() throws InterruptedException {
		login.click_on_the_user_account_button();
		
	    
	}

	public void click_on_the_create_an_account_button() throws InterruptedException {
		WebElement CreateAccountButton=driver.findElement(By.xpath("//*[text()='CREATE AN ACCOUNT']"));
		CreateAccountButton.click();
		Thread.sleep(2000);
		WebElement acceptCoocies=driver.findElement(By.xpath("//a[@onclick='window.nlcb.accept()']"));
		acceptCoocies.click();
		getScreenShot1();
	    
	}

	public void fill_all_the_mandatary_details_for_sign_up_a_user() throws InterruptedException {
		WebElement Email=driver.findElement(By.xpath("//input[@id='email']"));
		Email.sendKeys(prop.getProperty("email"));
		Thread.sleep(2000);
		WebElement password=driver.findElement(By.xpath("//input[@id='pwd']"));
		password.sendKeys(prop.getProperty("password"));
		Thread.sleep(2000);
		WebElement title=driver.findElement(By.xpath("//select[@id='titleCode']"));
		title.click();
		selectDroopDown(title, "mr");
		Thread.sleep(2000);
		WebElement FirstName=driver.findElement(By.xpath("//input[@id='firstName']"));
		FirstName.sendKeys(prop.getProperty("firstname"));
		Thread.sleep(2000);
		WebElement LastName=driver.findElement(By.xpath("//input[@id='lastName']"));
		LastName.sendKeys(prop.getProperty("lastname"));
		Thread.sleep(2000);
		WebElement checkbox=driver.findElement(By.xpath("//label[@class='label checkbox__label']"));
		checkbox.click();
		WebElement SubmitButton=driver.findElement(By.xpath("//button[text()='CREATE MY ACCOUNT']"));
		SubmitButton.click();
		Thread.sleep(2000);
		getScreenShot1();
		
		
	    
	}

	public void click_on_the_sign_up_button() throws InterruptedException {
		driver.switchTo().frame(0);
		WebElement SubmitButton=driver.findElement(By.xpath("//div[@class='form-group']//button"));
		SubmitButton.click();
		Thread.sleep(2000);
	
	}

	public void verify_the_success_text() {
	driver.switchTo().frame(0);
	String verifActualysuccessmessage=driver.findElement(By.xpath("//li[@class='alert__item alert__item--rendered']")).getText();
	 String VerifyExpectedSuccessText="Thanks for registering – and welcome!";
	 Assert.assertEquals(verifActualysuccessmessage,VerifyExpectedSuccessText);
	}


}
