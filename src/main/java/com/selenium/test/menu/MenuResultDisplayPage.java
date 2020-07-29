package com.selenium.test.menu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MenuResultDisplayPage {
    WebDriver webDriver;

    //By result= By.xpath("//*[@id=\"hmenu-content\"]/ul[1]/li[2]/a/div");
    //*[@id="hmenu-content"]/ul[1]/li[2]/a/div
    @CacheLookup
    @FindBy(xpath="//div[contains(text(),'Echo & Alexa')]")
    WebElement result2;

    public MenuResultDisplayPage(WebDriver driver) {
        this.webDriver = driver;
        PageFactory.initElements(driver,this);
    }

    public String getSearchResultName(WebDriver webDriver) throws InterruptedException {
//        Thread.sleep(1000);
        new WebDriverWait(webDriver,10).until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//div[contains(text(),'Echo & Alexa')]")));
        return result2.getTagName();
    }
}
