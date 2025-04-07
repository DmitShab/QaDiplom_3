package seleniumTests;

import pageObject.AccountPage;
import pageObject.LogInPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import testDateApiUser.ApiUser;
import testDateApiUser.PostRequestSignUPPOJO;

public class AccountTest extends BaseUITest {
    LogInPage logInPage;
    AccountPage accountPage;
    ApiUser apiUser = new ApiUser();
    PostRequestSignUPPOJO postRequestSignUPPOJO;

    @Before
    public void setUp() {
        //Создание тестовой сущности
        postRequestSignUPPOJO = new PostRequestSignUPPOJO(TestData.generateRandomName(), TestData.generateRandomEmail(), TestData.generateRandomPassword(10));
        apiUser.signUp(postRequestSignUPPOJO);

        //Авторизация
        driver.get(url);
        logInPage = new LogInPage(driver);
        logInPage.clickLandingLogInButton();
        logInPage.logIn(postRequestSignUPPOJO.getEmail(), postRequestSignUPPOJO.getPassword());

        accountPage = new AccountPage(driver);
    }

    //Удаление тестовой сущности
    @After
    public void clear() {
        apiUser.deleteUser();
    }


    @Test
    @DisplayName("Переход с лендинга в Личный кабинет")
    public void goToAccountPageTest() {
        logInPage.clickAccountButton();
        Assert.assertTrue(accountPage.checkGoToProfilePage());
    }

    @Test
    @DisplayName("Разлогиниться")
    public void logOutTest() {
        logInPage.clickAccountButton();
        accountPage.clickLogOutButton();
        Assert.assertTrue(driver.findElement(logInPage.logInButton).isDisplayed());
    }
}
