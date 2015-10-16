package com.citrix.podio.testdata;

import com.citrix.podio.configuration.Configuration;

public class TestData {

  public static String VALID_LOGIN;
  public static String VALID_PASSWORD;
  public static final String INVALID_PASSWORD = "$%^DFUBIJNOKM";
  public static final String ERROR_MESSAGE = "Sorry, wrong password. Have you forgotten your password?";
  public static final String DEFAULT_WORKSPACE = "Employee Network";
  public static final String STATUS_TEXT = "Test Status Test TEXT";
  public static final int DEFAULT_RANDOM_STRING_SIZE = 30;

  static {
    VALID_LOGIN = Configuration.getLogin();
    VALID_PASSWORD = Configuration.getPassword();
  }
}
