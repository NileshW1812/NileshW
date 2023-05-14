package com.nilesh.project;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;



public class Utility2 {
	public static WebDriver getDriver() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		return driver;
	}

	public static String getProperty(String key) {
		File file = new File("src/test/resources/data.properties");
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream(file);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Properties properties = new Properties();
		try {
			properties.load(fileInputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return properties.getProperty(key);
	}

	public static void getScreenshot(WebDriver driver, String screenshotName) throws IOException {
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File file = takesScreenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("src/test/resources/screenshot" + screenshotName + ".png"));
	}

	public static List<String> readExcel() throws IOException {
		File file = new File("src/test/resources/Registration3.xls");
		FileInputStream fileInputStream = new FileInputStream(file);

		List<String> userRegistrationDetails = new ArrayList<String>();

		// reading .xls file
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(fileInputStream);

		HSSFSheet sheet = hssfWorkbook.getSheetAt(0);

		int lastRowNumer = sheet.getLastRowNum();

		int lastCellNumber = 0;

		for (int i = 1; i <= lastRowNumer; i++) {
			HSSFRow row = sheet.getRow(i);
			lastCellNumber = row.getLastCellNum();
			for (int j = 0; j < lastCellNumber; j++) {
				userRegistrationDetails.add(row.getCell(j).getStringCellValue());
			}
		}
		return userRegistrationDetails;
	}

//DropDown select
	public static void selectValueFromDropdown(WebElement dropDown, String valueToSelect) {
		Select select = new Select(dropDown);
		select.selectByVisibleText(valueToSelect);
	}

//Datepicker Method
	public static void selectDateFromDatePicker(WebDriver driver, String month, String year, String dateToSelect) {

		driver.findElement(By.id("dateOfBirthInput")).click();

		WebElement monthDropdown = driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']"));
		Utility2.selectValueFromDropdown(monthDropdown, month);

		WebElement yearDropdown = driver.findElement(By.xpath("//select[@class='react-datepicker__year-select']"));
		Utility2.selectValueFromDropdown(yearDropdown, year);

		List<WebElement> dates = driver
				.findElements(By.xpath("//div[@class='react-datepicker__month-container']//div[@role='option']"));
		for (WebElement date1 : dates) {
			if (date1.getText().contains(dateToSelect)) {
				date1.click();
				break;
			}

		}

	}
	public void display()
	{
	}
	
