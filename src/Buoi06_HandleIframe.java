import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Buoi06_HandleIframe {
    public static void main(String[] args) {
        String projectPath = System.getProperty("user.dir");
        System.out.println(projectPath);
        System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        // Vào trang www.w3schools.com
        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_submit_create");

        //Switch to Iframe
        //driver.switchTo().frame("iframeResult");
        driver.switchTo().frame(0); // lấy theo index của Iframe nếu trong trường hợp Iframe ko có id và name

        //Click vào button Try it
        driver.findElement(By.xpath("//button[text()='Try it']")).click();

        //Thoát Iframe để quay lại trang web chính
        driver.switchTo().defaultContent();

        //Nhấn vào button Run
        driver.findElement(By.xpath("//button[text()='Run »']")).click();

        //Đóng tab/window hiện tại của trình duyệt đang mở
        driver.close();
    }
}
