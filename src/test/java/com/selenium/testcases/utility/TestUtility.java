package com.selenium.testcases.utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestUtility {
    public static WebDriver webDriver;

    public void startup() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().deleteAllCookies();
        webDriver.manage().window().maximize();
        Thread.sleep(2000);
        webDriver.get("https://www.amazon.in/");
        Thread.sleep(2000);
//        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//        webDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    }

    public void takeSnapShot(WebDriver webdriver,String fileName) throws Exception{
        String fileWithPath="F:\\SELENIUM\\Selenium Projects\\Test\\PageFacory\\src\\test\\resources\\snapshots\\"+fileName;
//        String fileBasePath = System.getProperty("user.dir");
//        System.out.println(fileBasePath);
        TakesScreenshot scrShot =((TakesScreenshot)webdriver);
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile=new File(fileWithPath);
        FileUtils.copyFile(SrcFile, DestFile);
        Thread.sleep(2000);
    }

    public JSONObject getJasonObject() throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader("F:\\SELENIUM\\Selenium Projects\\Test\\PageFacory\\src\\test\\resources\\DataFile.json"));
        return jsonObject;
    }

}
