import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Set;

public class PopupDemoTest {
    WebDriver driver;
    WebDriverWait wait;
    String mainWindow;

    @BeforeClass
    public void initial() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 20);
        driver.get("http://demo.guru99.com/popup.php");
        driver.manage().window().maximize();

    }

    @Test
    public void existElement() {
        driver.findElement(By.xpath("//*[contains(@href,'popup.php')]")).click();
        mainWindow = driver.getWindowHandle();

        // To handle all new opened window.
        Set<String> allWindows = driver.getWindowHandles();
        for (String childWindow : allWindows) {

            if (!mainWindow.equalsIgnoreCase(childWindow)) {
                // Switching to Child window
                driver.switchTo().window(childWindow);
                driver.findElement(By.name("emailid")).sendKeys("gaurav.3n@gmail.com");
                driver.findElement(By.name("btnLogin")).click();

                wait.until(
                        ExpectedConditions
                                .visibilityOfElementLocated(
                                        By.xpath("/html/body/table/tbody/tr[1]/td/h2")));

                WebElement userIdElement = driver.findElement(By.xpath("/html/body/table/tbody/tr[4]/td[2]"));
                WebElement passwordElement = driver.findElement(By.xpath("/html/body/table/tbody/tr[5]/td[2]"));

                System.out.println(userIdElement.getText());
                System.out.println(passwordElement.getText());
            }


            // Closing the Child Window.
            driver.close();
        }
    }

    @AfterClass
    public void closeDriver(){
        // Switching to Parent window i.e Main Window.
        driver.switchTo().

                window(mainWindow);

        driver.quit();
    }

}
