package TeoriaEjercicios;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class seleccionMultipleEspecificandoCuales {
	WebDriver driver;
	String url;
	String ChromeDrivePath = "..\\SauceDemo\\Drivers\\chromedriver.exe";
	
	@Test
	public void seleccionProductos() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ChromeDrivePath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		List<WebElement> catalogo = driver.findElements(By.xpath("//div[@class='inventory_list']"));
		Assert.assertFalse(catalogo.isEmpty());

		for (int i = 0; i < catalogo.size(); i++) {
			if(catalogo.get(i).getText().contains("Sauce Labs Backpack") == catalogo.get(i).getText().contains("Test.allTheThings() T-Shirt (Red)")){
				
				Actions action = new Actions(driver);
				action.moveToElement(driver.findElement(By.id("add-to-cart-sauce-labs-backpack"))).click().build().perform();
				action.moveToElement(driver.findElement(By.id("add-to-cart-test.allthethings()-t-shirt-(red)"))).click().build().perform();
				//catalogo.get(i).click();
		}
		}
		Thread.sleep(2000);
		//guardo los precios de los prod para despues comparar en el carrito 
		String precioElemUno = driver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[1]/div[2]/div[2]/div")).getText();
		String precioEleDos = driver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[6]/div[2]/div[2]/div")).getText();
		
		driver.findElement(By.xpath( "//span[@class='shopping_cart_badge' and text()='2']")).click();
		
		Assert.assertEquals(precioElemUno, driver.findElement(By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]/div[2]/div[2]/div")).getText());
		Assert.assertEquals(precioEleDos, driver.findElement(By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[4]/div[2]/div[2]/div")).getText());
		
		
		driver.findElement(By.id("checkout")).click();
		

		driver.findElement(By.id("first-name")).sendKeys("Pedro");
		driver.findElement(By.id("last-name")).sendKeys("Alfonso");
		driver.findElement(By.id("postal-code")).sendKeys("1651");
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.id("finish")).click();
		//System.out.println(driver.findElement(By.xpath("//span")).getText());
		Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/checkout-complete.html");
		Assert.assertEquals(driver.findElement(By.xpath("//span")).getText(),"CHECKOUT: COMPLETE!" );
		Assert.assertEquals(driver.findElement(By.xpath("//h2")).getText(),"THANK YOU FOR YOUR ORDER" );
		//driver.close();
}
	
}
