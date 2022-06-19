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

public class CompletePayment extends BaseTest {
    SoftAssert softassert = new SoftAssert();
    HomePage homepage = new HomePage();
    SunCreamPage suncream = new SunCreamPage();
    CardPage card=new CardPage();
    @FrameworkAnnotation
    @Test(description = "To check the weather and accordingly add creams and do the payment successfully",
            dataProvider = "getData", dataProviderClass = DataProviderUtils.class)
    public void completeWeatherHopper(TestData testdata) throws InterruptedException {
        String actualTitle = homepage.getTitleTest();
        softassert.assertEquals(actualTitle, testdata.expectedTitle, "Page title verification");
        homepage.checkWeather();
        card.clickCartButton().clickPayButton().loginToApplication(testdata.email,testdata.cardNumber,testdata.expiryDate,testdata.cvv,testdata.zip).verifySuccessMessage();
    }
}