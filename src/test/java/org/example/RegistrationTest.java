package org.example;

import another.YandexOptions;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import objpages.AuthorizationPage;
import objpages.MainPageBurger;
import objpages.RegistrationPage;
import another.Generator;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.Assert.assertEquals;


public class RegistrationTest {

    //WebDriver driver = new ChromeDriver();//когда нужно в Хроме тестировать
    WebDriver driver = new ChromeDriver(YandexOptions.getYandexOptions());// когда нужно в Яндексе тестировать


    @Test
    @DisplayName("check Registration - creating user")
    @Description("registration with valid password - 6 symbols")
    public void checkRegistrationTest() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        RegistrationPage objRegistrationPage = new RegistrationPage(driver);
        objRegistrationPage.open();
        objRegistrationPage.createNewUser(Generator.getLogin(), "9" + Generator.getEmail(), Generator.getPassword());
        AuthorizationPage objAuthorizationPage = new AuthorizationPage(driver);
        objAuthorizationPage.authorization("9" + Generator.getEmail(), Generator.getPassword());
        MainPageBurger objMainPageBurger = new MainPageBurger(driver);
        assertEquals("RegistrationFailed", "Оформить заказ", objMainPageBurger.findOrderButton());
    }

    @Test
    @DisplayName("check Registration - check Error Massage")
    @Description("registration with invalid password - 5 symbols")
    public void checkErrorMassageTest() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        RegistrationPage objRegistrationPage = new RegistrationPage(driver);
        objRegistrationPage.open();
        objRegistrationPage.createNewUser(Generator.getLogin(), Generator.getEmail(), "12345");
        objRegistrationPage.findErrorMessage();
        assertEquals("Error Massage Failed", "Некорректный пароль", objRegistrationPage.checkErrorMessage());
    }

    @After
    public void teardown() {
        driver.quit();
    }

}
