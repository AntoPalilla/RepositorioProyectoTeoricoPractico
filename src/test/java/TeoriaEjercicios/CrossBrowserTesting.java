package TeoriaEjercicios;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class CrossBrowserTesting {
	
String url = "http://automationpractice.com/index.php";
String ChromeDrivePath = "..\\ProyectoTeoricoPractico\\Drivers\\chromedriver.exe";
String FirefoxDriverPath = "..\\ProyectoTeoricoPractico\\Drivers\\geckodriver.exe";
WebDriver driver;

@BeforeClass
@Parameters("navegador")
public void setUp(String navegador){
	
	if (navegador.equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver", ChromeDrivePath);
		driver = new ChromeDriver();
		}else if (navegador.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",FirefoxDriverPath);
			driver= new FirefoxDriver();
		}
	
	driver.get(url);
	driver.manage().deleteAllCookies();	
}


@Test
public void buscarPalabra()  {
	
	WebElement txtBuscador = driver.findElement(By.id("search_query_top"));
	txtBuscador.sendKeys("dress");
	txtBuscador.sendKeys(Keys.ENTER);
}

@AfterSuite
public void tearDown() {
	//driver.close();
}

}
