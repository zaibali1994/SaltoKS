ApplicationConfig.properties file :
In this file you need to define your own credentials like platformName, APK path etc.

You don't need to define the device name , it will be capture automatically once your device connected with laptop. All you need is to install ADB in your laptop
once done then check the command : adb devices 
It will return the connected devices name.


Framework is written to help android for test cases automation , create your objects in pageobject.android package. 

log4j.xml has been used to maintain the logging of the actions during execution and these actions will be defined in test object classes like "CommonAssertion.actualResult" and "CommonAssertion.expectedResult". Don't forget to add the actual and expected steps in object class.

Common assertion class has all the common assertions that can be used during test automation

Common Function is the collection of common functions related to mobile apps like scroll , tap , touch , swipe

Generic functions will have generic functions related to automation like get current date etc



#
###### Pre-requisites (Windows):

1) Java JDK should be installed by using the following commands:

2) Verify that the java has been installed
    
3) JAVA_HOME environment variable should be set

4) Verify that the variable is set
    
5) Android Studio should be installed

6) ANDROID_HOME environment variable should be set 

8) Maven should be installed

8) To verify the installation, run
    - `mvn -version`
7) Maven_Home variable should be set
  
- Restart the system after completing the above steps

#
###### Steps to setup:

1) Download _Android Studio_ and setup a **virtual device** or use real physical device
   - https://developer.android.com/studio/run/managing-avds


2) Download Nodejs and npm

    
3) Install Appium
   

4) Appium is installed in your system, Now let us use the below command in terminal to start the Appium server
   - `appium`
   

5) Install Appium Desktop



7) After allowing, double-click on the app. This will start the installation process. Once complete double-click on the appium icon


8) Clone repo: https://github.com/zaibali1994/SaltoKS.git

    - On Bitbucket.com, navigate to the main page of the repository.
    - To clone your repository, click on the copy icon
    - Go to the location where you want to clone the repository
    - Make a folder and open it.
    - Right click and open Terminal in that folder
    - Type git clone, and then paste the URL you copied earlier.
    - $ git clone https://github.com/YOUR-USERNAME/YOUR-REPOSITORY
    - Press Enter to create your local clone.


9) Create your own branch
    - Click on Branches Tab in Bitbucket
    - Click on Create branch
    - Type your branch name and click on create


10) Open project on IntelliJ
- Open terminal and run command.
    - mvn clean test
    - git pull
- Checkout your created branch
    - git checkout origin/yourbranchname

11) Start _Appium Server_ (Appium Image) which you installed.


12) Start the Server


13) Click on _**Start Inspector Session**_ denoted with a Search icon and _Edit_ the _Json Representation_ section to add the following Json. 

{
  "platformName": "Android",
  "appium:app": "PATH TO APK",
  "appium:automationName": "UIAutomator2",
  "appium:deviceName": "YOUR DEVICE NAME",
  "appium:platformVersion": "YOUR DEVICE OS VERSION",
  "appium:noReset": true,
  "appium:appWaitActivity": "*"
}`


14)  Click on _Start Session_.


########## Test APK #########

SaltoKS APK has been shared separately due size issue. You will have to place APK file in APK folder available in directory and don't need to change the app path for the APK.
