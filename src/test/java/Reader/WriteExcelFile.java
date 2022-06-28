package Reader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcelFile {

	//clase para escribir los datos en el fichero
	
	//metodo escribir una lista de datos al excel
	public void writeExcel(String filepath, String sheetName, String[] dataToWrite) throws IOException {
		
		File file = new File (filepath);
		
		FileInputStream inputStream = new FileInputStream(file);
		
		XSSFWorkbook newWorkbook = new XSSFWorkbook(inputStream);
		
		XSSFSheet newSheet = newWorkbook.getSheet(sheetName);
		
		//cant de filas que existe, y vamos a escribir a partir de la ultima fila para no sobreescribir la info q se tiene
		int rowCount = newSheet.getLastRowNum() - newSheet.getFirstRowNum();
			
		//objeto fila
			XSSFRow row = newSheet.getRow(0);
		
		//crear una fila 
		XSSFRow newRow =newSheet.createRow(rowCount+1);
		
		//contamos  por la fila de arriba que tiene la estructuras de la celdas que tenemos
		for(int i=0; i <row.getLastCellNum(); i++) {
			
			//creamos una celda
			XSSFCell newCell = newRow.createCell(i)	;
			//dataToWrite Arreglo que se recibe en los parametros del metodo
			newCell.setCellValue(dataToWrite[i]);
		}
		
		inputStream.close();
		//escribimos la info en el excel
		FileOutputStream outputStream = new FileOutputStream(file);
		
		newWorkbook.write(outputStream);
		
		outputStream.close();
	}
	
	
	//metodo para crear un valor en una celda especifica
	//resulText, texto que queremos escribir en la celda
	public void writeCellValue(String filepath, String sheetName, int rowNumber, int cellNumber, String resultText) throws IOException {
		
		File file = new File (filepath);
		
		FileInputStream inputStream = new FileInputStream(file);
		
		//libro de excel que recibe el inputStream
		XSSFWorkbook newWorkbook = new XSSFWorkbook(inputStream);
		
		//la hoja de excel, que le pasamos por parametro el nombre en el metodo
		XSSFSheet newSheet = newWorkbook.getSheet(sheetName);
		
		//numero de la fila a la que queremos acceder
		XSSFRow row = newSheet.getRow(rowNumber);
		
		//firstcell, celda desde donde vamos a empezar a leer
		XSSFCell firstCell = row.getCell(cellNumber-1);
		
		//envia el valor de la primera celda, asi nos permita ver que esta pasadno en el codigo
		System.out.println("first cell values is:"+ firstCell.getStringCellValue());
		
		XSSFCell nextCell = row.createCell(cellNumber);
		
		nextCell.setCellValue(resultText);
		
		//para confirmar si en la celda nextCell se guardo el resulttext que se guardo como parametro 
		System.out.println("nextcell value:"+ nextCell.getStringCellValue());
		
		inputStream.close();
		
		FileOutputStream outputStream = new FileOutputStream(file);
		
		outputStream.close();	
	}
	
}

