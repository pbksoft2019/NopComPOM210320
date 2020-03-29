package WebTest;

import org.testng.annotations.Test;

public class TestSuit extends BaseTest
{
    // object created for all required classes to use methods
    HomePage homePage = new HomePage();
    RegistrationPage registrationPage = new RegistrationPage();
    RegistrationResultPage registrationResultPage = new RegistrationResultPage();
    CompareTwoProducts compareTwoProducts = new CompareTwoProducts();
    ReferFriendRegisterUser referFriendRegisterUser = new ReferFriendRegisterUser();
    LogIn logIn = new LogIn();
    ReferFriendNonRegisterUser referFriendNonRegisterUser = new ReferFriendNonRegisterUser();
    SortPriceHighToLow shortPriceHighToLow = new SortPriceHighToLow();
    GuestUserCheckOutSuccessfully guestUserCheckOutSuccessfully = new GuestUserCheckOutSuccessfully();
    PaymentPage paymentPage = new PaymentPage();
    GuestUserComment guestUserComment = new GuestUserComment();
    ChangeCurrency changeCurrency = new ChangeCurrency();
    AddToCartButtonPresentConfirmation addToCartButtonPresentConfirmation = new AddToCartButtonPresentConfirmation();

    // registration method
    @Test
    public void UserShouldBeAbleToRegisterSuccessfully()
    {
        homePage.clickOnRegisterButton();
        homePage.verifyUserIsOnRegisterPage();
        //takeScreenShot( "sample" );
        registrationPage.userEnterRegistrationDetails();
        registrationResultPage.verifyUserSeeRegistrationSuccessMessage();
    }

    // method to compare two products
    @Test
    public void UserShouldBeAbleToCompareTwoProducts()
    {
        compareTwoProducts.selectProductsToCompare();
    }

    // method to refer products to friend as a registered user
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

    // method to check that non registered user can not refer product to friend
    @Test
    public void nonRegisterUserShouldNotBeAbleToReferProductToFriend()
    {
        homePage.clickOnBookCategory();
        referFriendRegisterUser.clickOnBook();
        referFriendNonRegisterUser.emailAFriendNonRegUserDetails();
        referFriendNonRegisterUser.verifyUserSeeErrorMessage();
    }

    // method to sort price high to low
    @Test
    public void userShouldBeAbleToSortPriceHighToLow()
    {
        homePage.clickOnBookCategory();
        shortPriceHighToLow.userSelectFRomPositionPriceHighToLow();
        shortPriceHighToLow.verifyUserShouldBeAbleToSeePriceHighToLow();
    }

    // method to check that guest user can check out successfully
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

    // method to check that guest user can leave comment on news
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

    // method to check that user is able to change currency
    @Test
    public void userShouldBeAbleToChangeCurrency()
    {
        changeCurrency.selectCurrencyFromDropDown();
        changeCurrency.verifyingCurrencySymbolPresent();
    }

    // method to check add to cart button is present on all product
    @Test
    public void addToCartButtonPresentOnFeaturedProduct() throws InterruptedException
    {
        addToCartButtonPresentConfirmation.verifyAddToCartButtonPresentInEachItem();
        addToCartButtonPresentConfirmation.verifyAddToCartButtonPresent();
    }
}
