package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HomePage {
	WebDriver driver;
	private WebElement pageTitle;
	WebElement searchTextBox;
	WebElement dropdown;
	WebElement collegeImage;
	WebElement maleRadioButton;
	WebElement femaleRadioButton;
	WebElement orangaeCheckbox;
	WebElement blueCheclbox;
	WebElement BikeRadioButton;
	WebElement BicycleRadioButton;
	WebElement CarRadioButton;
	WebElement PenCheckbox;
	WebElement BookCheckbox;
	WebElement LaptopCheckbox;
	WebElement BagCheckbox;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getPageTitle() {
		setPageTitle();
		return pageTitle;
	}

	public void setPageTitle() {
		pageTitle = driver.findElement(By.xpath("//h1[@class='title']"));
	}

	public WebElement getSearchTextBox() {
		setSearchTextBox();
		return searchTextBox;
	}

	public void setSearchTextBox() {
		searchTextBox = driver.findElement(By.xpath("//input[@name='q' and @title='search']"));
	}

	public WebElement getDropdown() {
		setDropdown();
		return dropdown;
	}

	public void setDropdown() {
		this.dropdown = driver.findElement(By.xpath("//select[@id='drop1']"));
	}

	public WebElement getCollegeImage() {
		setCollegeImage();
		return collegeImage;
	}

	public void setCollegeImage() {
		this.collegeImage = driver.findElement(By.xpath("//img[contains(@src,'college')]"));
	}

	public WebElement getMaleRadioButton() {
		setMaleRadioButton();
		return maleRadioButton;
	}

	public void setMaleRadioButton() {
		this.maleRadioButton = driver.findElement(By.xpath("//input[@id='radio1']"));
	}

	public WebElement getFemaleRadioButton() {
		setFemaleRadioButton();
		return femaleRadioButton;
	}

	public void setFemaleRadioButton() {
		this.femaleRadioButton = driver.findElement(By.xpath("//input[@id='radio2']"));
	}

	public WebElement getOrangaeCheckbox() {
		setOrangaeCheckbox();
		return orangaeCheckbox;
	}

	public void setOrangaeCheckbox() {
		this.orangaeCheckbox = driver.findElement(By.xpath("//input[@id='checkbox1']"));
	}

	public WebElement getBlueCheclbox() {
		setBlueCheclbox();
		return blueCheclbox;
	}

	public void setBlueCheclbox() {
		this.blueCheclbox = driver.findElement(By.xpath("//input[@id='checkbox2']"));
	}

	public void setTextInSearchTextField(String textToSearch) {
		getSearchTextBox().sendKeys(textToSearch);
	}

	public boolean veryfySearchTextFieldIsEnabled() {
		return getSearchTextBox().isEnabled();
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

	public WebElement getPenCheckbox() {
		setPenCheckbox();
		return PenCheckbox;
	}

	public void setPenCheckbox() {
		PenCheckbox = driver.findElement(By.xpath("//input[@value='Pen']"));
	}

	public WebElement getBookCheckbox() {
		setBookCheckbox();
		return BookCheckbox;
	}

	public void setBookCheckbox() {
		BookCheckbox = driver.findElement(By.xpath("//input[@value='Book']"));
	}

	public WebElement getLaptopCheckbox() {
		setLaptopCheckbox();
		return LaptopCheckbox;
	}

	public void setLaptopCheckbox() {
		LaptopCheckbox = driver.findElement(By.xpath("//input[@value='Laptop']"));
	}

	public WebElement getBagCheckbox() {
		setBagCheckbox();
		return BagCheckbox;
	}

	public void setBagCheckbox() {
		BagCheckbox = driver.findElement(By.xpath("//input[@value='Bag']"));
	}

	public String getValueSelectedInDropdown() {
		Select select = new Select(getDropdown());
		return select.getFirstSelectedOption().getText();
	}

	public List<String> getTableData() {
		ArrayList<String> table = new ArrayList<String>();

		List<WebElement> tableData = driver.findElements(By.xpath("//table[@id='table1']//tr/td"));

		for (WebElement elm : tableData) {
			table.add(elm.getText());
		}
		return table;
	}
}
