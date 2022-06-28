package TeoriaEjercicios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class DragAndDrop {
	WebDriver driver;
	String url ="https://demo.guru99.com/test/drag_drop.html";
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
	public void soltarYArrastrar() {
		//Element which needs to drag.    		
    	WebElement From=driver.findElement(By.xpath("//*[@id='credit2']/a"));	
     
    	//Element on which need to drop.		
    	WebElement To=driver.findElement(By.xpath("//*[@id='bank']/li"));					
     		
    	//Using Action class for drag and drop.		
    	Actions act=new Actions(driver);					

    	//Dragged and dropped.		
    	act.dragAndDrop(From, To).build().perform();		
		}	


	@Test
	public void specificcellbyDragAndDrop() {
		//Element(BANK) which need to drag.		
        WebElement From=driver.findElement(By.xpath("//*[@id='credit2']/a"));					
      
        //Using Action class for drag and drop.		
        Actions act=new Actions(driver);					
      
        //Drag and Drop by Offset.		
        act.dragAndDropBy(From,135, 40).build().perform();		
	}		
	

	@Test
	public void dropAndDrawVerifyMessage() {
		//Element(BANK) which need to drag.		
    	 WebElement From1=driver.findElement(By.xpath("//*[@id='credit2']/a"));	
    	//Element(DEBIT SIDE) on which need to drop.		
    	WebElement To1=driver.findElement(By.xpath("//*[@id='bank']/li"));					
    	//Element(SALES) which need to drag.		
    	WebElement From2=driver.findElement(By.xpath("//*[@id='credit1']/a"));
	    //Element(CREDIT SIDE) on which need to drop.  		
    	WebElement To2=driver.findElement(By.xpath("//*[@id='loan']/li"));					
       	//Element(500) which need to drag.		
    	WebElement From3=driver.findElement(By.xpath("//*[@id='fourth']/a"));					
       	//Element(DEBIT SIDE) on which need to drop.		
    	WebElement To3=driver.findElement(By.xpath("//*[@id='amt7']/li"));					
    	//Element(500) which need to drag.		
    	WebElement From4=driver.findElement(By.xpath("//*[@id='fourth']/a"));					
       	//Element(CREDIT SIDE) on which need to drop.		
    	WebElement To4=driver.findElement(By.xpath("//*[@id='amt8']/li"));					
    	//Using Action class for drag and drop.		
    	Actions act=new Actions(driver);					
    	//BANK drag and drop.		
    	act.dragAndDrop(From1, To1).build().perform();
    	//SALES drag and drop.		
    	act.dragAndDrop(From2, To2).build().perform(); 
    	//500 drag and drop debit side.		
    	act.dragAndDrop(From3, To3).build().perform();	 
    	//500 drag and drop credit side. 		
    	act.dragAndDrop(From4, To4).build().perform();		
    	//Verifying the Perfect! message.		
    	if(driver.findElement(By.xpath("//a[contains(text(),'Perfect')]")).isDisplayed())							
    	{		
        	System.out.println("Perfect Displayed !!!");					
    	}
		else
    	{
       	System.out.println("Perfect not Displayed !!!");					
    	}	
	}
	
	@AfterSuite
	public void tearDown() {
		driver.close();
	}
}
