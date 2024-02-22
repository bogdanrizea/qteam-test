package com.softwaretestingboard.magento.helpers;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

import com.softwaretestingboard.magento.runners.Hook;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Helper {

    @Autowired
    private Hook hooks;

    public void waitForVisibilityOf(WebElement element) {
        hooks.getWait().until(visibilityOf(element));
    }

    public void waitForPresenceOf(By by) {
        hooks.getWait().until(visibilityOfElementLocated(by));
    }

    public void waitForPresenceOf(WebElement webElement) {
        hooks.getWait().until(visibilityOf(webElement));
    }

    public void waitForElementToBeClickable(By by) {
        hooks.getWait().until(elementToBeClickable(by));
    }

    public void moveToElementAndClick(WebElement webElement) {
        Actions action = new Actions(hooks.getDriver());
        action.moveToElement(webElement).click().perform();
    }

    public void clickElement(WebElement webElement) {
        hooks.getWait().until(elementToBeClickable(webElement));
        try {
            webElement.click();
        } catch (StaleElementReferenceException e)  {
            webElement.click();
        }
    }

    public void waitForInvisibilityOf(WebElement webElement) {
        hooks.getWait().until(invisibilityOf(webElement));
    }

    public void selectInDropdown(WebElement webElement, String value) {
        hooks.getWait().until(elementToBeClickable(webElement));
        webElement.click();
        Select select = new Select(webElement);
        select.selectByVisibleText(value);
        webElement.click();
    }
}
