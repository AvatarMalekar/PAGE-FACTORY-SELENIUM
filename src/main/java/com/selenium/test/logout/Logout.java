package com.selenium.test.logout;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Logout {
    WebDriver webDriver;
    Actions actions;

    @FindBy(xpath = "//span[contains(text(),'Account & Lists')]")
    WebElement logoutPanel;

    @FindBy(xpath = "//span[contains(text(),'Sign Out')]")
    WebElement signOut;


    public Logout(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.actions=new Actions(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    private void selectPanel() throws InterruptedException {
        Thread.sleep(20000);
        new WebDriverWait(webDriver,60).until(ExpectedConditions
                .elementToBeClickable(By.xpath("//span[contains(text(),'Account & Lists')]")));
        actions.moveToElement(logoutPanel).build().perform();
    }

    private void clickLogout(){
        signOut.click();
    }

    public void logOut() throws InterruptedException {
        this.selectPanel();
        Thread.sleep(2000);
        this.clickLogout();
    }
}
