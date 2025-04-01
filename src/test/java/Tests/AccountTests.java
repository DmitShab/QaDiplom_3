package Tests;

import PageObject.AccountPage;
import PageObject.LogInPage;
import PageObject.SingUpPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

public class AccountTests extends BaseUITest {
    String name;
    String email;
    String password;
    SingUpPage singUpPage;
    LogInPage logInPage;
    AccountPage accountPage;

    //Создание тестовой сущности (Пользователь)
    @Before
    public void setUp() {
        name = TestData.generateRandomName();
        email = TestData.generateRandomEmail();
        password = TestData.generateRandomPassword(10);

        singUpPage = new SingUpPage(driver);
        driver.get(urlLogin);
        singUpPage.singUp(name, email, password);

        //Авторизация
        driver.get(url);

        logInPage = new LogInPage(driver);
        logInPage.clickLandingLogInButton();
        logInPage.logIn(email, password);

        accountPage = new AccountPage(driver);
    }

    @Test
    @DisplayName("Переход с лендинга в Личный кабинет")
    public void goToAccountPage() {
        logInPage.clickAccountButton();
        Assert.assertTrue(accountPage.checkGoToProfilePage());
    }
    @Test
    @DisplayName("Разлогиниться")
    public void logOut() {
        logInPage.clickAccountButton();
        accountPage.clickLogOutButton();
        Assert.assertTrue(driver.findElement(logInPage.logInButton).isDisplayed());
    }
}
