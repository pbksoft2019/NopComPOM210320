package WebTest;

import org.openqa.selenium.By;

public class PaymentPage extends Utils
{
    @Override
    public void dropDownValue(By by, String text)
    {
        super.dropDownValue(by, text );
    }
    // locators for required fields
    private By _CardHolderName = By.id( ("CardholderName") );
    private By _CardNumber = By.id( "CardNumber" );
    // method to enter payment details
    public void paymentInstruction()
    {   dropDownValue( By.id("CreditCardType"), "MasterCard"  );
        enterText( _CardHolderName,"J bond" );
        enterText( _CardNumber,"5563 1234 5678 1234" );
        dropDownValue( By.id( "ExpireMonth" ), "4" );
        dropDownValue( By.id( "ExpireYear" ),"2020" );
        sleep( 3 );
        enterText( By.id("CardCode"),"123" );
        sleep( 3 );
        clickOnElement( By.xpath( "/html/body/div[6]/div[3]/div/div/div/div[2]/ol/li[5]/div[2]/div/input" ) );
        clickOnElement( By.xpath( "/html/body/div[6]/div[3]/div/div/div/div[2]/ol/li[6]/div[2]/div[2]/input" ) );
    }
}
