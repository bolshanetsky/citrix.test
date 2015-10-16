package com.citrix.podio.pageobjects;

import com.citrix.podio.configuration.Configuration;
import com.citrix.podio.locators.Locators;
import com.citrix.podio.testdata.TestData;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.logging.Logger;

public class ShareModalChunk {

  private final WebDriver driver;

  private static final Logger logger = Logger.getLogger(ShareModalChunk.class.getName());

  public ShareModalChunk(WebDriver driver) {
    logger.info("Creating Share Modal chunk");
    this.driver = driver;
    WebDriverWait wait = new WebDriverWait(driver, Configuration.DEFAULT_WAIT_TIMEOUT);
    String locator = String.format(Locators.ShareModalChunk.WORKSPACE_BUTTON,
                                   TestData.DEFAULT_WORKSPACE);
    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
  }

  public HomePage selectWorkspaceByName(String workspaceName) {
    logger.info(String.format("Selecting workspace by name: %s", workspaceName));
    getWorkSpaceButton(workspaceName).click();
    return new HomePage(driver);
  }

  private WebElement getWorkSpaceButton(String workspaceName) {
    String locator = String.format(Locators.ShareModalChunk.WORKSPACE_BUTTON, workspaceName);
    return driver.findElement(By.xpath(locator));
  }
}