package Tests;

import PageObject.LogInPage;
import PageObject.SingUpPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

public class LogInTests extends BaseUITest {
    String name;
    String email;
    String password;
    SingUpPage singUpPage;
    LogInPage logInPage;

    //Создание тестовой сущности (Пользователь)
    @Before
    public void setUp() {
        name = TestData.generateRandomName();
        email = TestData.generateRandomEmail();
        password = TestData.generateRandomPassword(10);

        singUpPage = new SingUpPage(driver);
        driver.get(urlLogin);
        singUpPage.singUp(name, email, password);
    }

    @Test
    @DisplayName("Успешный вход через кнопку лендинга 'Войти в аккаунт'")
    public void logInViaLandingLogInButtonTest() {

        driver.get(url);

        logInPage = new LogInPage(driver);
        logInPage.clickLandingLogInButton();
        logInPage.logIn(email, password);
        Assert.assertEquals(true, logInPage.makeOrderButton());
    }

    @Test
    @DisplayName("Успешный вход через кнопку лендинга 'Личный кабинет'")
    public void logInViaAccountButtonTest() {

        driver.get(url);

        LogInPage logInPage = new LogInPage(driver);
        logInPage.clickAccountButton();
        logInPage.logIn(email, password);
        Assert.assertEquals(true, logInPage.makeOrderButton());
    }

    @Test
    @DisplayName("Успешный вход через кнопку в форме регистрации")
    public void logInViaRegistrationButtonTest() {

        driver.get(urlLogin);
        singUpPage.clickSingUp();
        logInPage = new LogInPage(driver);
        logInPage.clickRegistrationLogInButton();
        logInPage.logIn(email, password);
        Assert.assertEquals(true, logInPage.makeOrderButton());
    }

    @Test
    @DisplayName("Успешный вход через кнопку в форме восстановления пароля")
    public void logInViaForgetPasswordButtonTest() {

        driver.get(urlLogin);
        logInPage = new LogInPage(driver);
        logInPage.clickForgetPasswordButton();
        logInPage.clickRegistrationLogInButton();
        logInPage.logIn(email, password);
        Assert.assertEquals(true, logInPage.makeOrderButton());
    }
}
