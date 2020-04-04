import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Buoi02_BrowserCommands {

    public static void main (String [] args)
    {
        String projectPath = System.getProperty("user.dir");

        System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        //Trình duyệt truy cập vào google.com
        driver.get("https://google.com");

        //In giá trị Title của trình duyêt ra màn hình
        String title = driver.getTitle();
        System.out.println(title);

        //In giá trị URL ra màn hình
        String currentURL = driver.getCurrentUrl();
        System.out.println(currentURL);

        //In giá trị PageSource ra màn hình
        String pageSource = driver.getPageSource();
        System.out.println(pageSource);

        //Thực hiện truy cập FB
        driver.navigate().to("https://facebook.com");

        //Refresh trang web
        driver.navigate().refresh();

        //Back về trang trước đó
        driver.navigate().back();

        //Forward về trang trước đó
        driver.navigate().forward();

        //Phóng to trang web
        driver.manage().window().maximize();

        //Đóng trình duyệt browser
         driver.close();
    }
}
