package pages2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DragDropPage {
	WebDriver driver;
	WebElement Drag;
	WebElement Drop;

	public DragDropPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getDrag() {
		setDrag();
		return Drag;
	}

	public void setDrag() {
		Drag = driver.findElement(By.id("draggable"));
	}

	public WebElement getDrop() {
		setDrop();
		return getDrop();
	}

	public void setDrop() {
		Drop = driver.findElement(By.id("droppable"));
	}



}
