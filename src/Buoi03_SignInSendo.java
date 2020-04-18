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

        //Chờ 12s
        Thread.sleep(12000);

        //// Tắt popup quảng cáo
        driver.findElement(By.xpath("//div[@class='modal-content']/button[starts-with(@class,'close')]")).click();

        //Tắt popup "Bật thông báo để không bỏ lỡ..."
        //driver.findElement(By.xpath("//button[@class='closeBtn_2s1w']")).click();
        driver.findElement(By.xpath("//button[starts-with(@class,'closeBtn')]")).click();

        //Click Đăng nhập
        WebElement lnkSignin = driver.findElement(By.xpath("//span[contains(text(),'Đăng nhập')]"));
        lnkSignin.click();

        //Chờ 1s
        Thread.sleep(1000);

        // Click link "Đã có SendoID"
        WebElement lnkSendoID = driver.findElement(By.xpath("//span[text()='Đã có SendoID']"));
        lnkSendoID.click();

        // Nhập textbox Email, Password
        WebElement txtEmail = driver.findElement(By.xpath("//input[@name='username']"));
        WebElement textPass = driver.findElement(By.xpath("//input[@name='password']"));

        txtEmail.sendKeys("0909090909");
        textPass.sendKeys("12345678");

        // Click button Đăng nhập
        driver.findElement(By.xpath("//button[starts-with(@class,'btnLogin')]")).click();

        // Chờ 1s
        Thread.sleep(2000);

        // Get error text
        String errorMsg = driver.findElement(By.xpath("//p[starts-with(@class,'error')]")).getText();
        System.out.println(errorMsg);

        //Đóng tab/window hiện tại của trình duyệt đang mở
        driver.close();
    }
}
