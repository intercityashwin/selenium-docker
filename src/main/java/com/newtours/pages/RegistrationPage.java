package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name = "firstName")
    private WebElement txtfirstName;

    @FindBy(name = "lastName")
    private WebElement txtlastName;

    @FindBy(id = "email")
    private WebElement txtuserName;

    @FindBy(name = "password")
    private WebElement txtpassword;

    @FindBy(name = "confirmPassword")
    private WebElement txtconfirmpassword;

    @FindBy(name = "register")
    private  WebElement btnsubmit;

    public RegistrationPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(30));
        PageFactory.initElements(this.driver,this);
    }

    public void goToFlightApp(){
        this.driver.get("https://vins-udemy.s3.amazonaws.com/docker/docker-book-flight.html#");
        this.wait.until(ExpectedConditions.visibilityOf(this.txtfirstName));
    }

    public void enterUserDetails(String firstName, String lastName){
        this.txtfirstName.sendKeys(firstName);
        this.txtlastName.sendKeys(lastName);
    }

    public void enterUserCredentials(String userName, String password){
        this.txtuserName.sendKeys(userName);
        this.txtpassword.sendKeys(password);
    }

    public void submit(){
        this.btnsubmit.click();
    }





}
