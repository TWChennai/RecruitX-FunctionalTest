package pages;

import org.fest.assertions.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {


    public HomePage() throws Exception {
    }

    public WebElement homePageTitle() {
        return driverPage.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]"));
    }

    public void verifyTitle(String title) {
        Assertions.assertThat(homePageTitle().getText().contains(title));
    }
}
