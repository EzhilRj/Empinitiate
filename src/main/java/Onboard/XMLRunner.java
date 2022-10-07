package Onboard;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;

public class XMLRunner {

	public static void main(String[] args) {

		TestNG runner = new TestNG();
		List<String> suitefiles = new ArrayList<String>();
		suitefiles.add("C:\\Users\\Admin\\eclipse-workspace\\AB Onboarding\\TestRunner\\Onboarding.xml");
		runner.setTestSuites(suitefiles);
		runner.run();

	}

}
