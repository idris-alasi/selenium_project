package com.company;


import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Main {

    WebDriver webDriver;

    @Before
    public void before() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\idris\\Downloads\\chromedriver_win32\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.get("http://www.youtube.com");


    }

    @After
    public void after(){
        webDriver.close();
    }

    @Test
    public void checkingURL(){

        String expected = "https://www.youtube.com/";
        String actual = webDriver.getCurrentUrl();
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void checkingVideo(){
       WebElement searchBar = webDriver.findElement(By.name("search_query"));
       String expected = "https://www.youtube.com/results?search_query=selenium";
       String text = "selenium";
       searchBar.click();
       searchBar.sendKeys(text);
       searchBar.sendKeys(Keys.ENTER);
       String actual = webDriver.getCurrentUrl();
        // webDriver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
       Assert.assertEquals(actual,expected);
    }

}
