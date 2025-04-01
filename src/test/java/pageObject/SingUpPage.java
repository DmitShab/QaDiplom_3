package pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SingUpPage {
    private WebDriver driver;
    //Локатор поля кнопки "Зарегестрироваться"
    private final By singUpButton = By.xpath(".//a[@class = 'Auth_link__1fOlj' and text() = 'Зарегистрироваться']");
    //Локаторы полей формы регистрации
    private final By nameField = By.xpath(".//fieldset[1]/div/div/input");
    private final By emailField = By.xpath(".//fieldset[2]/div/div/input");
    private final By passwordField = By.xpath(".//fieldset[3]/div/div/input");
    //Локатор кнопка "Зарегестрироваться"
    private final By sungUpButton = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']");
    //Локатор кнопки "Войти" после успешной регистрации
    private final By logInButton = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa' and text() = 'Войти']");
    //Локатор ошибки регистрации при вводе некорректного пароля
    private final By incorrectPasswordError = By.xpath(".//p[@class='input__error text_type_main-default' and text() = 'Некорректный пароль']");

    public SingUpPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Нажатие на кнопку регистрации")
    public void clickSingUp() {
        WebElement element = driver.findElement(singUpButton);
        element.click();
    }

    @Step("Заполнение поля Имя")
    public void fillInName(String name) {
        WebElement element = driver.findElement(nameField);
        element.sendKeys(name);
    }

    @Step("Заполнение поля Имя")
    public void fillInEmail(String email) {
        WebElement element = driver.findElement(emailField);
        element.sendKeys(email);
    }

    @Step("Заполнение поля Имя")
    public void fillInPassword(String password) {
        WebElement element = driver.findElement(passwordField);
        element.sendKeys(password);
    }

    @Step("Нажать кнопку зарегистрировать")
    public void clickSingUpAfterFillingIn() {
        WebElement element = driver.findElement(sungUpButton);
        element.click();
    }

    @Step("Возврат на главную страницу после успешной регистрации")
    public boolean successfulSingUp() {
        WebElement element = driver.findElement(logInButton);
        return element.isDisplayed();
    }

    @Step("Проверка отдлачи ошибки Некорректный пароль")
    public boolean incorrectPasswordErrorCheck() {
        WebElement element = driver.findElement(incorrectPasswordError);
        return element.isDisplayed();
    }


    //Общий шаг для успешной Регистрации
    public void singUp(String name, String email, String password) {
        clickSingUp();
        fillInName(name);
        fillInEmail(email);
        fillInPassword(password);
        clickSingUpAfterFillingIn();
    }
}
