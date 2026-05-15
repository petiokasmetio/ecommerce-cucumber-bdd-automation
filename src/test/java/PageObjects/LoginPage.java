package PageObjects;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;
    public LoginPage(WebDriver remoteDriver)
    {
        driver = remoteDriver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "Email")
    @CacheLookup
    WebElement txtEmail;

    @FindBy(id = "Password")
    @CacheLookup
    WebElement txtPassword;

    @FindBy(xpath = "//button[normalize-space()='Log in']")
    @CacheLookup
    WebElement btnLogin;

    @FindBy(xpath = "//a[normalize-space()='Logout']")
    @CacheLookup
    WebElement btnLogout;

    public void setUserName(String email)
    {
        txtEmail.clear();
        txtEmail.sendKeys(email);
    }

    public void setPassword(String password)
    {
        txtPassword.clear();
        txtPassword.sendKeys(password);
    }

    public void clickLogin()
    {
        btnLogin.click();
    }

    public void clickLogout()
    {
        btnLogout.click();
    }
}

