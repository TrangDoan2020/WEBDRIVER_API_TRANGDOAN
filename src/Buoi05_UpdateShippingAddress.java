import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import java.time.Duration;
import java.util.List;

public class Buoi05_UpdateShippingAddress {
    public static void main(String[] args)
    {
        String projectPath = System.getProperty("user.dir");
        System.out.println(projectPath);
        System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        //Fluent Wait
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(1))
                .withMessage("Time out after 20 seconds")
                .ignoring(NoSuchElementException.class);

        // Vào trang sendo.vn
        driver.get("https://sendo.vn");

        // Tắt popup "Ở nhà là nhất - 10K
        List<WebElement> btnClose1 =
                wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='modal-content']/button[starts-with(@class,'close')]")));
        if (btnClose1.size()>0) {
            btnClose1.get(0).click();
        }

        // Tắt popup "Bật thông báo để không bỏ lỡ..."
        List<WebElement> btnClose2 =
                wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//button[starts-with(@class,'closeBtn')]")));
        if (btnClose2.size()>0){
            btnClose2.get(0).click();
        }

        // Click Đăng nhập
        WebElement btnLogin = driver.findElement(By.xpath("//button[@id='login']"));
        btnLogin.click();

        // Click link "Đã có SendoID"
        WebElement eleHaveSendoId = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Đã có SendoID']")));
        eleHaveSendoId.click();

        // Nhập textbox Email
        WebElement txtEmail = driver.findElement(By.xpath("//input[@name='username']"));
        txtEmail.sendKeys("trangdoan@mailinator.com");

        // Nhập text Pass
        WebElement txtPass = driver.findElement(By.xpath("//input[@name='password']"));
        txtPass.sendKeys("12345678");

        // Click button Đăng nhập
        WebElement btnLogin2 = driver.findElement(By.xpath("//button[starts-with(@class,'btnLogin')]"));
        btnLogin2.click();

        //Tắt poup đăng nhập thành công
        //driver.findElement(By.xpath(("//button[starts-with(@class,'close')]"))).click();
        //WebElement eleClose = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[starts-with(@class,'close')]")));
        //eleClose.click();

        //Nhấn vào tên user
        WebElement eleMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='user_menu']")));
        eleMenu.click();

        //Nhấn vào thông tin tài khoản
        WebElement eleProfile = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Thông tin tài khoản')]")));
        eleProfile.click();

        //Nhấn vào menu Địa chỉ nhận hàng
        driver.findElement(By.xpath("//a[text()='Địa chỉ nhận hàng']")).click();

        //Nhấn vào icon Chỉnh sửa
        List<WebElement> btnEdits = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//button[contains(@class,'edit')]")));
        if (btnEdits.size()>0)
        {
            btnEdits.get(0).click();
        }

        //Cập nhật Họ
        //driver.findElement(By.xpath(("//input[@name='firstName']"))).clear();
        WebElement txtFirstName = driver.findElement(By.xpath("//input[@name='firstName']"));
        txtFirstName.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
        txtFirstName.sendKeys("Mi Hân");

        //Cập nhật Tên
        //driver.findElement(By.xpath(("//input[@name='lastName']"))).clear();
        WebElement txtLastName = driver.findElement(By.xpath(("//input[@name='lastName']")));
        txtLastName.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
        txtLastName.sendKeys("Nguyễn");

        //Cập nhật Địa chỉ
        WebElement txtAddress = driver.findElement(By.xpath(("//input[@name='address']")));
        txtAddress.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
        txtAddress.sendKeys("Tòa nhà FPT KCX Tân Thuận, đường số 8");

        //Cập nhật Tỉnh/Thành
        WebElement eleCity = driver.findElement(By.xpath("//select[@id='region']"));
        Select drpCity = new Select(eleCity);
        drpCity.selectByVisibleText("Hà Nội");

        //Cập nhật Quận/Huyện
        WebElement eleDistrict = driver.findElement(By.xpath("//select[@id='district']"));
        Select drpDistrict = new Select(eleDistrict);
        drpDistrict.selectByVisibleText("Quận Ba Đình");

        //Cập nhật Phường/Xã
        WebElement eleWard = driver.findElement(By.xpath("//select[@id='ward']"));
        Select drpWard = new Select(eleWard);
        drpWard.selectByVisibleText("Phường Nguyễn Trung Trực");

        //Cập nhật SĐT
        driver.findElement(By.xpath("//input[@name='phone']")).clear();
        driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("0909080808");

        //Cập nhật bản đồ


        //Nhấn button Lưu thông tin
        driver.findElement(By.xpath(("//button[starts-with(@class,'addressSubmit')]"))).click();

        //Get content của popup
        String message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[starts-with(@class,'toast')]/div/p"))).getText();
        System.out.println(message);

        // Đóng trình duyệt
        driver.close();
    }
}
