package pageobject.android;

import general.*;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;


public class PeopleView {
    public static By peopleOption = By.xpath("//android.widget.FrameLayout[@content-desc=\"People\"]/android.view.ViewGroup/android.widget.TextView");
    public static By firstPerson = By.xpath("(//android.widget.ImageView[@content-desc=\"A person\"])[1]");
    public static By blockUnblockButton = By.id("nl.moboa.myclay:id/button");
    public static By backButton = By.id("nl.moboa.myclay:id/back_button");
    public static By username = By.id("nl.moboa.myclay:id/user_fullname");
    public static By actionFilter = By.id("nl.moboa.myclay:id/action_filter");
    public static By blockedFilter = By.xpath("//android.widget.LinearLayout[@content-desc=\"filter_blocked\"]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView");
    public static By withAccessFilter = By.xpath("//android.widget.LinearLayout[@content-desc=\"filter_access\"]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView");


    public void BlockUser() throws InterruptedException {
        WebDriverWaits.waitUntilElementVisible(peopleOption);
        CommonFunctions.clickFunction(peopleOption);
        CommonFunctions.clickFunction(firstPerson);
        WebDriverWaits.waitUntilElementVisible(username);
        MobileElement userNameText = WebDriverFactory.getDriver().findElement(username);
        String userName = userNameText.getText();
        CommonFunctions.clickFunction(blockUnblockButton);

        MobileElement buttonText = WebDriverFactory.getDriver().findElement(blockUnblockButton);
        String actualTitle = buttonText.getText();

        CommonFunctions.clickFunction(backButton);
        CommonFunctions.clickFunction(actionFilter);
        CommonFunctions.clickFunction(blockedFilter);
        CommonAssertions.logVerifyStringEqual(actualTitle, "UNBLOCK", "User has been blocked");
    }

    public void UnblockUser() throws InterruptedException {
        CommonFunctions.clickFunction(peopleOption);
        CommonFunctions.clickFunction(firstPerson);
        WebDriverWaits.waitUntilElementVisible(username);
        MobileElement userNameText = WebDriverFactory.getDriver().findElement(username);
        String userName = userNameText.getText();
        CommonFunctions.clickFunction(blockUnblockButton);

        MobileElement buttonText = WebDriverFactory.getDriver().findElement(blockUnblockButton);
        String actualTitle = buttonText.getText();

        CommonFunctions.clickFunction(backButton);
        CommonFunctions.clickFunction(actionFilter);
        CommonFunctions.clickFunction(withAccessFilter);
        CommonAssertions.logVerifyStringEqual(actualTitle, "BLOCK", "User has been unblocked");

    }
}


