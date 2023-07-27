package config;


public class ConfigProperties {

    public static ApplicationConfigReader appConfig = new ApplicationConfigReader();

    public static String deviceName = appConfig.getDeviceName();
    public static String automationName = appConfig.getAutomationName();
    public static String appPath = System.getProperty("user.dir") +appConfig.getAppPath();

    public static String appWaitActivity = appConfig.getAppWaitActivity();


    public static String Environment = appConfig.getEnvironment();


}
