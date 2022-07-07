package com.anahuac.calidad.crossbrowser;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class LoginTest extends BaseTest {

	@Test
	public void testSuccessfulLogin() {
		LoginPage loginPage = new LoginPage(webdriver);
		EmployeePage employeePage = loginPage.loginAs("admin","admin123");
		Assert.assertTrue(employeePage.isEmployeePageDisplayed());
		Assert.aseertEquals(employeePage.getUsernameNameText(), "admin");
	}

}
