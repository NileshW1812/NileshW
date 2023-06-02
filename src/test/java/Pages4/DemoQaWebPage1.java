package Pages4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DemoQaWebPage1 {
	WebDriver driver;
	WebElement addbutton;
	WebElement firstnametext;
	WebElement lastnametext;
	WebElement useremailtext;
	WebElement agetext;
	WebElement salarytext;
	WebElement deparmenttext;
	WebElement submitbutton;
	WebElement searchbox;
	WebElement searchbutton;

	

	public DemoQaWebPage1(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getAddbutton() {
		setAddbutton();
		return addbutton;
	}

	public void setAddbutton() {
		this.addbutton = driver.findElement(By.xpath("//button[@id='addNewRecordButton']"));
	}

	public WebElement getFirstnametext() {
		setFirstnametext();
		return firstnametext;
	}

	public void setFirstnametext() {
		this.firstnametext = driver.findElement(By.id("firstName"));
	}

	public WebElement getLastnametext() {
		setLastnametext();
		return lastnametext;
	}

	public void setLastnametext() {
		this.lastnametext = driver.findElement(By.id("lastName"));
	}

	public WebElement getUseremailtext() {
		setUseremailtext();
		return useremailtext;
	}

	public void setUseremailtext() {
		this.useremailtext = driver.findElement(By.id("userEmail"));
	}

	public WebElement getAgetext() {
		setAgetext();
		return agetext;
	}

	public void setAgetext() {
		this.agetext = driver.findElement(By.id("age"));
	}

	public WebElement getSalarytext() {
		setSalarytext();
		return salarytext;
	}

	public void setSalarytext() {
		this.salarytext = driver.findElement(By.id("salary"));
	}

	public WebElement getDeparmenttext() {
		setDeparmenttext();
		return deparmenttext;
	}

	public void setDeparmenttext() {
		this.deparmenttext = driver.findElement(By.id("department"));
	}

	public WebElement getSubmitbutton() {
		setSubmitbutton();
		return submitbutton;
	}

	public void setSubmitbutton() {
		this.submitbutton = driver.findElement(By.id("submit"));
	}

	public WebElement getSearchbox() {
		setSearchbox();
		return searchbox;
	}

	public void setSearchbox() {
		this.searchbox = driver.findElement(By.id("searchBox"));
	}

	public WebElement getSearchbutton() {
		setSearchbutton();
		return searchbutton;
	}

	public void setSearchbutton() {
		this.searchbutton =driver.findElement(By.xpath("//div//span[@id='basic-addon2']//span"));
	}
}
