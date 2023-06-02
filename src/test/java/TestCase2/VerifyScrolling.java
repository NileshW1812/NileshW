package TestCase2;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.nilesh.project.Utility2;
import pages2.HomePageOmayo;

public class VerifyScrolling {
	WebDriver driver;
	HomePageOmayo homepageomayo;

	@BeforeMethod(alwaysRun = true)
	public void setup() throws IOException {
		driver = Utility2.getDriver();
		driver.get(Utility2.getProperty("url"));
		driver.manage().window().maximize();
		homepageomayo = new HomePageOmayo(driver);
	}

	@Test(priority = 1, groups = { "sanity" }, enabled = false)
	public void verifyPageScrolling() {
		JavascriptExecutor javascriptExecuter = (JavascriptExecutor) driver;
		javascriptExecuter.executeScript("window.scrollBy(0,1000)", "");
		javascriptExecuter.executeScript("window.scrollBy(0,-500)", "");
		javascriptExecuter.executeScript("window.scrollBy(1000,-500)", "");

	}

	@Test(priority = 0, groups = { "sanity" }, enabled = false)
	public void verifyScrollIntoView() {
		JavascriptExecutor javascriptExecuter = (JavascriptExecutor) driver;
		javascriptExecuter.executeScript("arguments[0].scrollIntoView(true);", homepageomayo.getDropdownbutton());
	}
	@Test(priority = 2, groups = { "sanity" }, enabled = false)
	public void verifyScrollViewClick() {
		JavascriptExecutor javascriptExecuter = (JavascriptExecutor) driver;
		javascriptExecuter.executeScript("arguments[0].click();", homepageomayo.getDropdownbutton());
	}
	@Test(priority = 5, groups = { "sanity" }, enabled = true)
	public void verifyScrollEndOfPage() {
		JavascriptExecutor javascriptExecuter = (JavascriptExecutor) driver;
		javascriptExecuter.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}



	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			Utility2.getScreenshot(driver, result.getName());
		}

//		driver.quit();
	}

}
