package com.anahuac.calidad.funcionales;


import java.util.regex.Pattern;
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


public class TestGoogle {
	
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  JavascriptExecutor js;
  @Before
  public void setUp() throws Exception {
	  WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
    baseUrl = "https://www.google.com/";
    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    js = (JavascriptExecutor) driver;
  }

  @Test
  public void testUntitledTestCase() throws Exception {
    driver.get("https://www.google.com/search?q=fotos+gatitos&oq=fotos+gatitos&aqs=chrome..69i57j0i512l6j0i22i30l3.2597j0j9&sourceid=chrome&ie=UTF-8");
    driver.findElement(By.linkText("Imágenes")).click();
    driver.get("https://www.google.com/search?q=fotos+gatitos&source=lnms&tbm=isch&sa=X&ved=2ahUKEwiUu5zI4874AhVwDEQIHbCWD6QQ_AUoAXoECAEQAw&biw=1366&bih=657&dpr=1");
    driver.findElement(By.xpath("//img[@alt='Todo lo que tienes que saber de los gatitos bebés | Purina®']")).click();
    assertEquals("fotos gatitos - Búsqueda de Google", driver.getTitle());
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
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}

