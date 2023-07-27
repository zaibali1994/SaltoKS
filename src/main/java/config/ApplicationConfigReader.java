package config;

import ru.qatools.properties.Property;
import ru.qatools.properties.PropertyLoader;
import ru.qatools.properties.Resource;

@Resource.Classpath("ApplicationConfig.properties")

public class ApplicationConfigReader {

    public ApplicationConfigReader() {
        PropertyLoader.newInstance().populate(this);
    }



    @Property(value = "deviceName")
    private String deviceName;

    @Property(value = "automationName")
    private String automationName;

    @Property(value = "ENV")
    private String Environment;

    @Property(value = "appPath")
    private String appPath;

    @Property(value = "appWaitActivity")
    private String appWaitActivity;

    @Property(value = "ProjectDescription")
    private String ProjectDescription;


    public String getDeviceName() {
        return deviceName;
    }

    public String getAutomationName() {
        return automationName;
    }

    public String getAppPath() {
        return appPath;
    }

    public String getAppWaitActivity() {
        return appWaitActivity;
    }
    public String getEnvironment() {
        return Environment;
    }

    public String getProjectDescription()
    {
        return ProjectDescription;
    }

}
