package com.softwaretestingboard.magento.pages;

import com.softwaretestingboard.magento.helpers.Helper;
import com.softwaretestingboard.magento.runners.Hook;
import java.util.List;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ShippingPage extends AbstractCheckoutPage {

  @Autowired
  private Helper helper;
  @Autowired
  private Hook hook;
  @FindBy(how = How.CSS, using = "#checkout-loader")
  private WebElement checkoutLoader;
  @FindBy(how = How.CSS, using = "#customer-email-fieldset[class='fieldset _block-content-loading']")
  private WebElement detailsLoading;
  @FindBy(how = How.CSS, using = "div[data-role='loader']")
  private WebElement shippingMethodLoader;
  @FindBy(how = How.CSS, using = "#checkout-step-shipping_method")
  private List<WebElement> shippingMethodsDiv;
  @FindBy(how = How.CSS, using = "input[type='radio'][value='flatrate_flatrate']")
  private WebElement flatRateRadioButton;
  @FindBy(how = How.CSS, using = "input[type='radio'][value='tablerate_bestway']")
  private WebElement tableRateRadioButton;
  @FindBy(how = How.CSS, using = "button[data-role='opc-continue']")
  private WebElement nextButton;

  public void waitForPageLoaded() {
    helper.waitForInvisibilityOf(checkoutLoader);
  }

  public void waitForDetailsLoaderIsDisplayed() {
    helper.waitForVisibilityOf(detailsLoading);
  }

  public void waitForDetailsLoaderNotDisplayed() {
    helper.waitForVisibilityOf(detailsLoading);
  }

  private void clickShippingMethodRadioButton(WebElement webElement) {
    helper.waitForPresenceOf(webElement);
    if (!webElement.isSelected()) {
      webElement.click();
    }
  }

  public void clickFixedShippingMethod() {
    clickShippingMethodRadioButton(flatRateRadioButton);
  }

  public void clickTableRateShippingMethod() {
    clickShippingMethodRadioButton(tableRateRadioButton);
  }

  public void waitForCountryChangeToTakeEffect() {
    try {
      helper.waitForVisibilityOf(shippingMethodLoader);
      helper.waitForInvisibilityOf(shippingMethodLoader);
    } catch (TimeoutException e) {
    }
  }

  public void clickNextButton() {
    helper.clickElement(nextButton);
  }

  public void clickOutsideTheInputs() {
    helper.clickElement(ousideOfInputs);
  }

}