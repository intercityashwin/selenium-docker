package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FlightConfirmationPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//td[normalize-space(text())='Total Price']/parent::tr/td/font")
    private WebElement lblprice;

    @FindBy(xpath = "//a[text()='SIGN-OFF']")
    private WebElement lnksignOff;

    public FlightConfirmationPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(30));
        PageFactory.initElements(this.driver, this);
    }

    public String getPrice(){
        this.wait.until(ExpectedConditions.visibilityOf(this.lblprice));
        String amount = this.lblprice.getText();
        System.out.println("Amount is " + amount);
        this.lnksignOff.click();
        return amount ;
    }

}
