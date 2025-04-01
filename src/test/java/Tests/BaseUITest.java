package Tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import com.yandex.webdriver.YandexDriver;

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
//    public void initYandex(){
//        System.setProperty("webdriver.yandex.driver", "yandexdriver.exe");
//        driver = new YandexDriver();
    }

