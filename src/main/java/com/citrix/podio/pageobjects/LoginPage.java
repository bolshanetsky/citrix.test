package com.citrix.podio.pageobjects;

import com.citrix.podio.locators.Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.logging.Logger;

public class LoginPage {

  private static final Logger logger = Logger.getLogger(LoginPage.class.getName());

  private final WebDriver driver;

  public LoginPage(WebDriver driver){
    this.driver = driver;
  }

  public HomePage doLogin(String login, String password) {
    logger.info(String.format("Do login for Login: %s", login));
    getLoginField().sendKeys(login);
    getPasswordField().sendKeys(password);
    getLoginButton().click();
    return new HomePage(driver);
  }

  public WebElement getLoginField() {
    return driver.findElement(By.cssSelector(Locators.LoginPage.LOGIN_FIELD));
  }

  public WebElement getPasswordField() {
    return driver.findElement(By.cssSelector(Locators.LoginPage.PASSWORD_FIELD));
  }

  public WebElement getLoginButton() {
    return driver.findElement(By.cssSelector(Locators.LoginPage.LOGIN_BUTTON));
  }

  public String getErrorMessageText() {
    return getErrorMessage().getText();
  }

  public WebElement getErrorMessage() {
    return driver.findElement(By.cssSelector(Locators.LoginPage.ERROR_MESSAGE));
  }
}