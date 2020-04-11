import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class Buoi03_LocateByTagName {
    public static void main(String[] args) {
        String projectPath = System.getProperty("user.dir");

        System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        //Truy cập vào trang FB
        driver.get("https://facebook.com");

        //Tìm toàn bộ trang web có bao nhiêu đường link, in giá trị các đường link đó ra màn hình
        List<WebElement> eleLinks = driver.findElements(By.tagName("a"));
        System.out.println(eleLinks.size());
        for (WebElement eleLink : eleLinks) {
            String url = eleLink.getAttribute("href");
            System.out.println(url);
        }

        //Đóng tab/window hiện tại của trình duyệt đang mở
        driver.close();
    }
}
