import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AlertDemoTest {
    public WebDriver driver;
    public WebDriverWait wait;
    public String baseUrl = "http://demo.guru99.com/test/delete_customer.php";

    @BeforeClass
    public void openSite(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 20);
        driver.get(baseUrl);
    }


    @Test
    public void existElement(){

        driver.findElement(By.name("cusid")).sendKeys("53920");
        driver.findElement(By.name("submit")).click();

        wait.until(ExpectedConditions.alertIsPresent());
        // Switching to Alert
        Alert alert = driver.switchTo().alert();

        // Capturing alert message.
        String alertMessage= alert.getText();

        // Displaying alert message
        System.out.println(alertMessage);
        // Accepting alert
        alert.accept();

        wait.until(ExpectedConditions.alertIsPresent());

        // Switching to Alert
        Alert alert2 = driver.switchTo().alert();

        // Capturing alert message.
        String alertMessage2 = driver.switchTo().alert().getText();
        System.out.println(alertMessage2);

    }

    @AfterClass
    public void closeSite(){
        driver.quit();
    }
}
