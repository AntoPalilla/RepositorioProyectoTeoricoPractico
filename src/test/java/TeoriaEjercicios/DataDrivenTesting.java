package TeoriaEjercicios;

import org.testng.annotations.Test;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;


import Reader.ReadExcelFile;
//@Listeners(Listener.TestListener.class)

public class DataDrivenTesting {

	WebDriver driver;
	String url ="http://automationpractice.com/index.php?controller=authentication&back=my-account";
	String ChromeDrivePath = "..\\ProyectoTeoricoPractico\\Drivers\\chromedriver.exe";
	static String rutaExcel="..\\ProyectoTeoricoPractico\\Datos\\Libro1.xlsx";
	static String nombreHoja="Hoja1";
	
	@BeforeSuite
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", ChromeDrivePath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		//readFile = new ReadExcelFile();
		driver.get(url);
		
	}
	

	@Test (priority=0, description="Prueba de Registro", dataProvider="datos login")
	public void irRegistroLogin(String usuario, String clave) throws InterruptedException {
		//context.setAttribute("WebDriver", driver);
		//ITestContext context
		driver.findElement(By.id("email")).sendKeys(usuario);
		driver.findElement(By.id("passwd")).sendKeys(clave);
		driver.findElement(By.id("SubmitLogin")).click();
		Assert.assertEquals(driver.getCurrentUrl(), "http://automationpractice.com/index.php?controller=my-account");
		driver.findElement(By.linkText("Sign out")).click();
	}

		
	@DataProvider (name="datos login")
	public static Object[][] getExcelData() throws Exception{
	//Object datosExcel[][]=ReadExcelFile.leerExcel(rutaExcel,nombreHoja);
		return ReadExcelFile.leerExcel(rutaExcel,nombreHoja);
	 }
	
	@Test
	public void leerDatosCSV() throws Exception {
		ReadExcelFile datosLeidos = new ReadExcelFile();
		//System.out.println(navegador.getTitle());
		//descargar el get data en un objeto tipo ArrayList de String
		ArrayList<String> datos = datosLeidos.getData();
				
		int number = datos.size();
				
		System.out.println(number);
				
				//se arranca el i=1 porq la primera linea del doc no me interesa
				// < porq necesito hacerlo por el tope de registro que tengo ingresados
				for (int i=0; i<datos.size(); i++) {
					// saco los ; de cada registro
					String[] lineaDatos = datos.get(i).split(";");
					driver.findElement(By.id("email")).sendKeys(lineaDatos[0]);
					driver.findElement(By.id("passwd")).sendKeys(lineaDatos[1]);
					driver.findElement(By.id("SubmitLogin")).click();
					//Assert.assertEquals(driver.getCurrentUrl(), "http://automationpractice.com/index.php?controller=my-account");
					//driver.findElement(By.linkText("Sign out")).click();
					//System.out.println("Repeticion nro: " + i);
					//para volver para atras , asi se ingresa el siguiente dato del archivo
				//driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
				driver.navigate().forward();
				
	}
	}
	
	@Test
	public void datos() {
		
		

	}
	
	@AfterSuite
	public void teardown() {
	//driver.close();
	}
		
		
		
}
	

	

