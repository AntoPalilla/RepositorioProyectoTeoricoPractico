package TeoriaEjercicios;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class ScreenListener {
	
	WebDriver driver;
	String ChromeDrivePath = "..\\ProyectoTeoricoPractico\\Drivers\\chromedriver.exe";
	double totalProductos;
	
	@Test
	public void selecAlAzarDeProductos(ITestContext context) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ChromeDrivePath);
		driver = new ChromeDriver();
		context.setAttribute("WebDriver", driver);
		driver.manage().window().maximize();
		context.setAttribute("WebDriver", driver);
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		// se guarda en esa lista todos los elementos que tenga la pagina
		List<WebElement> listadeProductos = new ArrayList<WebElement>();
		// una vez que los guardo, los tengo que sacar para poder trabajarlos 
		//genero un contenedor para que solo seleccione prods de una parte de la pagina
		Thread.sleep(2000);
		WebElement contenedordeProductos = driver.findElement(By.xpath("//div[@class='inventory_list']"));
		// del contenedor ya generando, sumo a la listadeProductos los que quiero
		listadeProductos =contenedordeProductos.findElements(By.xpath("//div[@class='inventory_item_name']"));
		//System.out.println(listadeProductos.size());
		
		//Hacer una validacion para que solo seleccione 3 prods del catalogo
		 int cantidadLista;
		 int numeroAlAzar;
		 List <Integer> productosAlAzar = new ArrayList<Integer>();
		
		 //Dif int es una variable, Integer es un objeto
		 
		if (listadeProductos.size()<4) {
			cantidadLista= listadeProductos.size();
		}
		else 
		{
			cantidadLista=3;
		}
		
		//hacemos click en 3 prod al azar
		for(int i=0; i<cantidadLista; i++) {
			//formula para obtener 3 numeros al azar, la lista de productos es el rango que da esos num al azar
			numeroAlAzar = (int) (Math.random() * listadeProductos.size() +1);
			//ver si ya selecciono el numero, si es asi regreso sino lo sumo al array de prodAlAzar
			if(productosAlAzar.contains(numeroAlAzar)) {
				i--; //repite el proceso 
			}
			else {
				productosAlAzar.add(numeroAlAzar); //suma ese numero a mi array de ProdAlAzar
			}
		}
		
		System.out.println(productosAlAzar);
		
	
		//se va a ejecutar la cantidad que valga la lista
		for(int i=0; i<cantidadLista; i++) {
			//saco el xpath de los elements elegidos al azar
			String xpathElemento = String.format("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[%s]/div[2]/div[2]/div[1]",productosAlAzar.get(i));
			
			driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div["+productosAlAzar.get(i)+"]/div[2]/div[2]/button[1]")).click();
			
			// precio unitario del producto, 
			//-1 porq los arrays arrancan en 0
			String precioUnitarioDolar = listadeProductos.get(productosAlAzar.get(i)-1).findElement(By.xpath(xpathElemento)).getText();
			
			String precioUnitario = precioUnitarioDolar.replace("$", "");
		
			
			Double precio = Double.valueOf(precioUnitario);
			System.out.println("valor unitario del producto" + " "+  precio);
	
			
			 
			
			//sumar el valor que ya tiene con el nuevo
			totalProductos += precio;
			
			
			listadeProductos.get(productosAlAzar.get(i)-1).findElement(By.xpath(xpathElemento)).click();
			
			Thread.sleep(2000);
			
			
			System.out.println(listadeProductos.get(i).getText());
			System.out.println("---------------------------------------------------------------------");
			
			}
	
		System.out.println("total de los valores" + " " + totalProductos);

		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/a[1]")).click();
		
		//Ejemplo de asercion para que falle
		Assert.assertTrue(false);
		
		driver.findElement(By.id("checkout")).click();
	}
}
