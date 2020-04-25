import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Iterator;

public class Buoi06_HandleTab {
    public static void main(String[] args) {
        String projectPath = System.getProperty("user.dir");
        System.out.println(projectPath);
        System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        // Vào trang facebook.com
        driver.get("https://facebook.com");
        driver.findElement(By.xpath("//a[text()='Instagram']")).click();
        System.out.println(driver.getCurrentUrl());

        String facebookTitle = driver.getTitle();
        System.out.println(facebookTitle);

        //Sử dụng iterator để switch tab
        Iterator<String> iter = driver.getWindowHandles().iterator();
        String parentID = iter.next();
        String childID = iter.next();

        //Switch to child window (Instagram) và hiển thị kết quả URL trên màn hình console
        driver.switchTo().window(childID);
        System.out.println(driver.getCurrentUrl());

        String instagramTitle = driver.getTitle();
        System.out.println(instagramTitle);

        //Switch back to parent window (FB) và hiển thị kết quả URL trên màn hình console
        driver.switchTo().window(parentID);
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());

        //Đóng tab/window hiện tại của trình duyệt đang mở
        driver.close();

        //Đóng tất cả các tab của trình duyệt
        driver.quit();
    }
}