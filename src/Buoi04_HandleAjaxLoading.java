import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Buoi04_HandleAjaxLoading {
    public  static void main (String [] args) throws InterruptedException {
        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //Fluent Wait
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofSeconds(2))
                .withMessage("Time out after 10 seconds")
                .ignoring(NoSuchElementException.class);

        //Truy cập vào trang web
        driver.get("http://the-internet.herokuapp.com/dynamic_loading/2");

        //Click button Start
        driver.findElement(By.xpath("//button[contains(text(),'Start')]")).click();
        //driver.findElement(By.xpath("//div[@id='start']")).click();

        //Chờ loading
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='loading']")));

        //Hiển thị Hello World! sau khi loading xong
        String txtHello = driver.findElement(By.xpath("//div[@id='finish']")).getText();
        System.out.println(txtHello);

        //Đóng tab/window hiện tại của trình duyệt đang mở
        driver.close();
    }
}
