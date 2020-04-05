import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Buoi02_BrowserCommands {

    public static void main (String [] args) throws InterruptedException {
        String projectPath = System.getProperty("user.dir");
        System.out.println(projectPath);

        System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        //Trình duyệt truy cập vào google.com
        //Phương thức GET sẽ ko back lại đc trang trc đó
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

        //Refresh trang web
        driver.navigate().refresh();

        Thread.sleep(1000);

        //Thực hiện truy cập FB
        //Phương thức TO cho phép back về trang trc đó
        driver.navigate().to("https://facebook.com");

        //Back về trang trước đó
        driver.navigate().back();

        //Forward về trang trước đó
        //driver.navigate().forward();
        //System.out.println("Forward!");

        //Phóng to trang web
        driver.manage().window().maximize();

        //Đóng tab/window hiện tại của trình duyệt đang mở
         driver.close();

         //Đóng tất cả các tab của trình duyệt
        //driver.quit();
    }
}
