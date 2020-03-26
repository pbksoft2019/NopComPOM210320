package WebTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class ChangeCurrency extends Utils
{
    // object created for LoadProp Class
    LoadProp loadProp = new LoadProp();
    // locator for Currency menu
    private By _currencyDropDrownMenuField = By.id("customerCurrency");

    // method to change currency
    public void selectCurrencyFromDropDown(){
        dropDrownVisibleText(_currencyDropDrownMenuField,loadProp.getProperty("changeToCurrency"));
    }
    // method to find out which currency symbol is present
    public void verifyingCurrencySymbolPresent()
    {
        String selectedCurrencyName = dropDownGetSelectedText(_currencyDropDrownMenuField);
        String currencySymbol =getCurrencySymbolFromCurrencyName(selectedCurrencyName);
        System.out.println("Currently selected currency symbol is : "+currencySymbol);
        List<WebElement> listOfPriceElements = driver.findElements(By.xpath("//span[@class='price actual-price']"));
        for (WebElement element : listOfPriceElements ) ;
    }
    // method to get currency symbol from currency name
    public String getCurrencySymbolFromCurrencyName(String currencyName)
    {
        switch (currencyName){
            case "US Dollar":
                return "$";
            case "Euro":
                return "Ђ";
            default:
                return "Invalid Currency name";
        }
    }
}
