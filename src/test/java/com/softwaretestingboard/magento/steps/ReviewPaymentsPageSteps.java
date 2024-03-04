package com.softwaretestingboard.magento.steps;

import com.softwaretestingboard.magento.pages.ReviewPaymentsPage;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.StaleElementReferenceException;
import org.springframework.beans.factory.annotation.Autowired;

public class ReviewPaymentsPageSteps {

  @Autowired
  private ReviewPaymentsPage reviewPaymentsPage;

  @Then("the Review & Payments page should be loaded")
  public void checkShippingPageIsLoaded() {
    try {
      reviewPaymentsPage.waitForPageLoaded();
    } catch (StaleElementReferenceException e) {
      reviewPaymentsPage.waitForPageLoaded();
    }
  }

  @When("the client clicks on the Place Order button")
  public void clickPlaceOrderButton() {
    reviewPaymentsPage.clickPlaceOrderButton();
    reviewPaymentsPage.waitForLoader();
  }

  @When("the client unchecks the My billing and shipping address checkbox")
  public void uncheckBillingShipping() {
    reviewPaymentsPage.unTickBillingShippingCheckbox();
  }

  @ParameterType("First Name|Last Name|Address|City|Post Code|Phone Number")
  public String paymentInputs(String string) {
    return string;
  }

  @Then("a message requiring to input {paymentInputs} should appear")
  public void aMessageRequiringToFillInInput(String paymentInputs) {
    switch (paymentInputs) {
      case "First Name":
        reviewPaymentsPage.checkNameValidationMessage();
        break;
      case "Last Name":
        reviewPaymentsPage.checkLastNameValidationMessage();
        break;
      case "Address":
        reviewPaymentsPage.checkAddressValidationMessage();
        break;
      case "City":
        reviewPaymentsPage.checkCityValidationMessage();
        break;
      case "Post Code":
        reviewPaymentsPage.checkPostCodeValidationMessage();
        break;
      default:
        reviewPaymentsPage.checkPhoneValidationMessage();
    }
  }

  @And("clicks the Update button")
  public void clicksTheUpdateButton() {
    reviewPaymentsPage.clickUpdateButton();
  }
}