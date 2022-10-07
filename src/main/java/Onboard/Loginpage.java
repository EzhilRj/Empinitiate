package Onboard;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import BaseFunctions.Setup;
import Pageobjects.Loginpageobjects;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Loginpage extends Setup {
	
	@Test(priority = 1)
	public void LOGIN() throws InterruptedException, IOException {


		Properties prop = new Properties();
		FileInputStream stream = new FileInputStream("./src/main/resources/Config Files/Onboarding.properties");
		prop.load(stream);

		test  = extent.createTest("Loginpage");
		
		Logger log = Logger.getLogger("OnboardingLogs");
		test = extent.createTest("Login page");
		PageFactory.initElements(driver, Loginpageobjects.class);

		log.info("Username is Entered");
		String Uname = prop.getProperty("Username");
		Loginpageobjects.username.sendKeys(Uname);

		log.info("Password is Entered");
		String pword = prop.getProperty("password");
		Loginpageobjects.password.sendKeys(pword);

		log.info("Company ID is Entered");
		String comp = prop.getProperty("Company");
		Loginpageobjects.company.sendKeys(comp);

		log.info("Submit button is clicked");
		Loginpageobjects.submit.click();

	}
	
}
