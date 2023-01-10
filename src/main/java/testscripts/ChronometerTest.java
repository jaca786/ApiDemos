package testscripts;

import base.BaseTest;
import org.testng.annotations.Test;

public class ChronometerTest extends BaseTest {

    @Test
    public void chronometerTest() throws InterruptedException {
        homePage.validatePageHeader();
        homePage.validateHomePageCTAOptions();
        homePage.clickViewCTA();
        viewPage.validatePageHeader();
        viewPage.validateViewPageCTAOptions();
        viewPage.clickChronometerCTA();
        chronometerPage.validatePageHeader();
        chronometerPage.validateChronometerPageParametersnCTAOptions();
        chronometerPage.validateStartStopTimeFeature();
        chronometerPage.validateResetFeature();
        //Set format String and Clear Format String CTA is not working
    }

}
