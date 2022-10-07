package BaseFunctions;

import Utilities.DirectoryCreation;
import Utilities.ExcelCreation;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

public class Setup {

	protected static WebDriver driver;
	public static ExtentHtmlReporter htmlreporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	protected static String OnboardingFilepath = "C:\\Onboarding datas\\OnboardingHSSF.xls";

	long StartTime;
	long endTime;

	@BeforeSuite
	public void Startbrowser() throws IOException {

		Logger log = Logger.getLogger("ABOnboardingLogs");
		DOMConfigurator.configure("Log4J.xml");

		Properties prop = new Properties();
		FileInputStream stream = new FileInputStream("./src/main/resources/Config Files/Onboarding.properties");
		prop.load(stream);

		String browser = prop.getProperty("browser");
		String url = prop.getProperty("url");

		if (browser.equalsIgnoreCase("chrome")) {

			log.info("Chrome is Opened successfully ");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("firefox")) {

			log.info("firefox is Opened successfully ");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		} else if (browser.equalsIgnoreCase("Edge")) {

			log.info("MicrosoftEdge is Opened successfully ");
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

		}

		DirectoryCreation.CreateDatadir();

		File obfile = new File(OnboardingFilepath);

		if (obfile.exists()) {

		} else {

			ExcelCreation.Createxcelsheet();

		}

		log.info("Cookies Deleted ");
		driver.manage().deleteAllCookies();

		log.info("Page is navigated to" + url);

		driver.navigate().to(url);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		DirectoryCreation.CreateScreenshotdir();
		DirectoryCreation.CreateAadharFrontdir();
		DirectoryCreation.CreateAadharBackdir();
		DirectoryCreation.createBankdir();
		DirectoryCreation.createResumedir();

	}

	@AfterSuite(enabled = true)
	public void teardown() throws InterruptedException {

		Logger log = Logger.getLogger("Logs");

		log.info("Browser Closed");
		driver.quit();
		endTime = System.currentTimeMillis();
		long Totaltime = endTime - StartTime;
		System.out.println("TIMETAKEN:" + Totaltime);

	}

	@BeforeTest
	public void setextent() {

		htmlreporter = new ExtentHtmlReporter(
				System.getProperty("user.dir") + "/src/main/resources/Reports/OnBoardingExtentReport.html");
		htmlreporter.config().setDocumentTitle("OnboardingReport");
		htmlreporter.config().setReportName("Onboarding Expert");
		htmlreporter.config().setTheme(Theme.DARK);

		extent = new ExtentReports();
		extent.attachReporter(htmlreporter);

		extent.setSystemInfo("Hostname", "LocalHost");
		extent.setSystemInfo("OS", "Windows11");
		extent.setSystemInfo("Tester Name", "EzhilRaj");

	}

	@AfterTest
	public void EndReport() {

		extent.flush();

	}

	@AfterMethod
	public void teardown(ITestResult result) throws IOException {

		if (result.getStatus() == ITestResult.FAILURE) {

			test.log(Status.FAIL, "TEST CASE FAILED IS" + result.getName());
			test.log(Status.FAIL, "TEST CASE FAILED IS" + result.getThrowable());

			String Screenshotpath = Setup.getscreenshot(driver, result.getName());
			test.addScreenCaptureFromPath(Screenshotpath); // adding Screen shot
		} else if (result.getStatus() == ITestResult.SKIP) {

			test.log(Status.SKIP, "Test Case SKIPPED IS " + result.getName());
		} else if (result.getStatus() == ITestResult.SUCCESS) {

			test.log(Status.PASS, "Test Case PASSED IS" + result.getName());
		}

	}


	public static String getscreenshot(WebDriver driver, String Screenshotname) throws IOException {

		String Datename = new SimpleDateFormat("yyyymmddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File Source = ts.getScreenshotAs(OutputType.FILE);

		String destination = System.getProperty("user.dir") + "/Screenshots/" + Screenshotname + Datename + ".png";
		File finaldestination = new File(destination);
		FileUtils.copyFile(Source, finaldestination);
		return destination;

	}

	public static String GetRandAadharnum() {

		Random rand =  new Random();
		int randaadhint = rand.nextInt(99);
		String randaadhint1 = Integer.toString(randaadhint);

		return randaadhint1;

	}

	public static String getrandomemail() {

		String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < 10) { // length of the random string.
			int index = (int) (rnd.nextFloat() * SALTCHARS.length());
			salt.append(SALTCHARS.charAt(index));
		}
		String saltStr = salt.toString()+"@gmail.com";
		return saltStr;

	}

	public static String GetRandomMobilenum() {

		Random rand =  new Random();
		int randint = rand.nextInt(999);
		String randint1 = Integer.toString(randint+1);

		return randint1;

	}

	public static String GetRandomAccnum() {

		Random rand =  new Random();
		int randint = rand.nextInt(9999);
		String randacc = Integer.toString(randint);

		return randacc;

	}

	

}