import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Buoi03_LocateByCssSelector {
    public static void main (String [] args){
        String projectPath = System.getProperty("user.dir");

        System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        //Truy cập vào trang FB
        driver.get("https://facebook.com");

        //Tìm element của Email và Pass bằng cssSelector  - cách 1
//        WebElement txtEmail = driver.findElement(By.cssSelector("input[id='email']"));
//        WebElement txtPass = driver.findElement(By.cssSelector("input[id='pass']"));

        //Tìm element của Email và Pass bằng cssSelector  - cách 2
//        WebElement txtEmail = driver.findElement(By.cssSelector("input[name='email']"));
//        WebElement txtPass = driver.findElement(By.cssSelector("input[name='pass']"));

        //Tìm element của Email và Pass bằng cssSelector  - cách 3
        //WebElement txtEmail = driver.findElement(By.cssSelector("input#email"));
        //WebElement txtPass = driver.findElement(By.cssSelector("input#pass"));

        //Tìm element của Email và Pass bằng cssSelector  - cách 4
        WebElement txtEmail = driver.findElement(By.cssSelector("input.email"));
        WebElement txtPass = driver.findElement(By.cssSelector("input.pass"));

        //Nhập dữ liệu cho field Email và Pass
        txtEmail.sendKeys("tester01gm@gmail.com");
        txtPass.sendKeys("123456");

        //Đóng tab/window hiện tại của trình duyệt đang mở
        driver.close();
    }
}
