package landingpage;

import base.CommonAPI;
import org.junit.Assert;
import org.junit.Test;

public class PageTitle extends CommonAPI {

    @Test
    public void checkTitle(){
        String expectedTitle = "Amazon.com:Online Shopping for Electronics, Apparel, Computers,Books";
        driver = null;
        String actualTitle = driver.getTitle();
        System.out.println(actualTitle);
        Assert.assertEquals(expectedTitle,actualTitle);
    }
}
