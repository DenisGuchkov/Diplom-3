package objpages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PersonalAccountPage {

    private final WebDriver driver;
    private final static String personalAccountPage = "https://stellarburgers.nomoreparties.site/";
    private final By
            exitButton = By.xpath("/html/body/div[1]/div/main/div/nav/ul/li[3]/button"),
            logoButton = By.xpath("/html/body/div[1]/div/header/nav/div/a"),
            constructorButton = By.xpath("/html/body/div[1]/div/header/nav/ul/li[1]/a/p");

    public PersonalAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("open personal Account Page")
    public void open() {
    }

    //	выход из аккаунта через кнопку 'выход' в личном кабинете
    @Step("Find And Click exit button on personal account")
    public void clickExitButton() {
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(exitButton));
        driver.findElement(exitButton).click();
    }

    //	переход на главную страницу через символ логотипа в личном кабинете
    @Step("Find And Click logo on personal account")
    public void clickLogoButton() {
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(logoButton));
        driver.findElement(logoButton).click();
    }

    //	переход в раздел конструктор на главной странице через ссылку в личном кабинете
    @Step("Find And Click Constructor Button on personal account")
    public void clickConstructorButton() {
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(constructorButton));
        driver.findElement(constructorButton).click();
    }

    @Step("Find And get text from exit Button on personal account")
    public String checkLogInPersonalAccount() {
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOfElementLocated(exitButton));
        return driver.findElement(exitButton).getText();
    }
}