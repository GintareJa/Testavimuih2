package lt.techin.stud;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;


public class BasePageTest {

    protected WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new EdgeDriver();
//        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost:8080/prisijungti");
        //driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @AfterEach
    public void close() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        if (driver != null) {
            driver.quit();
        }
    }
}