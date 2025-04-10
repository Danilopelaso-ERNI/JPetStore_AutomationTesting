import Pages.CategoryPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CategoryTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Browser Driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://petstore.octoperf.com");

        CategoryPage categoryPage = new CategoryPage(driver);
        categoryPage.login();
        categoryPage.browseCategories();

        System.out.println("Done browsing all categories");
        driver.quit();
    }
}
