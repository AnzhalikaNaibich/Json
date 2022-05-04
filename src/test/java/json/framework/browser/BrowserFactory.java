package json.framework.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.ConfigFileReader;

public class BrowserFactory {
    private static ConfigFileReader config = ConfigFileReader.configFileReader;

    public static WebDriver getDriver(String nameBrowser) {
        System.setProperty(config.getDriverAdapter(), config.getDriverPath());
        WebDriver driver;
        if (nameBrowser.equalsIgnoreCase("ChromeDriver")) {
            driver = new ChromeDriver();
        } else if (nameBrowser.equalsIgnoreCase("FireFoxDriver")) {
            driver = new FirefoxDriver();
        } else {
            throw new RuntimeException("Invalid browser name");
        }
        return driver;
    }
}
