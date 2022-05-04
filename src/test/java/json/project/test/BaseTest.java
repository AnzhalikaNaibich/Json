package json.project.test;
import json.framework.browser.Browser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;
import utils.ConfigFileReader;

public class BaseTest {
    private ConfigFileReader config = ConfigFileReader.configFileReader;

    @BeforeClass
    public void before(){
        System.setProperty(config.getDriverAdapter(), config.getDriverPath());
        WebDriver driver = Browser.BROWSER.getDriver();
                driver.manage().timeouts().implicitlyWait(15,
                TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
}
