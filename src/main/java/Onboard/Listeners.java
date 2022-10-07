package Onboard;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import BaseFunctions.Setup;

public class Listeners extends Setup implements ITestListener {


    public void onTestStart(ITestResult result) {

        System.out.println("Onboarding Started");

    }

    public void onTestSuccess(ITestResult result) {


    }

    public void onTestFailure(ITestResult result ) {


        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        File targetfolder = new File(".\\Screenshots\\Failedscreenshot.png");
        try {
            FileUtils.copyFile(src, targetfolder);
        } catch (IOException e) {

            e.printStackTrace();
        }

    }

    public void onTestSkipped(ITestResult result) {

        System.out.println("Test is Skipped");

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

        System.out.println("Test Failed with sucess Percentage");
    }

    public void onTestFailedWithTimeout(ITestResult result) {

        System.out.println("Test Failed");

    }

    public void onStart(ITestContext context) {

    }

    public void onFinish(ITestContext context) {

    }

}
