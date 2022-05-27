package ui.framework.data;

import org.testng.annotations.DataProvider;

import java.util.Iterator;

public class ArbitProvider {

    @DataProvider
    public Iterator<Object[]> arbit(){
        return ExcelData.getDataFromSheet("Arbit",false);
    }

}
