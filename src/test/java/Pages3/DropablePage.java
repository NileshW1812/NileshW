package Pages3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DropablePage {
	WebDriver driver;
	WebElement ifarme;
	WebElement draggable;;
	WebElement droppable;

	public DropablePage(WebDriver driver) {
		this.driver = driver;

	}

	public WebElement getIfarme() {
		setIfarme();
		return ifarme;
	}

	public void setIfarme() {
		this.ifarme = driver.findElement(By.xpath("id=\"content\"]/iframe"));
	}

	public WebElement getDraggable() {
		setDraggable();
		return draggable;
	}

	public void setDraggable() {
		this.draggable = driver.findElement(By.id("draggable"));
	}

	public WebElement getDroppable() {
		setDroppable();
		return droppable;
	}

	public void setDroppable() {
		this.droppable = driver.findElement(By.id("droppable"));
	}
}
