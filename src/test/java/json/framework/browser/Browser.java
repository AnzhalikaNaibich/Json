package json.framework.browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import utils.ConfigFileReader;

public class Browser {
    private static WebDriver driver;
    private static ConfigFileReader config = ConfigFileReader.configFileReader;
    public static Browser BROWSER = new Browser();


    public Browser() {
        this.driver = BrowserFactory.getDriver(config.getNameBrowser());
    }

    public void goTo(String url) {
        this.driver.get(url);
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    public WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    public List<WebElement> findElements(By locator) {
        return driver.findElements(locator);
    }

}
