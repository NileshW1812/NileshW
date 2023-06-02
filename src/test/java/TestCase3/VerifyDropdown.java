package TestCase3;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.nilesh.project.Utility2;
import Pages3.OmayoDropwon;

public class VerifyDropdown {
	WebDriver driver;
	OmayoDropwon omayodropwon;

	@BeforeMethod(alwaysRun = true)
	public void setup() {
		driver = Utility2.getDriver();
		driver.get(Utility2.getProperty("url"));
		driver.manage().window().maximize();
		omayodropwon = new OmayoDropwon(driver);
	}

	@Test(priority = 1, groups = { "sanity" }, enabled = true)
	public void verifyDropDown1() {
		Select select = new Select(omayodropwon.getMultipleselectbox());
		List<WebElement> dropdownoption = select.getOptions();
		for (WebElement dd : dropdownoption) {
			System.out.println(dd.getText());
		}

		System.out.println(select.isMultiple());

		select.selectByValue("swiftx");
		select.selectByVisibleText("Hyundai");

	}

	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			Utility2.getScreenshot(driver, result.getName());
		}

//		driver.quit();
	}
}
