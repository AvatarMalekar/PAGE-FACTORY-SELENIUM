package com.selenium.test.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageAfterLogin {
    WebDriver webDriver;
    @FindBy(xpath = "//span[contains(text(),'Hello, Avatar')]")
    WebElement userName;

    public HomePageAfterLogin(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public String checkLogin(){
        return userName.getText();
    }
}
