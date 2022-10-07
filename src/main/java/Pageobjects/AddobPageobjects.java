package Pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddobPageobjects {
	
	@FindBy(xpath="//*[text()='OnBoard']")
	public static WebElement ob ;
	
	@FindBy(xpath="//*[text()='Add OB Employee']")
	public static WebElement addob ;
	
	@FindBy(id="ctl00_Content_dd_division")
	public static WebElement division ;
	
	@FindBy(id="ctl00_Content_ddl_branch")
	public static WebElement branch ;
	
	@FindBy(id="ctl00_Content_ddl_Town")
	public static WebElement town ;
	
	@FindBy(xpath="//*[@id=\"ctl00_Content_ddlstate\"]")
	public static WebElement state ;
	
	@FindBy(id="ctl00_Content_ddlReportingMgr")
	public static WebElement RM1 ;
	
	@FindBy(id="ctl00_Content_ddlReportingMGr2")
	public static WebElement RM2 ;
	
	@FindBy(id="ctl00_Content_ddlDesignation")
	public static WebElement Desig ;
	
	@FindBy(id="ctl00_Content_ddlEmpCategory")
	public static WebElement empcat ;
	
	@FindBy(id="ctl00_Content_ddlClientBranch")
	public static WebElement clientbranch ;
	
	//@FindBy(id="ctl00_Content_btnOne")
	//public static WebElement calender ;
	
	//@FindBy(xpath="//div[@id='ctl00_Content_calOne_day_4_4']")
	//public static WebElement datepick ;
	
	@FindBy(id="ctl00_Content_txtDateOfJoining")
	public static WebElement dateofjoin;
	
	@FindBy(xpath="//input[@id='ctl00_Content_fuAadhar']")
	public static WebElement Aadharimage ;

	@FindBy(id ="ctl00_Content_txtDOB")
	public static WebElement DOB;
	
	@FindBy(id="ctl00_Content_txtAadhar")
	public static WebElement Aadharno ;
	
	@FindBy(id="ctl00_Content_txtEmpName")
	public static WebElement Firstname ;
	
	@FindBy(id="ctl00_Content_txtmidname")
	public static WebElement Middlename ;
	
	@FindBy(id="ctl00_Content_txtlastname")
	public static WebElement lastname ;
	
	@FindBy(id="ctl00_Content_txtEmployeeEmail")
	public static WebElement candidateemail ;
	
	@FindBy(id="ctl00_Content_txtMobile")
	public static WebElement candidatemobileno ;
	
	@FindBy(id="ctl00_Content_txtbankacnumber")
	public static WebElement Accno ;
	
	@FindBy(id="ctl00_Content_txtifsccode")
	public static WebElement IFSC ;
	
	@FindBy(xpath="//input[@id='ctl00_Content_fubank']")
	public static WebElement bankimage ;
	
	@FindBy(id="ctl00_Content_btnAdminSubmit")
	public static WebElement submitbutton;
	
	@FindBy(id="ctl00_Content_lblMessage2")
	public static WebElement infomsg;
	
	
	
	
	
	
	
	
	

}

