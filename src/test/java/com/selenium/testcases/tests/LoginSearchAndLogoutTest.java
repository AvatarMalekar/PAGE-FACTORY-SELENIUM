package com.selenium.testcases.tests;

import com.selenium.test.login.HomePageBeforeLogin;
import com.selenium.test.login.LoginPasswordPage;
import com.selenium.test.login.LoginUserNamePage;
import com.selenium.test.logout.Logout;
import com.selenium.test.search.ResultPage;
import com.selenium.test.search.SearchPage;
import com.selenium.testcases.utility.TestUtility;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginSearchAndLogoutTest extends TestUtility {
    SearchPage searchBarPage;
    ResultPage resultPage;

    HomePageBeforeLogin homePageBeforeLogin;
    LoginUserNamePage loginUserNamePage;
    LoginPasswordPage loginPasswordPage;

    Logout logout;

    @BeforeTest
    public void setUp() throws InterruptedException {
        super.startup();
    }

    @Test(priority = 0)
    public void testLoginPage() throws InterruptedException {
        homePageBeforeLogin=new HomePageBeforeLogin(webDriver);
        String loginPanelText = homePageBeforeLogin.getLoginPanelText();
        Assert.assertFalse(loginPanelText.isEmpty());

        homePageBeforeLogin.clickLoginPanel();
    }

    @Test(priority = 1)
    public void testLoginUsernamePage() throws InterruptedException, IOException, ParseException {
        loginUserNamePage=new LoginUserNamePage(webDriver);
        loginPasswordPage=new LoginPasswordPage(webDriver);
        String loginPageName = loginUserNamePage.getLoginPageName();
        Assert.assertFalse(loginPageName.isEmpty());
        loginUserNamePage.login((String) super.getJasonObject().get("userName"));
        String checkPasswordPage = loginPasswordPage.checkPasswordPage();
        Assert.assertFalse(checkPasswordPage.isEmpty());
        System.out.println((String) super.getJasonObject().get("password"));
        loginPasswordPage.login((String) super.getJasonObject().get("password"));
    }

    @Test(priority = 3)
    public void testSearchFunction() throws Exception {
        super.takeSnapShot(webDriver,(String) super.getJasonObject().get("homePageImage"));
        searchBarPage = new SearchPage(webDriver);
        int stringLength = searchBarPage.getSearchBoxText().length();
        Assert.assertEquals(0, stringLength);
        searchBarPage.search((String) super.getJasonObject().get("searchText"));
        Thread.sleep(2000);
        resultPage = new ResultPage(webDriver);
        super.takeSnapShot(webDriver,(String) super.getJasonObject().get("searchResultPageImage"));
        int length = resultPage.getSearchResultName().length() - 1;
        Assert.assertEquals((String) super.getJasonObject().get("searchText"), resultPage.getSearchResultName().substring(1, length));
    }

    @Test(dependsOnMethods = "testSearchFunction")
    public void testLogout() throws InterruptedException {
        logout=new Logout(webDriver);
        logout.logOut();
        String loginPageName = loginUserNamePage.getLoginPageName();
        Assert.assertFalse(loginPageName.isEmpty());

    }

    @AfterTest
    public void setUp2() {
        webDriver.quit();
    }
}
