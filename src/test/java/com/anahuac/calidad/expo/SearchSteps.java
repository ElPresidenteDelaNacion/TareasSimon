package com.anahuac.calidad.expo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.hamcrest.Matchers.is;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchSteps {
	
	//BASICAMENTE REVISA QUE LO BUSCADO SI COINCIDA CON LO ENCONTRADO
	
	//Atributos:
	private WebDriver driver;
	private String baseUrl; //DA WARNING
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	JavascriptExecutor js;
	
	
	//Primera orden
	@Given("the user is in the index page")
	public void theUserIsInTheIndexPage() {
		
		//Chrome
		//WebDriverManager.chromedriver().setup();
		//driver = new ChromeDriver();
		
		//FireFox
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		
		//AMBOS
		baseUrl = "https://www.google.com/";
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS); //DA WARNING
		js = (JavascriptExecutor) driver;
		
		//Añadimos driver
		driver.get("http://automationpractice.com/index.php");
	}
	
	//Ahora con when
	@When("the user enters dresses in the search bar")
	public void theUserEntersDressesInTheSearchBar() {
		
		//Busca la barra de búsqueda e introduce "dresses"
		driver.findElement(By.id("search_query_top")).sendKeys("dresses");
		
	}
	
	//Ahora con el and
	//NO SE USA EL AND
	@When("the user clicks the search button")
	public void theUserClicksTheSearchButton() {
		
		//Dar click a botón de buscar
		driver.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[2]/form/button")).click();
		
		//Para la pausa
				pause(10000);
				
			}
			
			//Finaliza con el then
			@Then("the dresses page appears")
			public void theDressesPageAppears() {
				String titulo ="dato aleatorio";
				
				driver.quit();
				
				//Para la pausa
				pause(10000);
				
				//XPATH del dearch dresses
				///html/body/div/div[2]/div/div[3]/div[2]/h1/span[1]
				
			}
			
			//Pegamos pausa
			private void pause(long mils) {
				  try {
					  Thread.sleep(mils);
				  } catch(Exception e) {
					  e.printStackTrace();
				  }
			  }
		}