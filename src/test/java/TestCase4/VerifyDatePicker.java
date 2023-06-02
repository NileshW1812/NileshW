package TestCase4;

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

import Pages4.DemoQaWebPage;

public class VerifyDatePicker {
	WebDriver driver;
	DemoQaWebPage demoqaoform;

	@BeforeMethod(alwaysRun = true)
	public void setup() {
		driver = Utility2.getDriver();
		driver.get(Utility2.getProperty("url"));
		driver.manage().window().maximize();
		demoqaoform = new DemoQaWebPage(driver);

	}

	@Test(priority = 1, groups = { "sanity" }, enabled = true)
	public void verifyDatePicker() {

		driver.findElement(By.id("dateOfBirthInput")).click();
		WebElement monthdropdown = driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']"));
		Utility2.selectValueFromDropdown(monthdropdown, "May");

		// DemoQaForm.SelectValueFromDropDown(monthdropdown, "may");

		WebElement yeardropdown = driver.findElement(By.xpath("//select[@class='react-datepicker__year-select']"));
		Utility2.selectValueFromDropdown(yeardropdown, "2023");

		// DemoQaForm.SelectValueFromDropDown(yeardropdown, "2023");

		List<WebElement> dates = driver
				.findElements(By.xpath("//div[@class='react-datepicker__month-container']//div[@role='option']"));
		for (WebElement date1 : dates) {
			if (date1.getText().contains("20")) {
				date1.click();
				break;
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
