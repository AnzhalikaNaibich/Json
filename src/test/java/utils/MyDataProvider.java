package utils;
import org.testng.annotations.DataProvider;

public class MyDataProvider {
    @DataProvider(name = "data")
    public static Object[][] getInvalidData () {
        return new Object[][] {
                {null},
                {""},
                {" "},
                {"0"}
        };
    }
}
