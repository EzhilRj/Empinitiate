package Pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Loginpageobjects {

	@FindBy(id = "txtUsername")
	public static WebElement username;

	@FindBy(id = "txtPassword")
	public static WebElement password;

	@FindBy(id = "txtClient")
	public static WebElement company;

	@FindBy(id = "btnLogin")
	public static WebElement submit;

	@FindBy(xpath = "//*[@id=\"aspnetForm\"]/div[4]/div/div[1]/div/div[1]/h1")
	public static WebElement getmsg;

}
