package TestCase2;

import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.nilesh.project.Utility2;

public class WaitsOnClickButton {
	WebDriver driver;

	@BeforeMethod(alwaysRun = true)
	public void setup() throws IOException {
		driver = Utility2.getDriver();
		driver.get(Utility2.getProperty("url"));
		driver.manage().window().maximize();

	}

	@Test(priority = 1, groups = { "sanity" }, enabled = true)
	public void verifyWaitsOnAlert() {

		driver.findElement(By.xpath("//button[@id='alertButton']")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		System.out.println(driver.getTitle());

	}

	@Test(priority = 1, groups = { "sanity" }, enabled = true)
	public void verifyWaitsInSecAlert() {

		driver.findElement(By.xpath("//button[@id='timerAlertButton']")).click();
		FluentWait<WebDriver> fluentwait = new FluentWait<WebDriver>(driver);
		fluentwait.withTimeout(Duration.ofSeconds(15)).pollingEvery(Duration.ofMillis(200))
				.ignoring(NoSuchElementException.class).until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		System.out.println(driver.getTitle());

	}

	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			Utility2.getScreenshot(driver, result.getName());
		}

//		driver.quit();
	}
}
