package com.softwaretestingboard.magento.steps;

import com.softwaretestingboard.magento.helpers.ItemColor;
import com.softwaretestingboard.magento.helpers.Size;
import com.softwaretestingboard.magento.pages.HomePage;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

public class HomePageSteps {

  @Autowired
  private HomePage homePage;

  @ParameterType("SX|X|M|L|XL")
  public Size size(String itemSize) {
    return Size.valueOf(itemSize);
  }

  @ParameterType("Blue|Orange|Purple")
  public ItemColor itemColor(String itemColor) {
    return ItemColor.valueOf(itemColor);
  }

  @Given("a user selects {size} and {itemColor} for item number 1 on page")
  public void selectSizeAndColorForItem(Size size, ItemColor itemColor) {
    homePage.pickSizeForItem();
    homePage.pickColorForItem();
  }

  @When("client clicks on Add to Cart Button")
  public void clickAddToCartButton() {
    homePage.clickAddToCartButton();
  }

  @Then("the shopping cart should show {int} item count")
  public void checkShoppingCartCounterIs(int number) {
    homePage.checkShoppingCartCounterValueIs(number);
  }

  @When("client clicks on the shopping cart icon")
  public void clickCartButton() {
    homePage.clickCartIcon();
  }

  @When("client clicks on the Proceed to Checkout button")
  public void clickProceedToCheckoutButton() {
    homePage.proceedToCheckout();
  }

  @Given("client adds product to cart and goes to checkout")
  public void addToCartAndCheckout() {
    homePage.navigateToHomePage();
    homePage.addItemToCartIfEmpty();
    homePage.clickCartIcon();
    homePage.proceedToCheckout();
  }
}
