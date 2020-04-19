import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import java.time.Duration;
import java.util.List;

public class Buoi05_UpdateInfo {
    public static void main(String[] args)
    {
        String projectPath = System.getProperty("user.dir");
        System.out.println(projectPath);
        System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        //Fluent Wait
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(36))
                .pollingEvery(Duration.ofSeconds(2))
                .withMessage("Time out after 36 seconds")
                .ignoring(NoSuchElementException.class);

        // Vào trang sendo.vn
        driver.get("https://sendo.vn");

        // Chờ 12s
        //Thread.sleep(12000);

        // Tắt popup "Ở nhà là nhất - 10K
        //WebElement btnClose1 = driver.findElement(By.xpath("//div[@class='modal-content']/button[starts-with(@class,'close')]"));
        //btnClose1.click();
//        List<WebElement> btnClose1 = driver.findElements((By.xpath("//div[@class='modal-content']/button[starts-with(@class,'close')]")));
//        if (btnClose1.size()>0){
//            btnClose1.get(0).click();
//        }
        List<WebElement> btnClose1 =
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='modal-content']/button[starts-with(@class,'close')]")));
        if (btnClose1.size()>0) {
            btnClose1.get(0).click();
        }
        // Tắt popup "Bật thông báo để không bỏ lỡ..."
        //WebElement btnClose2 = driver.findElement(By.xpath("//button[starts-with(@class,'closeBtn')]"));
        //btnClose2.click();
        List<WebElement> btnClose2 =
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//button[starts-with(@class,'closeBtn')]")));
        if (btnClose2.size()>0){
            btnClose2.get(0).click();
        }

        // Click Đăng nhập
        WebElement btnLogin = driver.findElement(By.xpath("//button[@id='login']"));
        btnLogin.click();

        // Chờ 1s
        //Thread.sleep(1000);

        // Click link "Đã có SendoID"
        //WebElement eleHaveSendoId = driver.findElement(By.xpath("//span[text()='Đã có SendoID']"));
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
        //driver.findElement(By.xpath("//button[@id='user_menu']")).click();
        WebElement eleMenu = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@id='user_menu']")));
        eleMenu.click();

        //Nhấn vào thông tin tài khoản
        //driver.findElement(By.xpath("//span[contains(text(),'Thông tin tài khoản')]"));
        WebElement eleProfile = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'Thông tin tài khoản')]")));
        eleProfile.click();

        //Cập nhật Họ và tên đệm
        driver.findElement(By.xpath(("//input[@name='firstName']"))).clear();
        driver.findElement(By.xpath(("//input[@name='firstName']"))).sendKeys("Cheng Cheng");

        //Cập nhật Tên
        driver.findElement(By.xpath(("//input[@name='lastName']"))).clear();
        driver.findElement(By.xpath(("//input[@name='lastName']"))).sendKeys("Phạm");

        //Cập nhật Giới tính
        if (!driver.findElement(By.xpath(("//label[contains(text(),'Nam')]/preceding-sibling::input"))).isSelected())
        {
            driver.findElement(By.xpath(("//label[contains(text(),'Nam')]/preceding-sibling::input"))).click();
        }

        //Cập nhật ngày sinh
//        driver.findElement(By.xpath("//div[@class='DayPickerInput']")).click();
//
//        WebElement eleMonth = driver.findElement(By.xpath("//select[@id='month']"));
//        Select drpMonth = new Select(eleMonth);
//        drpMonth.selectByIndex(6);
//
//        WebElement eleYear = driver.findElement(By.xpath("//select[@id='year']"));
//        Select drpYear = new Select(eleYear);
//        drpYear.selectByIndex(36);
//
//        driver.findElement((By.xpath("//div[@class='DayPicker-Body']//div[1]//div[5]"))).click();

        //Nhấn button Cập nhật
        driver.findElement(By.xpath(("//button[starts-with(@class,'userSubmit')]"))).click();
//        WebElement btnSubmit = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(("//button[starts-with(@class,'userSubmit')]"))));
//        btnSubmit.click();

        //Đóng popup Cập nhật thành công
        //driver.findElement(By.xpath("//div[starts-with(@class,'content')]/button[starts-with(@class,'close')]")).click();

        // Đóng trình duyệt
        driver.close();
    }
}
