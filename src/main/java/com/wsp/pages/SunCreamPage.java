package com.wsp.pages;

import com.wsp.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.*;

import static com.wsp.utils.SeleniumUtils.click;
import static com.wsp.utils.SeleniumUtils.getTitle;

public class SunCreamPage {

    public String getTitleTestSunCream() {
        getTitle(DriverManager.getDriver().getTitle());
        return DriverManager.getDriver().getTitle();
    }

    public SunCreamPage addLeastExpensive() {
        List<Integer> list=new LinkedList<>();
        List<WebElement> elements = DriverManager.getDriver().findElements(By.xpath("//p[@class='font-weight-bold top-space-10']"));
        for(int i=0;i<elements.size();i++)
        {
            String text = elements.get(i).getText();
            if(text.contains("50"))
            {
                WebElement element= DriverManager.getDriver().findElement(By.xpath("//p[text()='"+text+"']/following::p[1]"));
                String text1=element.getText();
                String newPrice=text1.replaceAll("[^0-9]","");
                int priceValue=Integer.parseInt(newPrice);
                list.add(priceValue);
            }
        }
        int value=Collections.min(list);
        By leastExpensiveSunsCream = By.xpath("//p[contains(text(),'"+value+"')]//following::button");
        click(leastExpensiveSunsCream, "Least expensive sunscream with SPF 50:");
        return this;
    }
    public CardPage addSecondLeastExpensive()  {
        List<Integer> list=new LinkedList<>();
        List<WebElement> elements = DriverManager.getDriver().findElements(By.xpath("//p[@class='font-weight-bold top-space-10']"));
        for(int i=0;i<elements.size();i++)
        {
            String text = elements.get(i).getText();
            if(text.contains("30"))
            {
                WebElement element= DriverManager.getDriver().findElement(By.xpath("//p[text()='"+text+"']/following::p[1]"));
                String text1=element.getText();
                String newPrice=text1.replaceAll("[^0-9]","");
                int priceValue=Integer.parseInt(newPrice);
                list.add(priceValue);
            }
        }
        int value=Collections.min(list);
        By leastExpensiveSunsCream = By.xpath("//p[contains(text(),'"+value+"')]//following::button");
        click(leastExpensiveSunsCream, "Least expensive suncream SPF30 :");
        return new CardPage();
    }

}
