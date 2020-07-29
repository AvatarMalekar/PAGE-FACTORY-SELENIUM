package com.selenium.test.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginUserNamePage {
    WebDriver webDriver;
    @FindBy(xpath = "//h1[@class='a-spacing-small']")
    WebElement loginPage;

    @FindBy(xpath = "//input[@id='ap_email']")
    WebElement userNameBox;

    @FindBy(xpath = "//input[@id='continue']")
    WebElement continueButton;


    public LoginUserNamePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public String getLoginPageName() throws InterruptedException {
        Thread.sleep(4000);
        new WebDriverWait(webDriver,40).until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//h1[@class='a-spacing-small']")));
        return loginPage.getText();
    }

    public void setUserName(String username) throws InterruptedException {
        new WebDriverWait(webDriver,40).until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//h1[@class='a-spacing-small']")));
        userNameBox.sendKeys(username);
    }

    public void click() {
        continueButton.click();
    }

    public void login(String userName) throws InterruptedException {
        Thread.sleep(2000);
        this.setUserName(userName);
        Thread.sleep(1500);
        this.click();
        Thread.sleep(2000);
    }
}
