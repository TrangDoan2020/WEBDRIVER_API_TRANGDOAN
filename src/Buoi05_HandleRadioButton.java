import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Buoi05_HandleRadioButton {
    public static void main (String [] args) {
        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //Truy cập vào trang FB
        driver.get("https://facebook.com");

        //Click vào radio button "Nam"
        driver.findElement(By.xpath("//label[contains(text(),'Nam')]")).click();
        //driver.findElement(By.xpath("//input/following-sibling::label [text()='Nam']")).click();

        //Kiểm tra radio button có đc click chọn hay chưa
        boolean chkState = driver.findElement(By.xpath("//label [text()='Nam']/preceding-sibling::input")).isSelected();
        System.out.println(chkState);

        //Đóng tab/window hiện tại của trình duyệt đang mở
        driver.close();
    }
}
