package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.internal.KeysRelatedAction;

/**
 * Created by Bharathan on 10/02/16.
 * Created on 10/02/16 1:05 PM
 */
public class LoginPage extends BasePage {

    private WebElement submit() {
        return driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.view.View[1]/android.widget.Button[1]"));
    }

    private WebElement userNameTextBox() {
        return driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.view.View[1]/android.widget.EditText[2]"));
    }

    private WebElement passWordTextBox() {
        return driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.view.View[1]/android.widget.EditText[3]"));
    }

    public void setLogin(String userName) {
        userNameTextBox().click();
        userNameTextBox().sendKeys(userName);
    }

    public void setPassword(String password) {
        userNameTextBox().click();
        userNameTextBox().sendKeys(password);
    }

    public void clickSubmit() {
        submit().click();
    }
}
