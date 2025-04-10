package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CategoryPage {
    WebDriver driver;

    public CategoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Enter the Store") WebElement enterStore;
    @FindBy(linkText = "Sign In") WebElement signIn;
    @FindBy(name = "username") WebElement username;
    @FindBy(name = "password") WebElement password;
    @FindBy(name = "signon") WebElement signInBtn;

    @FindBy(xpath = "//area[@alt='Fish']") WebElement fish;
    @FindBy(xpath = "//area[@alt='Dogs']") WebElement dogs;
    @FindBy(xpath = "//area[@alt='Reptiles']") WebElement reptiles;
    @FindBy(xpath = "//area[@alt='Cats']") WebElement cats;
    @FindBy(xpath = "//area[@alt='Birds']") WebElement birds;

    public void login() {
        enterStore.click();
        signIn.click();
        username.sendKeys("pelasotest1");
        password.clear();
        password.sendKeys("password123");
        signInBtn.click();
    }

    public void browseCategories() {
        fish.click();
        System.out.println("Visited Fish");
        driver.navigate().back();

        dogs.click();
        System.out.println("Visited Dogs");
        driver.navigate().back();

        reptiles.click();
        System.out.println("Visited Reptiles");
        driver.navigate().back();

        cats.click();
        System.out.println("Visited Cats");
        driver.navigate().back();

        birds.click();
        System.out.println("Visited Birds");
        driver.navigate().back();
    }
}
