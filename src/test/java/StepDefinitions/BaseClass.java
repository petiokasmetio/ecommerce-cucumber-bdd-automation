package StepDefinitions;

import PageObjects.AddCustomer;
import PageObjects.LoginPage;
import PageObjects.SearchCustomer;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import java.util.Properties;
import java.util.logging.Logger;

public class BaseClass {

    public WebDriver driver;
    public LoginPage lp;
    public AddCustomer ac;
    public SearchCustomer sc;
    public static Logger logger;
    public Properties configProp;

    public static String randomStringGenerator()
    {
        return (RandomStringUtils.randomAlphabetic(5));
    }


}
