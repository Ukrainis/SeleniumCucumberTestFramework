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
        System.setProperty("webdriver.chrome.driver", "D:\\Soft\\selenium-drivers\\chromedriver.exe");
        System.out.println("Starting driver.");
        var browserName = "chrome";
        switch (browserName.toLowerCase()){
            case "chrome":
                System.out.println("Starting chrome");
                driver = new ChromeDriver();
                System.out.println("Before break.");
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
        return new WebDriverWait(driver, 120);
    }

    public void terminateDriver(){
        System.out.println("Terminating driver.");
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }
}
