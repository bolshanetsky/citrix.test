package com.citrix.podio.locators;

/**
 * Created by olsha_000 on 10/16/2015.
 */
public class Locators {

  public class LoginPage {

    public static final String LOGIN_FIELD = "#email";
    public static final String PASSWORD_FIELD = "#password";
    public static final String LOGIN_BUTTON = ".flatbutton.green";
    public static final String ERROR_MESSAGE = ".form-messages.warning>li";
  }

  public class HomePage {

    public static final String STREAM_EDIT_FIELD = "#status_value";
    public static final String SHARE_BUTTON = ".flatbutton.green";
    public static final String STATUSES_IN_STREAM = ".image-block.object";
    public static final String WARNING_ICON = ".form-validation-invalid-icon";
  }

  public class ShareModalChunk {

    public static final String WORKSPACE_BUTTON = ".//*[@class='space_listitemcontent']/ul/li[contains(., '%s')]";
  }
}
