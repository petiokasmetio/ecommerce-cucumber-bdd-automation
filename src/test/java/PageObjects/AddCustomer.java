package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomer {

    WebDriver driver;

    public AddCustomer(WebDriver remoteDriver)
    {
        driver = remoteDriver;
        PageFactory.initElements(driver, this);
    }

    By lnkCustomersMenu = By.xpath("//a[@href='#']//p[contains(text(),'Customers')]");
    By cmItemCustomers = By.xpath("//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]");

    By btnAddNew = By.cssSelector("a[class='btn btn-primary']");

    By inpEmail = By.xpath("//input[@id='Email']");
    By inpPass = By.xpath("//input[@id='Password']");
    By inpFirstName = By.xpath("//input[@id='FirstName']");
    By inpLastName = By.xpath("//input[@id='LastName']");

    By btnGenderMale = By.xpath("//input[@id='Gender_Male']");
    By btnGenderFemale = By.xpath("//input[@id='Gender_Female']");

    By inpDateOfBirth = By.xpath("//input[@id='DateOfBirth']");
    By inpCompanyName = By.xpath("//input[@id='Company']");
    By btnTax = By.xpath("//input[@id='IsTaxExempt']");

    By lstBoxCustomerRole = By.xpath("(//div[@role='listbox'])[2]");
        By lstItemAdmin = By.xpath("//li[contains(text(), 'Administrators')]");
        By lstItemModer = By.xpath("//li[contains(text(), 'Forum Moderators')]");
        By lstItemGuest = By.xpath("//li[contains(text(), 'Guests')]");
        By lstItemRegistered = By.xpath("//li[contains(text(), 'Registered')]");
        By lstItemVendor = By.xpath("//li[contains(text(), 'Vendors')]");

    By selectManagerVendor = By.xpath("//select[@id='VendorId']");
    By btnSave = By.xpath("//button[@name='save']");

    public String getPageTitle()
    {
        return driver.getTitle();
    }

    public void clickCustomersMenu()
    {
        driver.findElement(lnkCustomersMenu).click();
    }

    public void clickCustomersMenuItem()
    {
        driver.findElement(cmItemCustomers);
    }

    public void clickAddNew()
    {
        driver.findElement(btnAddNew);
    }

    public void setEmail(String email)
    {
        driver.findElement(inpEmail).sendKeys(email);
    }

    public void setPassword(String password)
    {
        driver.findElement(inpPass).sendKeys(password);
    }

    public void setFirstName(String firstname)
    {
        driver.findElement(inpFirstName).sendKeys(firstname);
    }

    public void setLastName(String lastname)
    {
        driver.findElement(inpLastName).sendKeys(lastname);
    }

    public void setGender(String gender)
    {
        if(gender.equals("Male"))
        {
            driver.findElement(btnGenderMale).click();
        }
        else if(gender.equals("Female"))
        {
            driver.findElement(btnGenderFemale).click();
        }
        else
        {
            driver.findElement(btnGenderMale).click();
        }
    }

    public void setManagerVendors(String value)
    {
        Select dropdown = new Select(driver.findElement(selectManagerVendor));
        dropdown.selectByVisibleText(value);
    }

    public void setDateOfBirth(String dob)
    {
        driver.findElement(inpDateOfBirth).sendKeys(dob);
    }

    public void setCompanyName(String cn)
    {
        driver.findElement(inpCompanyName).sendKeys(cn);
    }

    public void clickTax()
    {
        driver.findElement(btnTax).click();
    }

    public void clickSave()
    {
        driver.findElement(btnSave).click();
    }
}
