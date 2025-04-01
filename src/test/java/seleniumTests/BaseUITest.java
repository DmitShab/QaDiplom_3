package seleniumTests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class BaseUITest {
    WebDriver driver;

    public final String url = "https://stellarburgers.nomoreparties.site/";
    public final String urlLogin = "https://stellarburgers.nomoreparties.site/login";

    @Before
    public void createDriver() {
        initChrome();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    public void initChrome() {
        driver = new ChromeDriver();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    public void initYandex() {
        System.setProperty("webdriver.yandex.driver", "yandexdriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:/Users/Dmitry/AppData/Local/Yandex/YandexBrowser/Application/browser.exe");
//        options.setBinary(System.getProperty("C:/Users/Dmitry/WebDriver/bin/yandexdriver.exe"));
        driver = new ChromeDriver(options);
    }
}

//Yandex driver
//* Путь до бинарника скачанного с https://github.com/yandex/YandexDriver/releases  */
//        System.setProperty("webdriver.chrome.driver", "yandexdriver.exe");
//ChromeOptions options = new ChromeOptions();
//* Путь до яндекс браузера. Такой путь не сможет запустить никто кроме вас */
//options.setBinary("C:\\Users\\Dmitry\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
//* Поэтому лучше передавать путь через переменную maven
// * mvn clean test -DyandexDriverPath=путь до драйвера
// * mvn clean test -DyandexDriverPath=C:\Users\Dmitry\AppData\Local\Yandex\YandexBrowser\Application\browser.exe*/
//        options.setBinary(System.getProperty("yandexDriverPath"));
//ChromeDriver driver = new ChromeDriver(options);
//        driver.get("https://github.com/yandex/YandexDriver/releases");