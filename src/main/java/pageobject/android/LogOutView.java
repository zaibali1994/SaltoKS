package pageobject.android;

import general.CommonAssertions;
import general.CommonFunctions;
import general.WebDriverFactory;
import general.WebDriverWaits;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;


public class LogOutView {
    public static By settingsOption = By.xpath("//android.widget.FrameLayout[@content-desc=\"Settings\"]/android.view.ViewGroup/android.widget.TextView");
    public static By logOutOption = By.xpath("(//android.widget.LinearLayout[@content-desc=\"logout\"]/android.widget.RelativeLayout");
    public void PerformLogoutOperation() throws InterruptedException {
        WebDriverWaits.waitUntilElementVisible(settingsOption);
        CommonFunctions.clickFunction(settingsOption);
        WebDriverWaits.waitUntilElementVisible(logOutOption);

        MobileElement logOutButtonText = WebDriverFactory.getDriver().findElement(logOutOption);
        String buttonText = logOutButtonText.getText();
        WebDriverWaits.waitUntilElementVisible((LoginView.continueButton));
        CommonFunctions.clickFunction(LoginView.continueButton);

        CommonAssertions.logVerifyStringEqual(buttonText, "Log out", "User has been blocked");
    }


}


