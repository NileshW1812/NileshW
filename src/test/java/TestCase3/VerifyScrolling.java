package TestCase3;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.nilesh.project.Utility2;
public class VerifyScrolling {
	WebDriver driver;

	@BeforeMethod(alwaysRun = true)
	public void setup() {
		driver = Utility2.getDriver();
		driver.get(Utility2.getProperty("url"));
		driver.manage().window().maximize();

	}

	@Test(priority = 1, groups = { "sanity" }, enabled = false)
	public void verifyScrolling() {

		JavascriptExecutor javascript = (JavascriptExecutor) driver;

		javascript.executeScript("window.scrollBy(0,1000)", "");
		javascript.executeScript("window.scrollBy(0,-500)", "");
	}

	@Test(priority = 1, groups = { "sanity" }, enabled = false)
	public void verifyScrolling2() {

		JavascriptExecutor javascript = (JavascriptExecutor) driver;

		javascript.executeScript("window.scrollBy(500,1000)", "");
		javascript.executeScript("window.scrollBy(1000,500)", "");
	}

	@Test(priority = 1, groups = { "sanity" }, enabled = true)
	public void verifyScrolling3() {

		JavascriptExecutor javascript = (JavascriptExecutor) driver;
		WebElement link = driver.findElement(By.xpath("//a[@href='https://www.blogger.com']"));
		javascript.executeScript("arguments[0].scrollIntoView(true);", link);
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			Utility2.getScreenshot(driver, result.getName());
		}
//		driver.quit();
	}
}
