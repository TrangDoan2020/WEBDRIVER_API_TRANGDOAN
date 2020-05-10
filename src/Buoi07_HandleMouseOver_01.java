import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Buoi07_HandleMouseOver_01 {
    public static void main(String[] args) {
        String projectPath = System.getProperty("user.dir");
        System.out.println(projectPath);
        System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        // Vào trang http://demoqa.com/tooltip-and-double-click/
        driver.get("http://demoqa.com/tooltip-and-double-click/");

        //Xác định element
        WebElement menu = driver.findElement(By.xpath("//div[@id='tooltipDemo']"));

        //Hover vào
        Actions builder = new Actions (driver);
        builder.moveToElement(menu).perform();

        //Đóng tab/window hiện tại của trình duyệt đang mở
        //driver.close();
    }
}
