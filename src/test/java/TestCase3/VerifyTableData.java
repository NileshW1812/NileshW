package TestCase3;

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
import Pages3.ReadTabbleData;

public class VerifyTableData {
	WebDriver driver;
	ReadTabbleData readtabledata;

	@BeforeMethod(alwaysRun = true)
	public void setup() throws IOException {
		driver = Utility2.getDriver();
		driver.get(Utility2.getProperty("url"));
		driver.manage().window().maximize();
		readtabledata = new ReadTabbleData(driver);

	}

	@Test(priority = 1, groups = { "sanity" }, enabled = false)
	public void verifyTableData() {
		readtabledata.getTable();
	}

	@Test(priority = 2, groups = { "sanity" }, enabled = false)
	public void verifyTableData1() {
		readtabledata.ReadTabbleData1(driver);
	}

	@Test(priority = 0, groups = { "sanity" }, enabled = true)
	public void verifyTableData2() {

		List<WebElement> alldata = driver.findElements(By.xpath("//table[@id='customers']//tbody//tr[2]//td[2]"));
		for (WebElement elm : alldata) {
			System.out.println(elm.getText());
		}
	}

	@Test(priority = -5, groups = { "sanity" }, enabled = true)
	public void verifyTableData3() {

		List<WebElement> alldata = driver.findElements(By.xpath("//table[@id='customers']//tbody//tr[4]//td[1]"));
		for (WebElement elm : alldata) {
			System.out.println(elm.getText());
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
