package seleniumTests;

import pageObject.SingUpPage;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

public class SingUpTest extends BaseUITest {

    @Test
    @DisplayName("Успешная регистрация")
    public void singUpTest(){
        SingUpPage singUpPage = new SingUpPage(driver);
        driver.get(urlLogin);
        singUpPage.singUp(TestData.generateRandomName(), TestData.generateRandomEmail(), TestData.generateRandomPassword(10));
        Assert.assertEquals(true, singUpPage.successfulSingUp());
    }
    @Test
    @DisplayName("Неуспешная регистрация")
    public void singUpIncorrectPasswordInputTest(){
        SingUpPage singUpPage = new SingUpPage(driver);
        driver.get(urlLogin);
        singUpPage.singUp(TestData.generateRandomName(), TestData.generateRandomEmail(), TestData.generateRandomPassword(2));
        Assert.assertEquals(true, singUpPage.incorrectPasswordErrorCheck());
    }
}
