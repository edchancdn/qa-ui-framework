package ui.framework.data;

import org.testng.annotations.DataProvider;

import java.util.Iterator;

public class LoginProvider {

    @DataProvider
    public Iterator<Object[]> loginProvider(){
        return ExcelData.getDataFromSheet("SignIn",true);
    }

}
