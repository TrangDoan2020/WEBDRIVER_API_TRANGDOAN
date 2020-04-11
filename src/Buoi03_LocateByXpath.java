import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Buoi03_LocateByXpath {
    public static void main(String[] args) {
        String projectPath = System.getProperty("user.dir");

        System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        //Truy cập vào trang FB
        driver.get("https://facebook.com");

        //Tìm element của Email và Pass bằng Xpath - cách 1
        WebElement txtEmail = driver.findElement(By.xpath("//input[@id='email']"));
        WebElement txtPass = driver.findElement(By.xpath("//input[@id='pass']"));

        //Tìm element của Email và Pass bằng Xpath - cách 2
        //driver.findElement(By.xpath("//input[@name='email']")).sendKeys("tester01gm@gmail.com");
        //driver.findElement(By.xpath("//input[@name='pass']")).sendKeys("123456");

        //Tìm element của nút Đăng ký (giả sử ko có các thuộc tính)
        WebElement btnRegister = driver.findElement(By.xpath("//button[text()='Đăng ký']"));
        btnRegister.click();

        //Nhập dữ liệu cho field Email và Pass
        txtEmail.sendKeys("tester01gm@gmail.com");
        txtPass.sendKeys("123456");

        //Đóng tab/window hiện tại của trình duyệt đang mở
        driver.close();
    }
}