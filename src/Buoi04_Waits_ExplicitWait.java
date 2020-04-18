import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Buoi04_Waits_ExplicitWait {
    public  static void main (String [] args){
        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //Explicit Wait
        WebDriverWait wait = new WebDriverWait(driver,5);

        //Truy cập vào Gmail
        driver.get("https://gmail.com");

        //Nhập vào Email
        driver.findElement(By.id("identifierId")).sendKeys("trainer@way2automation.com");

        //Nhấn button Tiếp theo
        driver.findElement(By.id("identifierNext")).click();

        //Nhập vào Password
        //Thread.sleep();
        //driver.findElement(By.name("password")).sendKeys("12345678");
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.name("password"))).sendKeys("12345678Abc");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password"))).sendKeys("12345678Abc");

        //Nhấn button Tiếp theo
        driver.findElement(By.id("passwordNext")).click();

        //Get error text
        //WebElement errorMessage = driver.findElement(By.xpath("//*[@id='view_container']//div[2]/span"));
        String errorMessage = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='view_container']//div[2]/span"))).getText();
        System.out.println(errorMessage);

        //Đóng tab/window hiện tại của trình duyệt đang mở
        driver.close();
    }
}
