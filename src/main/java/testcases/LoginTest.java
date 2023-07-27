package testcases;

import general.MainCall;
import general.BaseTest;
import com.testinium.deviceinformation.exception.DeviceNotFoundException;
import org.testng.annotations.Test;

import java.io.IOException;


public class LoginTest extends BaseTest {

    @Test
    public static void verifyUserIsAbleToLoginSuccessfully() throws DeviceNotFoundException, IOException, InterruptedException {

        MainCall.loginView.loginTheApp();
    }
    @Test
    public static void verifyUserIsAbleToSelectSiteAndNavigateHomeScreen() throws DeviceNotFoundException, IOException, InterruptedException {

        MainCall.onboardingView.selectSite();
        //MainCall.onboardingView.navigateToMainScreen();
    }

}
