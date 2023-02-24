package TestRunner;

import BaseURL.Setup;
import Pages.OrderProcess;
import Utils.Utils;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class OrderTestRunner extends Setup  {
    OrderProcess OrderProcess;
    Utils utils;

    @Test(priority = 0)
    public void doLogin() throws IOException, ParseException, InterruptedException {
        driver.get("https://www.saucedemo.com/");
        OrderProcess = new OrderProcess(driver);
        utils=new Utils(driver);
        utils.getUserCreds(0);
        String nn=OrderProcess.doLogin(utils.getUsername(), utils.getPassword());
        Assert.assertEquals(nn, "CHECKOUT: COMPLETE!");
        System.out.println(nn);
    }
}
