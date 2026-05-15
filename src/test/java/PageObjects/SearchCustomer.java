package PageObjects;


import StepDefinitions.BaseClass;
import Utilities.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.List;

public class SearchCustomer extends BaseClass {

    WebDriver driver;
    WaitHelper waitHelper;

    public SearchCustomer(WebDriver remoteDriver)
    {
        driver = remoteDriver;
        PageFactory.initElements(driver, this);
        waitHelper = new WaitHelper(driver);
    }

    @FindBy(how = How.ID, using = "SearchEmail")
    @CacheLookup
    WebElement inpEmail;

    @FindBy(how = How.ID, using = "SearchFirstName")
    @CacheLookup
    WebElement inpFirstName;

    @FindBy(how = How.ID, using = "SearchLastName")
    @CacheLookup
    WebElement inpLastName;

    @FindBy(how = How.ID, using = "SearchMonthOfBirth")
    @CacheLookup
    WebElement drpMonth;

    @FindBy(how = How.ID, using = "SearchDayOfBirth")
    @CacheLookup
    WebElement drpDay;

    @FindBy(how = How.ID, using = "search-customers")
    @CacheLookup
    WebElement btnSearch;

    @FindBy(how = How.XPATH, using = "//table[@role='grid']")
    @CacheLookup
    WebElement tableSearchResult;

    @FindBy(how = How.XPATH, using = "//table[@id='customers-grid']")
    WebElement table;

    @FindBy(how = How.XPATH, using = "//table[@id='customers-grid']//tbody/tr")
    List<WebElement> tableRows;

    @FindBy(how = How.XPATH, using = "//table[@id='customers-grid']//tbody/tr/td")
    List<WebElement> tableColumns;

    public void setEmail(String email)
    {
        waitHelper.WaitForElement(inpEmail, 15);
        inpEmail.clear();
        inpEmail.sendKeys(email);
    }

    public void setFirstName(String fname)
    {
        waitHelper.WaitForElement(inpFirstName, 15);
        inpFirstName.clear();
        inpFirstName.sendKeys(fname);
    }

    public void setLastName(String lname)
    {
        waitHelper.WaitForElement(inpLastName, 15);
        inpLastName.clear();
        inpLastName.sendKeys(lname);
    }

    public void clickSearch()
    {
        btnSearch.click();
        waitHelper.WaitForElement(btnSearch, 30);
    }

    public int getNumberOfRows()
    {
        return (tableRows.size());
    }

    public int getNumberOfCols()
    {
        return (tableColumns.size());
    }

    //victoria_victoria@nopCommerce.com
    public boolean searchCustomerByEmail(String email)
    {
        boolean flag = false;
        for (int i = 1; i <= getNumberOfRows(); i++)
            {
                String emailId = table.findElement(By
                        .xpath("//table[@id='customers-grid']/tbody/tr["+ i + "]/td[2]")).getText();
                System.out.println(emailId);
                if(emailId.equals(email))
                {
                    flag = true;
                }
            }
        return flag;
    }

    public boolean searchCustomerByName(String Name)
    {
        boolean flag = false;
        for (int i = 1; i <= getNumberOfRows(); i++)
        {
            String personalname = table.findElement(By
                    .xpath("//table[@id='customers-grid']/tbody/tr["+ i + "]/td[3]")).getText();

            String[] names = personalname.split(" ");  //Separating first name and last name
            System.out.println(Arrays.toString(names));

            if(names[0].equals("Victoria") && names[1].equals("Terces"))
            {
                flag = true;
            }
        }
        return flag;
    }
}


