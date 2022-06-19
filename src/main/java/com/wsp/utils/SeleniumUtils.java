package com.wsp.utils;

import com.wsp.config.ConfigFactory;
import com.wsp.driver.DriverManager;
import com.wsp.enums.WaitType;
import com.wsp.reports.ExtentLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public final class SeleniumUtils {

    private SeleniumUtils(){}

    public static void click(By by, String elementName){
        WebElement element = waitUntilElementPresent(by);
        element.click();
        ExtentLogger.pass(elementName + " is clicked successfully");
    }
    public static void getTitle(String title){
        ExtentLogger.pass(title + "Title is displayed successfully");
    }

    public static void click(WebElement element){
        element.click();
    }

    public static void click(By by, WaitType waitType){
        WebElement element = null;
        if(waitType == WaitType.PRESENCE){
            element = waitUntilElementPresent(by);
        } else if(waitType == WaitType.CLICKABLE){
            element = waitUntilElementToBeClickable(by);
        } else if(waitType == WaitType.VISIBLE){
            element = waitUntilElementToBeVisible(by);
        }
        element.click();
    }

    public static void sendKeys(By by, String value, String elementName){
        WebElement element = waitUntilElementPresent(by);
        element.sendKeys(value);
        ExtentLogger.pass(value + " is entered "+ " successfully in "+elementName);
    }

    public static void javaScriptSenkeys(String id,String value,String elementName){
        JavascriptExecutor js=(JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("document.getElementById('"+id+"').value='"+value+"';");
        ExtentLogger.pass(value + " is entered "+ " successfully in "+elementName);
    }


    private static WebElement waitUntilElementToBeVisible(By by) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), ConfigFactory.getConfig().timeout());
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    private static WebElement waitUntilElementPresent(By by) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), ConfigFactory.getConfig().timeout());
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }
    private static WebElement waitUntilElementToBeClickable(By by) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), ConfigFactory.getConfig().timeout());
        return wait.until(ExpectedConditions.elementToBeClickable(by));

    }
}
