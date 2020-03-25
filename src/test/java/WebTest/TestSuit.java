package WebTest;

import org.testng.annotations.Test;

public class TestSuit extends BaseTest
{
    HomePage homePage = new HomePage();
    RegistrationPage registrationPage = new RegistrationPage();
    RegistrationResultPage registrationResultPage = new RegistrationResultPage();
    CompareTwoProducts compareTwoProducts = new CompareTwoProducts();
    ReferFriendRegisterUser referFriendRegisterUser = new ReferFriendRegisterUser();
    LogIn logIn = new LogIn();
    ReferFriendNonRegisterUser referFriendNonRegisterUser = new ReferFriendNonRegisterUser();
    ShortPriceHighToLow shortPriceHighToLow = new ShortPriceHighToLow();
    GuestUserCheckOutSuccessfully guestUserCheckOutSuccessfully = new GuestUserCheckOutSuccessfully();
    PaymentPage paymentPage = new PaymentPage();
    GuestUserComment guestUserComment = new GuestUserComment();
    ChangeCurrency changeCurrency = new ChangeCurrency();
    AddToCartButtonPresentConfirmation addToCartButtonPresentConfirmation = new AddToCartButtonPresentConfirmation();


    @Test
    public void UserShouldBeAbleToRegisterSuccessfully()
    {
        homePage.clickOnRegisterButton();
        homePage.verifyUserIsOnRegisterPage();
        //takeScreenShot( "sample" );
        registrationPage.userEnterRegistrationDetails();
        registrationResultPage.verifyUserSeeRegistrationSuccessMessage();
    }

    @Test
    public void UserShouldBeAbleToCompareTwoProducts()
    {
        compareTwoProducts.selectProductsToCompare();
    }

    @Test
    public void registerUserShouldBeAbleToReferProductToFriend()
    {
        logIn.clickOnLogIn();
        logIn.enterLoginDetails();
        homePage.clickOnBookCategory();
        takeScreenShot( "sample" );
        referFriendRegisterUser.clickOnBook();
        referFriendRegisterUser.emailAFriendDetails();
        referFriendRegisterUser.verifyUserSeeSuccessMessageOfEmailAFriend();
    }

    @Test
    public void nonRegisterUserShouldNotBeAbleToReferProductToFriend()
    {
        homePage.clickOnBookCategory();
        referFriendRegisterUser.clickOnBook();
        referFriendNonRegisterUser.emailAFriendNonRegUserDetails();
        referFriendNonRegisterUser.verifyUserSeeErrorMessage();
    }

    @Test
    public void userShouldBeAbleToShortPriceHighToLow()
    {
        homePage.clickOnBookCategory();
        shortPriceHighToLow.userSelectFRomPositionPriceHighToLow();
        shortPriceHighToLow.verifyUserShouldBeAbleToSeePriceHighToLow();
    }

    @Test
    public void guestUserShouldBeAbleToCheckOutSuccessfully()
    {
        homePage.clickOnBookCategory();
        referFriendRegisterUser.clickOnBook();
        guestUserCheckOutSuccessfully.addToCart();
        guestUserCheckOutSuccessfully.guestCheckOut();
        paymentPage.paymentInstruction();
        guestUserCheckOutSuccessfully.guestCheckOutSuccessVerify();
    }

    @Test
    public void guestUserCanAddNewComment()
    {
        guestUserComment.clickOnNews();
        guestUserComment.enterTitle();
        guestUserComment.enterComment();
        guestUserComment.clickOnNewComment();
        guestUserComment.verifyUsersCommentIsAdded();
        guestUserComment.userShouldSeeCommentAddedMessage();
    }

    @Test
    public void userShouldBeAbleToChangeCurrency()
    {
        changeCurrency.selectCurrencyFromDropDown();
        changeCurrency.verifyingCurrencySymbolPresent();
    }

    @Test
    public void addToCartButtonPresentOnFeaturedProduct() throws InterruptedException
    {
        addToCartButtonPresentConfirmation.verifyAddToCartButtonPresentInEachItem();
        addToCartButtonPresentConfirmation.verifyAddToCartButtonPresent();
    }



}
