package ui.framework.data;

import org.testng.annotations.DataProvider;

import java.util.Iterator;

public class ContactSalesProvider {

    @DataProvider
    public Iterator<Object[]> contactSalesProvider(){
        return ExcelData.getDataFromSheet("ContactSales",true);
    }
}
