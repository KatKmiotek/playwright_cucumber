package steps;


import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import pages.*;

public class Stepdefs {

	NextPage next = new NextPage();

	@Given("^I am on Next home page$")
	public void i_am_on_next_home_page() {
		next.clickHome();
	}

	@Given("^check if all elements of navBar are present$")
	public void check_if_all_elements_of_are_present() throws JsonProcessingException {
		next.checkNavBar();
	}

	@And("^check \"([^\"]*)\" navbar link$")
	public void checkNavbarLinks(String value) {
		next.clickNavBarLinks(value);
	}
}
