import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Buoi07_HandleDoubleClick {
    public static void main(String[] args) {
        String projectPath = System.getProperty("user.dir");
        System.out.println(projectPath);
        System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        WebDriverWait wait = new WebDriverWait(driver,3);

        driver.manage().window().maximize();

        // Vào trang http://demoqa.com/tooltip-and-double-click/
        driver.get("http://demoqa.com/tooltip-and-double-click/");

        //Xác định element button
        WebElement button1 = driver.findElement(By.xpath("//button[@id='doubleClickBtn']"));

        //Double click vào button
        Actions builder = new Actions(driver);
        builder.doubleClick(button1).perform();

        wait.until(ExpectedConditions.alertIsPresent());

        //Khởi tạo đối tượng alert
        Alert alert = driver.switchTo().alert();

        //getText trong alert
        String alertText = alert.getText();
        System.out.println(alertText);

        //Click button Ok trong alert
        alert.accept();

        //Đóng tab/window hiện tại của trình duyệt đang mở
        driver.close();
    }
}
