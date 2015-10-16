package com.citrix.podio.test;

import com.citrix.podio.configuration.Configuration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
  protected static WebDriver driver;
  protected static final String loginPageUrl;

  static {
    System.setProperty("webdriver.chrome.driver", Configuration.getChromePath());
    loginPageUrl = Configuration.getUrl();
  }

  public static WebDriver getDriver() {
    return new ChromeDriver();
  }
}
