package com.purevpn.tests;

import com.purevpn.extensionpages.CountryPage;
import com.purevpn.extensionpages.HomePage;
import com.purevpn.extensionpages.TrialPage;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.DriverManagerType;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.rules.Timeout;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Time;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestHomePage {
    final static Logger log = Logger.getLogger(TestHomePage.class);
    public  static Properties objectConfigs = new Properties();
    public static String dutchFlag = "chrome-extension://bfidboloedlamgdmenmlbipfnccokknp/assets/images/flags/64/nl.png";
    public static String errorMSg = "The address 172.31.0.185 is not in the database.";
    public static void main(String[] args)  {
        try {
            //HomePage hp = new HomePage();
            FileInputStream fIS = new FileInputStream("C:\\Users\\Ghous\\Desktop\\PureVPN\\src\\test\\java\\com\\purevpn\\configs\\configuration.properties");
            objectConfigs.load(fIS);
            ChromeDriverManager.getInstance(DriverManagerType.CHROME).setup();
            ChromeOptions opt = new ChromeOptions();
            opt.addExtensions(new File("PureVPNExtension.crx"));
            WebDriver chromeDriver = new ChromeDriver(opt);
            // chromeDriver.get("chrome-extension://bfidboloedlamgdmenmlbipfnccokknp/ui/popup/template.html");
            chromeDriver.get(objectConfigs.getProperty("extensionsite"));
            chromeDriver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
            HomePage hp = PageFactory.initElements(chromeDriver, HomePage.class);

            TrialPage tp = hp.clickOnSignUpButton();


            Timeout.millis(100);
            tp.checkTermsAndConditions();
            Timeout.millis(100);
            tp.enterEmailAddress();

            CountryPage cp = tp.clickSignUpButton();
            Timeout.millis(1000);
            Assert.assertFalse(tp.getErrorText().equals(errorMSg));
            Timeout.millis(100);
            cp.clickSelectCountry();
            Timeout.millis(100);
            cp.selectNetherland();
            Timeout.millis(100);
            Assert.assertEquals(cp.getDutchFlag(), dutchFlag);
            Timeout.millis(100);
            chromeDriver.close();
            chromeDriver.quit();

        }
        catch (Exception e)
        {
            log.debug(e.getStackTrace());
        }

    }
}

