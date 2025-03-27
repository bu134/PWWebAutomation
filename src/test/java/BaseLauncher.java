import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class BaseLauncher {

    Playwright playwright;
    Browser browser;
    Page page;

    public void browserLauncher(){

        //Creating a Playwright object
        try {
            playwright = Playwright.create();
            //By default, Playwright launches browser in headless mode
            browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            page = browser.newPage();
        }catch (Exception ex){
            System.out.println("Error launching browser");
        }
    }
}
