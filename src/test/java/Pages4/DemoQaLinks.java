package Pages4;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DemoQaLinks {
	WebDriver driver;
	private WebElement pagetitle;

	public DemoQaLinks(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getPagetitle() {
		setPagetitle();
		return pagetitle;
	}

	public void setPagetitle() {
		this.pagetitle = driver.findElement(By.xpath("/html/head/title[1]"));
	}

	public List<WebElement> allLink() {
		List<WebElement> links = driver.findElements(By.xpath("//a"));
		for (WebElement elm : links) {
			System.out.println(elm.getAttribute("href"));
		}
		return allLink();

	}
}
