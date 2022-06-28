package TeoriaEjercicios;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class AllBrokenLinks {

	WebDriver driver;
	String url;
	String ChromeDrivePath = "..\\ProyectoTeoricoPractico\\Drivers\\chromedriver.exe";

	@BeforeSuite
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", ChromeDrivePath);
		driver = new ChromeDriver();
		
		
	}
	
	@Test
	public void linksRotos() {
		driver.get("http://www.zlti.com");
		String homePage = "http://www.zlti.com";
        String url = "";
        //Con los métodos de este paquete, podemos enviar solicitudes HTTP y capturar códigos de respuesta HTTP de la respuesta.
        HttpURLConnection huc = null;
        int respCode = 200;
        
        //Identifique todos los enlaces en una página web y guárdelos en Lista.
        List<WebElement> links = driver.findElements(By.tagName("a"));
        //Iterator<WebElement> it = enlaces.iterator();
        Iterator<WebElement> it = links.iterator();
        
        while(it.hasNext()){
            //verificaremos si la URL pertenece a un dominio de terceros o si la URL está vacía o es nula.Obtenga href de la etiqueta de anclaje y guárdelo en la variable url.
            url = it.next().getAttribute("href");
            
            System.out.println(url);
        //Compruebe si la URL es nula o está vacía y omita los pasos restantes si se cumple la condición.
            if(url == null || url.isEmpty()){
            	System.out.println("URL is either not configured for anchor tag or it is empty");
                continue;
            }
            //Compruebe si la URL pertenece a un dominio principal o a un tercero. Omita los pasos restantes si pertenece al dominio de un tercero.
            if(!url.startsWith(homePage)){
                System.out.println("URL belongs to another domain, skipping it.");
                continue;
            }
            
            try {
            	// la salida del método openConnection() (URLConnection) se convierte a HttpURLConnection.
                huc = (HttpURLConnection)(new URL(url).openConnection());
                //Podemos establecer el tipo de solicitud como "HEAD" en lugar de "GET". Para que solo se devuelvan los encabezados y no el cuerpo del documento.
                huc.setRequestMethod("HEAD");
                //Al invocar el método connect(), se establece la conexión real a la URL y se envía la solicitud.
                huc.connect();
                //Usando el método getResponseCode() podemos obtener el código de respuesta para la solicitud
                respCode = huc.getResponseCode();
                
                //Según el código de respuesta, intentaremos verificar el estado del enlace.
                if(respCode >= 400){
                    System.out.println(url+" is a broken link");
                }
                else{
                    System.out.println(url+" is a valid link");
                }
                    
            } catch (MalformedURLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        
        driver.quit();

	}
	
	@Test
	public void obtenerEnlacesPagWeb() {
		driver.get("http://demo.guru99.com/test/newtours/");
		String underConsTitle = "En construcción: Mercury Tours";
		
		List<WebElement> linkElements = driver.findElements(By.tagName("a"));							
        String[] linkTexts = new String[linkElements.size()];							
			int i = 0;					

			// extrae los textos de enlace de cada elemento de enlace 	
			for (WebElement e : linkElements) {							
			linkTexts[i] = e.getText();							
			i++;			
        }		

			//probar cada enlace		
			for (String t : linkTexts) {
				WebDriverWait wait = new WebDriverWait(driver, 60);
		        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.linkText(t))));

			driver.findElement(By.linkText(t)).click();					
			if (driver.getTitle().equals(underConsTitle)) {							
                System.out.println("\"" + t + "\""								
                        + " is under construction.");			
            } else {			
                System.out.println("\"" + t + "\""								
                        + " is working.");			
            }		
			driver.navigate().back();			
        }		
			driver.quit();			
    }	
	
	@Test 
	public void otro() {
		driver.get("http://demo.guru99.com/test/newtours/");
		List<WebElement> links = driver.findElements(By.tagName("a"));
        List<String> hrefs = new ArrayList<>();
        for (WebElement link : links)
        {
            hrefs.add(link.getAttribute("href"));
        }
        System.out.println(hrefs.size());
        String underConsTitle = "Under Construction: Mercury Tours";
        for (String href : hrefs)
        {
            driver.get(href);
            System.out.print("\"" + href + "\"");
            if (driver.getTitle().equals(underConsTitle))
            {
                System.out.println(" is under construction.");
            }
            else
            {
                System.out.println(" is working.");
            }
        }
        driver.close();
        driver.quit();
    }
	


}
		
	
	
	
	
	
	
	
