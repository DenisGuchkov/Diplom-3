package objpages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AuthorizationPage {
    private final WebDriver driver;
    private final static String authorizationPage = "https://stellarburgers.nomoreparties.site/login";
    private final By
            userEmailAuthorization = By.xpath("/html/body/div/div/main/div/form/fieldset[1]/div/div/input"),
            userPasswordAuthorization = By.xpath("/html/body/div[1]/div/main/div/form/fieldset[2]/div/div/input"),
            loginButton = By.xpath("/html/body/div/div/main/div/form/button"),
            registrationLink = By.xpath("/html/body/div[1]/div/main/div/div/p[1]/a");

        public AuthorizationPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("open authorization Page")
    public void open (){
        driver.get(authorizationPage);
    }

    @Step("Filling out and check the authorization form")
    public void authorization (String email, String password){
        try{
            Thread.sleep(1000);
        }
        catch(InterruptedException ie){
        }
        driver.findElement(userEmailAuthorization).clear();
        driver.findElement(userEmailAuthorization).sendKeys(email);
        driver.findElement(userPasswordAuthorization).clear();
        driver.findElement(userPasswordAuthorization).sendKeys(password);
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(loginButton));
        driver.findElement(loginButton).click();
        }

    @Step("Find And Click Registration Link on authorizationPage")
    public void clickRegistrationLink (){
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(registrationLink));
        driver.findElement(registrationLink).click();
    }

    @Step("Find And get text from authorization Button on authorizationPage")
    public String checkLoginButton () {
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOfElementLocated(loginButton));
        return driver.findElement(loginButton).getText();
    }
}
