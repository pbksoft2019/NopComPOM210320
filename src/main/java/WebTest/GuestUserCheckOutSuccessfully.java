package WebTest;

import org.openqa.selenium.By;

public class GuestUserCheckOutSuccessfully extends Utils
{
    // locators and data for required fields
    //private By _AddToCart = By.xpath( "/html/body/div[6]/div[3]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div/div[2]/div[3]/div[2]/input[1]" );
    private By _AddToCart =By.id( "add-to-cart-button-37" );
    private By _ShoppingCart = By.className( "cart-label" );
    private By _CheckBox = By.id( "termsofservice" );
    private By _CheckOut = By.xpath( "//button[@type='submit']" );
    private By _CheckOutGuest =  By.xpath( "//input[@class='button-1 checkout-as-guest-button']" );
    private By _FirstNme = By.id("BillingNewAddress_FirstName");
    private By _LastName =By.id("BillingNewAddress_LastName");
    private By _EmailAddress = By.id("BillingNewAddress_Email");
    String expected ="Your order has been successfully processed!";
    private By _actual = By.xpath( "/html/body/div[6]/div[3]/div/div/div/div[2]/div/div[1]" );

    // method to add product in cart
    public void addToCart()
    {
        sleep( 3);
        clickOnElement( _AddToCart );
        sleep( 5 );
    }
    //  method to check out as a guest
    public void guestCheckOut()
    {   clickOnElement( _ShoppingCart );
        sleep( 2 );
        clickOnElement( _CheckBox );
        sleep( 2 );
        clickOnElement( _CheckOut );
        sleep( 2 );
        clickOnElement( _CheckOutGuest );
        sleep( 2 );
        enterText(_FirstNme,"pk");
        sleep( 2 );
        enterText( _LastName,"pk" );
        enterText( _EmailAddress, "pbk"+timeStamp()+"@gmail.com");
        dropDownValue( By.id( "BillingNewAddress_CountryId" ),"1" );
        dropDownValue( By.id( "BillingNewAddress_StateProvinceId" ),"53" );
        enterText( By.id( "BillingNewAddress_City" ), "london");
        enterText( By.id( "BillingNewAddress_Address1" ), "10 downing Street" );
        enterText(By.id( "BillingNewAddress_ZipPostalCode" ), "123456");
        enterText( By.id( "BillingNewAddress_PhoneNumber" ),"01234567890" );
        clickOnElement(By.xpath( "/html/body/div[6]/div[3]/div/div/div/div[2]/ol/li[1]/div[2]/div/input" ));
        clickOnElement( By.xpath( "/html/body/div[6]/div[3]/div/div/div/div[2]/ol/li[3]/div[2]/form/div[2]/input" ) );
        clickOnElement( By.id( "paymentmethod_1" ) );
        clickOnElement( By.xpath( "//*[@id=\"payment-method-buttons-container\"]/input" ) );
    }
    // method to see order placed verification message
    public void guestCheckOutSuccessVerify()
    {
        //String actual = getTextFromElement(_actual);
        assertTextMessage( "", expected, _actual );
    }

}
