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
public class ReviewPaymentsPage extends AbstractCheckoutPage {

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
  @FindBy(how = How.CSS, using = "input[name='billing-address-same-as-shipping']")
  private WebElement billingShippingAddressAreSameCheckBox;
  @FindBy(how = How.CSS, using = "div[name='billingAddresscheckmo.firstname'] input[name='firstname']")
  private WebElement billShipFirstName;
  @FindBy(how = How.CSS, using = "button[class='action action-update']")
  private WebElement updateButton;
  @FindBy(how = How.CSS, using = "div[name='billingAddresscheckmo.firstname'] div span")
  private WebElement firstNameValidation;
  @FindBy(how = How.CSS, using = "div[name='billingAddresscheckmo.street.0'] div span")
  private WebElement addressValidation;
  @FindBy(how = How.CSS, using = "div[name='billingAddresscheckmo.lastname'] div span")
  private WebElement lastNameValidation;
  @FindBy(how = How.CSS, using = "div[name='billingAddresscheckmo.city'] div span")
  private WebElement cityValidation;
  @FindBy(how = How.CSS, using = "div[name='billingAddresscheckmo.postcode'] div span")
  private WebElement postCodeValidation;
  @FindBy(how = How.CSS, using = "div[name='billingAddresscheckmo.telephone'] div[class='field-error'] span")
  private WebElement phoneValidation;

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

  public void unTickBillingShippingCheckbox() {
    if (!billingShippingAddressAreSameCheckBox.isSelected()) {
      billingShippingAddressAreSameCheckBox.click();
    }
    helper.waitForElementToBeCheked(billingShippingAddressAreSameCheckBox);
    helper.clickElement(billingShippingAddressAreSameCheckBox);
  }

  public void clickUpdateButton() {
    helper.clickElement(updateButton);
  }

  public void checkNameValidationMessage() {
    Assert.assertEquals(REQUIRED_FIELD, firstNameValidation.getText());
  }

  public void checkLastNameValidationMessage() {
    Assert.assertEquals(REQUIRED_FIELD, lastNameValidation.getText());
  }

  public void checkAddressValidationMessage() {
    Assert.assertEquals(REQUIRED_FIELD, addressValidation.getText());
  }

  public void checkPostCodeValidationMessage() {
    Assert.assertEquals(REQUIRED_FIELD, postCodeValidation.getText());
  }

  public void checkCityValidationMessage() {
    Assert.assertEquals(REQUIRED_FIELD, cityValidation.getText());
  }

  public void checkPhoneValidationMessage() {
    Assert.assertEquals(REQUIRED_FIELD, phoneValidation.getText());
  }
}