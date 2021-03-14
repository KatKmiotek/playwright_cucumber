package runner;

//import cucumber.api.CucumberOptions;
import com.microsoft.playwright.Page;
//import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/",
        glue = {"steps"},
        plugin = { "pretty"}
        
)
public class TestRunner{


    private TestRunner() {

    }
    
    
	
	  @BeforeClass 
	  public static void beforeClass() {
		 
	  
	  }
	  
	  @AfterClass 
	  public static void afterClass() {

	  }
	 
}