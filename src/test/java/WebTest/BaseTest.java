package WebTest;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest extends Utils
{   // object created for browser selector class
    BrowserSelector browserSelector = new BrowserSelector();
    // method to run before test case
    @BeforeMethod
    public void openBrowser() {
        browserSelector.setUpBrowser();
    }

    // method to run after test case
    @AfterMethod
    public void takeScreenShot(ITestResult result)
    {
        if (!result.isSuccess())
        {
            takeScreenShot( result.getName() + timeStamp());
        }
        driver.quit();
    }
}

