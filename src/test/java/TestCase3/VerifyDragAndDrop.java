package TestCase3;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.nilesh.project.Utility2;

import Pages3.DropablePage;

public class VerifyDragAndDrop {
	WebDriver driver;
	DropablePage dropablePage;

	@BeforeMethod(alwaysRun = true)
	public void setup() {
		driver = Utility2.getDriver();
		driver.get(Utility2.getProperty("url"));
		driver.manage().window().maximize();
		dropablePage = new DropablePage(driver);

	}

	@Test(priority = 1, groups = { "sanity" }, enabled = true)
	public void verifyDragAndDrop() {

		WebElement frame = driver.findElement(By.xpath("//*[@id=\"content\"]/iframe"));
		driver.switchTo().frame(frame);

		WebElement drag = dropablePage.getDraggable();
		WebElement drop = dropablePage.getDroppable();

		Actions action = new Actions(driver);
		action.dragAndDrop(drag, drop).perform();
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			Utility2.getScreenshot(driver, result.getName());
		}

		driver.quit();
	}
}
