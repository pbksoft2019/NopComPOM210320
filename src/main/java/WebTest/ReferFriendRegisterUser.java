package WebTest;

import org.openqa.selenium.By;

public class ReferFriendRegisterUser extends Utils
{
    private By _fahrenheit451 = By.xpath( "/html/body/div[6]/div[3]/div[2]/div[2]/div/div[2]/div[3]/div/div[1]/div/div[1]/a/img" ) ;
    private By _emailAFriend = By.xpath( "/html/body/div[6]/div[3]/div[2]/div/div/div/form/div/div[1]/div[2]/div[9]/div[3]/input" );
    private By _friendEmail = By.className("friend-email");
    private By _yourEmail = By.className("your-email.valid");
    private By _textBox = By.xpath("//*[@id='PersonalMessage']");
    private By _sendEmail = By.name("send-email");
    private By _enterPassword = By.id( "Password" );
    private String friendEmail = "jbond@gmail.com";
    private String yourEmail = "pbk@gmail.com";
    private String message = "This is best product";
    String expected = "Your message has been sent.";
    //private By _emailSuccessMessage = org.openqa.selenium.By.xpath("//div[@class='result']");
    private By _emailSuccessMessage = By.className("result");
    String expectedError = "Only registered customers can use email a friend feature";
    private By _emailErrorMessage = org.openqa.selenium.By.xpath("//div[contains(@class,'message-error')]/ul/li");

    public  void verifyUserOnEmailAFriendPage()
    {
        assertURL("productemailafriend");
    }
    public void clickOnBook()
    {
        clickOnElement( _fahrenheit451 );
    }

    public void emailAFriendDetails()

    {
        clickOnElement( _emailAFriend );
        enterText(_friendEmail,friendEmail);
        //enterText(_yourEmail,yourEmail);
        enterText(_textBox,message);
        scrollAndClick(_sendEmail);

    }
    public void verifyUserSeeSuccessMessageOfEmailAFriend()
    {
        assertTextMessage("Your message has NOT been sent",expected,_emailSuccessMessage);
    }

    public void verifyUserSeeErrorMessage()
    {
        assertTextMessage("Your message not display",expected,_emailErrorMessage);
    }
}
