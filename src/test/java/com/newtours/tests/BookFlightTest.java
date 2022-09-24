package com.newtours.tests;
import com.newtours.pages.*;
import com.test.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BookFlightTest extends BaseTest {
    private String noOfPassengers;
    private String expectedPrice;

    @BeforeTest
    @Parameters({"noOfPassengers","expectedPrice"})
    public void setupParameter(String noOfPassengers, String expectedPrice){
        this.noOfPassengers = noOfPassengers;
        this.expectedPrice = expectedPrice;
    }

    @Test
    public void registrationPage(){
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.goToFlightApp();
        registrationPage.enterUserDetails("Selenium","Docker");
        registrationPage.enterUserCredentials("Selenium","Docker");
        registrationPage.submit();
    }

    @Test(dependsOnMethods = "registrationPage")
    public void registrationConfirmationPage(){
        RegistrationConfirmationPage registrationConfirmationPage = new RegistrationConfirmationPage(driver);
        registrationConfirmationPage.goToflightdetailsPage();
    }

    @Test(dependsOnMethods = "registrationConfirmationPage")
    public void flightDetailsPage(){
        FlightDetailsPage flightDetailsPage = new FlightDetailsPage(driver);
        flightDetailsPage.selectNumberofPassenegers(this.noOfPassengers);
        flightDetailsPage.goToFindFlights();
    }

    @Test(dependsOnMethods = "flightDetailsPage")
    public void findFlightPage(){
        FindFlightsPage findFlightsPage = new FindFlightsPage(driver);
        findFlightsPage.submitFinalFlightPage();
        findFlightsPage.goToflightConfirmationPage();
    }

    @Test(dependsOnMethods = "findFlightPage")
    public void flightConfirmationPage(){
        FlightConfirmationPage flightConfirmationPage = new FlightConfirmationPage(driver);
        String actualValue = flightConfirmationPage.getPrice().trim();
        Assert.assertTrue(actualValue.length()>0,"Verify the Amount After Final Flight Booking Confirmation by User");
        Assert.assertEquals(actualValue,expectedPrice.trim());
    }

}
