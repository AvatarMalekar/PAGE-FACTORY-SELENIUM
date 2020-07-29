package com.selenium.testcases.tests;

import com.selenium.test.menu.HomeMenuPage;
import com.selenium.test.menu.MenuResultDisplayPage;
import com.selenium.testcases.utility.TestUtility;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SidemenuTest extends TestUtility {
    HomeMenuPage homeMenuPage;
    MenuResultDisplayPage menuResultDisplayPage;

    @BeforeTest
    public void setUp() throws InterruptedException {
        super.startup();
    }

    @Test
    public void testSideMenu() throws Exception {
        homeMenuPage = new HomeMenuPage(webDriver);
        int length = homeMenuPage.getSearchBoxText().length();
        super.takeSnapShot(webDriver,(String) super.getJasonObject().get("menuHomePage"));
        Thread.sleep(1000);
        Assert.assertEquals(0, length);
        homeMenuPage.clickMenu();
        menuResultDisplayPage = new MenuResultDisplayPage(webDriver);
        super.takeSnapShot(webDriver,(String) super.getJasonObject().get("sideMenuBar"));
        String searchResultName = menuResultDisplayPage.getSearchResultName(webDriver);
        Assert.assertFalse(searchResultName.isEmpty());
    }

    @AfterTest
    public void setUp2() {
        webDriver.quit();
    }
}
