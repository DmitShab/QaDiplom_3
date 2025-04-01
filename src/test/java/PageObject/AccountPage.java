package PageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountPage {
    WebDriver driver;
    //Локатор кнопки "личный кабинет"
    private final By profileButton = By.xpath(".//ul[@class='Profile_profileList__3vTor']");
    //Локатор кнопки "Выход"
    private final By logOutButton = By.xpath(".//button[@type='button' and text() = 'Выход']");
    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Проверка перехода на страницу профиля будучи авторизованным")
    public boolean checkGoToProfilePage() {
        WebElement element = driver.findElement(profileButton);
        return element.isDisplayed();
    }
    @Step("Клик на кнопку 'Выход'")
    public void clickLogOutButton(){
        WebElement element = driver.findElement(logOutButton);
        element.click();
    }
}
