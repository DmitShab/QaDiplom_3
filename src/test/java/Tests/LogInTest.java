package Tests;

import PageObject.LogInPage;
import PageObject.SingUpPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import testDateApiUser.ApiUser;
import testDateApiUser.PostRequestSignUPPOJO;

public class LogInTest extends BaseUITest {

    SingUpPage singUpPage;
    LogInPage logInPage;
    ApiUser apiUser = new ApiUser();
    PostRequestSignUPPOJO postRequestSignUPPOJO;

    //Создание тестовой сущности (Пользователь)
    @Before
    public void setUp() {
        postRequestSignUPPOJO = new PostRequestSignUPPOJO(TestData.generateRandomName(), TestData.generateRandomEmail(), TestData.generateRandomPassword(10));
        apiUser.signUp(postRequestSignUPPOJO);
    }
    //Удаление тестовой сущности
    @After
    public void clear(){
        apiUser.deleteUser();
    }
    @Test
    @DisplayName("Успешный вход через кнопку лендинга 'Войти в аккаунт'")
    public void logInViaLandingLogInButtonTest() {

        driver.get(url);

        logInPage = new LogInPage(driver);
        logInPage.clickLandingLogInButton();
        logInPage.logIn(postRequestSignUPPOJO.getEmail(), postRequestSignUPPOJO.getPassword());
        Assert.assertEquals(true, logInPage.makeOrderButton());
    }

    @Test
    @DisplayName("Успешный вход через кнопку лендинга 'Личный кабинет'")
    public void logInViaAccountButtonTest() {

        driver.get(url);

        LogInPage logInPage = new LogInPage(driver);
        logInPage.clickAccountButton();
        logInPage.logIn(postRequestSignUPPOJO.getEmail(), postRequestSignUPPOJO.getPassword());
        Assert.assertEquals(true, logInPage.makeOrderButton());
    }

    @Test
    @DisplayName("Успешный вход через кнопку в форме регистрации")
    public void logInViaRegistrationButtonTest() {

        driver.get(urlLogin);
        singUpPage = new SingUpPage(driver);
        singUpPage.clickSingUp();
        logInPage = new LogInPage(driver);
        logInPage.clickRegistrationLogInButton();
        logInPage.logIn(postRequestSignUPPOJO.getEmail(), postRequestSignUPPOJO.getPassword());
        Assert.assertEquals(true, logInPage.makeOrderButton());
    }

    @Test
    @DisplayName("Успешный вход через кнопку в форме восстановления пароля")
    public void logInViaForgetPasswordButtonTest() {

        driver.get(urlLogin);
        logInPage = new LogInPage(driver);
        logInPage.clickForgetPasswordButton();
        logInPage.clickRegistrationLogInButton();
        logInPage.logIn(postRequestSignUPPOJO.getEmail(), postRequestSignUPPOJO.getPassword());
        Assert.assertEquals(true, logInPage.makeOrderButton());
    }
}
