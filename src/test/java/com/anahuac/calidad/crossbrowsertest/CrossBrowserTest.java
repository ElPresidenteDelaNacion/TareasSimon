package com.anahuac.calidad.crossbrowsertest;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class CrossBrowserTest {
  
	private WebDriver driver;
	
	@BeforeClass
	@Parameters({"URL","BrowserType"})
	  public void beforeClass(String url, String browserType) {
		
		if(browserType.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
		    driver = new ChromeDriver();
		}else {
			WebDriverManager.firefoxdriver().setup();
		    driver = new FirefoxDriver();
		}
		
		
		driver.get(url);
		
		System.out.println("Abriendo en "+browserType);
		
	  }
	
	
	@Test
  public void testCaminoFeliz() {
		
		
		
  }
  
	
	@Test
	  public void testCaminoNoFeliz() {
		driver.get("https://www.facebook.com/");
	      driver.findElement(By.name("email")).clear();
	      driver.findElement(By.name("email")).sendKeys("fsimonbcontact@gmail.com");
	      driver.findElement(By.name("pass")).clear();
	      driver.findElement(By.name("pass")).sendKeys("asdasdasdasd");
	      driver.findElement(By.name("login")).click();
	    
	      pause(5000);
	      
	    String incorrect = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div[2]/div[2]/form/div/div[2]/div[2]")).getText(); 
	    assertTrue(incorrect.contains("La contraseña que ingresaste es incorrecta. "));
		
	}
  
  

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }
  
  
  private void pause(long mils) {
	  try {
		  Thread.sleep(mils);
		  }catch(Exception e){
			  e.printStackTrace();	
		  }
	  }

}
