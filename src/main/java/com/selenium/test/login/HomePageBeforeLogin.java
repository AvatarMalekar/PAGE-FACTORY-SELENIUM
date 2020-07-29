package com.selenium.test.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageBeforeLogin {
    WebDriver webDriver;
    @FindBy(xpath = "//a[@id='nav-link-accountList']")
    WebElement loginPanel;

    public HomePageBeforeLogin(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public String getLoginPanelText() {
        return loginPanel.getTagName();
    }

    public void clickLoginPanel() throws InterruptedException {
        loginPanel.click();
        Thread.sleep(1000);
    }
}
