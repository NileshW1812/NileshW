package Pages3;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ReadTabbleData {
	WebDriver driver;
	WebElement table;

	public ReadTabbleData(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getTable() {
		setTable();
		return table;
	}

	public void setTable() {
		this.table = driver.findElement(By.xpath("//table[@id='customers']//tbody//tr//th"));
	}

	public List<WebElement> ReadTabbleData1(WebDriver driver) {
		List<WebElement> alldata = driver.findElements(By.xpath("//table[@id='customers']//tbody//tr[1]//td[1]"));
		for (WebElement elm : alldata) {
			System.out.println(elm.getText());
		}
		return alldata;
	}
}
