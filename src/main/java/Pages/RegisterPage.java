package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
    WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "username") WebElement username;
    @FindBy(name = "password") WebElement password;
    @FindBy(name = "repeatedPassword") WebElement confirmPassword;
    @FindBy(name = "account.firstName") WebElement firstName;
    @FindBy(name = "account.lastName") WebElement lastName;
    @FindBy(name = "account.email") WebElement email;
    @FindBy(name = "account.languagePreference") WebElement language;
    @FindBy(name = "account.favouriteCategoryId") WebElement category;
    @FindBy(name = "account.listOption") WebElement myList;
    @FindBy(name = "account.bannerOption") WebElement myBanner;
    @FindBy(name = "newAccount") WebElement submit;

    @FindBy(name = "account.phone") WebElement phone;
    @FindBy(name = "account.address1") WebElement address1;
    @FindBy(name = "account.address2") WebElement address2;
    @FindBy(name = "account.city") WebElement city;
    @FindBy(name = "account.state") WebElement state;
    @FindBy(name = "account.zip") WebElement zip;
    @FindBy(name = "account.country") WebElement country;

    public void register(String uname, String pass, String fName, String lName, String mail) {
        username.sendKeys(uname);
        password.sendKeys(pass);
        confirmPassword.sendKeys(pass);
        firstName.sendKeys(fName);
        lastName.sendKeys(lName);
        email.sendKeys(mail);

        phone.sendKeys("1234567890");
        address1.sendKeys("Sitio Di Makita Street");
        address2.sendKeys("Apt 2B");
        city.sendKeys("Makati");
        state.sendKeys("Metro Manila");
        zip.sendKeys("2001");
        country.sendKeys("Singapore");

        language.sendKeys("english");
        category.sendKeys("FISH");
        if (!myList.isSelected()) myList.click();
        if (!myBanner.isSelected()) myBanner.click();

        submit.click();
    }
}
