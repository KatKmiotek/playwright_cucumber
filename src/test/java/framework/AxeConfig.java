package framework;

import com.microsoft.playwright.Page;

public class AxeConfig {
    Page page = new FrameworkInitialize().InitializePlaywrightPage();
    String scriptPath = "https://cdnjs.cloudflare.com/ajax/libs/axe-core/4.1.3/axe.min.js";

    public Object injectAxe() {
        Page.AddScriptTagOptions options = new Page.AddScriptTagOptions();
        options.setUrl(scriptPath);
        page.addScriptTag(options);
        Object axeReport = page.evaluate("axe.run()");
        return axeReport;
    }

}
