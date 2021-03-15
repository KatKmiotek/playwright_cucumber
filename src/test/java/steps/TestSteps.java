package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import pages.TestingPage;

public class TestSteps {

    TestingPage testingPage = new TestingPage();

    @Given("^I am on testing page$")
    public void i_am_on_next_home_page() {
        testingPage.goTo();
    }

    @And("^click on \"([^\"]*)\" challenge$")
    public void clickOnChallenge(String task) {
        testingPage.goToTask(task);
    }

    @And("^complete \"([^\"]*)\" for tabs challenge$")
    public void complete(String taskNumber) {
        testingPage.completeTask(taskNumber);
    }
}
