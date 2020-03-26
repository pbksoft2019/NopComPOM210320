package WebTest;

import org.openqa.selenium.By;

public class GuestUserComment extends Utils
{
    // locators and data for required field
    private By _ClickOnNews = By.xpath("/html/body/div[6]/div[4]/div[1]/div[2]/ul/li[2]/a" );
    private By _ClickDetails = By.xpath( "//a[contains(@href,'about')and(@class='read-more')]" );
    private By _EnterTitle = By.id( "AddNewComment_CommentTitle" );
    private By _EnterComment =By.id( "AddNewComment_CommentText" );
    private By _ClickOnNewComment =By.name( "add-comment" );
    private By _GetMessage =By.id( "result" );
    private String EnterTitle = "Very Good website";
    private String EnterComment = "thanks for providing practice website";
    private String expected = "News comment is successfully added.";

    // method to click on news button
    public void clickOnNews()
    {
        clickOnElement( _ClickOnNews );
        sleep( 2 );
        clickOnElement( _ClickDetails );
    }
    // method to enter title of comment
    public  void enterTitle()
    {
        sleep( 3 );
        enterText( _EnterTitle, EnterTitle );
    }
    // method to enter comment
    public void enterComment()
    {
        enterText( _EnterComment, EnterComment );
    }
    // method to click on submit new comment
    public void clickOnNewComment()
    {
        clickOnElement( _ClickOnNewComment );
    }
    //
    public void verifyUsersCommentIsAdded()
    {
    }
    // method to verify new comment has been added
    public  void userShouldSeeCommentAddedMessage()
    {
        getTextFromElement( _GetMessage );
        assertTextMessage( "News comment is successfully added.",expected, _GetMessage );
    }
}
