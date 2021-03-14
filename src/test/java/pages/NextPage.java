package pages;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.microsoft.playwright.Page;
import com.sun.java.accessibility.util.AccessibilityListenerList;
import framework.*;
import org.junit.Assert;

import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

public class NextPage {

    Page page = new FrameworkInitialize().InitializePlaywrightPage();
    String navBar = "#MainNavigation";
    String navBarElements = "li.Primarynavlinks";
    static List<String> navbarList;
    AxeConfig axeConfig = new AxeConfig();

    public String getUrl(){
        return page.url();
    }

    public void checkNavBar() throws JsonProcessingException {
        page.getAttribute(navBar, "id").equalsIgnoreCase("HeaderNavigation");
        axeConfig.injectAxe("navBar");
        Assert.assertEquals(14, getNavbarElements().size());
    }
    public List<String> getNavbarElements(){
        navbarList =  page.querySelectorAll(navBarElements)
                .stream()
                .map(e-> e.innerText())
                .collect(Collectors.toList());
        return navbarList;
    }

    public void clickNavBarLinks(String value){
        String selector = "text=" + value;
        page.click(selector);
        if(value.equalsIgnoreCase("baby")){
            Assert.assertEquals("https://www.next.co.uk/newborn", getUrl());
        }
        else {
            Assert.assertEquals("https://www.next.co.uk/" + value, getUrl());
        }
    }

    public void clickHome() {
        page.navigate("https://www.next.co.uk/");
        Assert.assertEquals("https://www.next.co.uk/", getUrl());
    }

}
