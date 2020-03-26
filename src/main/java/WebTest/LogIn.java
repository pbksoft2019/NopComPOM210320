package WebTest;

import org.openqa.selenium.By;

public class LogIn extends Utils
{
    // locators and data for required fields
    private By _logIn =By.className( "ico-login" );
    private By _yourEmail = By.id( "Email" );
    private By _enterPassword = org.openqa.selenium.By.id( "Password" );
    private String yourEmail = "pbk@gmail.com";
    private String password = "abc123";
    // method to click on log in button
    public void clickOnLogIn()
    {
        clickOnElement( _logIn);
    }
    // method to enter log in details
    public void enterLoginDetails()
    {
        sleep( 3 );
        enterText( _yourEmail, yourEmail );
        enterText( _enterPassword, password );
        clickOnElement( By.xpath( "/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[3]/input" ) );
    }
}
