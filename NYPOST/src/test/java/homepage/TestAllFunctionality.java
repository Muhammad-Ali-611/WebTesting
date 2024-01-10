package homepage;

import PAGES.AllFunctionality;
import base.CommonAPI;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestAllFunctionality extends CommonAPI {
    @Test
    public void newsFeatures() throws IOException, InterruptedException {
        AllFunctionality featureNews = PageFactory.initElements(driver,AllFunctionality.class);
        featureNews.runAllTheFeatureTest(driver);
    }
}
