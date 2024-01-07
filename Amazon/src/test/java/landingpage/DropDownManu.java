package landingpage;

import base.CommonAPI;
import org.junit.Test;

import java.util.List;

public class DropDownManu extends CommonAPI {

    @Test
    public void dropDownMenu() {
        List<String> manuList = getListOfText(".nav-search-dropdown searchSelect");
        for (String value : manuList) {
            System.out.println(value);

        }


    }
}
