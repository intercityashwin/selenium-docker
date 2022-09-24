package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FlightDetailsPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name = "passCount")
    private WebElement selpassCount;

    @FindBy(css = "input#findFlights")
    private WebElement btncontinue;

    public FlightDetailsPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(30));
        PageFactory.initElements(this.driver,this);
    }

    public void selectNumberofPassenegers(String value){
        this.wait.until(ExpectedConditions.elementToBeClickable(this.selpassCount));
        new Select(this.selpassCount).selectByValue(value);
    }

    public void goToFindFlights(){
        this.btncontinue.click();
    }



}
