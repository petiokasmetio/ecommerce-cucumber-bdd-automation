package StepDefinitions;

import PageObjects.AddCustomer;
import PageObjects.LoginPage;
import PageObjects.SearchCustomer;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.cucumber.java.eo.Se;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;


public class Steps extends BaseClass
{
    @Before
    public void setup() throws IOException  //Setup desired browser
    {
        configProp = new Properties();
        FileInputStream configPropfile = new FileInputStream("config.properties");
        configProp.load(configPropfile);
        String br = configProp.getProperty("browser");
        switch (br) {
            case "chrome" -> {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }
            case "firefox" -> {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }
            case "edge" -> {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
            }
        }

        logger = Logger.getLogger("eCommerce-CucumberBDD");
        PropertyConfigurator.configure("Log4j.properties");
        driver.manage().window().maximize();

    }


    @Given("User launch Chrome browser")
    public void user_launch_chrome_browser() {
        lp = new LoginPage(driver);
        logger.info("***********LAUNCHING BROWSER*************");
    }
    @When("User open URL {string}")
    public void user_open_url(String url) throws InterruptedException {
        driver.get(url);
        Thread.sleep(1000);
    }

    @When("When User enter Email {string} and Password {string}")
    public void when_user_enter_email_and_password(String email, String password) {
        lp = new LoginPage(driver);
        lp.setUserName(email);
        lp.setPassword(password);
    }

    @When("Click on Login")
    public void click_on_login() {
        lp = new LoginPage(driver);
        lp.clickLogin();
    }


    @Then("Page title should be {string}")
    public void page_title_should_be(String homepagetitle) {
        lp = new LoginPage(driver);
        if(driver.getPageSource().contains("Login was unsuccessful."))
        {
            driver.close();
            Assert.fail();
        } else
        {
            Assert.assertEquals(homepagetitle, driver.getTitle());
        }
    }
    @Then("User click on logout link")
    public void user_click_on_logout_link() throws InterruptedException {
        lp = new LoginPage(driver);
        Thread.sleep(1000);
        lp.clickLogout();
    }

    @Then("close browser")
    public void close_browser() {
        driver.close();
    }

    //Add customer step definitions
    @Then("User can view Dashboard")
    public void user_can_view_dashboard() {
        ac = new AddCustomer(driver);
        lp = new LoginPage(driver);
        Assert.assertEquals("Dashboard / nopCommerce administration", ac.getPageTitle());
    }
    @When("User click on customers Menu")
    public void user_click_on_customers_menu() throws InterruptedException {
        ac = new AddCustomer(driver);
        ac.clickCustomersMenu();
        Thread.sleep(2000);
    }

    @Then("Click on Add new button")
    public void click_on_add_new_button() {
        ac = new AddCustomer(driver);
        ac.clickCustomersMenuItem();
        ac.clickAddNew();
    }

    @Then("User can view Add new customer page")
    public void user_can_view_add_new_customer_page() {
        ac = new AddCustomer(driver);
        Assert.assertEquals("Add a new customer / nopCommerce administration", ac.getPageTitle());
    }

    @When("User enter customer info")
    public void user_enter_customer_info() {
        ac = new AddCustomer(driver);
        String email = randomStringGenerator() + "@gmail.com";
        ac.setPassword("test123");
        ac.setEmail(email);
        String firstName = randomStringGenerator();
        ac.setFirstName(firstName);
        String lastName = randomStringGenerator();
        ac.setLastName(lastName);
        ac.setGender("Male");
        ac.setDateOfBirth("7/07/1977");
        ac.setCompanyName("QACOMPANY");
        ac.clickTax();
    }

    @When("click on Save button")
    public void click_on_save_button() {
        ac = new AddCustomer(driver);
        ac.clickSave();
    }

    @When("User can view confirmation message {string}")
    public void user_can_view_confirmation_message(String msd) {
        Assert.assertTrue(driver.findElement(By.tagName("body"))
                .getText().contains("The new customer has been added successfully."));
    }

    @Then("Finish")
    public void finish() {
        ac = new AddCustomer(driver);
        driver.findElement(By.cssSelector("body > div:nth-child(3) > aside:nth-child(2) > " +
                "div:nth-child(2) > div:nth-child(4) > div:nth-child(1) > " +
                "div:nth-child(1) > nav:nth-child(2) > ul:nth-child(1) > " +
                "li:nth-child(4) > ul:nth-child(2) > li:nth-child(1) > " +
                "a:nth-child(1) > p:nth-child(2)")).click();
    }

    //Steps for search customer

    @Then("Enter customer Email")
    public void enter_customer_email() {
        sc = new SearchCustomer(driver);
        sc.setEmail("victoria_victoria@nopCommerce.com");
    }
    @When("Click on search button")
    public void click_on_search_button() throws InterruptedException {
        sc = new SearchCustomer(driver);
        sc.clickSearch();
        Thread.sleep(2000);
    }
    @Then("User should found Email in the Search table")
    public void user_should_found_email_in_the_search_table() {
        boolean status = sc.searchCustomerByEmail("victoria_victoria@nopCommerce.com");
        Assert.assertTrue(status);
    }
    //Search by firstname and lastname

    @Then("Enter customer FirstName")
    public void enter_customer_first_name() {
        sc = new SearchCustomer(driver);
        sc.setFirstName("Victoria");
    }
    @Then("Enter customer LastName")
    public void enter_customer_last_name() {
        sc = new SearchCustomer(driver);
        sc.setLastName("Terces");
    }
    @Then("User should found Name in the Search table")
    public void user_should_found_name_in_the_search_table() {
        sc = new SearchCustomer(driver);
        boolean status = sc.searchCustomerByName("Victoria Terces");
        Assert.assertTrue(status);
    }
}
