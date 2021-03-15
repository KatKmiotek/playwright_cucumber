package pages;

import com.microsoft.playwright.Page;
import framework.FrameworkInitialize;
import org.junit.Assert;

public class TestingPage {
    Page page = new FrameworkInitialize().InitializePlaywrightPage();

    public void goTo() {
        page.navigate("https://www.globalsqa.com/demo-site/");
    }

    public void goToTask(String task) {
//        hardcoded selector for Tabs
        String taskSelector = "#post-2715 > div:nth-child(3) > div > div > div.row.price_table_holder.col_4 > div:nth-child(1) > ul > li:nth-child(2) > a";
        page.click(taskSelector);
        page.title().contains(task);
    }

    public void completeTask(String taskNumber) {

        if(taskNumber.equalsIgnoreCase("task1")){
            String taskSelector = "li:has-text(\"Simple Accordion\")";
            page.click(taskSelector);


        }
        else if(taskNumber.equalsIgnoreCase("task2")){
            String taskSelector = "li:has-text(\"Re-Size Accordion\")";
            page.click(taskSelector);
        }
        else{
            String taskSelector = "li:has-text(\"Toggle Icons\")";
            page.click(taskSelector);
        }
    }
}
