import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Buoi02_LaunchChrome {

    public static void main (String [] args)
    {
       String projectPath = System.getProperty("user.dir");

       System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

    }
}
