package Onboard;

import BaseFunctions.Setup;
import Pageobjects.AddobPageobjects;
import com.aventstack.extentreports.Status;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static Utilities.FileUpload.uploadfile;

public class AddOB extends Setup {

    static String OnboardingAadharFront = "C:\\Onboarding Aadhar Front\\";
    static String OnboardingAadharBack = "C:\\Onboarding Aadhar Back\\";

    static String Onboardingbankimages = "C:\\Onboarding Bank Images\\";
    static String OnboardingResumes = "C:\\Onboarding Resume Datas\\";


    @Test
    public static void ADDINGEMPLOYEE() throws AWTException, InterruptedException, IOException {

        test = extent.createTest("Initiate Onboarding");

        Logger log = Logger.getLogger("OnboardingLogs");

        PageFactory.initElements(driver, AddobPageobjects.class);

        log.info("Onboarding module is clicked");
        AddobPageobjects.ob.click();

        Thread.sleep(800);
        log.info("Add OB Employee module is clicked");
        AddobPageobjects.addob.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        log.info(" Excel File Path is Getting");
        FileInputStream File = new FileInputStream(OnboardingFilepath);

        log.info("Getting Workbook");
        HSSFWorkbook workbook = new HSSFWorkbook(File);

        log.info("Getting Sheet");
        HSSFSheet sheet = workbook.getSheet("OnboardDatas");

        log.info("Getting TotalRows");
        int noforows = sheet.getLastRowNum();

        for (int row = 1; row <= noforows; row++) {

            HSSFRow currentrow = sheet.getRow(row);

            String division_name = currentrow.getCell(0).getStringCellValue();
            String divisionnameuc = division_name.toUpperCase();
            log.info("Getting division name" + division_name);

            String branch_name = currentrow.getCell(1).getStringCellValue();
            log.info("Getting Branch name" + branch_name);

            String town_name = currentrow.getCell(2).getStringCellValue();
            log.info("Getting Town name" + town_name);

            String State_name = currentrow.getCell(3).getStringCellValue();
            String statenameuc = State_name.toUpperCase();
            log.info("Getting State name" + State_name);

            String reporting_manager = currentrow.getCell(4).getStringCellValue();
            log.info("Getting Reporting manager name" + reporting_manager);

            String reporting_manager2 = currentrow.getCell(5).getStringCellValue();
            log.info("Getting Reporting manager 2 name" + reporting_manager2);

            String designation = currentrow.getCell(6).getStringCellValue();
            log.info("Getting designation" + designation);

            String Employeecategory = currentrow.getCell(7).getStringCellValue();
            log.info("Getting Employeecategory" + Employeecategory);

            String clientbranch = currentrow.getCell(8).getStringCellValue();
            String Clientbranchuc = clientbranch.toUpperCase();
            log.info("Getting clientbranch" + clientbranch);

            String dateofjoin = currentrow.getCell(9).getStringCellValue();
            log.info("Getting dateofjoin" + dateofjoin);

            String Aadharfront = currentrow.getCell(10).getStringCellValue();
            log.info("GettingAadharfrontimagepath" + Aadharfront);

            String Aadharback = currentrow.getCell(11).getStringCellValue();
            log.info("GettingAadharbackimagepath" + Aadharback);

            String Resume = currentrow.getCell(12).getStringCellValue();
            log.info("GettingResumepath" + Resume);

            String DateofBirth = currentrow.getCell(13).getStringCellValue();
            log.info("GettingDateofBirth" + DateofBirth);

            String Aadharcardnum = currentrow.getCell(14).getStringCellValue();
            log.info("Getting Aadharcardnum" + Aadharcardnum);

            String first_name = currentrow.getCell(15).getStringCellValue();
            log.info("Getting first_name" + first_name);

            String email_id = currentrow.getCell(16).getStringCellValue();
            log.info("Getting  email_id" + email_id);

            String mobile_number = currentrow.getCell(17).getStringCellValue();
            log.info("Getting mobile_number" + mobile_number);

            String Bankaccnum = currentrow.getCell(18).getStringCellValue();
            log.info("Getting Bankaccnum" + Bankaccnum);

            String IFSCcode = currentrow.getCell(19).getStringCellValue();
            log.info("Getting IFSCcode" + IFSCcode);

            String Bankimage = currentrow.getCell(20).getStringCellValue();
            log.info("Getting Bankimagepath" + Bankimage);

            // Int is changed to String
            log.info("Mobile number is changed into String");
            String mobile_num = " " + mobile_number;

            log.info("Aadhar number is changed into String");
            String Aadhar_num = " " + Aadharcardnum;

            log.info("Bankaccountnumber is changed into String");
            String Bank_acc_num = " " + Bankaccnum;


            // Division
            Select select1 = new Select(AddobPageobjects.division);
            select1.selectByVisibleText(divisionnameuc);
            log.info("Division name is Selected");

            // Branch
            Thread.sleep(1000);
            Select select2 = new Select(AddobPageobjects.branch);
            log.info("Branch name is Selected");
            select2.selectByVisibleText(branch_name);

            // Town
            Thread.sleep(1000);
            Select select3 = new Select(AddobPageobjects.town);
            log.info("Town name is Selected");
            select3.selectByVisibleText(town_name);

            Thread.sleep(1000);

            // State
            Select select4 = new Select(AddobPageobjects.state);
            log.info("State name is Selected");
            select4.selectByVisibleText(statenameuc);

            // Reportingmanager1
            Select select5 = new Select(AddobPageobjects.RM1);
            log.info("Reporting Manager 1 is Selected");
            select5.selectByVisibleText(reporting_manager);

            // Reportingmanager2
            Select select6 = new Select(AddobPageobjects.RM2);
            log.info("Reporting Manager 2 is Selected");
            select6.selectByVisibleText(reporting_manager2);

            // Designation
            Select select7 = new Select(AddobPageobjects.Desig);
            log.info("Designation is Selected");
            select7.selectByVisibleText(designation);

            // Employeecategory
            /*Select select8 = new Select(AddobPageobjects.empcat);
            log.info("Category  is Selected");
            select8.selectByVisibleText(Employeecategory);
            test.log(Status.INFO, " [ " + Employeecategory + " ] " + "Category  is Selected");*/


            // Clientbranch
            Select select9 = new Select(AddobPageobjects.clientbranch);
            log.info("Client Branch is Selected");
            select9.selectByVisibleText(Clientbranchuc);

            // Calender
            log.info("Date of Join is Selected");
            AddobPageobjects.dateofjoin.sendKeys(dateofjoin);

            //Aadhar front image
            uploadfile(OnboardingAadharFront , Aadharfront);

            // Aadhar back image
            uploadfile(OnboardingAadharBack , Aadharback);

            // Resume
            uploadfile(OnboardingResumes , Resume);

            log.info("DOB Is Entered");
            AddobPageobjects.DOB.sendKeys(DateofBirth);

            // Aadhar number
            Thread.sleep(100);
            log.info("Aadhar number is Entered");
            String trimmedAadhar = Aadhar_num.trim();
            AddobPageobjects.Aadharno.sendKeys(Aadharcardnum);  //"6787657699"+GetRandAadharnum()

            // Candidate Username
            log.info("Firstname is Entered");
            AddobPageobjects.Firstname.sendKeys(first_name);

            // CandidateEmail			
            log.info("Email is Entered");
            AddobPageobjects.candidateemail.sendKeys(email_id);   //getrandomemail()

            // Mobilenumber
            log.info("Mobile number is Entered");
            String trimmedmno = mobile_num.trim();
            AddobPageobjects.candidatemobileno.sendKeys(mobile_number);  //"8248606"+GetRandomMobilenum()

            AddobPageobjects.Aadharno.sendKeys(Aadhar_num);
            log.info("Aadhar number is Entered");

            log.info("BankAccount number is Entered");
            AddobPageobjects.Accno.sendKeys(Bank_acc_num);   //"89879879879"+GetRandomAccnum()

            log.info("IFSC Code  is Entered");
            AddobPageobjects.IFSC.sendKeys(IFSCcode);

            // Bankproofimage

            uploadfile(Onboardingbankimages , Bankimage);


            Thread.sleep(500);
            log.info("Submit Button is Clicked");
            AddobPageobjects.submitbutton.click();

            // Infomsg
            String message = AddobPageobjects.infomsg.getText();
            System.out.println("Username--" + first_name + "====>" + "[" + message + "]");
            test.log(Status.INFO, " Username-- " + first_name + " ====>" + "[ " + message + " ] ");
            log.info("Username--" + first_name + "====>" + "[" + message + "]");


            log.info("Onboarding module is clicked");
            AddobPageobjects.ob.click();


            log.info("Add OB Employee module is clicked");
            AddobPageobjects.addob.click();

        }


    }

}

