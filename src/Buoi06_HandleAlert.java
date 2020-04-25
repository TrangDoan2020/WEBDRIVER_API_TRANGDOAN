import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Buoi06_HandleAlert {
    public static void main(String[] args) {
        String projectPath = System.getProperty("user.dir");
        System.out.println(projectPath);
        System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        WebDriverWait wait = new WebDriverWait(driver,3);

        driver.manage().window().maximize();

        // Vào trang tizag.com
        driver.get("http://www.tizag.com/javascriptT/javascriptalert.php");

//        //Viết hàm kiểm tra alert có xuất hiện trên trang web hay ko?
//        public static boolean isAlertPresent () {
//            try {
//                WebDriverWait wait = new WebDriverWait(driver, 3);
//                wait.until(ExpectedConditions.alertIsPresent());
//                return true;
//            } catch (Exception e) {
//                return false;
//            }
//        }
        driver.findElement(By.xpath("//div[@class='display']//form//input")).click();

        wait.until(ExpectedConditions.alertIsPresent());

        //Khởi tạo đối tượng alert
        Alert alert = driver.switchTo().alert();

        //getText trong alert
        String alertText = alert.getText();
        System.out.println(alertText);

        //Click button Ok trong alert
        alert.accept();

        //Click button Cancel trong alert
        //alert.dismiss();

        //Đóng tab/window hiện tại của trình duyệt đang mở
        driver.close();
    }
}