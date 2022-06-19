package com.wsp.pages;

import com.wsp.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.wsp.utils.SeleniumUtils.click;
import static com.wsp.utils.SeleniumUtils.getTitle;


public class HomePage {
    SunCreamPage sunCream=new SunCreamPage();
    MoisturizerCreamPage moisturizer=new MoisturizerCreamPage();
    private static final By SUNCREAM = By.xpath("//button[text()='Buy sunscreens']"); //100 threads //1 txtboxUsername
    private static final By MOISTURIZER = By.xpath("//button[text()='Buy moisturizers']");
    public String getTitleTest(){
        getTitle(DriverManager.getDriver().getTitle());
        return DriverManager.getDriver().getTitle();
    }
    public int checkWeather() {
        WebElement ele = DriverManager.getDriver().findElement(By.id("temperature"));
        String weather = ele.getText();
        String newWeather=weather.replaceAll("[^0-9]","");
        System.out.println("Weather is:"+newWeather);
        int we=Integer.parseInt(newWeather);
        if (we>34) {
            sunsCreamClick();
        } else if (we<19)
            moisturizerClick();
        return we;
    }
    public SunCreamPage sunsCreamClick()
    {
        click(SUNCREAM, "Weather is >34 so Sunscream Button");
        getTitleTest();
        sunCream.addLeastExpensive().addSecondLeastExpensive();
        return new SunCreamPage();
    }

    public MoisturizerCreamPage moisturizerClick()
    {
        click(MOISTURIZER, "Weather is < 19 so moiturizer cream Button");
        getTitleTest();
        moisturizer.addLeastExpensiveMositurizer().addSecondLeastExpensiveMositurizer();
        return new MoisturizerCreamPage();
    }

}
