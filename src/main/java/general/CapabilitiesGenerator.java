package general;

import com.google.common.collect.ImmutableMap;
import config.ConfigProperties;
import com.testinium.deviceinformation.DeviceInfo;
import com.testinium.deviceinformation.DeviceInfoImpl;
import com.testinium.deviceinformation.device.DeviceType;
import com.testinium.deviceinformation.exception.DeviceNotFoundException;
import com.testinium.deviceinformation.model.Device;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;

public class CapabilitiesGenerator {
    public static String versionName;


    public static Device defineDeviceVariable() throws DeviceNotFoundException, IOException  //Define the type of device and its version
    {
        DeviceInfo deviceInfo = new DeviceInfoImpl(DeviceType.ANDROID);   // if IOs device then select io
        Device device = null;
        if (deviceInfo.anyDeviceConnected()) {
            device = deviceInfo.getFirstDevice();  // because we are doing single device execution
        }

        return device;
    }


    public static DesiredCapabilities getCapabilities() throws DeviceNotFoundException, IOException {
        DesiredCapabilities capabilities = new DesiredCapabilities();


        Device device=defineDeviceVariable();


        capabilities.setCapability("platformName", device.getDeviceProductName());
        capabilities.setCapability(CapabilityType.VERSION, device.getProductVersion());
        capabilities.setCapability("deviceName", device.getModelNumber());
        capabilities.setCapability("app", ConfigProperties.appPath);
        capabilities.setCapability("chromeOptions", ImmutableMap.of("w3c", false));
        capabilities.setCapability("automationName", ConfigProperties.automationName);
        capabilities.setCapability("noReset", true);
        capabilities.setCapability("autoGrantPermissions", "true");
        capabilities.setCapability("autoAcceptAlerts", "true");
        capabilities.setCapability("appWaitActivity", ConfigProperties.appWaitActivity);
        capabilities.setCapability("setWebContentsDebuggingEnabled", true);

        return capabilities;
    }

    public static String getVersion() throws DeviceNotFoundException, IOException //device platform i.e ios or android will be used to detremine the execution on the platform

    {
        Device device = defineDeviceVariable();
        versionName = device.getDeviceProductName();
        System.out.println(versionName);
        return versionName;

    }

}
