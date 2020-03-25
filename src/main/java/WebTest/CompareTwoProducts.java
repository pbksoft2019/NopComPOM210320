package WebTest;

import org.openqa.selenium.By;

public class CompareTwoProducts extends Utils
{
    private By _category = org.openqa.selenium.By.linkText( "Books" );
    private By _fahrenheit451 = org.openqa.selenium.By.xpath( "//input[@onclick='return AjaxCart.addproducttocomparelist(\"/compareproducts/add/37\"),!1']" );
    private By _firstprizepies = org.openqa.selenium.By.xpath( "//input[@onclick='return AjaxCart.addproducttocomparelist(\"/compareproducts/add/38\"),!1']" );
    private By _compare = org.openqa.selenium.By.linkText( "product comparison" );

    public void selectProductsToCompare() {

        sleep( 5 );

        //click on Book category
        clickOnElement(_category);
        sleep( 5 );

        // Click on Add to Compare for product Fahrenheit 451 by Ray Bradbury
        clickOnElement(_fahrenheit451);
        //waitForClickable(_fahrenheit451,10);
        sleep( 5 );

        //click on Book category
        //clickOnElement(_category);

        //Click on Add to Compare for product First Prize Pies
        clickOnElement(_firstprizepies);
        //waitForClickable(_firstprizepies,10);
        sleep( 5 );

        waitForVisibility(_compare,2);

        // Click on Product comparision on Popup Bar
        clickOnElement(_compare);
    }
}
