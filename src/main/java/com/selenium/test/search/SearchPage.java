package com.selenium.test.search;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
    WebDriver driver;

    @FindBy(id="twotabsearchtextbox")
    WebElement searchBox;

    @FindBy(className="nav-input")
    WebElement searchButton;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public String getSearchBoxText(){
        return searchBox.getText();
    }

    public void setSearchText(String searchText){
        searchBox.sendKeys(searchText);
    }

    public void clickSearch(){
        searchButton.click();
    }

    public void search(String searchText){
        setSearchText(searchText);
        clickSearch();
    }
}
