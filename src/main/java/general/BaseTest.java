package general;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.testinium.deviceinformation.exception.DeviceNotFoundException;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;



public class BaseTest {

    static Date startTime = null;
    static Date endTime = null;
    static Integer passedCount = 0;
    static Integer failedCount = 0;
    static Integer skippedCount = 0;
    static ArrayList<String> automationSteps;
    static Integer beforeAddingStepsLength;
    static Integer afterAddingStepsLength;
    static Integer beforeAddingExpectedResultLength;
    static Integer afterAddingExpectedResultLength;
    static ArrayList<String> expectedResults;
    static ArrayList<File> screenShotCollection = new ArrayList<File>();

    private static ExtentTest logger;



    @BeforeSuite()
    public void startReport() throws MalformedURLException, IOException, DeviceNotFoundException, SQLException {


        MainCall.startReport();
        WebDriverFactory.startDriver();
        startTime = getTime();
        automationSteps = new ArrayList<String>();
        expectedResults=new ArrayList<String>();


;

    }

    @BeforeMethod()
    public void beforeTest(Method method)  {
        beforeAddingStepsLength=automationSteps.size();
        beforeAddingExpectedResultLength=expectedResults.size();
        System.out.println("before"+beforeAddingStepsLength);
        System.out.println("before"+beforeAddingExpectedResultLength);

        logger = MainCall.getExtentReport().startTest(method.getName(), "");
        logger.setStartedTime(getTime());



    }

    @AfterMethod()
    public void QuitDriver(ITestResult result, ITestContext ctx, Method method) throws IOException {

        afterAddingStepsLength=automationSteps.size();
        afterAddingExpectedResultLength=expectedResults.size();

        try
        {
            if (result.getStatus() == ITestResult.FAILURE) {
                failedCount++;
                logger.log(LogStatus.FAIL, "Test Case Failed reason is: " + result.getThrowable());
                logger.log(LogStatus.FAIL, logger.addScreenCapture(Screenshots.takeScreenshot(result.getMethod().getMethodName())));
                System.out.println("After Actual"+afterAddingStepsLength);
                System.out.println("After Expected"+afterAddingExpectedResultLength);
                screenShotCollection.add(Screenshots.screenShot);

            }
            else if (result.getStatus() == ITestResult.SKIP) {
                skippedCount++;
                logger.log(LogStatus.SKIP, "Test Case Skipped is: " + result.getName());
            }
            else {
                passedCount++;
                logger.log(LogStatus.PASS, result.getMethod().getMethodName() + " is Passed");

            }


            logger.setEndedTime(getTime());
            MainCall.getExtentReport().endTest(logger);
        }


        finally {

        }
    }

    private Date getTime()
    {
        Calendar calendar = Calendar.getInstance();
        return calendar.getTime();
    }

    @AfterSuite()
    public void endReport() throws Exception {
        WebDriverFactory.finishDriver();
        MainCall.getExtentReport().flush();
        MainCall.getExtentReport().close();
    }
}
