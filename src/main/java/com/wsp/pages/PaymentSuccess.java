package com.wsp.pages;

import com.wsp.driver.DriverManager;
import com.wsp.reports.ExtentLogger;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

import static com.wsp.utils.SeleniumUtils.click;


public class PaymentSuccess {

    private static final By paymentMessage = By.xpath("//h2[text()='PAYMENT SUCCESS']"); //100 threads //1 txtboxUsername

    public PaymentSuccess verifySuccessMessage(){
        DriverManager.getDriver().switchTo().defaultContent();
        String message=DriverManager.getDriver().findElement(paymentMessage).getText();
        SoftAssert softassert = new SoftAssert();
       softassert.assertEquals(message, "PAYMENT SUCCESS", "Payment is successfull");
        ExtentLogger.pass(message + " is displayed successfully");
        return this;
    }


}
