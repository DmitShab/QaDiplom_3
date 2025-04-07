package seleniumTests;

import org.junit.After;
import org.junit.Before;
import pageObject.SingUpPage;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import testDateApiUser.ApiUser;

public class SingUpTest extends BaseUITest {
    ApiUser apiUser = new ApiUser();
    SingUpPage singUpPage;
    public static String name;
    public static String email;
    public static String password;

    @Before
    public void setUp() {
        singUpPage = new SingUpPage(driver);
        driver.get(urlLogin);
    }

    @After
    public void clear() {
        apiUser.deleteUiUser();
    }

    @Test
    @DisplayName("Успешная регистрация")
    public void singUpTest() {
        name = TestData.generateRandomName();
        email = TestData.generateRandomEmail();
        password = TestData.generateRandomPassword(10);
        singUpPage.singUp(name, email, password);
        Assert.assertTrue(singUpPage.successfulSingUp());
    }

    @Test
    @DisplayName("Неуспешная регистрация")
    public void singUpIncorrectPasswordInputTest() {
        SingUpPage singUpPage = new SingUpPage(driver);
        driver.get(urlLogin);
        name = TestData.generateRandomName();
        email = TestData.generateRandomEmail();
        password = TestData.generateRandomPassword(2);
        singUpPage.singUp(name, email, password);
        Assert.assertTrue(singUpPage.incorrectPasswordErrorCheck());
    }
}
