import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Buoi03_LocateByLinkText {
    public static void main(String[] args) {
        String projectPath = System.getProperty("user.dir");

        System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        //Truy cập vào trang FB
        driver.get("https://facebook.com");

        //Tìm element của link Quên tài khoản?
        WebElement eleLink = driver.findElement(By.linkText("Quên tài khoản?"));

        //Lấy giá trị đường link và hiển thị giá trị đó ra màn hình console
        String forgetUrl = eleLink.getAttribute("href");
        System.out.println(forgetUrl);

        //Click vào link Quên tài khoản?
        eleLink.click();

        //Đóng tab/window hiện tại của trình duyệt đang mở
        driver.close();
    }
}
