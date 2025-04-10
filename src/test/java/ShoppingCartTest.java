import Pages.ShoppingCartPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShoppingCartTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Browser Driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://petstore.octoperf.com");

        ShoppingCartPage cart = new ShoppingCartPage(driver);
        cart.login();
        cart.addItemToCart();

        if (cart.verifyItemInCart()) {
            System.out.println("Item successfully added to cart!");
        } else {
            System.out.println("Item was NOT found in the cart.");
        }

        driver.quit();
    }
}
