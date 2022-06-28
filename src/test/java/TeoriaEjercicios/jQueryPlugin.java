package TeoriaEjercicios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class jQueryPlugin {

	WebDriver driver;
	String url ="http://demo.guru99.com/test/tooltip.html";
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
	public void jQPlugin() {
		String expectedTooltip = "What's new in 3.2";
		//Encuentre el WebElement que corresponde al elemento "descargar ahora" que pasaremos con el mouse.
		WebElement download = driver.findElement(By.xpath(".//*[@id='download_now']"));							
        
		//Con la API de interacciones, pase el mouse sobre "Descargar ahora".
		Actions builder = new Actions (driver);							

        builder.clickAndHold().moveToElement(download);					
        builder.moveToElement(download).build().perform(); 	
        
        //Suponiendo que se muestra la información sobre herramientas, busque el WebElement que corresponda al enlace dentro de la información sobre herramientas, es decir, la etiqueta "a".
        WebElement toolTipElement = driver.findElement(By.xpath(".//*[@class='box']/div/a"));							
        
        //Verifique el texto de información sobre herramientas del enlace recuperado usando getText() contra un valor esperado que hemos almacenado en "expectedToolTip"
        String actualTooltip = toolTipElement.getText();			
        
        System.out.println("Actual Title of Tool Tip  "+actualTooltip);							
        if(actualTooltip.equals(expectedTooltip)) {							
            System.out.println("Test Case Passed");					
        }		
        driver.close();			
   }		


}
	
	

