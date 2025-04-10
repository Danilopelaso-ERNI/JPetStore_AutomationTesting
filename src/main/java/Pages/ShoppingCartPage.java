package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {
    WebDriver driver;

    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Enter the Store") WebElement enterStore;
    @FindBy(linkText = "Sign In") WebElement signIn;
    @FindBy(name = "username") WebElement username;
    @FindBy(name = "password") WebElement password;
    @FindBy(name = "signon") WebElement loginButton;

    @FindBy(xpath = "//area[@alt='Fish']") WebElement fishCategory;
    @FindBy(xpath = "//a[contains(text(),'FI-SW-01')]") WebElement angelfishProduct;
    @FindBy(xpath = "//a[contains(text(),'EST-1')]") WebElement angelfishItem;
    @FindBy(xpath = "//a[text()='Add to Cart']") WebElement addToCartButton;

    @FindBy(xpath = "//td[contains(text(),'Angelfish')]") WebElement cartItemName;

    public void login() {
        enterStore.click();
        signIn.click();
        username.sendKeys("pelasotest1");
        password.clear();
        password.sendKeys("password123");
        loginButton.click();
    }

    public void addItemToCart() {
        fishCategory.click();
        angelfishProduct.click();
        angelfishItem.click();
        addToCartButton.click();
    }

    public boolean verifyItemInCart() {
        return cartItemName.isDisplayed();
    }
}
