package Tests;

import PageObject.AccountPage;
import PageObject.LandingPage;
import PageObject.LogInPage;
import PageObject.SingUpPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;

public class LandingPageTests extends BaseUITest {

    LogInPage logInPage;
    LandingPage constructorPage;
    String name;
    String email;
    String password;
    SingUpPage singUpPage;
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

        //Переход в Личный кабинет
        logInPage.clickAccountButton();
    }

    @Test
    @DisplayName("Переход из 'Личный кабинет' на лендинг через кнопку 'Конструктор'")
    public void goToLandingPage() {
        constructorPage = new LandingPage(driver);
        constructorPage.clickConstructorButton();
        Assert.assertEquals(true, logInPage.makeOrderButton());
    }
    @Test
    @DisplayName("Переход из 'Личный кабинет' на лендинг через логотип 'StellarBurgers'")
    public void goToLandingPage1() {
        constructorPage = new LandingPage(driver);
        constructorPage.clickStellarBurgers();
        Assert.assertEquals(true, logInPage.makeOrderButton());
    }
    @Test
    @DisplayName("переход в раздел соусы")
    public void goToSouces(){
        constructorPage = new LandingPage(driver);
        constructorPage.clickConstructorButton();
        constructorPage.clickSouces();
        Assert.assertTrue(constructorPage.findSouceElement());
    }
    @Test
    @DisplayName("переход в раздел булки")
    public void goToBuns(){
        constructorPage = new LandingPage(driver);
        constructorPage.clickConstructorButton();
        constructorPage.clickSouces();
        constructorPage.clickIngredients();
        Assert.assertTrue(constructorPage.findBunsElement());
    }
    @Test
    @DisplayName("переход в раздел начинки")
    public void goToIngredients(){
        constructorPage = new LandingPage(driver);
        constructorPage.clickConstructorButton();
        constructorPage.clickIngredients();
        Assert.assertTrue(constructorPage.findIngredientElement());
    }
}
