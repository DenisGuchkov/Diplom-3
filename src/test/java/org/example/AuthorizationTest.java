package org.example;

import another.YandexOptions;
import io.qameta.allure.junit4.DisplayName;
import objpages.AuthorizationPage;
import objpages.MainPageBurger;
import objpages.RegistrationPage;
import objpages.ResetPasswordPage;
import another.Generator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class AuthorizationTest {

    //WebDriver driver = new ChromeDriver();//когда нужно в Хроме тестировать
    WebDriver driver = new ChromeDriver(YandexOptions.getYandexOptions());// когда нужно в Яндексе тестировать

    @Before
    public void setUp() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    @Test
    @DisplayName("check Authorization path by Authorization Button at MainPage")
    public void mainPageAuthorizationButtonTest() {
        RegistrationPage objRegistrationPage = new RegistrationPage(driver);
        objRegistrationPage.open();
        objRegistrationPage.createNewUser(Generator.getLogin(), Generator.getEmail(), Generator.getPassword());
        MainPageBurger objMainPageBurger = new MainPageBurger(driver);
        objMainPageBurger.open();
        objMainPageBurger.findCheckAndClickAuthorizationButton();
        AuthorizationPage objAuthorizationPage = new AuthorizationPage(driver);
        objAuthorizationPage.authorization(Generator.getEmail(), Generator.getPassword());
        assertEquals("AuthorizationFailed", "Оформить заказ", objMainPageBurger.findOrderButton());
    }

    @Test
    @DisplayName("check Authorization path by Personal Account Element at MainPage")
    public void authorizationByPersonalAccountTest() {
        RegistrationPage objRegistrationPage = new RegistrationPage(driver);
        objRegistrationPage.open();
        objRegistrationPage.createNewUser(Generator.getLogin(), "1" + Generator.getEmail(), Generator.getPassword());
        MainPageBurger objMainPageBurger = new MainPageBurger(driver);
        objMainPageBurger.open();
        objMainPageBurger.findAndClickPersonalAccountElement();
        AuthorizationPage objAuthorizationPage = new AuthorizationPage(driver);
        objAuthorizationPage.authorization("1" + Generator.getEmail(), Generator.getPassword());
        assertEquals("AuthorizationFailed", "Оформить заказ", objMainPageBurger.findOrderButton());
    }

    @Test
    @DisplayName("check Authorization path by Authorization Link at Registration Page")
    public void authorizationByRegistrationLinkTest() {
        RegistrationPage objRegistrationPage = new RegistrationPage(driver);
        objRegistrationPage.open();
        objRegistrationPage.createNewUser(Generator.getLogin(), "2" + Generator.getEmail(), Generator.getPassword());
        objRegistrationPage.open();
        objRegistrationPage.clickAuthorizationLinkByRegistrationForm();
        AuthorizationPage objAuthorizationPage = new AuthorizationPage(driver);
        objAuthorizationPage.authorization("2" + Generator.getEmail(), Generator.getPassword());
        MainPageBurger objMainPageBurger = new MainPageBurger(driver);
        assertEquals("AuthorizationFailed", "Оформить заказ", objMainPageBurger.findOrderButton());
    }

    @Test
    @DisplayName("check Authorization path by Authorization Link at ResetPassword Page")
    public void authorizationByResetPasswordLinkTest() {
        RegistrationPage objRegistrationPage = new RegistrationPage(driver);
        objRegistrationPage.open();
        objRegistrationPage.createNewUser(Generator.getLogin(), "3" + Generator.getEmail(), Generator.getPassword());
        ResetPasswordPage objResetPasswordPage = new ResetPasswordPage(driver);
        objResetPasswordPage.open();
        objResetPasswordPage.clickAuthorizationLinkByResetPasswordForm();
        AuthorizationPage objAuthorizationPage = new AuthorizationPage(driver);
        objAuthorizationPage.authorization("3" + Generator.getEmail(), Generator.getPassword());
        MainPageBurger objMainPageBurger = new MainPageBurger(driver);
        assertEquals("AuthorizationFailed", "Оформить заказ", objMainPageBurger.findOrderButton());
    }

    @After
    public void teardown() {
        driver.quit();
    }

}
