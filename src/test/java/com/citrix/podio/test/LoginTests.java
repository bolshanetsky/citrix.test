package com.citrix.podio.test;

import com.citrix.podio.pageobjects.LoginPage;
import com.citrix.podio.testdata.TestData;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class LoginTests extends BaseTest{

  @Before
  public void beforeTest(){
    driver = getDriver();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  @After
  public void afterTest(){
    driver.quit();
  }

  private LoginPage loginPage;

  /**
   * Test: Validate successful login with valid credentials.
   * Steps:
   * 1. Navigate to login page.
   * 2. Enter valid login and password.
   * 3. Click Login button
   * Expected result:
   * 3. Home page is loaded
   */
  @Test
  public void validLoginTest(){

    // Navigate to login page.
    driver.get(loginPageUrl);

    // Enter valid login and password.
    loginPage = new LoginPage(driver);
    boolean isHomePageLoaded = loginPage.doLogin(TestData.VALID_LOGIN, TestData.VALID_PASSWORD).isHomePageLoaded();

    // Assert that home page was loaded.
    Assert.assertTrue("Home Page wasn't loaded", isHomePageLoaded);
  }

  /**
   * Test: Validate proper message after unsuccessful login.
   * Steps:
   * 1. Navigate to login page
   * 2. Enter valid login
   * 3. Enter invalid password
   * 4. Click login button
   * Expected result:
   * 4. "Sorry, wrong password. Have you forgotten your password?" message is shown.
   */
  @Test
  public void invalidLoginTest(){

    // Navigate to login page
    driver.get(loginPageUrl);


    // Login with invalid credentials
    loginPage = new LoginPage(driver);
    loginPage.doLogin(TestData.VALID_LOGIN, TestData.INVALID_PASSWORD);
    String errorMessageText = loginPage.getErrorMessageText();

    // Assert that proper message is shown.
    Assert.assertEquals("Error message isn't shown or invalid", TestData.ERROR_MESSAGE,
                        errorMessageText);
  }
}
