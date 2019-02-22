package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import utils.Driver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GoogleMainPageSteps {
    private Driver driver;

    public GoogleMainPageSteps(Driver driver){
        this.driver = driver;
    }

    @Given("^I navigated to (.*?) main page$")
    public void iNavigatedToGoogleMainPage(String site){
        String url = null;
        switch (site){
            case "Google": url = "https://google.com";
            break;
            case "Delfi": url = "https:/rus.delfi.lv";
            break;
        }
        driver.getDriver().navigate().to(url);
    }

    @Then("^I see that title should be (.*?)$")
    public void seeThatTitleShouldBe(String titleExpected){
        var titleActual = driver.getDriver().getTitle();

        assertEquals(titleExpected, titleActual);
    }
}
