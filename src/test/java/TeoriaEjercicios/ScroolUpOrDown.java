package TeoriaEjercicios;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class ScroolUpOrDown {
	WebDriver driver;
	String url ="http://demo.guru99.com/test/guru99home/";
	String ChromeDrivePath = "..\\ProyectoTeoricoPractico\\Drivers\\chromedriver.exe";

	
	@BeforeSuite
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", ChromeDrivePath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		//readFile = new ReadExcelFile();
		driver.get(url);

}
	
	@Test
	public void scroolByPixel() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//x-pixels es el número en el eje x, se mueve hacia la izquierda si el número es positivo y se mueve hacia la derecha si el número es negativo. 
		//y-pixels es el número en el eje y, se mueve hacia abajo si el número es positivo y se mueve hacia arriba si el número está en negativo.
		js.executeScript("window.scrollBy(0,1000)");
	}
	
	@Test
	public void scrollDownByVisibilityOfElement() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		 //Find element by link text and store in variable "Element"        		
        WebElement Element = driver.findElement(By.linkText("Linux"));
        //This will scroll the page till the element is found	
        //"argumentos [0]" significa el primer índice de la página que comienza en 0. Donde un “Elemento” es el localizador en la página web.
        js.executeScript("arguments[0].scrollIntoView();", Element);
	}
	
	@Test
	public void scrollDownWebPage() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
       //This will scroll the web page till end.
		// El método Javascript scrollTo() desplaza hasta el final de la página.
		//“document.body.scrollHeight” devuelve la altura completa del cuerpo, es decir, la página web.
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
	
	@Test
	public void horizontalScrollOnTheWebPage() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement Element = driver.findElement(By.linkText("VBScript"));
        //This will scroll the page Horizontally till the element is found		
        js.executeScript("arguments[0].scrollIntoView();", Element);
    }
	
	
	
	@AfterSuite
	public void tearDown() {
		//driver.close();
	}
}
