import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Buoi07_HandleUploader_01 {
    public static void main(String[] args) {
        String projectPath = System.getProperty("user.dir");
        System.out.println(projectPath);
        System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        // Vào trang http://blueimp.github.io/jQuery-File-Upload/
        driver.get("http://blueimp.github.io/jQuery-File-Upload/");

        //Nhấn button Add files...
        WebElement btnAddFiles = driver.findElement(By.xpath("//input[@name='files[]']"));
        btnAddFiles.sendKeys(projectPath + "/images/CoMayMan.jpg");

        //Nhấn button Start
        driver.findElement(By.xpath("//button[@class='btn btn-primary start']")).click();

        //Đóng tab/window hiện tại của trình duyệt đang mở
        //driver.close();
    }
}
