package Listener;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.io.File;
import java.io.IOException;

public class TestListener implements ITestListener {
	
	//Creamos un File para guardar los screen
	String filePath = "C:\\Users\\u582197\\eclipse-workspace\\ProyectoTeoricoPractico\\test-output\\printScreen\\";
	
	
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestStart(result);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String nombreMetodo = result.getName().toString().trim();
		//leer el webdriver, para poder hacer la captura sobre el webdriver
		ITestContext context = result.getTestContext();
		//antes de correr cualquier prueba , seteo el contexto
		//crear un driver interno, lo casteo , esta instanciado con ese nombre WebDriver en la clase SeleccionAlAzarDeProdutos
		WebDriver driver = (WebDriver)context.getAttribute("WebDriver");
		takeScreenShot(nombreMetodo, driver);		
	}

	
	
	
	@Override
	public void onTestFailure(ITestResult result) {

		//saber cuando un CP ha fallado
		//Saco el nombre del metodo, para colocarlo en el Print de pantalla
		String nombreMetodo = result.getName().toString().trim();
		//leer el webdriver, para poder hacer la captura sobre el webdriver
		ITestContext context = result.getTestContext();
		//antes de correr cualquier prueba , seteo el contexto
		//crear un driver interno, lo casteo , esta instanciado con ese nombre WebDriver en la clase SeleccionAlAzarDeProdutos
		WebDriver driver = (WebDriver)context.getAttribute("WebDriver");
		takeScreenShot(nombreMetodo, driver);		
	}
	
	//funcion para crear el ScreenShot
	//2 parametros en la funcion , el webdriver al cual hago el print y el nombre del metodo
	public void takeScreenShot(String methodName, WebDriver driver) {
		
		//guardar con un nombre dif el archivo de los scren
		Calendar calendario = Calendar.getInstance();
		//formato a la Fecha
		SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd-mm-ss");
		//toma el momento cuando se haga el llamado a esta funcion
		String imprimirFecha = formatoFecha.format(calendario.getTime());
		
		//impresion de pantalla, creamos archivos y dsp pasas ese mismo a la pc
		File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//hace un try catch, sino se puede hacer la copia del archivo, que arroje el error
		//con este metodo se guarda el archivo
		try {
			//codigo para crear el archivo
			FileHandler.copy(sourceFile, new File(filePath+methodName+"-"+imprimirFecha+".png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		//ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		//ITestListener.super.onFinish(context);
	}

	
	//implementar los metodos
	
}
