package TeoriaEjercicios;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import org.testng.annotations.Test;

public class ListasDependientes {

	WebDriver driver;
	String url;
	String ChromeDrivePath = "..\\ProyectoTeoricoPractico\\Drivers\\chromedriver.exe";

	
	@Test(enabled=false)
	public void listDependientesCorreoArgentino() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ChromeDrivePath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.correoargentino.com.ar/formularios/cpa");
		driver.findElement(By.xpath("//span[@id='select2-chosen-1']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("s2id_autogen1_search")).sendKeys("Ciudad Autonoma de Buenos Aires ");
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//span[text()='Ciudad Autonoma de Buenos Aires ']"))).click().build().perform();
}
	
	@Test
	public void listaDependientesCorreoEcuador() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ChromeDrivePath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://codigopostal.gob.ec/");
		//LISTA PROVINCIA
		driver.findElement(By.xpath("//span[text()='select' and @aria-controls='provincias_listbox']")).click();
		Thread.sleep(2000);
		List<WebElement> opciones = driver.findElements(By.xpath("//ul[@id='provincias_listbox']"));
		for (WebElement opcion:opciones) {
			System.out.println(opcion.getText());
			if(opcion.getText().contains("COTOPAXI")){
				opcion.click();
				break;
			}
			
		}
		System.out.println("------------------------------------------------");
		//LISTA CANTON
			Actions actionc = new Actions(driver);
			actionc.moveToElement(driver.findElement(By.xpath("//span[text()='select' and @aria-controls='cantones_listbox']"))).click().build().perform();
		//driver.findElement(By.xpath("//span[text()='select' and @aria-controls='cantones_listbox']")).click();
		Thread.sleep(2000);
		List<WebElement> opciones1 = driver.findElements(By.xpath("//ul[@id='cantones_listbox']"));
		for (WebElement opcion1:opciones1) {
			System.out.println(opcion1.getText());
			if(opcion1.getText().contains("PUJILI")){
				opcion1.click();
				break;
			}

		}
		Thread.sleep(2000);
		System.out.println("------------------------------------------------");
		//LISTA CALLES
		driver.findElement(By.xpath("//input[@id='calle']")).sendKeys("MA");
		Thread.sleep(2000);
		List<WebElement> opciones2 = driver.findElements(By.xpath("//ul[@id='calle_listbox']")); 
		for (WebElement opcion2:opciones2) {
			System.out.println(opcion2.getText());
			if(opcion2.getText().contains("GONZALO NAVAS MATUTE, LOCALIDAD : PUJILI")){
				opcion2.click();
				break;
			}
		
	}
	
		
			//driver.findElement(By.id("provincias_listbox")).sendKeys("PICHINCHA");
			//Actions action = new Actions(driver);
			//action.moveToElement(driver.findElement(By.xpath("//li[text()='PICHINCHA']"))).click().build().perform();
		}
	

	}
	

