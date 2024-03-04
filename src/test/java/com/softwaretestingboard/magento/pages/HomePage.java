package com.softwaretestingboard.magento.pages;

import com.softwaretestingboard.magento.helpers.Helper;
import com.softwaretestingboard.magento.runners.Hook;
import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HomePage implements BasePage {

  private static final String ADD_TO_CART_BUTTON_LOCATOR = "button[title='Add to Cart']";
  @Autowired
  private Helper helper;
  @Autowired
  private Hook hook;
  @FindBy(how = How.CSS, using = "a[class='action showcart']")
  private WebElement cartIcon;
  @FindBy(how = How.CSS, using = "span[class='counter-number']")
  private WebElement cartIconCounter;
  @FindBy(how = How.CSS, using = "span[class='counter-number']")
  private List<WebElement> cartIconCounterList;
  @FindBy(how = How.CSS, using = "div[class='swatch-attribute color']>div>div[class='swatch-option color'][aria-label='Blue']")
  private WebElement blueCOlorButton;
  @FindBy(how = How.CSS, using = "div[class='swatch-attribute size'] div[aria-label='XS']")
  private WebElement sizeXsButton;
  @FindBy(how = How.CSS, using = ADD_TO_CART_BUTTON_LOCATOR)
  private WebElement addToCartButton;
  @FindBy(how = How.CSS, using = "#top-cart-btn-checkout")
  private WebElement proceedToCheckoutButton;

  public void pickSizeForItem() {
    helper.clickElement(sizeXsButton);
  }

  public void pickColorForItem() {
    helper.clickElement(blueCOlorButton);
  }

  public void clickAddToCartButton() {
    helper.waitForPresenceOf((By.cssSelector(ADD_TO_CART_BUTTON_LOCATOR)));
    helper.moveToElementAndClick(addToCartButton);
  }

  public void checkShoppingCartCounterValueIs(int number) {
    helper.waitForPresenceOf(cartIconCounter);
    Assert.assertEquals(Integer.parseInt(cartIconCounter.getText()), number);
  }

  public void waitShoppingCartCounterIsUpdated() {
    helper.waitForPresenceOf(cartIconCounter);
  }

  public void clickCartIcon() {
    helper.clickElement(cartIcon);
  }

  public ShippingPage proceedToCheckout() {
    helper.clickElement(proceedToCheckoutButton);
    return new ShippingPage();
  }

  public void navigateToHomePage() {
    if (hook.getDriver().getCurrentUrl() != hook.getBaseUrl()) {
      hook.getDriver().get(hook.getBaseUrl());
    }
  }

  public void addItemToCart() {
    pickSizeForItem();
    pickColorForItem();
    clickAddToCartButton();
    waitShoppingCartCounterIsUpdated();
  }

}