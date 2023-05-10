package pages2;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HomePageOmayo {
	WebDriver driver;
	private WebElement pageTitle;
	WebElement BikeRadioButton;
	WebElement BicycleRadioButton;
	WebElement CarRadioButton;
	WebElement iframe;
	WebElement link;
	WebElement text1;
	WebElement dropdown;
	WebElement button;
	WebElement links;
	WebElement userid;
	WebElement password;
	WebElement horrelink;
	WebElement seleclink;
	WebElement text;
	WebElement passwordtext;
	WebElement loginbutton;

	public HomePageOmayo(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getPageTitle() {
		setPageTitle();
		return pageTitle;
	}

	public void setPageTitle() {
		this.pageTitle = driver.findElement(By.xpath("//h1[@class='title']"));
	}

	public WebElement getBikeRadioButton() {
		setBikeRadioButton();
		return BikeRadioButton;
	}

	public void setBikeRadioButton() {
		BikeRadioButton = driver.findElement(By.xpath("//input[@value='Bike']"));
	}

	public WebElement getBicycleRadioButton() {
		setBicycleRadioButton();
		return BicycleRadioButton;
	}

	public void setBicycleRadioButton() {
		BicycleRadioButton = driver.findElement(By.xpath("//input[@value='Bicycle']"));
	}

	public WebElement getCarRadioButton() {
		setCarRadioButton();
		return CarRadioButton;
	}

	public void setCarRadioButton() {
		this.CarRadioButton = driver.findElement(By.xpath("//input[@value='Car']"));
	}

	public WebElement getIframe() {
		setIframe();
		return iframe;
	}

	public void setIframe() {
		this.iframe = driver.findElement(By.xpath("//iframe[1]"));
	}

	public WebElement getLink() {
		setLink();
		return link;
	}

	public void setLink() {
		this.link = driver.findElement(By.linkText("Page One"));
	}

	public WebElement getText1() {
		setText1();
		return text1;
	}

	public void setText1() {
		this.text1 = driver.findElement(By.xpath("//textarea[@id='ta1']"));
	}

	public WebElement getDropdown() {
		setDropdown();
		return dropdown;
	}

	public void setDropdown() {
		this.dropdown = driver.findElement(By.xpath("//select[@id='multiselect1']"));
	}

	public WebElement getUserid() {
		setUserid();
		return userid;
	}

	public void setUserid() {
		this.userid = driver.findElement(By.name("userid"));
	}

	public WebElement getPassword() {
		setPassword();
		return password;
	}

	public void setPassword() {
		this.password = driver.findElement(By.name("pswrd"));
	}

	public WebElement getHorrelink() {
		setHorrelink();
		return horrelink;
	}

	public void setHorrelink() {
		this.horrelink = driver.findElement(By.xpath("//div[@id='cssmenu']//ul//li[2]//span"));
	}

	public WebElement getSeleclink() {
		setSeleclink();
		return seleclink;
	}

	public void setSeleclink() {
		this.seleclink = driver.findElement(By.xpath("//div[@id='cssmenu']//ul//li[2]//ul//li//a"));
	}

	public WebElement getText() {
		setText();
		return text;
	}

	public void setText() {
		this.text = driver.findElement(By.xpath("//input[@type='text']"));
	}

	public WebElement getPasswordtext() {
		setPasswordtext();
		return passwordtext;
	}

	public void setPasswordtext() {
		this.passwordtext = driver.findElement(By.xpath("//input[@type='password']"));
	}

	public WebElement getLoginbutton() {
		setLoginbutton();
		return loginbutton;
	}

	public void setLoginbutton() {
		this.loginbutton = driver.findElement(By.xpath("//button[@type='button']"));
	}

	public String selectDropdown(String string) {
		Select select = new Select(getDropdown());
		return select.getFirstSelectedOption().getText();

	}

	public List<WebElement> getAllWebElement() {
		List<WebElement> button = driver.findElements(By.xpath("//button[@type='button']"));
		Iterator<WebElement> it = button.iterator();
		System.out.println(button.size());
		while (it.hasNext()) {
			WebElement elm = it.next();
			System.out.println(elm.getText());

		}
		return button;
	}

	public List<WebElement> getAllLinks() {
		List<WebElement> links = driver.findElements(By.xpath("//a"));
		for (WebElement elm : links) {
			System.out.println(elm.getAttribute("href"));
		}

		return links;

	}

}
