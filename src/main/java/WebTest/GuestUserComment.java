package WebTest;

import org.openqa.selenium.By;

public class GuestUserComment extends Utils
{
    private By _ClickOnNews = By.xpath("/html/body/div[6]/div[4]/div[1]/div[2]/ul/li[2]/a" );
    private By _ClickDetails = By.xpath( "//a[contains(@href,'about')and(@class='read-more')]" );
    private By _EnterTitle = By.id( "AddNewComment_CommentTitle" );
    private By _EnterComment =By.id( "AddNewComment_CommentText" );
    private By _ClickOnNewComment =By.name( "add-comment" );
    private By _GetMesssage =By.id( "result" );
    private String EnterTitle = "Very Good website";
    private String EnterComment = "thanks for providing practice website";
    private String expected = "News comment is successfully added.";


    public void clickOnNews()
    {
        clickOnElement( _ClickOnNews );
        sleep( 2 );
        clickOnElement( _ClickDetails );
    }
    public  void enterTitle()
    {
        sleep( 3 );
        enterText( _EnterTitle, EnterTitle );
    }
    public void enterComment()
    {
        enterText( _EnterComment, EnterComment );
    }
    public void clickOnNewComment()
    {
        clickOnElement( _ClickOnNewComment );
    }
    public void verifyUsersCommentIsAdded()
    {

    }
    public  void userShouldSeeCommentAddedMessage()
    {
        getTextFromElement( _GetMesssage );
        assertTextMessage( "cc","News comment is successfully added.", _GetMesssage );
    }
}
