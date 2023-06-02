package Pages3;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DemoqaButtonAndLinks {
	WebDriver driver;

	public DemoqaButtonAndLinks(WebDriver driver) {
		this.driver = driver;
	}

	public List<WebElement> getAllButton() {
		List<WebElement> button = driver.findElements(By.xpath("//button"));
		Iterator<WebElement> it = button.iterator();
		System.out.println(button.size());
		while (it.hasNext()) {
			WebElement elm = it.next();
			System.out.println(elm.getText());
		}
		return button;

	}
	public List<WebElement>getAllLinks(){
		List<WebElement> links=driver.findElements(By.xpath("//a"));
		for(WebElement elm:links) {
			System.out.println(elm.getAttribute("href"));
		}
		return links;
		
	}
}
