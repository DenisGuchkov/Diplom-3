package org.example;

import io.qameta.allure.junit4.DisplayName;
import objpages.AuthorizationPage;
import objpages.MainPageBurger;
import objpages.PersonalAccountPage;
import objpages.RegistrationPage;
import another.Generator;
import another.YandexOptions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import static org.junit.Assert.assertEquals;

public class PersonalAccountPageTest {

    //WebDriver driver = new ChromeDriver();//когда нужно в Хроме тестировать
    WebDriver driver = new ChromeDriver(YandexOptions.getYandexOptions());// когда нужно в Яндексе тестировать

    @Before
    public void setUp(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        }

    @Test
    @DisplayName("check enter in Personal Account")
    public void checkPersonalAccountLinkTest() {
        RegistrationPage objRegistrationPage = new RegistrationPage(driver);
        objRegistrationPage.open();
        objRegistrationPage.createNewUser(Generator.getLogin(), "4" + Generator.getEmail(), Generator.getPassword());
        AuthorizationPage objAuthorizationPage = new AuthorizationPage(driver);
        objAuthorizationPage.authorization("4" + Generator.getEmail(), Generator.getPassword());
        MainPageBurger objMainPageBurger = new MainPageBurger(driver);
        objMainPageBurger.findAndClickPersonalAccountElement();
        PersonalAccountPage objPersonalAccountPage = new PersonalAccountPage(driver);
        assertEquals("PersonalAccountEnterLinkFailed", "Выход", objPersonalAccountPage.checkLogInPersonalAccount());
    }

    @Test
    @DisplayName("check exit from Account by Link at Personal Account")
    public void checkExitButtonTest() {
        RegistrationPage objRegistrationPage = new RegistrationPage(driver);
        objRegistrationPage.open();
        objRegistrationPage.createNewUser(Generator.getLogin(), "5" + Generator.getEmail(), Generator.getPassword());
        AuthorizationPage objAuthorizationPage = new AuthorizationPage(driver);
        objAuthorizationPage.authorization("5" + Generator.getEmail(), Generator.getPassword());
        MainPageBurger objMainPageBurger = new MainPageBurger(driver);
        objMainPageBurger.findAndClickPersonalAccountElement();
        PersonalAccountPage objPersonalAccountPage = new PersonalAccountPage(driver);
        objPersonalAccountPage.clickExitButton();
        assertEquals("ExitFailed", "Войти", objAuthorizationPage.checkLoginButton());
    }

    @Test
    @DisplayName("check exit to MainPage by Logo at Personal Account")
    public void checkLogoButtonTest() {
        RegistrationPage objRegistrationPage = new RegistrationPage(driver);
        objRegistrationPage.open();
        objRegistrationPage.createNewUser(Generator.getLogin(), "6" + Generator.getEmail(), Generator.getPassword());
        AuthorizationPage objAuthorizationPage = new AuthorizationPage(driver);
        objAuthorizationPage.authorization("6" + Generator.getEmail(), Generator.getPassword());
        MainPageBurger objMainPageBurger = new MainPageBurger(driver);
        objMainPageBurger.findAndClickPersonalAccountElement();
        PersonalAccountPage objPersonalAccountPage = new PersonalAccountPage(driver);
        objPersonalAccountPage.clickLogoButton();
        assertEquals("LogoButtonFailed", "Оформить заказ", objMainPageBurger.findOrderButton());
    }

    @Test
    @DisplayName("check exit to MainPage by Constructor Button at Personal Account")
    public void checkConstructorButtonTest() {
        RegistrationPage objRegistrationPage = new RegistrationPage(driver);
        objRegistrationPage.open();
        objRegistrationPage.createNewUser(Generator.getLogin(), "7" + Generator.getEmail(), Generator.getPassword());
        AuthorizationPage objAuthorizationPage = new AuthorizationPage(driver);
        objAuthorizationPage.authorization("7" + Generator.getEmail(), Generator.getPassword());
        MainPageBurger objMainPageBurger = new MainPageBurger(driver);
        objMainPageBurger.findAndClickPersonalAccountElement();
        PersonalAccountPage objPersonalAccountPage = new PersonalAccountPage(driver);
        objPersonalAccountPage.clickConstructorButton();
        assertEquals("ConstructorButtonFailed", "Оформить заказ", objMainPageBurger.findOrderButton());
    }

        @After       // Закрыть браузер
    public void teardown() {
        driver.quit();
    }
}
