package Tests;

import PageObject.LandingPage;
import PageObject.LogInPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import testDateApiUser.ApiUser;
import testDateApiUser.PostRequestSignUPPOJO;

public class LandingPageTest extends BaseUITest {

    LogInPage logInPage;
    LandingPage constructorPage;
    ApiUser apiUser = new ApiUser();
    PostRequestSignUPPOJO postRequestSignUPPOJO;

    //Создание тестовой сущности (Пользователь)
    @Before
    public void setUp() {
        postRequestSignUPPOJO = new PostRequestSignUPPOJO(TestData.generateRandomName(), TestData.generateRandomEmail(), TestData.generateRandomPassword(10));
        apiUser.signUp(postRequestSignUPPOJO);

        //Авторизация
        driver.get(url);

        logInPage = new LogInPage(driver);
        logInPage.clickLandingLogInButton();
        logInPage.logIn(postRequestSignUPPOJO.getEmail(), postRequestSignUPPOJO.getPassword());

        //Переход в Личный кабинет
        logInPage.clickAccountButton();
    }
    //Удаление тестовой сущности
    @After
    public void clear() {
        apiUser.deleteUser();
    }

    @Test
    @DisplayName("Переход из 'Личный кабинет' на лендинг через кнопку 'Конструктор'")
    public void goToLandingPageTest() {
        constructorPage = new LandingPage(driver);
        constructorPage.clickConstructorButton();
        Assert.assertEquals(true, logInPage.makeOrderButton());
    }

    @Test
    @DisplayName("Переход из 'Личный кабинет' на лендинг через логотип 'StellarBurgers'")
    public void goToLandingPage1Test() {
        constructorPage = new LandingPage(driver);
        constructorPage.clickStellarBurgers();
        Assert.assertEquals(true, logInPage.makeOrderButton());
    }

    @Test
    @DisplayName("переход в раздел соусы")
    public void goToSoucesTest() {
        constructorPage = new LandingPage(driver);
        constructorPage.clickConstructorButton();
        constructorPage.clickSouces();
        Assert.assertTrue(constructorPage.findSouceElement());
    }

    @Test
    @DisplayName("переход в раздел булки")
    public void goToBunsTest() {
        constructorPage = new LandingPage(driver);
        constructorPage.clickConstructorButton();
        constructorPage.clickSouces();
        constructorPage.clickIngredients();
        Assert.assertTrue(constructorPage.findBunsElement());
    }

    @Test
    @DisplayName("переход в раздел начинки")
    public void goToIngredientsTest() {
        constructorPage = new LandingPage(driver);
        constructorPage.clickConstructorButton();
        constructorPage.clickIngredients();
        Assert.assertTrue(constructorPage.findIngredientElement());
    }
}
