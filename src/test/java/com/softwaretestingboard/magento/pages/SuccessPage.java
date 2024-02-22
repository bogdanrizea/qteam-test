package com.softwaretestingboard.magento.pages;

import com.softwaretestingboard.magento.helpers.Helper;
import com.softwaretestingboard.magento.runners.Hook;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SuccessPage implements BasePage {

  private final String THANK_YOU_MESSAGE = "Thank you for your purchase!";
  @Autowired
  private Helper helper;
  @Autowired
  private Hook hook;

  @FindBy(how = How.CSS, using = "#maincontent span[data-ui-id='page-title-wrapper']")
  private WebElement thankYouMessage;
  @FindBy(how = How.CSS, using = "div[class='checkout-success'] p span")
  private WebElement orderNumber;


  public void waitForPageLoaded() {
    helper.waitForVisibilityOf(thankYouMessage);
    Assert.assertEquals(THANK_YOU_MESSAGE, thankYouMessage.getText());
  }

  public void checkOrderNumberIsPresent() {
    helper.waitForVisibilityOf(orderNumber);
    Assert.assertNotNull(Integer.parseInt(orderNumber.getText()));
  }

}