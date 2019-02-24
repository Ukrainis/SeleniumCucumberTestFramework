package utils;

import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Driver {
    private WebDriver driver;

    public Driver(){
        driverInitialization();
    }

    private void driverInitialization(){
        var browserName = PropertiesUtils.getPropertyValueByKey("browser");
        System.out.format("Starting driver: %s. \n", browserName);
        switch (browserName.toLowerCase()){
            case "chrome":
                setPropertyForChromeDriver();
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            default:
                throw new NotFoundException("Browser not found: " + browserName);
        }
    }

    public WebDriver getDriver(){
        return driver;
    }

    public WebDriverWait getWebDriverWait(){
        return new WebDriverWait(driver, 60);
    }

    private void setPropertyForChromeDriver(){
        var chromeDriver = PropertiesUtils.getPropertyValueByKey("chromedriver");
        System.out.println(String.format("Driver place: %s", chromeDriver));
        System.setProperty("webdriver.chrome.driver", chromeDriver);
    }

    public void terminateDriver(){
        System.out.println("Terminating driver.");
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }
}
