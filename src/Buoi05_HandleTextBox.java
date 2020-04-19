import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Buoi05_HandleTextBox {
    public static void main (String [] args) {
        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //Truy cập vào trang Google
        driver.get("https://google.com");

        //Kiểm tra textbox có đang ở trạng thái Enabled hay ko?
        WebElement txtSearch = driver.findElement(By.xpath("//input[@name='q']"));
        Boolean state = txtSearch.isEnabled();
        System.out.println(state);

        //Nhập dữ liệu vào textbox
        txtSearch.sendKeys("Selenium");

        //Xóa dữ liệu torng textbox
        txtSearch.clear();
        txtSearch.sendKeys("Java");

        //Nhấn button Tìm với Goolge
        //driver.findElement(By.xpath("//div[@class='tfB0Bf']//input[@name='btnK']"));

        //Key ENTER
        //txtSearch.sendKeys(Keys.ENTER);
        txtSearch.sendKeys("Selenium",Keys.ENTER);

        //Lấy giá trị từ trong textbox và in ra kết quả ở màn hình console
        WebElement txtSearch2 = driver.findElement(By.xpath("//input[@name='q']"));
        String txtValue = txtSearch2.getAttribute("value");
        System.out.println(txtValue);

        //Đóng tab/window hiện tại của trình duyệt đang mở
        driver.close();
    }
}
