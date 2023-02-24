package TestRunner;

import BaseURL.Setup;
import Pages.LoginPage;
import Utils.Utils;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTestRunner extends Setup {
    LoginPage loginPage;
    Utils utils;

    @Test(priority = 0)
    public void doLogin() throws IOException, ParseException, InterruptedException {
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
        utils=new Utils(driver);
        utils.getUserCreds(0);
        String nn=loginPage.doLogin(utils.getUsername(), utils.getPassword());
        Assert.assertEquals(nn, "PRODUCTS");
        System.out.println(nn);
    }

    @Test(priority = 1)
    public void doLoginWithWrongPassword() throws IOException, ParseException, InterruptedException {
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
        utils=new Utils(driver);
        utils.getUserCreds(1);

        String nn1=loginPage.doLoginWithWrongPassword(utils.getUsername(), utils.getPassword());
        Assert.assertEquals(nn1, "Epic sadface: Username and password do not match any user in this service");
        System.out.println(nn1);
    }

    @Test(priority = 2)
    public void doLoginWithWrongUsername() throws IOException, ParseException, InterruptedException {
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
        utils=new Utils(driver);
        utils.getUserCreds(2);

        String nn2=loginPage.doLoginWithWrongPassword(utils.getUsername(), utils.getPassword());
        Assert.assertEquals(nn2, "Epic sadface: Username and password do not match any user in this service");
        System.out.println(nn2);
    }

}
