package pageobject.android;

import general.CommonAssertions;
import general.CommonFunctions;
import general.WebDriverFactory;
import general.WebDriverWaits;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class OnboardingView {
    public static By selectSiteTitle = By.id("nl.moboa.myclay:id/textView");

    public static By firstSite = By.xpath("//android.view.ViewGroup[@content-desc=\"site_0\"]");

    public static By nextButton = By.id("nl.moboa.myclay:id/positive_button");

    public static By passwordInputField = By.id("Password");

    public static By submitButton = By.id("SubmitButton");

    public void ValidateOnboardingScreenVisibility() throws InterruptedException {
        MobileElement modalTitle = WebDriverFactory.getDriver().findElement(selectSiteTitle);
        String actualTitle = modalTitle.getText();
        WebDriverWaits.waitUntilElementVisible(selectSiteTitle);
        CommonAssertions.logVerifyStringEqual(actualTitle, "You have access to 6 sites. Choose the one that you want to start with. You can always switch sites.", "Title found");

    }

    public void selectSite() throws InterruptedException {
        WebDriverWaits.visibilityOfElementLocated(firstSite);
        CommonFunctions.clickFunction(firstSite);
    }

    public void navigateToMainScreen() throws InterruptedException {
        WebDriverWaits.visibilityOfElementLocated(nextButton);
        for(int i=0;i<4; i++) {
            CommonFunctions.clickFunction(nextButton);
        }
    }
}



