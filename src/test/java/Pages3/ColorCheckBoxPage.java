package Pages3;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ColorCheckBoxPage {
	WebDriver driver;

	public ColorCheckBoxPage(WebDriver driver) {
		this.driver = driver;

	}

	public void selectAllCheckbox() {
		List<WebElement> allcheckbox = driver.findElements(By.xpath("//input[@type='checkbox']"));
		System.out.println("total no of checkbox:-" + allcheckbox);
//using for loop
//		for (int i = 1; i < allcheckbox.size(); i++) {
//			allcheckbox.get(i).click();
//		}
//using advance for loop
//		
//		for (WebElement elm : allcheckbox) {
//			elm.click();
//		}
//select only Orange and Green checkbox

		for (WebElement elm1 : allcheckbox) {
			String check = elm1.getAttribute("value");
			if (check.equals("orange") || check.equals("green")) {
				elm1.click();
			}
		}

//SELECT 1ST THREE CHECKBOX
		
//		int totalcheckbox = allcheckbox.size();
//		for (int j = 0; j < totalcheckbox; j++) {
//			if (j < 3) {
//				allcheckbox.get(j).click();
//			}
//		}
//select last three box
		
//		int totalcheckbox1=allcheckbox.size();
//        for(int k=totalcheckbox1-3;k<totalcheckbox1;k++) {
//        	allcheckbox.get(k).click();
//        }
	}
}
