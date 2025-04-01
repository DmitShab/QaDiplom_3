package PageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
    WebDriver driver;
    //Локатор кнопки Конструктор
    private final By constructorLocator = By.xpath(".//a[@class='AppHeader_header__link__3D_hX' and @href = '/']");
    //Локатор кнопки логотип Stellar Burgers
    private final By stellarBurgers = By.xpath(".//*[@id=\"root\"]/div/header/nav/div/a");
    //Локатор кнопки Соусы
    private final By soucesButton = By.xpath(".//div[@class='tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Соусы']");
    //Локатор кнопки Булки
    private final By bunsButton = By.xpath(".//div[@class='tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Булки']");
    //Локатор кнопки Начинки
    private final By ingredientsButton = By.xpath(".//div[@class='tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Начинки']");

    //Локатор выбранного раздела начинки
//    private final By ingredientsLocator = By.xpath(".//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[@class = 'text text_type_main-default' and text() = 'Ничинки']");
//    //Локатор выбранного раздела булки
//    private final By bunsLocator = By.xpath(".//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[@class = 'text text_type_main-default' and text() = 'Булки']");
//    //Локатор выбранного раздела соусы
//    private final By soucesLocator = By.xpath(".//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[@class = 'text text_type_main-default' and text() = 'Соусы']");

    private final By ingredientsLocator = By.xpath(".//h2[@class='text text_type_main-medium mb-6 mt-10' and text() = 'Начинки']");
    //Локатор выбранного раздела булки
    private final By bunsLocator = By.xpath(".//h2[@class='text text_type_main-medium mb-6 mt-10' and text() = 'Булки']");
    //Локатор выбранного раздела соусы
    private final By soucesLocator = By.xpath(".//h2[@class='text text_type_main-medium mb-6 mt-10' and text() = 'Соусы']");


    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Клик на кнопку конструктор")
    public void clickConstructorButton() {
        WebElement element = driver.findElement(constructorLocator);
        element.click();
    }

    @Step("Клик на stellarBurgers")
    public void clickStellarBurgers() {
        WebElement element = driver.findElement(stellarBurgers);
        element.click();
    }

    @Step("Клик на Булки")
    public void clickBuns() {
        WebElement element = driver.findElement(bunsButton);
        element.click();
    }

    @Step("Клик на Соусы")
    public void clickSouces() {
        WebElement element = driver.findElement(soucesButton);
        element.click();
    }

    @Step("Клик на Начинки")
    public void clickIngredients() {
        WebElement element = driver.findElement(ingredientsButton);
        element.click();
    }
    @Step
    public boolean findSouceElement(){
        WebElement element = driver.findElement(soucesLocator);
        return element.isDisplayed();
    }
    @Step
    public boolean findBunsElement(){
        WebElement element = driver.findElement(bunsLocator);
        return element.isDisplayed();
    }
    @Step
    public boolean findIngredientElement(){
        WebElement element = driver.findElement(bunsLocator);
        return element.isDisplayed();
    }
}
