package pages2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NewToursHomePage2 {
	WebDriver driver;
    WebElement pageTitle;

	public NewToursHomePage2(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getPageTitle() {
		setPageTitle();
		return pageTitle;
	}

	public void setPageTitle() {
		this.pageTitle = driver.findElement(By.xpath("[text()='Welcome: Mercury Tours']"));
		}

}
