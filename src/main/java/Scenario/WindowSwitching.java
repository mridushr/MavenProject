package Scenario;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class WindowSwitching {

	WebDriver driver;
	@Test
	public void switchWin()
	{
		driver = new EdgeDriver();
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open");
		driver.manage().window().maximize();
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.xpath("/html/body/button")).click();
		Set<String> allWinIds=driver.getWindowHandles();
		System.out.println("Total windows="+allWinIds.size());
		String win1=null;
		String win2=null;
		Iterator<String> itr=allWinIds.iterator();
		if(itr.hasNext())
		{
			win1=itr.next();
			win2=itr.next();
		}
		System.out.println(win1);
		System.out.println(win2);
		System.out.println("Window1 title="+driver.getTitle());
		driver.switchTo().window(win2);
		System.out.println("Window2 title="+driver.getTitle());
		boolean chkLogin=driver.findElement(By.linkText("Log in")).isEnabled();
		System.out.println(chkLogin);
		if(chkLogin==true)
		{
			System.out.println("Login is enabled");
		}
		else
		{
			System.out.println("Login is disabled");
		}
		driver.quit();
	}
}
