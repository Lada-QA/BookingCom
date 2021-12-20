package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;

public class BookingFiltersSteps {
    public static final String EMPTY_ZONE ="//*[@class='_30227359d _0db903e42']";
    public static final String CHECKBOX_HEALTH_AND_SAFETY = "//*[@data-filters-item='health_and_hygiene:health_and_hygiene=1']";
    public static final String CHECKBOX_POPULAR_FILTERS = "//*[@data-filters-item='popular:ht_id=204']";
    public static final String CHECKBOX_NUMBER_OF_STARS = "//*[@data-filters-item='class:class=5']";
    public static final String HOTEL_ON_PAGE = "//*[@class='_12369ea61']";

    @Then("User choose criteria for hotel")
    public void userChooseCriteriaForHotel() {
        $(By.xpath(EMPTY_ZONE)).click();
        $(By.xpath(CHECKBOX_HEALTH_AND_SAFETY)).click();
        $(By.xpath(CHECKBOX_POPULAR_FILTERS)).click();
        $(By.xpath(CHECKBOX_NUMBER_OF_STARS)).click();
        Assert.assertTrue($(By.xpath(HOTEL_ON_PAGE)).isDisplayed());
    }
}
