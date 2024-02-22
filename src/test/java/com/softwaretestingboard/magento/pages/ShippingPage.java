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
public class ShippingPage implements BasePage {

  @Autowired
  private Helper helper;
  @Autowired
  private Hook hook;

  @FindBy(how = How.CSS, using = "#checkout-loader")
  private WebElement checkoutLoader;
  @FindBy(how = How.CSS, using = "div[data-role='loader']")
  private WebElement shippingMethodLoader;
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
  @FindBy(how = How.CSS, using = "input[type='radio'][value='flatrate_flatrate']")
  private WebElement flatRateRadioButton;
  @FindBy(how = How.CSS, using = "input[type='radio'][value='tablerate_bestway']")
  private WebElement tableRateRadioButton;
  @FindBy(how = How.CSS, using = "select[name='country_id']")
  private WebElement countryDropdown;
  @FindBy(how = How.CSS, using = "select[name='region_id']")
  private WebElement stateProvinceDropdown;
  @FindBy(how = How.CSS, using = "button[data-role='opc-continue']")
  private WebElement nextButton;

  public void waitForPageLoaded() {
    helper.waitForInvisibilityOf(checkoutLoader);
  }

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

  public void selectInCountryDropdown(String value) {
    helper.selectInDropdown(countryDropdown, value);
  }

  public void selectInStateProvinceDropdown(String value) {
    helper.selectInDropdown(stateProvinceDropdown, value);
  }

  public void waitForCountryChangeToTakeEffect() {
    helper.waitForVisibilityOf(shippingMethodLoader);
    helper.waitForInvisibilityOf(shippingMethodLoader);
  }

  public void clickNextButton() {
    helper.clickElement(nextButton);
  }
}