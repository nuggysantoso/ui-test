import common.BaseAndroidTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseAndroidTest {

    @Test()
    public void LP_01() throws InterruptedException {
        onboardingPage.checkOnboardingScreenIsDisplayed();
        onboardingPage.swipeOnboardingLayout();
        onboardingPage.clickMulaiBtn();

        loginPage.checkLoginPageIsDisplayed();
        loginPage.clickSetujuBtn();
        loginPage.checkAndroidPermissionIsDisplayed();
        loginPage.clickAllowPermissionBtn();
        loginPage.inputNomorPonselTxtBox("087888098063");
        loginPage.clickSignInBtn();
        loginPage.checkErrorLoginMessageTxtViewIsDisplayed();
        loginPage.clickOkeLoginBtn();
    }
}
