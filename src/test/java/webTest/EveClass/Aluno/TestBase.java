package webTest.EveClass.Aluno;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class TestBase {

    protected WebDriver driver;
    protected Map<String, Object> vars;
    protected JavascriptExecutor js;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        System.setProperty("webdriver.chrome.driver", "drivers/chrome/chromedriver.exe");
        driver = new ChromeDriver(options);
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
        driver.manage().window().maximize();
    }

    @AfterEach
    public void tearDown() throws InterruptedException {
        Thread.sleep(10000); // espera por 3 segundos
        driver.quit();
    }

    public void botaoComecarAgoraClick()  {
        // Aciona o botão "Começar Agora"
        driver.findElement(By.cssSelector(".button-custom:nth-child(4) > .button-text > span > span")).click();
    }

}
