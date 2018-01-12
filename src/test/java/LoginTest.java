import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

/**
 * Created by Aleh_Hutyrchyk on 1/11/2018.
 */
public class LoginTest {
    private WebDriver driver;
    private LoginPage page;
    public static String driverPath = "D:/Study/Automation/HomeTasks/";

    @BeforeTest
    public void setUp() throws Exception {
        //System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://test-web1-06.corp.globoforce.com/m/");

        page = new LoginPage(driver);
    }

    @Test
    public void registerSuccess() {
        page.registerClient("globoforce")
                .clickRegisterClient();
        page.typeUsername("768604")
                .typePassword("7686041")
                .clickLogin();

    }

    /*@AfterClass
    public void tearDown() {
        if(driver!=null) {
            System.out.println("Closing chrome browser");
            driver.quit();
        }
    }*/


}
