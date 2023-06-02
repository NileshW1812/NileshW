package Pages4;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OmayoHomepage {
	WebDriver driver;

	public OmayoHomepage(WebDriver driver) {
		this.driver = driver;
	}

	public List<String> tabledata() {
		ArrayList<String> table = new ArrayList<String>();
		
		List<WebElement> tabledata1 = driver.findElements(By.xpath("//table[@id='table1']//tr//td"));

		for (WebElement elm : tabledata1) {
			table.add(elm.getText());
		}

		return table;

	}
}
