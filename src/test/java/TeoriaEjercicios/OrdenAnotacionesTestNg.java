package TeoriaEjercicios;

import org.testng.annotations.Test;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeSuite;

import org.testng.annotations.AfterGroups;

public class OrdenAnotacionesTestNg {

	
	@BeforeSuite
	public void BeforeSuite() {
		System.out.println("BeforeSuite");
	}
	
	@AfterSuite
	public void AfterSuite() {
		System.out.println("AfterSuite");
	}
	
	@BeforeGroups
	public void BeforeGroups() {
		System.out.println("BeforeGroups");
	}
	
	@AfterGroups
	public void AfterGroups() {
		System.out.println("AfterGroups");
	}
	
	@org.testng.annotations.BeforeClass
	public void BeforeClass() {
		System.out.println("BeforeClass");
	}
	
	@org.testng.annotations.AfterClass
	public void AfterClass() {
		System.out.println("AfterClass");
	}
	
	@org.testng.annotations.BeforeMethod
	public void BeforeMethod() {
		System.out.println("BeforeMethod");
	}
	
	@org.testng.annotations.AfterMethod
	public void AfterMethod() {
		System.out.println("AfterMethod");
	}
	
	@org.testng.annotations.BeforeTest
	public void BeforeTest() {
		System.out.println("BeforeTest");
		
	}
	
	@org.testng.annotations.AfterTest
	public void AfterTest() {
		System.out.println("AfterTest");
		
	}
	
	@Test
	public void Test1() {
		System.out.println("Test 1 ");
		
	}
	

	@Test
	public void Test2() {
		System.out.println("Test 2 ");
		
	}
	

}
