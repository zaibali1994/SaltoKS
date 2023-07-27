package pageobject.android;

import general.*;
import org.openqa.selenium.By;
import org.testng.Assert;


public class LoginView {
    public static By test = By.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.ListView/android.widget.LinearLayout[3]/android.widget.TextView[2]");
    public static By loginButton = By.id("nl.moboa.myclay:id/login_button");

    public static By emailInputField = By.id("nl.moboa.myclay:id/input");

    public static By continueButton = By.id("nl.moboa.myclay:id/button");

    public static By passwordInputField = By.id("Password");

    public static By submitButton = By.id("SubmitButton");
    public void loginTheApp() throws InterruptedException {

        CommonFunctions.clickFunction(loginButton);
        CommonAssertions.logExpectedResult("Login Button has been clicked"); //Add expected result of the above action

        CommonFunctions.sendKeysFunction(emailInputField,"ts@my-clay.com");
        WebDriverWaits.elementToBeClickable(continueButton);
        CommonFunctions.clickFunction(continueButton);

        WebDriverWaits.sleep(5000);
        WebDriverFactory.driver.context("WEBVIEW_chrome");

        CommonFunctions.sendKeysFunction(passwordInputField,"123456Ab");
        WebDriverWaits.elementToBeClickable(submitButton);
        CommonFunctions.clickFunction(submitButton);
    }


    }




