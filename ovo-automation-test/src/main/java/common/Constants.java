package common;

public class Constants {
    public static final String APPIUM_URL="http://127.0.0.1:4723/wd/hub";
    public static final String DEFAULT_APP_PATH= System.getProperty("user.dir") + "/src/test/resources/";
    /**
     * Default Constant value for android
     */
    public static final String DEFAULT_ANDROID_PLATFORM_VERSION="9";
    public static final String DEFAULT_ANDROID_DEVICE_NAME="AndroidP";
    public static final String DEFAULT_ANDROID_APP_NAME ="OVO.apk";
    public static final String DEFAULT_ANDROID_PAKCAGE_NAME ="ovo.id";
    public static final String DEFAULT_ANDROID_ACTIVITY_NAME ="ovo.id.auth.activity.LandingActivity";
    public static final String DEFAULT_ANDROID_WAIT_ACTIVITY = "ovo.id.loyalty.activity.ActOnboarding";
    public static final Boolean DEFAULT_ANDROID_FULL_RESET_VALUE = true;
    public static final int DEFAULT_ANDROID_COMMAND_TIMEOUT = 320000;
}
