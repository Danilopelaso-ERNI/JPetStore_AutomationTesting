import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.io.IOException;

public class Exercise2 {

    public static void pause(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Browser Driver\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-save-password-bubble");
        options.addArguments("disable-infobars");
        options.addArguments("user-data-dir=C:/temp/uniqueProfile");

        WebDriver driver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();


        driver.get("https://www.saucedemo.com/");
        System.out.println("Opened SauceDemo");
        pause(1000);

        By userLocator = By.xpath("//input[contains(@id,'user-name')]");
        By passLocator = By.xpath("//input[contains(@id,'password')]");
        By loginLocator = By.xpath("//input[contains(@id,'login-button')]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(userLocator));
        driver.findElement(userLocator).sendKeys("standard_user");
        pause(500);
        driver.findElement(passLocator).sendKeys("secret_sauce");
        pause(500);
        driver.findElement(loginLocator).click();
        System.out.println("Login is clicked");
        pause(1000);

        By itemLocator = By.xpath("//div[text()='Sauce Labs Backpack']/ancestor::div[@class='inventory_item']//button");
        wait.until(ExpectedConditions.visibilityOfElementLocated(itemLocator)).click();
        System.out.println("Added item to cart");
        pause(1000);

        By cartLocator = By.xpath("//a[@class='shopping_cart_link']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartLocator)).click();
        System.out.println("Navigated to cart");
        pause(1000);

        By checkoutLocator = By.xpath("//button[@id='checkout']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkoutLocator)).click();
        System.out.println("Checkout button clicked");
        pause(1000);

        By firstNameLocator = By.xpath("//input[contains(@id,'first-name')]");
        By lastNameLocator = By.xpath("//input[contains(@id,'last-name')]");
        By postalCodeLocator = By.xpath("//input[contains(@id,'postal-code')]");
        driver.findElement(firstNameLocator).sendKeys("Danilo");
        pause(500);
        driver.findElement(lastNameLocator).sendKeys("Pelaso");
        pause(500);
        driver.findElement(postalCodeLocator).sendKeys("2001");
        pause(500);
        System.out.println("Filled in checkout info");

        By continueLocator = By.xpath("//input[@id='continue']");
        wait.until(ExpectedConditions.elementToBeClickable(continueLocator)).click();
        System.out.println("Continue button clicked");
        pause(1000);

        By itemTotalLocator = By.xpath("//div[contains(@class,'summary_subtotal_label')]");
        WebElement itemTotal = wait.until(ExpectedConditions.visibilityOfElementLocated(itemTotalLocator));
        System.out.println("🧾 Item total: " + itemTotal.getText());
        pause(1000);

        By finishLocator = By.xpath("//button[@id='finish']");
        wait.until(ExpectedConditions.elementToBeClickable(finishLocator)).click();
        System.out.println("🎉 Finish button clicked");
        pause(1000);

        By confirmationLocator = By.xpath("//h2[contains(@class,'complete-header')]");
        WebElement confirmation = wait.until(ExpectedConditions.visibilityOfElementLocated(confirmationLocator));
        System.out.println("🎯 Order complete: " + confirmation.getText());

        pause(5000);
    }
}