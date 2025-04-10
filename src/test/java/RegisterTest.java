import Pages.RegisterPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegisterTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Browser Driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://petstore.octoperf.com/actions/Account.action?newAccountForm=");

        RegisterPage register = new RegisterPage(driver);
        String username = "pelasotest1";
        register.register(username, "password123", "Danilo", "Pelaso", "danilo@email.com");

        System.out.println("Registration submitted for: " + username);
    }
}
