package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;

public class LoginPage extends BasePage {

    public LoginPage() throws MalformedURLException, InterruptedException {
//        WebDriverWait wait = new WebDriverWait(driverPage, 30);
//        wait.until(ExpectedConditions.elementToBeClickable(By
//                .xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.view.View[1]/android.widget.EditText[2]")));
        Thread.sleep(20000);
        driverPage.context("WEBVIEW_com.thoughtworks.recruitx");
    }



    private WebElement userNameTextBox() {
//        return driverPage.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.view.View[1]/android.widget.EditText[2]"));
        return driverPage.findElement(By.name("username"));
    }

    private WebElement passWordTextBox() {
//        return driverPage.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.view.View[1]/android.widget.EditText[3]"));
        return driverPage.findElement(By.name("password"));
    }

    private WebElement submit() {
//        return driverPage.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.view.View[1]/android.widget.Button[1]"));
        return driverPage.findElement(By.cssSelector("input[value='Sign In']"));
    }

    private WebElement experienceTextBox() {
        return driverPage.findElement(By.cssSelector("input[ng-model='data.experience']"));
    }

    private WebElement experienceSubmit() {
        return driverPage.findElement(By.cssSelector("button.ng-binding"));
    }

    public void setLogin(String userName) {
        userNameTextBox().click();
        userNameTextBox().sendKeys(userName);
    }

    public void setPassword(String password) {
        passWordTextBox().click();
        passWordTextBox().sendKeys(password);
    }

    public void clickSubmit() {
//        userNameTextBox().submit();
        submit().click();
    }

    public void setExperience(String experienceValue) {
        experienceTextBox().sendKeys(experienceValue);
    }



    public void submitExperience() {
        experienceSubmit().click();
    }


}
