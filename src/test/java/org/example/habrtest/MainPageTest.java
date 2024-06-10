package org.example.habrtest;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class MainPageTest {
    private WebDriver driver;


    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        // Fix the issue https://github.com/SeleniumHQ/selenium/issues/11750
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://habr.com/ru/news/820315/");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    // Тест, ищущий текст на странице, после перехода на неё по тегу

    public void nextPageFromTag() {
        WebElement tagLink = driver.findElement(By.cssSelector("span.tm-publication-hub__link-container"));
        tagLink.click();

        WebElement nextPageText = driver.findElement(By.xpath("//*[contains(text(), 'Офисы IT-компаний')]"));
    }

    @Test
    // Тест для перехода на личную страницу автора и поиск его публикаций
    public void findAuthorPublications () {
        WebElement findAuthor = driver.findElement(By.xpath("//*[contains(text(), 'IgnatChuker')]"));
        findAuthor.click();

        WebElement findPublications = driver.findElement(By.xpath("//*[contains(text(), 'Публикации')]"));
        findPublications.click();
    }
    //
}
