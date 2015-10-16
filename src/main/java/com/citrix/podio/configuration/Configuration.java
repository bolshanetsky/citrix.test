package com.citrix.podio.configuration;

import java.io.File;

public class Configuration {

  public static final int DEFAULT_WAIT_TIMEOUT = 60;
  private static String url = "https://nextpodio.dk/login";
  private static String chromePath;

  public static String getLogin() {
    return System.getProperty("Login");
  }

  public static String getPassword() {
    return System.getProperty("Password");
  }

  public static String getUrl() {
    return url;
  }

  public static String getChromePath() {
    chromePath =
        String.format("%s%s", System.getProperty("user.dir"),
                      "\\src\\main\\resources\\drivers\\chromedriver.exe"
                          .replace("\\", File.separator)
        );
    return chromePath;
  }
}