package testcases;

import com.testinium.deviceinformation.exception.DeviceNotFoundException;
import general.BaseTest;
import general.MainCall;
import org.testng.annotations.Test;

import java.io.IOException;


public class LogOutTest extends BaseTest {

    @Test
    public static void verifyUserIsableToLogOutSuccessfully() throws DeviceNotFoundException, IOException, InterruptedException {

        MainCall.logOutView.PerformLogoutOperation();
    }

}
