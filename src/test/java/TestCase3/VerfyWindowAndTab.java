package TestCase3;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.nilesh.project.Utility2;
import Pages3.OmayoIframe;

public class VerfyWindowAndTab {
	WebDriver driver;
	OmayoIframe omayoiframe;

	@BeforeMethod(alwaysRun = true)
	public void setup() {
		driver = Utility2.getDriver();
		driver.get(Utility2.getProperty("url"));
		driver.manage().window().maximize();
		omayoiframe = new OmayoIframe(driver);
	}

	@Test(priority = 1, groups = { "sanity" }, enabled = false)
	public void verifyWindow() {
		driver.switchTo().newWindow(WindowType.WINDOW).get("https://WWW.google.com");

	}

	@Test(priority = 1, groups = { "sanity" }, enabled = false)
	public void verifyNewTab() {
		driver.switchTo().newWindow(WindowType.TAB).get("http://omayo.blogspot.com/");

	}

	@Test(priority = 1, groups = { "sanity" }, enabled = true)
	public void verifyNewWidowhandle() {
		driver.switchTo().frame(omayoiframe.getIframe());
		omayoiframe.getLink().click();

		String parentwindowhandle = driver.getWindowHandle();
		Set<String> allwindowhandle = driver.getWindowHandles();
		for (String handle : allwindowhandle) {
			if (!(handle.equals(allwindowhandle))) {
				driver.getTitle().equals("https://www.blogger.com/blog/posts/7427117225957127479#create");
			}
		}
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			Utility2.getScreenshot(driver, result.getName());
		}

//		driver.quit();
	}
}
