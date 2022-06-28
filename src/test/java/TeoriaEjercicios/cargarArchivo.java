package TeoriaEjercicios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;



public class cargarArchivo {
	
	WebDriver driver;
	String url ="http://demo.guru99.com/test/upload/";
	String ChromeDrivePath = "..\\ProyectoTeoricoPractico\\Drivers\\chromedriver.exe";

	@BeforeSuite
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", ChromeDrivePath);
		driver = new ChromeDriver();
		driver.get(url);
		
	}
	
	@Test
	public void cargaArchivo() {
		
		driver.findElement(By.id("uploadfile_0")).sendKeys("C:\\Users\\u582197\\Desktop\\SauceDemo-NOBORRAR\\Curso\\Base.txt");
		driver.findElement(By.id("terms")).click();
		driver.findElement(By.id("submitbutton")).click();
		/*String fraseUno = driver.findElement(By.xpath("/html/body/div[4]/div/div/div[2]/form/ul/li/div[2]/h3/center/text()[1]")).getText();
		String fraseDos= driver.findElement(By.xpath("/html/body/div[4]/div/div/div[2]/form/ul/li/div[2]/h3/center/text()[2]")).getText();
		String resultado = fraseUno.concat(fraseDos); */
		WebElement frase = driver.findElement(By.xpath(".//*[@class='formbuttons']/div/center"));
		//html/body/div[4]/div/div/div[2]/form/ul/li/div[2]/h3/center[1]
		
		String f = frase.getText();
		///html/body/div[4]/div/div/div[2]/form/ul/li/div[2]/h3/center/text()[1]
		System.out.println("Carga OK " + " " + f);
		
	    int size = driver.findElements(By.tagName("iframe")).size();
	    System.out.println("Total Frames --" + size);
		Assert.assertEquals(f, "1 file  has been successfully uploaded.");
	
	
		;
		
	}
}

