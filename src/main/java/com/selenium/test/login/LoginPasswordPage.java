package com.selenium.test.login;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPasswordPage {
    WebDriver webDriver;
    JavascriptExecutor jse;

    @FindBy(xpath = "//h1[@class='a-spacing-small']")
    WebElement isUserNamePresent;

    @FindBy(xpath = "//input[@id='ap_password']")
    WebElement passwordBox;

    @FindBy(xpath = "//input[@id='signInSubmit']")
    WebElement submitButton;

    public LoginPasswordPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public String checkPasswordPage() throws InterruptedException {
        Thread.sleep(2000);
        new WebDriverWait(webDriver,60).until(ExpectedConditions
                .elementToBeClickable(By.xpath("//input[@id='ap_password']")));
        return isUserNamePresent.getTagName();
    }

    public void enterPassword(String password) throws InterruptedException {
        Thread.sleep(4000);
        new WebDriverWait(webDriver,60).until(ExpectedConditions
                .elementToBeClickable(By.xpath("//input[@id='ap_password']")));
       passwordBox.sendKeys(password);
       Thread.sleep(1000);
    }

    public void clickSubmitButton(){
        submitButton.click();
    }

    public void login(String password) throws InterruptedException {
        this.enterPassword(password);
        Thread.sleep(1000);
        this.clickSubmitButton();
    }

}
