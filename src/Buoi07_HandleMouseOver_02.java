import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Buoi07_HandleMouseOver_02 {
    public static void main(String[] args) {
        String projectPath = System.getProperty("user.dir");
        System.out.println(projectPath);
        System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        // Vào trang https://demoqa.com/menu/
        driver.get("https://demoqa.com/menu/");

        //Xác định element
        WebElement menu = driver.findElement(By.xpath("//ul[@id='menu']//div[text()='Music']"));


        //Hover vào menu
        Actions builder = new Actions (driver);
        builder.moveToElement(menu).perform();

        //Đóng tab/window hiện tại của trình duyệt đang mở
        //driver.close();
    }
}
