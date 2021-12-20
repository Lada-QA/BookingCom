package steps;

import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.*;

public class BookingSteps {
    String city;

    @Given("User is looking for hotels in {string} city")
    public void userIsLookingForHotelsInCity(String city) {
        this.city = city;
    }

    @When("User does search")
    public void userDoesSearch() {
        open("https://www.booking.com/");
        $(By.id("ss")).sendKeys(city);
        $(".sb-searchbox__button").click();
    }

    @Then("Hotel {string} should be on the first page")
    public void hotelHamptonByHiltonMinskCityCentreShouldBeOnTheFirstPage(String hotel) {
        ArrayList<String> hotelsNames = new ArrayList<>();
        for(SelenideElement element : $$(By.xpath("//*[@data-testid='title']"))){
            hotelsNames.add(element.getText());
        }
        Assert.assertTrue(hotelsNames.contains(hotel));
    }

    @Then("Hotel {string} should be {string}")
    public void hotelHotelShouldBeRating(String hotel, String rating) {
        ArrayList<String> ratingHotels = new ArrayList<>();
        for(SelenideElement element : $$(By.xpath(String.format("//*[@data-testid='review-score']/div", hotel)))){
            ratingHotels.add(element.getText());
        }
        Assert.assertTrue(ratingHotels.contains(rating));
    }
}