package TeoriaEjercicios;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class BusquedaGoogle {

	WebDriver driver;
	String url ="https://www.google.com/";
	String ChromeDrivePath = "..\\ProyectoTeoricoPractico\\Drivers\\chromedriver.exe";

	@BeforeSuite
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", ChromeDrivePath);
		driver = new ChromeDriver();
		driver.get(url);
		
}
	
	@Test
	public void busqueda() {
		driver.findElement(By.name("q")).sendKeys("Power Ranger");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);

		WebElement element = driver.findElement(By.xpath("/html/body/div[7]/div/div[10]/div[1]/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[1]/div/video-voyager/div/div/div/a/div/div[1]/div[3]"));
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().build().perform();
		
		//JavascriptExecutor je = (JavascriptExecutor) driver;
		//je.executeScript("arguments[0].click();", element);
	}
	
	@AfterTest
	public void tearDown() throws Exception {
		driver.quit();
	   
	  }
}