package com.searchmodule.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SearchPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(css = "#search_form_input_homepage")
    private WebElement search;

    @FindBy(css = "#search_button_homepage")
    private WebElement btnsearch;

    @FindBy(linkText = "Videos")
    private WebElement lnkVideos;

    @FindBy(css = "div.tile__body a")
    private List<WebElement> listOfVideos;

    private By by = By.cssSelector("div.tile__body a");

    public SearchPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(30));
        PageFactory.initElements(this.driver, this);
    }

    public void gotoDuckDuckGo(){
        this.driver.get("https://duckduckgo.com/50x.html?e=2");
    }

    public void doSearch(String keyword){
        //this.driver.get("https://duckduckgo.com/50x.html?e=2");
        this.wait.until(ExpectedConditions.visibilityOf(this.search));
        this.search.sendKeys(keyword);
        this.btnsearch.click();
    }

    public void clickVideos(){
        this.wait.until(ExpectedConditions.elementToBeClickable(this.lnkVideos));
        this.lnkVideos.click();
    }

    public Integer printLinks(){
        this.wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(this.by,0));
        this.listOfVideos.stream().map(s->s.getText().trim()).forEach(text->System.out.println(text));
        return this.listOfVideos.size();
    }
}
