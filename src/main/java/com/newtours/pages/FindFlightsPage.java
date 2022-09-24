package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FindFlightsPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(css = "input#reserveFlights")
    private WebElement btncountinueflight;

    @FindBy(css = "input#buyFlights")
    private WebElement btnbuyFlights;

    public FindFlightsPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(30));
        PageFactory.initElements(this.driver, this);
    }

    public void submitFinalFlightPage(){
        this.wait.until(ExpectedConditions.elementToBeClickable(this.btncountinueflight));
        this.btncountinueflight.click();
    }

    public void goToflightConfirmationPage(){
        this.wait.until(ExpectedConditions.elementToBeClickable(this.btnbuyFlights));
        this.btnbuyFlights.click();
    }

}
