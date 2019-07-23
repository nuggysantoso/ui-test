package common;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import page.LoginPage;
import page.OnboardingPage;

public class BaseAndroidTest extends DriverBuilder {
    private final String platform = "Android";
    protected OnboardingPage onboardingPage;
    protected LoginPage loginPage;

    /**
     * List of page
     * Please make sure the class from android package
     */
    @BeforeSuite()
    public void setUp() throws Exception {
        super.startServer();
        super.setPlatform(platform);
        super.setDriver();
    }

    @BeforeTest()
    public void createObject(){
        onboardingPage = new OnboardingPage(getDriver());
        loginPage = new LoginPage(getDriver());
    }

    @AfterSuite
    public void tearDown(){
        driver.quit();
        stopServer();
    }
}
