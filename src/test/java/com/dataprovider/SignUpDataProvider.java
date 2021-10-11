package com.dataprovider;

import com.shoppingcart.utilities.StringFunctions;
import org.testng.annotations.DataProvider;

public class SignUpDataProvider {

    int n= 15;

    @DataProvider(name = "email verification")
    public Object[][] emailVerification(){
        return new Object[][]{
                {StringFunctions.randomEmail(n)}
        };
    }

    @DataProvider(name = "valid data")
    public Object[][] validData(){
        return new Object[][]{
                {"Mathias", "Martinez", "123456", "OKTANA", "Nueva York 123 NY", "Nueva Jersey" , "01234", "999999999", "Toms River"}
        };
    }
}
