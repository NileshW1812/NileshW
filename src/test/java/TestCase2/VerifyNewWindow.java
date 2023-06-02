package TestCase2;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.nilesh.project.Utility2;
import pages2.HomePageOmayo;

public class VerifyNewWindow {
	WebDriver driver;
	HomePageOmayo homepageomayo;

	@BeforeMethod(alwaysRun = true)
	public void setup() throws IOException {
		driver = Utility2.getDriver();
		driver.get(Utility2.getProperty("url"));
		driver.manage().window().maximize();
		homepageomayo = new HomePageOmayo(driver);

	}

	@Test(priority = 1, groups = { "sanity" }, enabled = true)
	public void verifyWindow() {
		homepageomayo.getLink().click();
		driver.navigate().back();
	}

	@Test(priority = 1, groups = { "sanity" }, enabled = true)
	public void verifyOpenWindow() {
		driver.switchTo().newWindow(WindowType.WINDOW).get("http://selenium143.blogspot.com/");
		driver.switchTo().newWindow(WindowType.TAB).get("http://omayo.blogspot.com/");
	}

	@Test(priority = 0, groups = { "sanity" }, enabled = true)
	public void verfyWindowHandle() {
		String parentwindowhandle = driver.getWindowHandle();
		Set<String> allwindowhandle = driver.getWindowHandles();
		for (String handle : allwindowhandle) {
			if (!(handle.equals(allwindowhandle))) {
				driver.getTitle().equals("https://www.blogger.com/about/?bpli=1");
			}
		}
		System.out.println(driver.getTitle());
		driver.switchTo().window(parentwindowhandle);
		homepageomayo.getText1().sendKeys("this is my text");
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			Utility2.getScreenshot(driver, result.getName());
		}

		driver.quit();
	}

}
