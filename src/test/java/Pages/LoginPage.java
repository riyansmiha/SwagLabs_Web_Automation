package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;
    @FindBy(xpath = "//input[@id='user-name']")
    WebElement user;

    @FindBy(xpath = "//input[@id='password']")
    WebElement pass;

    @FindBy(xpath = "//input[@id='login-button']")
    WebElement LogIn;

    //@FindBy(xpath = "//button[@id='react-burger-menu-btn']")
    //WebElement menu_btn;

    //@FindBy(xpath = "//a[contains(.,'Logout')]")
    //WebElement logt;
    @FindBy(xpath = "//span[contains(.,'Products')]")
    WebElement Testassert;

    @FindBy(xpath = "//h3[@data-test='error'][contains(.,'Epic sadface: Username and password do not match any user in this service')]")
    WebElement Testassert2;

    @FindBy(xpath = "//h3[@data-test='error'][contains(.,'Epic sadface: Username and password do not match any user in this service')]")
    WebElement Testassert3;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory pageFactory;
        PageFactory.initElements(driver, this);
    }

    public String doLogin(String username, String password) throws InterruptedException {

        user.sendKeys(username);
        Thread.sleep(2000);
        pass.sendKeys(password);
        Thread.sleep(2000);
        LogIn.click();
        Thread.sleep(5000);

        //menu_btn.click();
        //Thread.sleep(2000);
        //logt.click();
        return Testassert.getText();


    }
        public String doLoginWithWrongPassword(String username, String password) throws InterruptedException {

            user.sendKeys(username);
            Thread.sleep(3000);
            pass.sendKeys(password);
            Thread.sleep(2000);
            LogIn.click();
            Thread.sleep(5000);

            return Testassert2.getText();
        }

    public String doLoginWithWrongUsername(String username, String password) throws InterruptedException {

        user.sendKeys(username);
        Thread.sleep(3000);
        pass.sendKeys(password);
        Thread.sleep(2000);
        LogIn.click();
        Thread.sleep(5000);

        return Testassert3.getText();
    }

}
