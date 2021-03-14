package framework;

import com.microsoft.playwright.*;
import com.microsoft.playwright.BrowserType.LaunchOptions;

public class FrameworkInitialize {
	String scriptPath = "https://cdnjs.cloudflare.com/ajax/libs/axe-core/4.1.3/axe.min.js";

	public Page InitializePlaywrightPage() {

		Browser browser = Playwright
                .create()
				.chromium()
                .launch(new LaunchOptions().setHeadless(true));
		Page page = browser.newPage();


		return page;

	}
}
