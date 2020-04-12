import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Buoi03_SignInSendo {
    public static void main (String [] args) throws InterruptedException {
        String projectPath = System.getProperty("user.dir");

        System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        //Truy cập vào trang sendo.vn
        driver.get("https://sendo.vn");

        Thread.sleep(7000);
        driver.findElement(By.xpath("//button[@class='close_3d2Y']")).click();
        //Thread.sleep(1000);
        //driver.findElement(By.xpath("//button[@class='closeBtn_2s1w']")).click();

        //Tìm element của link Đăng nhập
        //WebElement lnkSignin = driver.findElement(By.xpath("//span[contains(text(),'Đăng nhập')]"));
        //lnkSignin.click();

        //WebElement lnkSendoID = driver.findElement(By.xpath("//span[contains(text(),'Đã có SendoID')]"));
        //lnkSendoID.click();

        //WebElement txtEmail = driver.findElement(By.xpath("//input[@name='username']"));
        //WebElement textPass = driver.findElement(By.xpath("//input[@name='password']"));

        //txtEmail.sendKeys("0938586131");
        //textPass.sendKeys("123456@");

       // driver.findElement(By.xpath("//button[@class='btnLogin_1eqO']")).click();

        //Đóng tab/window hiện tại của trình duyệt đang mở
        driver.close();
    }
}
