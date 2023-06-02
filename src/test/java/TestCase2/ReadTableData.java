package TestCase2;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.nilesh.project.Utility2;
import pages.HomePage;

public class ReadTableData {
	WebDriver driver;
	

	@BeforeMethod(alwaysRun = true)
	public void setup() throws IOException {
		driver = Utility2.getDriver();
		driver.get(Utility2.getProperty("url"));
		driver.manage().window().maximize();
		

	}

	@Test(priority = 1, groups = { "sanity" }, enabled = true)
	public void verifyTableData() {
		
//		List<WebElement> alldata = driver.findElements(By.xpath("//table[@id='table1']//thead//tr/th"));
		List<WebElement> alldata1 = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr//td[2]"));
		for (WebElement elm1 : alldata1) {
			System.out.println(elm1.getText());
		}

	}

	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			Utility2.getScreenshot(driver, result.getName());
		}

		driver.quit();
	}

}
