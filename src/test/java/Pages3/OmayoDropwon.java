package Pages3;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class OmayoDropwon {
	WebDriver driver;
	WebElement Multipleselectbox;
	WebElement dropbutton;
	WebElement flipkartlink;
	WebElement dropdown1;

	public OmayoDropwon(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getMultipleselectbox() {
		setMultipleselectbox();
		return Multipleselectbox;
	}

	public void setMultipleselectbox() {
		Multipleselectbox = driver.findElement(By.xpath("//select[@id='multiselect1']"));
	}

	public WebElement getDropbutton() {
		setDropbutton();
		return dropbutton;
	}

	public void setDropbutton() {
		this.dropbutton = driver.findElement(By.xpath("//button[@class='dropbtn']"));
	}

	public WebElement getFlipkartlink() {
		setFlipkartlink();
		return flipkartlink;
	}

	public WebElement getDropdown1() {
		setDropdown1();
		return dropdown1;
	}

	public void setDropdown1() {
		this.dropdown1 = driver.findElement(By.xpath("//select[@id='drop1']"));
	}

	public void setFlipkartlink() {
		this.flipkartlink = driver.findElement(By.xpath("//*[@id=\"myDropdown\"]/a[2]"));
	}

	public void selectAllDropDown() {
//		WebElement dropdown1 = driver.findElement(By.xpath("//div[@id='myDropdown']"));
		WebElement dropdown2 = driver.findElement(By.xpath("//select[@id='multiselect1']"));
		Select select = new Select(dropdown1);
		List<WebElement> dropdownoption = select.getOptions();
		for (WebElement dd : dropdownoption) {
			System.out.println(dd.getText());
		}

		System.out.println(select.isMultiple());

	}
}
