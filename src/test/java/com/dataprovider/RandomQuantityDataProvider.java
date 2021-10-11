package com.dataprovider;

import com.pageobjects.ShoppingDetailPage;
import com.shoppingcart.utilities.RandomQuantity;
import org.testng.annotations.DataProvider;

public class RandomQuantityDataProvider {

    @DataProvider(name = "randomQuantity")
    public Object[][] setRandomQuantity(){
        return new Object[][]{
                {RandomQuantity.setRandomQuantity()}
        };
    }
}
