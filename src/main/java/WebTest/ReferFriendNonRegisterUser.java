package WebTest;

import org.openqa.selenium.By;

public class ReferFriendNonRegisterUser extends Utils
{
    private By _emailAFriend = By.xpath( "/html/body/div[6]/div[3]/div[2]/div/div/div/form/div/div[1]/div[2]/div[9]/div[3]/input" );
    private By _friendEmail = By.className("friend-email");
    private By _yourEmail = By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[1]/div/div[2]/input");
    private By _textBox = By.xpath("//*[@id='PersonalMessage']");
    private By _sendEmail = By.name("send-email");
    private String friendEmail = "jbond@gmail.com";
    private String yourEmail = "pbk@gmal.com";
    private String message = "This is best product";
    String expectedError = "Only registered customers can use email a friend feature";
    private By _emailErrorMessage = org.openqa.selenium.By.xpath("//div[contains(@class,'message-error')]/ul/li");

    public void emailAFriendNonRegUserDetails()
    {
        clickOnElement( _emailAFriend );
        sleep( 2 );
        enterText(_friendEmail,friendEmail);
        sleep( 2 );
        enterText(_yourEmail,yourEmail);
        enterText(_textBox,message);
        scrollAndClick(_sendEmail);
    }
    public void verifyUserSeeErrorMessage()
    {
        assertTextMessage("Your message not display",expectedError,_emailErrorMessage);
    }

}
