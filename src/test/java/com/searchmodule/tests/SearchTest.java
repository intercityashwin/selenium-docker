package com.searchmodule.tests;
import com.searchmodule.pages.SearchPage;
import com.test.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

    @Test(dataProvider = "getData")
    public void search(String keyword){
        SearchPage searchPage = new SearchPage(driver);
        searchPage.gotoDuckDuckGo();
        searchPage.doSearch(keyword);
        searchPage.clickVideos();
        Assert.assertTrue(searchPage.printLinks()>0,"Check Size of links");
    }

    @DataProvider
    public Object[][] getData(){
        return new Object[][]{
                {"java"},{"automation"},{"docker"},{"selenium"}
        };
    }
}
