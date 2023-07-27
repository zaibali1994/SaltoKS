package testcases;

import com.testinium.deviceinformation.exception.DeviceNotFoundException;
import general.BaseTest;
import general.MainCall;
import org.testng.annotations.Test;

import java.io.IOException;


public class PeopleTest extends BaseTest {

    @Test
    public static void verifyUserIsableBlockAndUnblockPeople() throws DeviceNotFoundException, IOException, InterruptedException {

        MainCall.peopleView.BlockUser();
        MainCall.peopleView.UnblockUser();
    }

}
