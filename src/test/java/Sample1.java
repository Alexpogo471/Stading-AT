import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Sample1 {
    WebDriver safariDriver;
    WebDriver chromeDriver;
    String baseUrl;

    @BeforeClass
    public void initialObjects(){
        safariDriver = new SafariDriver();
        chromeDriver = new ChromeDriver();
        baseUrl = "http://demo.guru99.com/test/newtours/";



    }
    @Test
    public void getTitleSite(){
        safariDriver.get(baseUrl);
        chromeDriver.get(baseUrl);

        System.out.println("Safari title = " + safariDriver.getTitle());
        System.out.println("Chrome title = " + chromeDriver.getTitle());

    }
    @AfterClass
    public void closeDriver(){
        safariDriver.quit();
        chromeDriver.quit();
    }
}
