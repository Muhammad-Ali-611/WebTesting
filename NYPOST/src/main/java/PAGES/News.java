package PAGES;

import base.CommonAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class News {

    @FindBy(how = How.CSS, using = "div.headline-container a:nth-child(2) h3")
    public static WebElement headLineNewsWebElement;

    public WebElement getHeadLineNewsWebElement() {
        return headLineNewsWebElement;

        public void clickOnHeadLineNews(){
            CommonAPI.waitUnitVisible(headLineNewsWebElement);
            String headLineNews = getHeadLineNewsWebElement().getText();
            System.out.println(headLineNewsWebElement);
            CommonAPI.waitUntilClickAble(headLineNewsWebElement);
            getHeadLineNewsWebElement().click();
        }
    }
}
