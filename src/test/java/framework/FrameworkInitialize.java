package framework;

import com.microsoft.playwright.*;
import com.microsoft.playwright.BrowserType.LaunchOptions;

public class FrameworkInitialize {

	public Page InitializePlaywrightPage() {

		Browser browser = Playwright
                .create()
				.chromium()
                .launch(new LaunchOptions().setHeadless(false));

		Page page = browser.newPage();

		return page;

	}
}
