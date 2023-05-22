package objpages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class RegistrationPage {

    private final WebDriver driver;
    private final static String registrationPage = "https://stellarburgers.nomoreparties.site/register";

    private final By

            userNameRegistration = By.xpath("/html/body/div[1]/div/main/div/form/fieldset[1]/div/div/input"),
            userEmailRegistration = By.xpath("/html/body/div[1]/div/main/div/form/fieldset[2]/div/div/input"),
            userPasswordRegistration = By.xpath("/html/body/div[1]/div/main/div/form/fieldset[3]/div/div/input"),
            registrationButton = By.xpath("/html/body/div[1]/div/main/div/form/button"),
            errorMessage = By.xpath("//*[contains(text(), 'Некорректный пароль')]"),
            authorizationLinkByRegistrationForm = By.xpath("/html/body/div[1]/div/main/div/div/p/a");

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("open registration Page")
    public void open (){
        driver.get(registrationPage);
    }

    @Step("Filling out and check the registration form")
    public void createNewUser(String login, String email, String password) {
        driver.findElement(userNameRegistration).clear();
        driver.findElement(userNameRegistration).sendKeys(login);
        driver.findElement(userEmailRegistration).clear();
        driver.findElement(userEmailRegistration).sendKeys(email);
        driver.findElement(userPasswordRegistration).clear();
        driver.findElement(userPasswordRegistration).sendKeys(password);
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(registrationButton));
        driver.findElement(registrationButton).click();
        try{
            Thread.sleep(1000);
        }
        catch(InterruptedException ie){
        }
    }

    //	вход через кнопку в форме регистрации
    @Step("Find And Click Authorization Link on registration Page")
    public void clickAuthorizationLinkByRegistrationForm (){
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(authorizationLinkByRegistrationForm));
        driver.findElement(authorizationLinkByRegistrationForm).click();
    }

    // наличие сообщения об ошибке пароля
    @Step("Find Error Message at registration form, check Error Message")
    public boolean findErrorMessage () {
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
        try {
            return driver.findElement(errorMessage).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
// текст ошибки
    @Step("Find And get Error Message text")
    public String checkErrorMessage () {
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
        return driver.findElement(errorMessage).getText();

    }

}
