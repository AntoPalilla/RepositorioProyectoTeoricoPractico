package TeoriaEjercicios;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import org.testng.annotations.Test;

public class Iframe {
	WebDriver driver;
	String url;
	String ChromeDrivePath = "..\\ProyectoTeoricoPractico\\Drivers\\chromedriver.exe";
	static WebElement elemento;
	static WebElement el;
	
	
	@Test
	public void iFrames() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ChromeDrivePath);
		ChromeOptions options = new ChromeOptions();
		// es una solucion, pero la pagina queda en esa resolucion que no es maximizar
		options.addArguments("window-size=1200x600");
		driver = new ChromeDriver(options);
		driver.get("http://automationpractice.com/index.php");
		elemento= driver.findElement(By.cssSelector("#homefeatured > li.ajax_block_product.col-xs-12.col-sm-4.col-md-3.first-in-line.first-item-of-tablet-line.first-item-of-mobile-line > div > div.right-block > div.button-container > a.button.ajax_add_to_cart_button.btn.btn-default > span"));
	
		Actions action=new Actions(driver);
		action.moveToElement(elemento).click(elemento).build().perform();
	}
		
	
	@Test
	public void iFrames2() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ChromeDrivePath);
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php");
		
		el= driver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[1]/div/div[1]/div/a[1]/img"));
		elemento= driver.findElement(By.cssSelector("#homefeatured > li.ajax_block_product.col-xs-12.col-sm-4.col-md-3.first-in-line.first-item-of-tablet-line.first-item-of-mobile-line > div > div.right-block > div.button-container > a.button.ajax_add_to_cart_button.btn.btn-default > span"));
		
		Actions action=new Actions(driver); 

		action.moveToElement(el).click(elemento).build().perform();
	

}
	
	
	@Test
	public void iFrames3() {
		
		System.setProperty("webdriver.chrome.driver", ChromeDrivePath);
		driver = new ChromeDriver();
		JavascriptExecutor je = (JavascriptExecutor) driver;
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php");
		je.executeScript("window.scrollBy(0,700)", "");
		el= driver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[1]/div/div[1]/div/a[1]/img"));
		elemento= driver.findElement(By.cssSelector("#homefeatured > li.ajax_block_product.col-xs-12.col-sm-4.col-md-3.first-in-line.first-item-of-tablet-line.first-item-of-mobile-line > div > div.right-block > div.button-container > a.button.ajax_add_to_cart_button.btn.btn-default > span"));

		Actions action=new Actions(driver);
		action.moveToElement(el).click(elemento).build().perform(); 
	
	}
	
	@Test
	public void iFrames4() {
		
		System.setProperty("webdriver.chrome.driver", ChromeDrivePath);
		driver = new ChromeDriver();
		JavascriptExecutor je = (JavascriptExecutor) driver;
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php");
		el= driver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[1]/div/div[1]/div/a[1]/img"));
		je.executeScript("arguments[0].scrollIntoView()",el);
		elemento= driver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[1]/div/div[2]/div[2]/a[1]"));
		elemento.click();
		
	}
	
}
