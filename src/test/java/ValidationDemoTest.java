import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ValidationDemoTest {
    String baseUrl = "http://demo.guru99.com/V1/index.php";
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void initial(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 20);
    }


    @Test
    public void findElements(){
        driver.get(baseUrl);
        WebElement usernameControl = driver.findElement(By.name("uid"));
        WebElement passwordControl = driver.findElement(By.name("password"));
        WebElement misc = driver.findElement(By.cssSelector("body"));
        WebElement userValidationMessage = driver.findElement(By.id("message23"));
        WebElement passwordValidationMessage = driver.findElement(By.id("message18"));

        System.out.println(userValidationMessage.getAttribute("style"));
        System.out.println(passwordValidationMessage.getAttribute("style"));

        usernameControl.click();
        passwordControl.click();
        misc.click();

        System.out.println(userValidationMessage.getAttribute("style"));
        System.out.println(passwordValidationMessage.getAttribute("style"));

        usernameControl.sendKeys("a");
        passwordControl.sendKeys("a");

        System.out.println(userValidationMessage.getAttribute("style"));
        System.out.println(passwordValidationMessage.getAttribute("style"));
    }

    @AfterClass
    public void close(){
        driver.quit();
    }
}
