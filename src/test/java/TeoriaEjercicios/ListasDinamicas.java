package TeoriaEjercicios;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ListasDinamicas {
	
	WebDriver driver;
	String ChromeDrivePath = "..\\ProyectoTeoricoPractico\\Drivers\\chromedriver.exe";
	String url = "https://www.mercadolibre.com.ar/";
	WebElement buscador;
	
@Test
	public void listDinamicas() {
		System.setProperty("webdriver.chrome.driver", ChromeDrivePath);
		driver = new ChromeDriver();
		driver.get(url);
		driver.findElement(By.xpath("//input[@placeholder='Buscar productos, marcas y más…']")).sendKeys("Alice Kel");
		List<WebElement> opciones = driver.findElements(By.xpath("//ul[@id='cb1-list']")); 
		////div[@id='sb-suggestions-1']
		System.out.println(opciones.size());
		for (WebElement opcion:opciones) {
			System.out.println(opcion.getText());
			if(opcion.getText().contains("alice kellen alaska")){
				opcion.click();
				break;
			}
	}
	
	
}
}