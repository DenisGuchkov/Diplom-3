package org.example;

import io.qameta.allure.junit4.DisplayName;
import objpages.MainPageBurger;
import another.YandexOptions;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import static org.junit.Assert.assertTrue;

public class CheckConstructorLinksTest {

//WebDriver driver = new ChromeDriver();//когда нужно в Хроме тестировать
WebDriver driver = new ChromeDriver(YandexOptions.getYandexOptions());// когда нужно в Яндексе тестировать

    @Test
    @DisplayName("check Constructor Sauce Link at MainPage")
    public void checkSauceLink() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        MainPageBurger objMainPageBurger = new MainPageBurger(driver);
        objMainPageBurger.open();
        assertTrue("Error in section Links-Sauce",  objMainPageBurger.checkSauceLinkDisplayed());
    }

    @Test
    @DisplayName("check Constructor Buns Link at MainPage")
    public void checkBunsLink() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        MainPageBurger objMainPageBurger = new MainPageBurger(driver);
        objMainPageBurger.open();
        assertTrue("Error in section Links-Buns",  objMainPageBurger.checkBunsLinkDisplayed());
    }

    @Test
    @DisplayName("check Constructor Stuffing Link at MainPage")
    public void checkStuffingLink() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        MainPageBurger objMainPageBurger = new MainPageBurger(driver);
        objMainPageBurger.open();
        assertTrue("Error in section Links-Stuffing",  objMainPageBurger.checkStuffingLinkDisplayed());
    }

  @After       // Закрыть браузер
 public void teardown() {
   driver.quit();
    }

}