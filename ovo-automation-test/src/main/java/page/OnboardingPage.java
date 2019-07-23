package page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;

public class OnboardingPage extends AbstracPage {
    public OnboardingPage(AppiumDriver appiumDriver){
        super(appiumDriver);
    }

    @AndroidFindBy(id = "vp_onboarding")
    MobileElement onboardingLayout;

    @AndroidFindBy(id = "btn_get_started")
    MobileElement btnMulai;

    @Step("Checking Onboarding Screen Is Displayed")
    public void checkOnboardingScreenIsDisplayed(){
        assertElementIsDisplayed(onboardingLayout);
    }

    @Step("Swipe Onboarding Screen Tutorial")
    public void swipeOnboardingLayout() throws InterruptedException {
        int middle = appiumDriver.manage().window().getSize().getWidth() / 2 + 300;
        int middleHeight = appiumDriver.manage().window().getSize().getHeight() / 2;
        for (int i = 0; i < 4; i++){
            scrollScreen(middle, middleHeight, 10, middleHeight);
            Thread.sleep(1000);
        }
    }

    @Step("Click Mulai Button Onboarding Screen")
    public void clickMulaiBtn(){
        clickElement(btnMulai);
    }
}
