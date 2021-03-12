package pages;

import com.microsoft.playwright.Page;
import framework.*;
import org.junit.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class NextPage {
    Page page = new FrameworkInitialize().InitializePlaywrightPage();
    String navBar = "#MainNavigation";
    String navBarElements = "li.Primarynavlinks";
    static List<String> navbarList;

    public String getUrl(){
        return page.url();
    }

    public void checkNavBar(){
        page.getAttribute(navBar, "id").equalsIgnoreCase("HeaderNavigation");
//        page.screenshot(new Page.ScreenshotOptions()
//                .withPath(Paths.get("src/test/resources/screenshots/navBar.png")));
    }
    public List<String> getNavbarElements(){
        navbarList =  page.querySelectorAll(navBarElements)
                .stream()
                .map(e-> e.innerText())
                .collect(Collectors.toList());
        return navbarList;
    }

    public void clickNavBarItem(String value){
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
