package szaq.testng.samples;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by pmalczyk on 3/13/14.
 */
public class DataProviderTest {

    @DataProvider(name = "test1")
    public Object[][] createData21() {
        return new Object[][] {
                { "Cedric", new Integer(36) },
                { "Anne", new Integer(37)},
        };
    }


    @Test(dataProvider = "test1", groups = {"willRun"})
    public void verifyData1(String n1, Integer n2) {
        System.out.println(n1 + " " + n2);
    }

}
