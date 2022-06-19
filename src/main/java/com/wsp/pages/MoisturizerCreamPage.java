package com.wsp.pages;

import com.wsp.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.*;

import static com.wsp.utils.SeleniumUtils.click;
import static com.wsp.utils.SeleniumUtils.getTitle;

public class MoisturizerCreamPage {

    public String getTitleTestMositurizerCream() {
        getTitle(DriverManager.getDriver().getTitle());
        return DriverManager.getDriver().getTitle();
    }

    public MoisturizerCreamPage addLeastExpensiveMositurizer()  {
        List<Integer> list=new LinkedList<>();
        List<WebElement> elements = DriverManager.getDriver().findElements(By.xpath("//p[@class='font-weight-bold top-space-10']"));
        for(int i=0;i<elements.size();i++)
        {
            String text = elements.get(i).getText();
            if(text.contains("Aloe"))
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
        click(leastExpensiveSunsCream, "Least expensive mositurizer with ALOE is :");
        return this;
    }
    public CardPage addSecondLeastExpensiveMositurizer()  {
        List<Integer> list=new LinkedList<>();
        List<WebElement> elements = DriverManager.getDriver().findElements(By.xpath("//p[@class='font-weight-bold top-space-10']"));
        for(int i=0;i<elements.size();i++)
        {
            String text = elements.get(i).getText();
            if(text.contains("Almond"))
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
        click(leastExpensiveSunsCream, "Least expensive moisturizer with almond :");
        return new CardPage();
    }

}
