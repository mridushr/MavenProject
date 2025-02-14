package Scenario;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class MouseHover {
	WebDriver driver;
	@Test
	public void dragAndDrop() throws InterruptedException
	{
		System.out.println("Actions Class Demo");
		driver = new EdgeDriver();
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		driver.switchTo().frame(0);
		WebElement drag=driver.findElement(By.id("draggable"));
		WebElement drop=driver.findElement(By.id("droppable"));
		Actions actions=new Actions(driver);
		//actions.dragAndDrop(drag, drop).build().perform();
		actions.clickAndHold(drag).moveToElement(drop).release(drag).build().perform();
		Thread.sleep(5000);
		driver.quit();

}
}
