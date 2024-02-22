package com.softwaretestingboard.magento.steps;

import com.softwaretestingboard.magento.pages.SuccessPage;
import io.cucumber.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

public class SuccessPageSteps {
  @Autowired
  private SuccessPage successPage;

  @Then("the Success page should be loaded")
  public void checkShippingPageIsLoaded() {
    successPage.waitForPageLoaded();
  }

  @Then("order number should be present")
  public void checkOrderNumberDisplayed() {
    successPage.checkOrderNumberIsPresent();
  }

}
