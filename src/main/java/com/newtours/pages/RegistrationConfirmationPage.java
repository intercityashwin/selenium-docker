package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationConfirmationPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//a[normalize-space(text())='Flights']")
    private WebElement lnkflights;

    public RegistrationConfirmationPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(30));
        PageFactory.initElements(this.driver,this);
    }

    public void goToflightdetailsPage(){
        this.wait.until(ExpectedConditions.visibilityOf(this.lnkflights));
        this.lnkflights.click();
    }

}
