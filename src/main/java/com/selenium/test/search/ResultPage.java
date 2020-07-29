package com.selenium.test.search;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResultPage {
    WebDriver webDriver;

   // By result= By.xpath("//*[@id=\"search\"]/span/div/span/h1/div/div[1]/div/div/span[3]");
    @CacheLookup
    @FindBy(xpath="//span[@class='a-color-state a-text-bold']")
    WebElement result;

    public ResultPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this);
    }

    public String getSearchResultName(){
        return result.getText();
    }
}
