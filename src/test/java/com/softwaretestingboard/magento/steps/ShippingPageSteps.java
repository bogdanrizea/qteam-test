package com.softwaretestingboard.magento.steps;

import com.softwaretestingboard.magento.pages.ShippingPage;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

public class ShippingPageSteps {

  private final String EMAIL = "rizea.bogdan@gmail.com";
  private final String NAME = "Harry";
  private final String LAST_NAME = "Potter";
  private final String ADDRESS = "No 4 Privet Drive, cupboard under the stairs";
  private final String CITY = "Little Whinging";
  private final String POST_CODE = "WD25 7FD";
  private final String PHONE_NUMBER = "+56342342342";

  @Autowired
  private ShippingPage shippingPage;

  @Then("the Shipping page should be loaded")
  public void checkShippingPageIsLoaded() {
    shippingPage.waitForPageLoaded();
    shippingPage.checkShippingMethodsPresent();
  }

  @When("the client types in a valid email")
  public void typeInEmail() {
    shippingPage.typeInEmailInput(EMAIL);
  }

  @When("the client types in his first name")
  public void typeInFirstName() {
    shippingPage.typeInFirstNameInput(NAME);
  }

  @When("the client types in his last name")
  public void typeInLastName() {
    shippingPage.typeInLastNameInput(LAST_NAME);
  }

  @When("the client types in his address")
  public void typeInAddress() {
    shippingPage.typeInAddressInput(ADDRESS);
  }

  @When("the client types in his city")
  public void typeInCity() {
    shippingPage.typeInCityInput(CITY);
  }

  @When("the client types in his post code")
  public void typeInPostCode() {
    shippingPage.typeInPostCodeInput(POST_CODE);
  }

  @When("the client types in his phone number")
  public void theClientTypesInHisPhoneNumber() {
    shippingPage.typeInPhoneInput(PHONE_NUMBER);
  }

  @ParameterType("Fixed|TableRate")
  public String rate(String string) {
    return string;
  }

  @When("the client checks {rate} shipping method radio button")
  public void selectShippingRateCheckbox(String string) {
    switch (string) {
      case "Fixed":
        shippingPage.clickFixedShippingMethod();
        break;
      default:
        shippingPage.clickTableRateShippingMethod();
    }
  }

  @ParameterType("Romania|United Kingdom|United States")
  public String country(String string) {
    return string;
  }

  @When("the client selects {country} in the country dropdown")
  public void theClientSelectsInTheCountryDropdown(String country) {
    shippingPage.selectInCountryDropdown(country);
    shippingPage.waitForCountryChangeToTakeEffect();
  }

  @ParameterType("Bucureşti|California")
  public String stateProvince(String string) {
    return string;
  }

  @When("the client selects {stateProvince} in the country dropdown")
  public void theClientSelectInStateProvinceDropdown(String stateProvince) {
    shippingPage.selectInStateProvinceDropdown(stateProvince);
  }

  @When("the client clicks on the Next button")
  public void clickNextButton() {
    shippingPage.waitForCountryChangeToTakeEffect();
    shippingPage.clickNextButton();
  }
}
