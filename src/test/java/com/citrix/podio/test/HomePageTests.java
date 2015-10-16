package com.citrix.podio.test;

import com.citrix.podio.pageobjects.HomePage;
import com.citrix.podio.pageobjects.LoginPage;
import com.citrix.podio.testdata.TestData;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HomePageTests extends BaseTest{

  private LoginPage loginPage;
  private HomePage homePage;

  @Before
  public void beforeTest(){
    driver = getDriver();
  }

  @After
  public void afterTest(){
    driver.quit();
  }

  /**
   * Test: Verify that status publishing functionality.
   * Steps:
   * 1. Navigate to Login page.
   * 2. Do login with valid credentials.
   * 3. Enter status text into Status field.
   * 4. Click share button.
   * 5. Pick workspace according to test data.
   * Expected result:
   * 2. Home page is loaded
   * 4. Status is published and visible.
   * */
  @Test
  public void publishStatusPostTest(){

    // Generating random status.
    String statusText = RandomStringUtils.randomAlphanumeric(TestData.DEFAULT_RANDOM_STRING_SIZE);

    // Navigate to Login page.
    driver.get(loginPageUrl);

    // Login with valid credentials.
    loginPage = new LoginPage(driver);
    homePage = loginPage.doLogin(TestData.VALID_LOGIN, TestData.VALID_PASSWORD);

    // Publishing status
    homePage.PublishStatus(statusText, TestData.DEFAULT_WORKSPACE);
    String actualStatusText = homePage.getLastAddedStatus();

    // Assert that Status is added.
    Assert.assertEquals("Status wasn't added", statusText, actualStatusText);
  }

  /**
   * Test: Verify that empty status is not publishing.
   * Steps:
   * 1. Navigate to Login page.
   * 2. Do login with valid credentials.
   * 3. Enter empty status text into Status field.
   * 4. Click share button.
   * Expected result:
   * 2. Home page is loaded
   * 4. Status is not published and warning icon is appeared.
   * */
  @Test
  public void publishEmptyStatusTest(){
    String emptyString = "";

    // Navigate to Login page and login.
    driver.get(loginPageUrl);
    loginPage = new LoginPage(driver);
    homePage = loginPage.doLogin(TestData.VALID_LOGIN, TestData.VALID_PASSWORD);

    // Enter empty status
    homePage.EnterStatusText(emptyString).clickShareButton();

    // Assert that warning icon is visible.
    boolean isWarningVisible = homePage.isWarningIconVisible();
    Assert.assertTrue("Warning icon should be visible", isWarningVisible);
  }
}