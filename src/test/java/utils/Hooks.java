package utils;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
    private Driver driver;

    public Hooks(Driver driver){
        this.driver = driver;
    }

    @Before
    public void setup(Scenario scenario){
        System.out.println("In the Setup method.");
        System.out.println("Scenario name: " + scenario.getName());
        scenario.getSourceTagNames().forEach(tag -> System.out.println(tag));
    }

    @After
    public void tearDown(Scenario scenario){
        System.out.println("In the TearDown method.");
        System.out.println("Status: " + scenario.getStatus());
        driver.terminateDriver();
    }
}
