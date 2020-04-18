import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import java.time.Duration;

public class Buoi04_Waits_FluentWait {
    public  static void main (String [] args){
        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //Fluent Wait
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2))
                .withMessage("Time out after 10 seconds")
                .ignoring(NoSuchElementException.class);

        //Truy cập vào Gmail
        driver.get("https://gmail.com");

        //Nhập vào Email
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.id("identifierId123"))).sendKeys("trainer@way2automation.com");
        driver.findElement(By.xpath("//input[@id='identifierId']")).sendKeys("trainer@way2automation.com");

        //Nhấn button Tiếp theo
        driver.findElement(By.xpath("//div[@id='identifierNext']")).click();

        //Nhập vào Password
        //Thread.sleep();
        //driver.findElement(By.name("password")).sendKeys("12345678");
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.name("password"))).sendKeys("12345678Abc");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='password']"))).sendKeys("12345678Abc");

        //Nhấn button Tiếp theo
        driver.findElement(By.xpath("//div[@id='passwordNext']")).click();

        //Get error text
        //WebElement errorMessage = driver.findElement(By.xpath("//*[@id='view_container']//div[2]/span"));
        String errorMessage = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='view_container']//div[2]/span"))).getText();
        System.out.println(errorMessage);

        //Đóng tab/window hiện tại của trình duyệt đang mở
        driver.close();
    }
}
