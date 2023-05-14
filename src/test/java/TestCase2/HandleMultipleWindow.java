package TestCase2;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.nilesh.project.Utility2;

import pages2.HomePageOmayo;

public class HandleMultipleWindow {
	WebDriver driver;
	HomePageOmayo homepageomayo;

	@BeforeMethod(alwaysRun = true)
	public void setUp() {
		driver = Utility2.getDriver();
		driver.get(Utility2.getProperty("url"));
		driver.manage().window().maximize();
		homepageomayo = new HomePageOmayo(driver);
	}

	@Test
	public void VerifyHandleMultipleWindow() {
		homepageomayo.getLink1().click();
		System.out.println(driver.getTitle());

		String parentwindowhandle = driver.getWindowHandle();
		Set<String> allwindowhandles = driver.getWindowHandles();
		for (String handle : allwindowhandles) {
			if (!(handle.equals(parentwindowhandle))) {
				driver.switchTo().window(handle);
				if (driver.getTitle().equals("http://selenium143.blogspot.com/"))
					;
			}
		}
		driver.findElement(By.xpath("//a[@id='sc_counter_9037253']")).click();
		allwindowhandles = driver.getWindowHandles();
		for (String handle2 : allwindowhandles) {
			if (handle2.equals(parentwindowhandle)) {
				driver.switchTo().window(handle2);
				if (driver.getTitle().equals("http://selenium143.blogspot.com")) {
					;
					continue;
				}
			}
		}
		System.out.println(driver.getTitle());
		driver.switchTo().window(parentwindowhandle);
		driver.navigate().back();

	}

	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			Utility2.getScreenshot(driver, result.getName());
		}
//		driver.quit();
	}

}