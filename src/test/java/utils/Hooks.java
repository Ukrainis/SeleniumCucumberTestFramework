package utils;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
    private Driver driver;

    @Before
    public void setup(){
        System.out.println("In the Setup method.");
        driver = new Driver();
    }

    @After
    public void tearDown(){
        System.out.println("In the TearDown method.");
        driver.terminateDriver();
    }
}
