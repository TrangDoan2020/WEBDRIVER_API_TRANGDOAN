import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Buoi02_LaunchFirefox {

    public static void main (String [] args)
    {
        String projectPath = System.getProperty("user.dir");

        System.setProperty("webdriver.gecko.driver", projectPath + "/drivers/geckodriver.exe");

        WebDriver driver = new FirefoxDriver();
    }
}
