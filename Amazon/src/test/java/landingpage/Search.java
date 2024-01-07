package landingpage;

import base.CommonAPI;
import org.junit.Test;
import searchpage.SearchPage;

import java.util.List;

public class Search extends CommonAPI {

    @Test
    public void search() throws InterruptedException {
        List<String> itemList = SearchPage.getItemList();
        for (String item:itemList) {
            typeOnCss("#twotabsearchtextbox", "laptop");
            Thread.sleep(2000);
            clearInputField("#twotabsearchtextbox");        }
    }
}
