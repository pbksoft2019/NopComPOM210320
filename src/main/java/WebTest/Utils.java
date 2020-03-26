package WebTest;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils extends BasePage
{
    // time stamp method
    public static String timeStamp()
    {
        DateFormat dateFormat = new SimpleDateFormat( "ddmmyyhhmmss" );
        Date date = new Date();
        return (dateFormat.format( date ));
    }
    // reusable method for click on element
    public static void clickOnElement(By by)
    {
        driver.findElement( by ).click();
    }
    // method for entering text input
    public void enterText(By by, String text)
    {
        driver.findElement( by ).sendKeys( text );
    }
    // method to get text from element
    public static String getTextFromElement(By by)
    {
        return driver.findElement( by ).getText();
    }
    // method to compare expected and actual text
    public static void assertTextMessage(String message, String expected, By by)
    {
        String actual = getTextFromElement( by );
        Assert.assertEquals( message, expected, actual );
    }
    // method to assert url
    public static void assertURL(String text) {
        Assert.assertTrue( driver.getCurrentUrl().contains( text ) );
    }
    // method for wait in between 2 action
    public static void sleep(int time)
    {
        try
        {
            Thread.sleep( time * 1000 );
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
    // method to wait for visibility of elements
    public void waitForVisibility(By by, int time)
    {
        WebDriverWait wait = new WebDriverWait( driver, time );
        wait.until( ExpectedConditions.visibilityOfElementLocated( by ) );
    }
    // method for scroll and click
    public static void scrollAndClick(By by)
    {
        WebElement element = driver.findElement( by );
        ((JavascriptExecutor) driver).executeScript( "arguments[0].scrollIntoView(true);", element );
        element.click();
    }
    // method to select from dropdown menu by visible text
    public void dropDrownVisibleText(By by, String text)
    {
        Select select = new Select( driver.findElement( by ) );
        select.selectByVisibleText( text );
    }
    // method to select from dropdown menu by value
    public void dropDownValue(By by,String text)
    { Select select = new Select(driver.findElement(by));
        select.selectByValue(text);
    }
    // method to select from dropdown menu by text
    public String dropDownGetSelectedText(By by)
    {
        Select select = new Select(driver.findElement(by));
        return select.getFirstSelectedOption().getText();
    }
    // method to take screenshot
    public void takeScreenShot(String fileName)
    {
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs( OutputType.FILE );
        try
        {
            FileUtils.copyFile( srcFile,new File(  "src/test/Resources/ScreenShot/"+fileName+".jpg") );
        }
        catch (IOException e)
            {
                e.printStackTrace();
            }
    }
}
