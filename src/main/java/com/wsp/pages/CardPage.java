package com.wsp.pages;

import com.wsp.driver.DriverManager;
import org.openqa.selenium.By;

import static com.wsp.utils.SeleniumUtils.*;

public class CardPage {

    private static final By PAYBUTTON   = By.className("stripe-button-el");
    private static final By CLICKCART   = By.xpath("//button[@class='thin-text nav-link']");
    private static final By EMAILCLICK  = By.xpath("//input[@id='email']");
    private static final By CARDID      = By.id("card_number");
    private static final By DATEDETAILS = By.id("cc-exp");
    private static final By CVC = By.id("cc-csc");
    private static final By CLICKPAY = By.className("iconTick");
    private static final By ZIP = By.id("billing-zip");

    public String getTitleTestCardPage() {
        getTitle(DriverManager.getDriver().getTitle());
        return DriverManager.getDriver().getTitle();
    }
    public CardPage clickCartButton()
    {
        click(CLICKCART, "CART button");
        return this;
    }
public CardPage clickPayButton()
    {
        click(PAYBUTTON, "Pay Button");
        return this;
    }
    public CardPage enterEmailId(String email)  {
        DriverManager.getDriver().switchTo().frame(0);
        DriverManager.getDriver().findElement(By.xpath("//input[@id='email']")).sendKeys("athirasabu94@gmail.com");
        return this;
    }

    public CardPage enterCard(String card)
    {
        javaScriptSenkeys("card_number","378282246310005","Card number");
        return this;
    }

    public CardPage enterDate(String date)
    {
        javaScriptSenkeys("cc-exp","10/28","Date");
        return this;
    }

    public CardPage enterCVC(String date)
    {
        sendKeys(CVC,date,"CVC details:");
        return this;
    }

    public CardPage enterZip(String date)
    {
        sendKeys(ZIP,date,"Zip details:");
        return this;
    }

    public PaymentSuccess loginButton()
    {
        click(CLICKPAY, "Click pay is clicked");
        return new PaymentSuccess();
    }

    public PaymentSuccess loginToApplication(String email, String card,String date,String cv,String zip) throws InterruptedException { //method chaining
        return enterEmailId(email)
                .enterCard(card)
                .enterDate(date).enterCVC(cv).enterZip(zip).loginButton();

    }

}
