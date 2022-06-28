package TeoriaEjercicios;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class VentanasEmergentes {


	WebDriver driver;
	String url ="http://demo.guru99.com/popup.php";
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
	public void alertaAcept() {
		
		driver.findElement(By.linkText("Click Here")).click();;
		//almacena el valor de la ventana principal en un identificador único de tipo cadena.
		String MainWindow=driver.getWindowHandle();
		//todas las ventanas secundarias se almacenan en un conjunto de cadenas.
		 Set<String> s1=driver.getWindowHandles();	
		 //Aquí iteraremos a través de todas las ventanas secundarias.		 
	        Iterator<String> i1=s1.iterator();		
	        		
	        while(i1.hasNext())			
	        {		
	            String ChildWindow=i1.next();		
	            //ahora verifíquelos comparando la ventana principal con las ventanas secundarias.		
	            if(!MainWindow.equalsIgnoreCase(ChildWindow))			
	            {    		
	            	//cambie a la ventana secundaria y lea el encabezado.
	            	driver.switchTo().window(ChildWindow);
	            	driver.findElement(By.name("emailid")).sendKeys("gaurav.3n@gmail.com");                			
                    driver.findElement(By.name("btnLogin")).click();			
                                 
			// Closing the Child Window.
                        driver.close();		
	                                	
	            }		
	        }		
	        // Switching to Parent window i.e Main Window.
	            driver.switchTo().window(MainWindow);	
	            driver.close();	
	}
	
	
	
}
