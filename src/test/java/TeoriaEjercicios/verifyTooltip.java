package TeoriaEjercicios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class verifyTooltip {
	WebDriver driver;
	String url ="https://demo.guru99.com/test/social-icon.html";
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
	public void toolTip() {
		 String expectedTooltip = "Facebook";	
	        
	        // Find the facebook icon at the top right of the header		
	        WebElement facebook = driver.findElement(By.xpath("//span[contains(text(),'Facebook')]"));	
	        
	        //get the value of the "title" attribute of the facebook icon		
	        String actualTooltip = facebook.getAttribute("title");	
	        
	        //Assert the tooltip's value is as expected 		
	        System.out.println("Actual Title of Tool Tip"+actualTooltip);							
	        if(actualTooltip.equals(expectedTooltip)) {							
	            System.out.println("Test Case Passed");					
	        }		
	        driver.close();			
	   }		
	}
	


