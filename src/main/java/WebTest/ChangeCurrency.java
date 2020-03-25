package WebTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ChangeCurrency extends Utils
{
    LoadProp loadProp = new LoadProp();
    private By _currencyDropDrownMenuField = By.id("customerCurrency");


    public void selectCurrencyFromDropDown(){
        dropDrownVisibleText(_currencyDropDrownMenuField,loadProp.getProperty("changeToCurrency"));
    }

    public void verifyingCurrencySymbolPresent()
    {
        String selectedCurrencyName = dropDownGetSelectedText(_currencyDropDrownMenuField);
        String currencySymbol =getCurrencySymbolFromCurrencyName(selectedCurrencyName);
        System.out.println("Currently selected currency symbol is : "+currencySymbol);
        List<WebElement> listOfPriceElements = driver.findElements(By.xpath("//span[@class='price actual-price']"));
        for (WebElement element : listOfPriceElements ) ;
    }

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
