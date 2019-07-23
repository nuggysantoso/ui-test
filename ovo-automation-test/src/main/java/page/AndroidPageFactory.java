package page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;

import java.time.Duration;

public class AndroidPageFactory {
    protected static AppiumDriver appiumDriver;
    private TouchAction touchAction = new TouchAction(this.appiumDriver);

    public AndroidPageFactory(AppiumDriver appiumDriver){
        this.appiumDriver = appiumDriver;
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
    }

    protected void assertTrue(String message, boolean condition){
        Assert.assertTrue(message, condition);
    }

    protected void assertFalse(String message, boolean condition){
        Assert.assertFalse(message, condition);
    }

    protected void assertEquals(String message, String expected, String actual){
        Assert.assertEquals(message, expected, actual);
    }

    protected void assertNotEquals(String message, String notExpected, String actual){
        Assert.assertNotEquals(message, notExpected, actual);
    }

    protected String getTextOrValueElement(MobileElement mobileElement){
        assertElementIsDisplayed(mobileElement);
        return mobileElement.getText();
    }

    protected Boolean isElementPresent(MobileElement mobileElement){
        return mobileElement.isDisplayed();
    }

    protected void assertElementIsDisplayed(MobileElement mobileElement){
        assertTrue("Failed : " + mobileElement.toString() + "Is Not Displayed", isElementPresent(mobileElement));
    }

    protected void assertTextElementIsEquals(MobileElement mobileElement, String expected){
        String actual = getTextOrValueElement(mobileElement);
        assertEquals("Failed : "+ actual + " Not Equals With "+ expected, expected, actual);
    }

    protected void assertTextElementIsNotEquals(MobileElement mobileElement, String expected){
        String actual = getTextOrValueElement(mobileElement);
        assertEquals("Failed : "+ actual + " Equals With "+ expected, expected, actual);
    }

    protected void clickElement(MobileElement mobileElement){
        assertElementIsDisplayed(mobileElement);
        mobileElement.click();
    }

    protected void inputTextToElement(MobileElement mobileElement, String textToInput){
        assertElementIsDisplayed(mobileElement);
        mobileElement.sendKeys(textToInput);
    }

    protected MobileElement getElementById(String id){
        return (MobileElement) appiumDriver.findElement(By.id(id));
    }

    protected MobileElement getElementByXpath(String xPath){
        return (MobileElement) appiumDriver.findElement(By.xpath(xPath));
    }

    protected void dragElement(MobileElement mobileElement1, MobileElement mobileElement2){
        assertElementIsDisplayed(mobileElement1);
        assertElementIsDisplayed(mobileElement2);
        touchAction.longPress(mobileElement1).waitAction(2000).moveTo(mobileElement2).perform().release();
    }

    protected void waitForPresenceOfElementById(String id){
        WebDriverWait wait = new WebDriverWait(appiumDriver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
    }

    public void scrollScreen(MobileElement xElement, int endX, int endY){
        TouchAction touchAction = new TouchAction(appiumDriver);
        touchAction.longPress(xElement, 5).moveTo(endX, endY).release().perform();
    }

    public void scrollScreen(int startX, int startY, int endX, int endY){
        TouchAction touchAction = new TouchAction(appiumDriver);
        touchAction.longPress(startX, startY, 3).moveTo(endX, endY).release().perform();
    }
}
