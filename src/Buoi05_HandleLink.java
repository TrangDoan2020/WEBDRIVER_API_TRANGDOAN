import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class Buoi05_HandleLink {
    public static void main (String [] args) {
        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //Truy cập vào trang FB
        driver.get("https://facebook.com");

        //In giá trị tất cả các đường link ra màn hình console
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println(links.size());

        for (int i=0;i<links.size();i++){
            String linkValue = links.get(i).getAttribute("href");
            System.out.println(linkValue);
        }

        //Xác định các đường link ở FB footer
        List<WebElement> childLinks = driver.findElement(By.xpath("//div[@id='pageFooterChildren']")).findElements(By.tagName("a"));
        System.out.println(childLinks.size());

        for (int i=0;i<childLinks.size();i++){
            String linkValue = links.get(i).getAttribute("href");
            System.out.println(linkValue);
        }

        //Đóng tab/window hiện tại của trình duyệt đang mở
        driver.close();
    }
}
