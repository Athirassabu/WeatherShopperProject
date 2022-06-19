package com.wsp.tests;

import com.wsp.annotations.FrameworkAnnotation;
import com.wsp.data.BaseTest;
import com.wsp.pages.CardPage;
import com.wsp.pages.SunCreamPage;
import com.wsp.pages.HomePage;
import com.wsp.testdata.TestData;
import com.wsp.utils.DataProviderUtils;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HomePageTest extends BaseTest {
    SoftAssert softassert = new SoftAssert();
    HomePage homepage = new HomePage();
    SunCreamPage suncream = new SunCreamPage();
    CardPage card=new CardPage();
    @FrameworkAnnotation
    @Test(description = "To check the title of Home page",
            dataProvider = "getData", dataProviderClass = DataProviderUtils.class)
    public void titleWeatherHopper(TestData testdata) throws InterruptedException {
        String actualTitle = homepage.getTitleTest();
        softassert.assertEquals(actualTitle, "Current Temperature", "Page title verification");
        softassert.assertAll();
    }
}