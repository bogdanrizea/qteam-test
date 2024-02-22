package com.softwaretestingboard.magento.steps;

import com.softwaretestingboard.magento.pages.ReviewPaymentsPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

public class ReviewPaymentsPageSteps {

  @Autowired
  private ReviewPaymentsPage reviewPaymentsPage;

  @Then("the Review & Payments page should be loaded")
  public void checkShippingPageIsLoaded() {
    reviewPaymentsPage.waitForPageLoaded();
  }

  @When("the client clicks on the Place Order button")
  public void clickPlaceOrderButton() {
    reviewPaymentsPage.clickPlaceOrderButton();
    reviewPaymentsPage.waitForLoader();
  }

}
