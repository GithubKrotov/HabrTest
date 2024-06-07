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
    // Тест, проверяющий наличие текста на странице после перехода на неё через тег из статьи

    public void nextPageFromTag() {

        WebElement tagLink = driver.findElement(By.cssSelector("span.tm-publication-hub__link-container"));
        tagLink.click();

        WebElement nextPageText = driver.findElement(By.xpath("//*[contains(text(), 'Офисы IT-компаний')]"));

       // assertTrue(driver.findElement(By.cssSelector('#app > div > div.tm-layout > main > div > div > div > div.tm-page__main.tm-page__main_has-sidebar > div > div.tm-page__top > div.tm-hub-card.tm-hub-card.tm-hub-card_va
    }

    @Test
    // Тест ддя перехода в поиск из статьи и поиска материалов по заданному слову
    public void searchFromPage() {

        WebElement searchButton = driver.findElement(By.cssSelector("svg.tm-svg-img tm-header-user-menu__icon tm-header-user-menu__icon_search"));
        searchButton.click();

        WebElement searchBar = driver.findElement(By.cssSelector("div.tm-input-text-decorated tm-input-text-decorated_has-label-after tm-search__input"));
        searchBar.sendKeys("Тестирование");

    }
    //
}
