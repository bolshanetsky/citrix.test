package com.citrix.podio.pageobjects;

import com.citrix.podio.configuration.Configuration;
import com.citrix.podio.locators.Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.logging.Logger;

public class HomePage {

  private static final Logger logger = Logger.getLogger(HomePage.class.getName());

  private final WebDriver driver;
  private WebElement streamEditField;
  private WebElement podioHomeButton;

  public HomePage(WebDriver driver) {
    logger.info("Creating Home Page.");
    this.driver = driver;
  }

  public boolean isHomePageLoaded() {
    podioHomeButton = getStreamEditField();
    Dimension dimension = podioHomeButton.getSize();

    return dimension.getHeight()>0 && dimension.getWidth()>0;
  }

  public WebElement getStreamEditField() {
    return driver.findElement(By.cssSelector(Locators.HomePage.STREAM_EDIT_FIELD));
  }

  public HomePage PublishStatus(String statusText, String workspaceName) {
    logger.info(String.format("Publishing status: %s; in workspace %s.", statusText, workspaceName));
    EnterStatusText(statusText);
    gotoShareModal().selectWorkspaceByName(workspaceName);

    // Wait until modal closes.
    WebDriverWait wait = new WebDriverWait(driver, Configuration.DEFAULT_WAIT_TIMEOUT);
    wait.until(ExpectedConditions.elementToBeClickable(getShareButton()));
    return this;
  }

  public ShareModalChunk gotoShareModal() {
    WebDriverWait wait = new WebDriverWait(driver, Configuration.DEFAULT_WAIT_TIMEOUT);
    wait.until(ExpectedConditions.elementToBeClickable(getShareButton()));
    clickShareButton();
    return new ShareModalChunk(driver);
  }

  public HomePage clickShareButton(){
    logger.info("clicking Share button.");
    WebDriverWait wait = new WebDriverWait(driver, Configuration.DEFAULT_WAIT_TIMEOUT);
    wait.until(ExpectedConditions.elementToBeClickable(getShareButton()));
    getShareButton().click();
    return this;
  }

  public WebElement getShareButton() {
    return driver.findElement(By.cssSelector(Locators.HomePage.SHARE_BUTTON));
  }

  private List<WebElement> getStatuses() {
    List statuses = driver.findElements(By.cssSelector(Locators.HomePage.STATUSES_IN_STREAM));
    return statuses;
  }

  public String getLastAddedStatus(){
    WebElement status = getStatuses().get(0);
    return status.getText().split("\n")[0];
  }

  public HomePage EnterStatusText(String text) {
    logger.info(String.format("Entering status: %s", text));
    streamEditField = getStreamEditField();
    streamEditField.clear();
    streamEditField.sendKeys(text);
    return this;
  }

  public boolean isWarningIconVisible() {
    WebDriverWait wait = new WebDriverWait(driver, Configuration.DEFAULT_WAIT_TIMEOUT);
    wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(Locators.HomePage.WARNING_ICON)));
    return getWarningIcon().isDisplayed();
  }

  public WebElement getWarningIcon() {
    return driver.findElement(By.cssSelector(Locators.HomePage.WARNING_ICON));
  }
}