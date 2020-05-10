import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Buoi07_HandleDragDrop {
    public static void main(String[] args) {
        String projectPath = System.getProperty("user.dir");
        System.out.println(projectPath);
        System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        // Vào trang https://demoqa.com/droppable/
        driver.get("https://demoqa.com/droppable/");

        //Xác định đối tượng cần Drag
        WebElement eleDrag = driver.findElement(By.xpath("//div[@id='draggable']"));

        //Xác định đối tượng cần Drop
        WebElement eleDrop = driver.findElement(By.xpath("//div[@id='droppable']"));

        //Kéo Drag và Drop
        Actions builder = new Actions(driver);
        builder.dragAndDrop(eleDrag,eleDrop).perform();

        //Đóng tab/window hiện tại của trình duyệt đang mở
        driver.close();
    }
}
