package TestCase;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.nilesh.project.Utility2;

public class SelectDateFromDatePicker {

	public static void main(String args[]) {
		WebDriver driver = Utility2.getDriver();
		driver.get("https://demoqa.com/automation-practice-form");
		driver.manage().window().maximize();

		driver.findElement(By.id("dateOfBirthInput")).click();

		WebElement monthDropdown = driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']"));
		Utility2.selectValueFromDropdown(monthDropdown, "June");

		WebElement yearDropdown = driver.findElement(By.xpath("//select[@class='react-datepicker__year-select']"));
		Utility2.selectValueFromDropdown(yearDropdown, "2022");

		List<WebElement> date = driver
				.findElements(By.xpath("//div[@class='react-datepicker__month-container']//div[@role='option']"));
		for (WebElement date1 : date) {
			if (date1.getText().contains("11")) {
				date1.click();
				break;
			}

		}

	}
}
