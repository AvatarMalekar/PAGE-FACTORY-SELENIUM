package com.selenium.test.menu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomeMenuPage {
    WebDriver driver;
//    By searchBox = By.id("twotabsearchtextbox");
//    By menuButton = By.id("nav-hamburger-menu");
    @FindBy(id="twotabsearchtextbox")
    WebElement searchBox;

    @FindBy(id="nav-hamburger-menu")
    WebElement menuButton;

    public HomeMenuPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public String getSearchBoxText(){
       return searchBox.getText();
    }

    public void clickMenu() throws InterruptedException {
        menuButton.click();
        Thread.sleep(1000);
    }
}
