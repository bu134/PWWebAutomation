import static com.microsoft.playwright.assertions.PlaywrightAssertions.*;

public class FirstDemoTest extends BaseLauncher{

    BaseLauncher baseLauncher = new BaseLauncher();

    public void navigation(){

        baseLauncher.browserLauncher();
        baseLauncher.page.navigate("https://f1tv.formula1.com/");
    }

    public void acceptCookies(){

//        baseLauncher.page.frameLocator("//*[@title='SP Consent Message']")
//                .locator("//*[@title=\"ACCEPT ALL\"]").click();
        baseLauncher.page.locator("button[aria-label='ACCEPT ALL']").click();
        baseLauncher.page.locator("//*[@class='user-signin']").click();
        assertThat(baseLauncher.page).hasTitle("Formula 1®");
        assertThat(baseLauncher.page.locator("div.loginForm h1.form-heading")).containsText("Sign In");
        assertThat(baseLauncher.page.getByPlaceholder("Enter your username")).isEditable();
        baseLauncher.page.getByPlaceholder("Enter your username").fill("bu@gmail.com");
        assertThat(baseLauncher.page.getByPlaceholder("Enter your password")).isEditable();
        baseLauncher.page.getByPlaceholder("Enter your password").fill("password");
        baseLauncher.page.locator("//*[@type='submit']").isVisible();
        baseLauncher.playwright.close();

    }

    public static void main(String[] args){
        FirstDemoTest firstDemoTest = new FirstDemoTest();
        firstDemoTest.navigation();
    }

}
