package TestCase2;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.nilesh.project.Utility2;

import pages2.DemoqaResgistration;

public class VerifyChooseFile {
	WebDriver driver;
	DemoqaResgistration demoqaresgistration;

	@BeforeMethod(alwaysRun = true)
	public void setup() {

		driver = Utility2.getDriver();
		driver.get(Utility2.getProperty("url"));
		driver.manage().window().maximize();
		demoqaresgistration = new DemoqaResgistration(driver);

	}

	@Test(priority = 1, groups = { "sanity" }, enabled = true)
	public void verifyUploadFile() {

		// WebElement uploaddriver =
		// driver.findElement(By.xpath("//input[@id='uploadPicture']"));
		demoqaresgistration.getChoosefile().sendKeys(
				"C:\\Users\\Asus\\Desktop\\Downloads\\B4Myproject\\src\\CollctionFramwor\\nilesh\\src\\test\\resources\\Registration3.xls");
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			Utility2.getScreenshot(driver, result.getName());
		}

//		driver.quit();
	}
}
