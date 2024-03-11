package testCases;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pageObjects.LoginPage;

public class TC_001 extends BaseClass{
	
	@Test
	public void logiTest() throws InterruptedException {
		test = extent.createTest("NOP COMMERCE LOGIN TEST");
		test.log(Status.INFO,"Application is up and running");
		driver.get(url);
		test.log(Status.INFO,"reached the website under testing");
		
		LoginPage lp=new LoginPage(driver);
		
		lp.clearUsernameAndPassword();
		
		test.log(Status.INFO,"clear default username and passsword");
		
		lp.enterUsernameAndPasswordAndLogin(username,password);
		
		test.log(Status.INFO,"enter valid username and passsword and click login");
		
		Thread.sleep(5000);
		
		test.log(Status.INFO,"logged in succesfully");

	}

}
