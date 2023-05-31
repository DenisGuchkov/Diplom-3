package objpages;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPageBurger {

    private final WebDriver driver;
    private final static String mainPage = "https://stellarburgers.nomoreparties.site/";

    public final By
            authorizationButton = By.xpath(".//*[text() = 'Войти в аккаунт']"),
            personalAccountElement = By.xpath("html/body/div[1]/div/header/nav/a/p"),
            ingredientSauceLink = By.xpath("/html/body/div[1]/div/main/section[1]/div[1]/div[2]/span"),

            ingredientStuffingLink = By.xpath("/html/body/div[1]/div/main/section[1]/div[1]/div[3]/span"),

            ingredientBunsLink = By.xpath("/html/body/div[1]/div/main/section[1]/div[1]/div[1]/span"),
            menu = By.xpath("//div[contains(@class,'tab_tab__1SPyG tab_tab_type_current__2BEPc')]"),

            orderButton = By.xpath(".//*[text() = 'Оформить заказ']");

    public MainPageBurger(WebDriver driver) {
        this.driver = driver;
    }

    @Step("open main Page")
    public void open() {
        driver.get(mainPage);
    }

    // 	вход по кнопке «Войти в аккаунт» на главной
    @Step("Find, Check And Click Authorization Button on mainPage")
    public void findCheckAndClickAuthorizationButton() {
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOfElementLocated(authorizationButton));
        Object elementAuthorizationButton = driver.findElement(authorizationButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", elementAuthorizationButton);
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(authorizationButton));
        driver.findElement(authorizationButton).click();
    }

    // 	вход в личный кабинет
    @Step("Find And Click Personal Account Element on mainPage")
    public void findAndClickPersonalAccountElement() {
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(personalAccountElement));
        driver.findElement(personalAccountElement).click();
    }

    // загрузка стартовой страницы после авторизации и наличие кнопки "Оформить заказ"
    @Step("Find And get text from Order Button on mainPage")
    public String findOrderButton() {
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOfElementLocated(orderButton));
        return driver.findElement(orderButton).getText();
    }

    // метод того что при нажатии ссылки соусов меню автоматически скролится до соусов
    @Step("Find And Click SauceLink on mainPage, check Sauce Element")
    public String getTextByCurrentIngredient(By ingredientLink) {
        driver.findElement(ingredientLink).click();
        var text = driver.findElement(menu).getText();
        return text;
    }

}

