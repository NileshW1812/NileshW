package TestCase3;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.nilesh.project.Utility2;
public class VerifyMultipleWindow {
	WebDriver driver;

	@BeforeMethod(alwaysRun = true)
	public void setup() {
		driver = Utility2.getDriver();
		driver.get(Utility2.getProperty("url"));
		driver.manage().window().maximize();

	}

	@Test(priority = 1, groups = { "sanity" }, enabled = true)
	public void verifyMultipleWindow() {
		System.out.println(driver.getTitle());
		String parentwindowhandle=driver.getWindowHandle();
		Set<String>allwindowhandle=driver.getWindowHandles();
		for(String handle:allwindowhandle) {
			if(!(handle.equals(parentwindowhandle))) {
				driver.switchTo().window(handle);
				if(driver.getTitle().equals("https://www.ironspider.ca/forms/checkradio.htm"));
			}
		}
		driver.findElement(By.xpath("//a[@href='http://www.chami.com/html-kit/']"));
              allwindowhandle=driver.getWindowHandles();
              for(String handle2:allwindowhandle) {
            	  if(!(handle2.equals(allwindowhandle))) {
            		  driver.switchTo().window(handle2);
            		  if(driver.getTitle().equals("http://www.chami.com/html-kit/")) {
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
