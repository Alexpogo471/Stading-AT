import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Sample3 {
    WebDriver driver;
    WebDriverWait wait;
    String baseUrl = "http://demo.guru99.com/test/upload/";

    @BeforeClass
    public void initial(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 20);
    }

    @Test
    public void findElements(){
        driver.get(baseUrl);
        WebElement uploadElement = driver.findElement(By.id("uploadfile_0"));

        // check the "I accept the terms of service" check box
        driver.findElement(By.id("terms")).click();

        WebElement resultElement = driver.findElement(By.cssSelector("#res"));
        WebElement resultText = driver.findElement(By.cssSelector("#res > center"));
        System.out.println(resultText.getText().contains(" successfully"));

        // click the "UploadFile" button
        driver.findElement(By.name("send")).click();
        System.out.println(resultText.getText().contains(" successfully"));

        wait.until(ExpectedConditions.attributeContains(resultElement, "style", "display: block"));

        System.out.println(resultText.getText().contains(" successfully"));
    }

    @AfterClass
    public void close(){
        driver.quit();
    }



}
