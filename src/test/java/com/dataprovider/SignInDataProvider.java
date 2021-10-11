package com.dataprovider;

import com.shoppingcart.utilities.StringFunctions;
import org.testng.annotations.DataProvider;

public class SignInDataProvider {

    @DataProvider(name = "login")
    public Object[][] signIn(){
        return new Object[][]{
                {"mathias.martinez@inei.gob.pe", "123456"}
        };
    }

}
