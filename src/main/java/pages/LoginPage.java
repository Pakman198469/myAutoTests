package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Aleh_Hutyrchyk on 1/8/2018.
 */
public class LoginPage extends BasePage {

    By clientLocator = By.id("email");
    By registerClient = By.id("registerButton");
    By usernameLocator = By.id("username");
    By passwordLocator = By.id("password");
    By loginButtonLocator = By.id("logInButton");

    private String strUserName;
    private String strPassword;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage clickRegisterClient() {
        waitUntilClickable(registerClient);
        driver.findElement(registerClient);
        return this;
    }
    

    public LoginPage registerClient(String strClientName) {
        driver.findElement(clientLocator).sendKeys(strClientName);
        return this;
    }

    public LoginPage typeUsername(String strUserName) {
        driver.findElement(usernameLocator).sendKeys(strUserName);
        return this;
    }

    public LoginPage typePassword(String strPassword) {
        driver.findElement(passwordLocator).sendKeys(strPassword);
        return this;
    }

    public LoginPage clickLogin() {
        driver.findElement(loginButtonLocator).click();
        return this;
    }

    /**
     * This POM method will be exposed in test case to login in the application
     * @param strUserName
     * @param strPasword
     * @return
     */
    public void loginToAutoQA(String strClientName, String strUserName,String strPasword){
        this.registerClient(strClientName)
            .clickRegisterClient();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //Fill user name
        typeUsername(strUserName)
                .typePassword(strPasword)
                .clickLogin();
    }

}
