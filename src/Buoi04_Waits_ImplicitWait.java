import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Buoi04_Waits_ImplicitWait {
    public  static void main (String [] args){
        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //Implicit Wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Truy cập vào Gmail
        driver.get("https://gmail.com");

        //Nhập vào Email
        driver.findElement(By.id("identifierId")).sendKeys("trainer@way2automation.com");

        //Nhấn button Tiếp theo
        driver.findElement(By.id("identifierNext")).click();

        //Nhập vào Password
        //Thread.sleep(1000);
        driver.findElement(By.name("password")).sendKeys("12345678");

        //Nhấn button Tiếp theo
        driver.findElement(By.id("passwordNext")).click();

        //Đóng tab/window hiện tại của trình duyệt đang mở
        driver.close();
    }
}
