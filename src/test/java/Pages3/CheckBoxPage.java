package Pages3;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckBoxPage {
	WebDriver driver;
	WebElement redcheckbox;

	public CheckBoxPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getRedcheckbox() {
		setRedcheckbox();
		return redcheckbox;
	}

	public void setRedcheckbox() {
		this.redcheckbox = driver.findElement(By.xpath("//input[@value='red']"));
	}

	public void selectAllCheckBox() {
		List<WebElement> allchecbox = driver.findElements(By.xpath("//input[@type='checkbox']"));
		System.out.println("Total no of checkbox:-" + allchecbox);
// using for loop		
//		for (int i = 0; i < allchecbox.size(); i++) {
//			allchecbox.get(i).click();
//		}
// Using Advance for loop		
//		for(WebElement check:allchecbox) {
//			check.click();
//		}

// select Blue and Green check box
//		for (WebElement checkbox : allchecbox) {
//			String check = checkbox.getAttribute("value");
//			if (check.equals("blue") || check.equals("green")) {
//				checkbox.click();
//			}
//		}

//select first three checkbox
//		int totalcheckbox = allchecbox.size();
//		for (int j = 0; j < totalcheckbox; j++) {
//			if (j < 3) {
//				allchecbox.get(j).click();
//			}
//		}

//select last three checkbox
		
//		int totalcheckbox1 = allchecbox.size();
//		for (int k = totalcheckbox1 - 3; k < totalcheckbox1; k++) {
//			allchecbox.get(k).click();
//		}
//
	}

}
