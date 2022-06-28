package Reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.nio.file.Path;


import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {
	
	private BufferedReader br;

	
	public static Object[][] leerExcel(String ruta,String nombreHoja) throws Exception {
	//para utilizar archivos Java solicita el manejo de excepciones (throws Excepcion)
		//lee los bytes del fichero	
		FileInputStream file = new FileInputStream(new File(ruta));
		
		//representa el archivo/libro Excel
		XSSFWorkbook libroExcel= new XSSFWorkbook(file);
		
		//representa la hoja del archivo Excel
		XSSFSheet Hoja=libroExcel.getSheet(nombreHoja);
		System.out.println(nombreHoja);
		
		//representa una fija de la hoja
		XSSFRow fila;
		int filas = Hoja.getPhysicalNumberOfRows();
		
		int columnas= Hoja.getRow(0).getPhysicalNumberOfCells();
		
		//crea arreglo de objetos del tamaño de filas/columbas del excel
		Object cellValue[][]=new Object[filas][columnas];
		
		for (int r = 0; r < filas; r++) {
		 fila = Hoja.getRow(r);
		 if (fila == null){ break; }else{ for (int c = 0; c < columnas; c++) {
		 DataFormatter dataFormatter = new DataFormatter();
		 cellValue[r][c] = dataFormatter.formatCellValue(Hoja.getRow(r).getCell(c)); } }
		 }
		
		libroExcel.close();
		return cellValue; }
	
	
	

public ArrayList<String> getData() throws Exception {
	ArrayList<String> dataRead = new ArrayList<String>();
	
	File archivo = new File("..\\ProyectoTeoricoPractico\\Datos\\Libro1.csv");
	
	br = new BufferedReader(new FileReader(archivo));
	
	//cada linea que voy a sumar a mi arrayList = dataread
	String st;
	
	//repita el proceso mientras se cumpla la condicion, si es una sola linea no haca falta la llave
	while ((st=br.readLine()) != null) dataRead.add(st);
	
	return dataRead;	
}

public void LectorCSV() {
	ArrayList<ArrayList<String>> datos = new ArrayList<ArrayList<String>>();
	
	Path filePath = Paths.get("..\\ProyectoTeoricoPractico\\Datos\\Libro1.csv");
	
	try {
		BufferedReader br= Files.newBufferedReader(filePath);
		String linea;
		while((linea= br.readLine()) !=null){
			String[] datosDeLinea = linea.split(";");
			ArrayList<String> datosTemporal = new ArrayList<String>();
			for (String dato : datosDeLinea) {
				datosTemporal.add(dato);
			}
			datos.add(datosTemporal);
			}}
		catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(datos);
		}

}






