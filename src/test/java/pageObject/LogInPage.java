package pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogInPage {
    WebDriver driver;

    public LogInPage(WebDriver driver) {
        this.driver = driver;
    }

    //Локатор кнопки "войти в аккаунт" на лендинге
    private final By LandingLogInButton = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg' and text() = 'Войти в аккаунт']");
    //Локатор поля email
    private final By emailLocator = By.xpath(".//fieldset[1]/div/div/input");
    //Локатор поля пароль
    private final By passwordLocator = By.xpath(".//fieldset[2]/div/div/input");
    //Локатор поля "войти" на странице "вход"
    public final By logInButton = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa' and text() = 'Войти']");
    //Локатор кнопки "Личный кабинет"
    private final By accountButton = By.xpath(".//a[@class = 'AppHeader_header__link__3D_hX' and @href = '/account']");
    //Локатор кнопки восстановить пароль
    private final By forgetPasswordButton = By.xpath(".//a[@class = 'Auth_link__1fOlj' and @href = '/forgot-password']");
    //Локатор кнопки войти в форме регистрации
    private final By registrationLogInButton = By.xpath(".//a[@class = 'Auth_link__1fOlj' and text() = 'Войти']");
    //Локатор кнопки "оформить заказ"
    private final By makeOrder = By.xpath(".//button[text() = 'Оформить заказ']");

    @Step("Нажали на кнопку 'войти в аккаунт' на лендинге ")
    public void clickLandingLogInButton() {
        WebElement element = driver.findElement(LandingLogInButton);
        element.click();
    }

    @Step("Заполнили поле Email")
    public void fillInEmailField(String email) {
        WebElement element = driver.findElement(emailLocator);
        element.sendKeys(email);
    }

    @Step("Заполнили поле Пароль")
    public void fillInPasswordField(String password) {
        WebElement element = driver.findElement(passwordLocator);
        element.sendKeys(password);
    }

    @Step("Нажали на кнопку 'войти' на странице вход")
    public void clickLogInButton() {
        WebElement element = driver.findElement(logInButton);
        element.click();
    }

    @Step("Нажали на кнопку 'Личный кабинет'")
    public void clickAccountButton() {
        WebElement element = driver.findElement(accountButton);
        element.click();
    }

    @Step("Нажали на кнопку 'Личный кабинет'")
    public void clickRegistrationLogInButton() {
        WebElement element = driver.findElement(registrationLogInButton);
        element.click();
    }

    @Step("Нажали на кнопку 'Восстановить пароль' на странице вход")
    public void clickForgetPasswordButton() {
        WebElement element = driver.findElement(forgetPasswordButton);
        element.click();
    }

    @Step("Проверка перехода на лендинг будучи авторизованным")
    public boolean makeOrderButton() {
        WebElement element = driver.findElement(makeOrder);
        return element.isDisplayed();
    }

    //Общиий шаг входа
    public void logIn(String email, String password) {
        fillInEmailField(email);
        fillInPasswordField(password);
        clickLogInButton();
    }
}
