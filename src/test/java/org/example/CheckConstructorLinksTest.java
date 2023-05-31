package org.example;

import io.qameta.allure.junit4.DisplayName;
import objpages.MainPageBurger;
import another.YandexOptions;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class CheckConstructorLinksTest {

WebDriver driver = new ChromeDriver();//когда нужно в Хроме тестировать
//WebDriver driver = new ChromeDriver(YandexOptions.getYandexOptions());// когда нужно в Яндексе тестировать

    @Test
    @DisplayName("check Constructor Sauce Link at MainPage")
    public void checkSauceLink() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        MainPageBurger objMainPageBurger = new MainPageBurger(driver);
        objMainPageBurger.open();
        assertEquals("Соусы", objMainPageBurger.getTextByCurrentIngredient(objMainPageBurger.ingredientSauceLink));
    }

    @Test
    @DisplayName("check Constructor Buns Link at MainPage")
    public void checkBunsLink() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        MainPageBurger objMainPageBurger = new MainPageBurger(driver);
        objMainPageBurger.open();
        driver.findElement(objMainPageBurger.ingredientStuffingLink).click(); //(сначала отмотаем меню тк булки и так стартовые)
        assertEquals("Булки", objMainPageBurger.getTextByCurrentIngredient(objMainPageBurger.ingredientBunsLink));
    }

    @Test
    @DisplayName("check Constructor Stuffing Link at MainPage")
    public void checkStuffingLink() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        MainPageBurger objMainPageBurger = new MainPageBurger(driver);
        objMainPageBurger.open();
        assertEquals("Начинки", objMainPageBurger.getTextByCurrentIngredient(objMainPageBurger.ingredientStuffingLink));
    }

  @After       // Закрыть браузер
 public void teardown() {
   driver.quit();
    }

}