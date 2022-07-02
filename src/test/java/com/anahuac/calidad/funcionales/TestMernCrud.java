package com.anahuac.calidad.funcionales;
import java.util.regex.Pattern;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;

import java.io.File;

public class TestMernCrud {
	  private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();
	  JavascriptExecutor js;
	  @Before
	  public void setUp() throws Exception {
	    WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	    js = (JavascriptExecutor) driver;
	  }
	  
	  @Test
	  public void testadd() throws Exception {
	    driver.get("https://mern-crud.herokuapp.com/"); 
	    //termine usando heroku, puesto que lo habiamos usado en algun momento(hace un año), ya que no pude 
	    //hacer que mi docker funcionara solo se queda haciendo el pull del mongo y simplemente no funciona, no se cual es el problema
	    //ya bsuque una posible solucion pero al final no pude hacerlo o resolverlo y se debe creo por la poca memoria de mi ssd
	    driver.findElement(By.xpath("//div[@id='root']/div/div[2]/button")).click();
	    driver.findElement(By.name("name")).click();
	    driver.findElement(By.name("name")).sendKeys("Frank");
	    driver.findElement(By.name("email")).click();
	    driver.findElement(By.name("email")).clear();
	    driver.findElement(By.name("email")).sendKeys("fsimonbcontact@gmail.com");
	    driver.findElement(By.name("age")).click();
	    driver.findElement(By.name("age")).sendKeys("20");
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Gender'])[2]/following::div[1]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Male'])[1]/following::span[1]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Woah!'])[1]/following::button[1]")).click();
	    pause(5000);
	    
	    String tag = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/div[4]/div/div")).getText();
	    assertThat("Nice one!",is(tag));
	  }


	  @Test
	  public void testUpdate() throws Exception {
		  driver.get("https://mern-crud.herokuapp.com/");
		  driver.findElement(By.xpath("/html/body/div/div/div[2]/table/tbody/tr[1]/td[5]/button[1]")).click();
		  driver.findElement(By.name("name")).click();
		  driver.findElement(By.name("name")).clear();
		  driver.findElement(By.name("name")).sendKeys("Francisco");
		  driver.findElement(By.name("email")).click();
		  driver.findElement(By.name("email")).clear();
		  driver.findElement(By.name("email")).sendKeys("ElPresidenteDelaNacion@gmail.com");
		  driver.findElement(By.name("age")).click();
		  driver.findElement(By.name("age")).clear();
		  driver.findElement(By.name("age")).sendKeys("21");
		  driver.findElement(By.xpath("//div[3]/div[2]/div/i")).click();
		  driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Male'])[2]/following::div[1]")).click();
		  driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Woah!'])[1]/following::button[1]")).click();
		  pause(5000);
		  driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/button")).click();
		  String tag = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/div[4]/div/div")).getText();
		    assertThat("Nice one!",is(tag));
		  
	  }
	  
	  @Test
	  public void testBuscar() throws Exception {
		  driver.get("https://mern-crud.herokuapp.com/");
	    driver.findElement(By.xpath("//div[@id='root']/div/div[2]/button")).click();
	    driver.findElement(By.name("name")).click();
	    driver.findElement(By.name("name")).clear();
	    driver.findElement(By.name("name")).sendKeys("Francisco");
	    driver.findElement(By.name("email")).clear();
	    driver.findElement(By.name("email")).sendKeys("fsimonbcontact@gmail.com");
	    driver.findElement(By.name("age")).click();
	    driver.findElement(By.name("age")).clear();
	    driver.findElement(By.name("age")).sendKeys("100");
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Gender'])[2]/following::div[1]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Male'])[1]/following::div[2]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Woah!'])[1]/following::button[1]")).click();
	    driver.findElement(By.xpath("//i")).click();
	    driver.findElement(By.xpath("//div[@id='root']/div/div[2]/button")).click();
	    driver.findElement(By.name("name")).click();
	    driver.findElement(By.name("name")).clear();
	    driver.findElement(By.name("name")).sendKeys("Elon Musk");
	    driver.findElement(By.name("email")).click();
	    driver.findElement(By.name("email")).clear();
	    driver.findElement(By.name("email")).sendKeys("payuselon@mail.com.us");
	    driver.findElement(By.name("age")).click();
	    driver.findElement(By.name("age")).clear();
	    driver.findElement(By.name("age")).sendKeys("10");
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Gender'])[2]/following::div[2]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Male'])[1]/following::div[2]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Woah!'])[1]/following::button[1]")).click();
	    driver.findElement(By.xpath("//i")).click();
	    driver.findElement(By.xpath("//div[@id='root']/div/div[2]/table/tbody/tr/td[5]/button[2]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Elon Musk'])[2]/following::button[1]")).click();
	    
	    String expName = "Francisco Simon";
	    String expMail = "fsimonbcontact@gmail.com";
	    String expAge = "100";
	    String expGend= "m";
	    
	    String actName = driver.findElement(By.xpath("/html/body/div/div/div[2]/table/tbody/tr/td[1]")).getText();
	    String actMail = driver.findElement(By.xpath("/html/body/div/div/div[2]/table/tbody/tr/td[2]")).getText();
	    String actAge = driver.findElement(By.xpath("/html/body/div/div/div[2]/table/tbody/tr/td[3]")).getText();
	    String actGend = driver.findElement(By.xpath("/html/body/div/div/div[2]/table/tbody/tr/td[4]")).getText();
	    
	    assertEquals(expName,actName);
	    assertEquals(expMail,actMail);
	    assertEquals(expAge,actAge);
	    assertEquals(expGend,actGend);
	    
	    
	    driver.findElement(By.xpath("//div[@id='root']/div/div[2]/table/tbody/tr/td[5]/button[2]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Francisco Simon'])[2]/following::button[1]")).click();
	  
	  }
	  

	  @Test
	  public void testdelete() throws Exception {
		    driver.get("https://mern-crud.herokuapp.com/");
		    	String bdelete = driver.findElement(By.xpath("/html/body/div/div/div[2]/table/tbody/tr[1]/td[5]/button[2]")).getText();
		        driver.findElement(By.xpath("/html/body/div/div/div[2]/table/tbody/tr/td[5]/button[2]")).click();
		        pause(2500);
		        driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/button[1]")).click();
		        pause(2500);
		        
			    assertThat("delete", is(not(bdelete)));
			    
		  } 
	  
		
	  @After
	  public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  }

	  private boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }

	  private boolean isAlertPresent() {
	    try {
	      driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }

	  private String closeAlertAndGetItsText() {
	    try {
	      Alert alert = driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	      acceptNextAlert = true;
	    }
	  }
	  
	  private void pause(long mils) {
		  try {
			  Thread.sleep(mils);
			  }catch(Exception e){
				  e.printStackTrace();	
			  }
		  }
	}