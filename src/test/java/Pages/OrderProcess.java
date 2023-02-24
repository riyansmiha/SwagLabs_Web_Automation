package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderProcess {

    WebDriver driver;
    @FindBy(xpath = "//input[@id='user-name']")
    WebElement user;

    @FindBy(xpath = "//input[@id='password']")
    WebElement pass;

    @FindBy(xpath = "//input[@id='login-button']")
    WebElement LogIn;

    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']")
    WebElement add_cart;

    @FindBy(className = "shopping_cart_badge")
    WebElement cart_tab;

    @FindBy(xpath = "//button[@id='checkout']")
    WebElement checkout;

    @FindBy(xpath = "//input[@id='first-name']")
    WebElement fname;

    @FindBy(xpath = "//input[@id='last-name']")
    WebElement lname;

    @FindBy(xpath = "//input[@id='postal-code']")
    WebElement zip;

    @FindBy(xpath = "//input[@id='continue']")
    WebElement cont;

    @FindBy(xpath = "//button[@id='finish']")
    WebElement finish;

    @FindBy(xpath = "//span[@class='title'][contains(.,'Checkout: Complete!')]")
    WebElement order_complete;


    public OrderProcess(WebDriver driver) {
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
        Thread.sleep(2000);
        add_cart.click();
        cart_tab.click();
        checkout.click();
        Thread.sleep(2000);
        fname.sendKeys("Sajib");
        lname.sendKeys("Riyan");
        zip.sendKeys("1216");
        Thread.sleep(2000);
        cont.click();
        finish.click();

        return order_complete.getText();
    }

}
