package Pages3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OmayoLinks {
	WebDriver driver;
	WebElement horrinlinks;
	WebElement link;

	public OmayoLinks(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getHorrinlinks() {
		setHorrinlinks();
		return horrinlinks;
	}

	public void setHorrinlinks() {
		this.horrinlinks = driver.findElement(By.xpath("//span[@id='blogsmenu']"));
	}

	public WebElement getLink() {
		setLink();
		return link;
	}

	public void setLink() {
		this.link = driver.findElement(By.xpath("//a[@href='http://www.selenium143.blogspot.com']"));
	}

}
