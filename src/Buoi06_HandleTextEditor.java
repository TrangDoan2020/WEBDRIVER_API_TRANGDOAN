import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Buoi06_HandleTextEditor {
    public static void main(String[] args) {
        String projectPath = System.getProperty("user.dir");
        System.out.println(projectPath);
        System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        // Vào trang yizeng.me
        driver.get("https://yizeng.me/2014/01/31/test-wysiwyg-editors-using-selenium-webdriver/");

        //Switch to Iframe CKEditor
        driver.switchTo().frame(0);

        //Nhập nội dung vào editor
        driver.switchTo().activeElement().sendKeys("Selenium Handle Text Editor");

        //Thoát Iframe để quay lại trang web chính
        driver.switchTo().defaultContent();

        //Đóng tab/window hiện tại của trình duyệt đang mở
        driver.close();
    }
}
