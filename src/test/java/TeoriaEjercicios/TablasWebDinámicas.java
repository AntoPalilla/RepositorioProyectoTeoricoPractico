package TeoriaEjercicios;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;

public class TablasWebDinámicas {

	WebDriver driver;
	String url ="http://demo.guru99.com/test/web-table-element.php";
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
	public void numeroFilaYColumna() {
		
        //No.of Columns
        List <WebElement> col = driver.findElements(By.xpath(".//*[@id=\"leftcontainer\"]/table/thead/tr/th"));
        System.out.println("No of cols are : " +col.size()); 
        //No.of rows 
        List <WebElement> rows = driver.findElements(By.xpath(".//*[@id='leftcontainer']/table/tbody/tr/td[1]")); 
        System.out.println("No of rows are : " + rows.size());
        driver.close();
	}
	
	
	@Test
	public void obtenerValor() {
		//localizar la tabla contenedora de todos los datos
		WebElement baseTable = driver.findElement(By.tagName("table"));
		
		//Valor especifico fila 
		WebElement filaCompany = baseTable.findElement(By.xpath("/html/body/div/div[3]/div[1]/table/tbody/tr[5]/td[1]/a"));
		String nombreFila = filaCompany.getText();
		WebElement filaGrupo = baseTable.findElement(By.xpath("/html/body/div/div[3]/div[1]/table/tbody/tr[1]/td[2]"));
		String nombreGrupo = filaGrupo.getText();
		WebElement filaPrecio = baseTable.findElement(By.xpath("/html/body/div/div[3]/div[1]/table/tbody/tr[5]/td[4]"));
		String precio = filaPrecio.getText();
		System.out.println("Compañia:" + " " + nombreFila + " " + "en el Grupo:" + " " + nombreGrupo + " "+"con el precio:" + " " + precio);
		
		/*
		//To find third row of table
		WebElement tableRow = baseTable.findElement(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr[3]"));
        String rowtext = tableRow.getText();
		 System.out.println("Third row of table : "+rowtext);
		    
		    //to get 3rd row's 2nd column data
		    WebElement cellIneed = tableRow.findElement(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr[3]/td[2]"));
	
		    String valueIneed = cellIneed.getText();
		    System.out.println("Cell value is : " + valueIneed); */
		    
		    
		    driver.close();
	}
	
	
	@Test 
	public void obtenerValorMaximo() throws ParseException {
			String max;
			double m=0,r=0;
		 
	       //No. of Columns
	        List<WebElement>  col = driver.findElements(By.xpath(".//*[@id='leftcontainer']/table/thead/tr/th"));
	        System.out.println("Total No of columns are : " +col.size());
	        //No.of rows
	        List<WebElement>  rows = driver.findElements(By.xpath (".//*[@id='leftcontainer']/table/tbody/tr/td[1]"));
	        System.out.println("Total No of rows are : " + rows.size());
	        //Usando for loop, iteramos a través del número total de filas y obtenemos valores uno por uno. Para obtener la siguiente fila usamos (i+1) en XPath
	        for (int i =1;i<rows.size();i++)
	        {    
	            max= driver.findElement(By.xpath("/html/body/div/div[3]/div[1]/table/tbody/tr[\"+(i+1)+\"]/td[3]")).getText();
	            //
	           // /html/body/div[1]/div[5]/table/tbody/tr["+(i+1)+"]/td[4]
	            		//*[@id="leftcontainer"]/table/tbody/tr[1]/td[3]
	            NumberFormat f =NumberFormat.getNumberInstance(); 
	            Number num = f.parse(max);
	            max = num.toString();
	            m = Double.parseDouble(max);
	            //Comparamos el valor anterior con el valor nuevo y el valor máximo se imprime al final del ciclo for
	            if(m>r)
	             {    
	                r=m;
	             }
	        }
	        System.out.println("Maximum current price is : "+ r);
	        driver.close();
	}
	
	@Test
	public void obtenerValoresTablaDinamica() {
		driver.get("http://demo.guru99.com/test/table.html");
    	//localizar la tabla contenedora
    	WebElement mytable =driver.findElement(By.xpath("/html/body/table/tbody"));
    	//localizar filas de la tabla. 
    	List < WebElement > rows_table = mytable.findElements(By.tagName("tr"));
    	//rows_count da el número total de filas
    	int rows_count = rows_table.size();
    	//Iteramos a través de cada columna y de cada fila y obtenemos valores.
    	for (int row = 0; row < rows_count; row++) {
    	    //para cada fila obtenemos el número total de columnas usando
    	    List < WebElement > Columns_row = rows_table.get(row).findElements(By.tagName("td"));
    	    //To calculate no of columns (cells). In that specific row.
    	    int columns_count = Columns_row.size();
    	    System.out.println("Number of cells In Row " + row + " are " + columns_count);
    	    //Loop will execute till the last cell of that specific row.
    	    for (int column = 0; column < columns_count; column++) {
    	        // To retrieve text from that specific cell.
    	        String celtext = Columns_row.get(column).getText();
    	        System.out.println("Cell Value of row number " + row + " and column number " + column + " Is " + celtext);
    	    }
    	    System.out.println("-------------------------------------------------- ");
    	}
    	driver.close();
   	}
	
	}
