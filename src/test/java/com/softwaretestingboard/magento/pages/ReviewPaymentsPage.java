package com.softwaretestingboard.magento.pages;

import com.softwaretestingboard.magento.helpers.Helper;
import com.softwaretestingboard.magento.runners.Hook;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReviewPaymentsPage implements BasePage {

  @Autowired
  private Helper helper;
  @Autowired
  private Hook hook;

  @FindBy(how = How.CSS, using = "#opc-sidebar div[class='loader']")
  private WebElement orderSummaryLoader;
  @FindBy(how = How.CSS, using = "button[class='action primary checkout']")
  private WebElement placeOrderButton;
  @FindBy(how = How.CSS, using = "div[class='loading-mask']")
  private WebElement loadingMask;

  public void waitForPageLoaded() {
    helper.waitForVisibilityOf(orderSummaryLoader);
    helper.waitForInvisibilityOf(orderSummaryLoader);
  }

  public void clickPlaceOrderButton() {
    helper.clickElement(placeOrderButton);
  }

  public void waitForLoader() {
    helper.waitForInvisibilityOf(loadingMask);
  }

}