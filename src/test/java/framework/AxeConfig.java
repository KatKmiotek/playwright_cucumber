package framework;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.jayway.jsonpath.JsonPath;
import com.microsoft.playwright.Page;

import java.util.List;

public class AxeConfig {
//    usage: axeConfig.injectAxe(String location of element (ex navbar)) returns List<String> of violations found
//    that match provided rules
//    line 27 to see json return by running axe
//    rules optional or empty string

    Page page = new FrameworkInitialize().InitializePlaywrightPage();
    String scriptPath = "https://cdnjs.cloudflare.com/ajax/libs/axe-core/4.1.3/axe.min.js";
    String rules = "{runOnly: ['wcag2a', 'wcag2aa']}";


    public void injectAxe(String location) throws JsonProcessingException {
        Page.AddScriptTagOptions options = new Page.AddScriptTagOptions();
        options.setUrl(scriptPath);
        page.addScriptTag(options);
        Object axeReport = page.evaluate("axe.run(" + rules + ")");
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String axeJson = ow.writeValueAsString(axeReport);
//        System.out.println(axeJson);
        List<String> violations = readViolations(axeJson);
        System.out.println("Axe violations in "+ location + " : " + violations);
    }

    private List<String> readViolations(String response) {
        String pathViolations = "$.violations[*].description";
        List<String> violations = JsonPath.read(response, pathViolations);
        return violations;
    }

}
