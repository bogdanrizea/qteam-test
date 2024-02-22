package com.softwaretestingboard.magento.pages;

import com.softwaretestingboard.magento.helpers.Helper;
import com.softwaretestingboard.magento.runners.Hook;
import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public abstract class AbstractCheckoutPage implements BasePage {

  private static final String REQUIRED_FIELD = "This is a required field.";
  private static final String EMAIL_VALIDATION_MESSAGE = "Please enter a valid email address (Ex: johndoe@domain.com).";
  private static final String SHIPPING_METHOD_MISSING_MESSAGE = "The shipping method is missing. Select the shipping method and try again.";
  @FindBy(how = How.CSS, using = "#checkout-step-shipping")
  protected WebElement ousideOfInputs;
  @Autowired
  private Helper helper;
  @Autowired
  private Hook hook;
  @FindBy(how = How.CSS, using = "#checkout-step-shipping_method")
  private List<WebElement> shippingMethodsDiv;
  @FindBy(how = How.CSS, using = "#customer-email")
  private WebElement emailInput;
  @FindBy(how = How.CSS, using = "input[name='firstname']")
  private WebElement firstNameInput;
  @FindBy(how = How.CSS, using = "input[name='lastname']")
  private WebElement lastNameInput;
  @FindBy(how = How.CSS, using = "input[name='street[0]']")
  private WebElement streetAddressInput;
  @FindBy(how = How.CSS, using = "input[name='city']")
  private WebElement cityInput;
  @FindBy(how = How.CSS, using = "input[name='postcode']")
  private WebElement postcodeInput;
  @FindBy(how = How.CSS, using = "input[name='telephone']")
  private WebElement phoneInput;
  @FindBy(how = How.CSS, using = "select[name='country_id']")
  private WebElement countryDropdown;
  @FindBy(how = How.CSS, using = "select[name='region_id']")
  private WebElement stateProvinceDropdown;
  @FindBy(how = How.CSS, using = "#customer-email-error")
  private WebElement emailValidationMessage;
  @FindBy(how = How.CSS, using = "#customer-email-error")
  private List<WebElement> emailValidationMessageList;
  @FindBy(how = How.CSS, using = "div[name='shippingAddress.firstname'] div span")
  private WebElement nameValidationMessage;
  @FindBy(how = How.CSS, using = "div[name='shippingAddress.lastname'] div span")
  private WebElement lastNameValidationMessage;
  @FindBy(how = How.CSS, using = "div[name='shippingAddress.street.0'] div span")
  private WebElement addressValidationMessage;
  @FindBy(how = How.CSS, using = "div[name='shippingAddress.city'] div span")
  private WebElement cityValidationMessage;
  @FindBy(how = How.CSS, using = "div[name='shippingAddress.postcode'] div span")
  private WebElement postCodeValidationMessage;
  @FindBy(how = How.CSS, using = "div[name='shippingAddress.telephone'] div[class='field-error'] span")
  private WebElement phoneValidationMessage;
  @FindBy(how = How.CSS, using = "#co-shipping-method-form div[class='message notice']")
  private WebElement shippingMethodMissingMessage;

  public void checkShippingMethodsPresent() {
    Assert.assertEquals(1, shippingMethodsDiv.size());
  }

  public void typeInEmailInput(String string) {
    emailInput.sendKeys(string);
  }

  public void typeInFirstNameInput(String string) {
    firstNameInput.sendKeys(string);
  }

  public void typeInLastNameInput(String string) {
    lastNameInput.sendKeys(string);
  }

  public void typeInAddressInput(String string) {
    streetAddressInput.sendKeys(string);
  }

  public void typeInCityInput(String string) {
    cityInput.sendKeys(string);
  }

  public void typeInPostCodeInput(String string) {
    postcodeInput.sendKeys(string);
  }

  public void typeInPhoneInput(String string) {
    phoneInput.sendKeys(string);
  }


  public void selectInCountryDropdown(String value) {
    helper.selectInDropdown(countryDropdown, value);
  }

  public void selectInStateProvinceDropdown(String value) {
    helper.selectInDropdown(stateProvinceDropdown, value);
  }

  public void clickOutsideTheInputs() {
    helper.clickElement(ousideOfInputs);
  }

  public void checkEmailValidationTextDisplayed() {
    helper.waitForPresenceOf(emailValidationMessage);
    Assert.assertEquals(EMAIL_VALIDATION_MESSAGE, emailValidationMessage.getText());
  }

  private void clearInput(WebElement webElement) {
    webElement.clear();
  }

  public void clearEmailInput() {
    clearInput(emailInput);
  }

  public void clearNameInput() {
    clearInput(firstNameInput);
  }

  public void clearLastNameInput() {
    clearInput(lastNameInput);
  }

  public void clearAddressInput() {
    clearInput(streetAddressInput);
  }

  public void clearPostCodeInput() {
    clearInput(postcodeInput);
  }

  public void clearPhoneInput() {
    clearInput(phoneInput);
  }

  public void clearCityInput() {
    clearInput(cityInput);
  }

  public void checkNameValidationMessageDisplayed() {
    helper.waitForPresenceOf(nameValidationMessage);
    Assert.assertEquals(REQUIRED_FIELD, nameValidationMessage.getText());
  }

  public void checkLastNameValidationMessageDisplayed() {
    helper.waitForPresenceOf(lastNameValidationMessage);
    Assert.assertEquals(REQUIRED_FIELD, lastNameValidationMessage.getText());
  }

  public void checkAddressValidationMessageDisplayed() {
    helper.waitForPresenceOf(addressValidationMessage);
    Assert.assertEquals(REQUIRED_FIELD, addressValidationMessage.getText());
  }

  public void checkCityValidationMessageDisplayed() {
    helper.waitForPresenceOf(cityValidationMessage);
    Assert.assertEquals(REQUIRED_FIELD, cityValidationMessage.getText());
  }

  public void checkPostCodeValidationMessageDisplayed() {
    helper.waitForPresenceOf(postCodeValidationMessage);
    Assert.assertEquals(REQUIRED_FIELD, postCodeValidationMessage.getText());
  }

  public void checkPhoneValidationMessageDisplayed() {
    helper.waitForPresenceOf(phoneValidationMessage);
    Assert.assertEquals(REQUIRED_FIELD, phoneValidationMessage.getText());
  }

  public void checkEmailIsNotEmptyTextDisplayed() {
    helper.waitForPresenceOf(emailValidationMessage);
    Assert.assertEquals(REQUIRED_FIELD, emailValidationMessage.getText());
  }

  public void checkShippingMethodNotSelectedMessage() {
    helper.waitForPresenceOf(shippingMethodMissingMessage);
    Assert.assertEquals(SHIPPING_METHOD_MISSING_MESSAGE, shippingMethodMissingMessage.getText());
  }
}