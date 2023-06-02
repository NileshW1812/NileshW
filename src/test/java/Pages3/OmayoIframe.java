package Pages3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OmayoIframe {
	WebDriver driver;
	WebElement iframe;
	WebElement link;

	public OmayoIframe(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getIframe() {
		setIframe();
		return iframe;
	}

	public void setIframe() {
		this.iframe = driver.findElement(By.xpath("//iframe[@id='navbar-iframe']"));
	}

	public WebElement getLink() {
		setLink();
		return link;
	}

	public void setLink() {
		this.link = driver.findElement(By.xpath("//*[@id=\"b-getorpost\"]"));
	}
}
