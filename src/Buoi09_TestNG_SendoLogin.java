import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

public class Buoi09_TestNG_SendoLogin {
    WebDriver driver;
    Wait<WebDriver> wait;

    @Parameters("browser")
    @BeforeMethod
    public void beforeMethod(String browserValue){
        String projectPath = System.getProperty("user.dir");
        System.out.println(projectPath);

        if(browserValue.equals("chrome")){
            System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver.exe");
            driver = new ChromeDriver();
        }else if (browserValue.equals("firefox")){
            System.setProperty("webdriver.gecko.driver", projectPath + "/drivers/geckodriver.exe");
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();

        //Fluent Wait
        wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(2))
                .withMessage("Time out after 20 seconds")
                .ignoring(NoSuchElementException.class);

        // Pre-condition: Vào trang sendo.vn
        driver.get("https://sendo.vn");
    }

    @Parameters({"email_1" , "password_1"})
    @Test
    public void TC_Login_01_EnterNoPassword(String emailValue, String passwordValue){
        SoftAssert softAssert = new SoftAssert();

        // Step 1: Tắt popup "Ở nhà là nhất - 10K
        List<WebElement> btnClose1 =
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='modal-content']/button[starts-with(@class,'close')]")));
        if (btnClose1.size()>0) {
            btnClose1.get(0).click();
        }

        // Step 2: Tắt popup "Bật thông báo để không bỏ lỡ..."
        List<WebElement> btnClose2 =
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//button[starts-with(@class,'closeBtn')]")));
        if (btnClose2.size()>0){
            btnClose2.get(0).click();
        }

        // Verify failed
        //Assert.assertTrue(false, "Verify failed");
        softAssert.assertTrue(false, "Verify failed");

        // Step 3: Click Đăng nhập
        WebElement btnLogin = driver.findElement(By.xpath("//button[@id='login']"));
        btnLogin.click();

        // Step 4: Click link "Đã có SendoID"
        WebElement eleHaveSendoId = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Đã có SendoID']")));
        eleHaveSendoId.click();

        // Step 5: Nhập textbox Email
        WebElement txtEmail = driver.findElement(By.xpath("//input[@name='username']"));
        txtEmail.sendKeys(emailValue);

        // Step 6: Nhập text Pass
        WebElement txtPass = driver.findElement(By.xpath("//input[@name='password']"));
        txtPass.sendKeys(passwordValue);

        // Step 7: Click button Đăng nhập
        WebElement btnLogin2 = driver.findElement(By.xpath("//button[starts-with(@class,'btnLogin')]"));
        btnLogin2.click();

        // Step 8: Get error text
        WebElement eleErrorText = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[starts-with(@class,'error')]")));
        String actualResult = eleErrorText.getText();
        System.out.println(actualResult);

        // Verify message
        String expectedResult = "Vui lòng nhập mật khẩu đăng nhập.";
//        if(actualResult.equals(expectedResult)){
//            System.out.println("TC PASSED");
//        } else {
//            System.out.println("TC FAILED");
//        }
        //Assert.assertEquals(actualResult,expectedResult,"Error message is not matched!");
        softAssert.assertEquals(actualResult,expectedResult,"Error message is not matched!");

        softAssert.assertAll();
    }

    @Parameters({"email_2" , "password_2"})
    @Test
    public void TC_Login_02_EnterPasswordLessThan6Chars(String emailValue, String passwordValue){
        // Step 1: Tắt popup "Ở nhà là nhất - 10K
        List<WebElement> btnClose1 =
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='modal-content']/button[starts-with(@class,'close')]")));
        if (btnClose1.size()>0) {
            btnClose1.get(0).click();
        }

        // Step 2: Tắt popup "Bật thông báo để không bỏ lỡ..."
        List<WebElement> btnClose2 =
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//button[starts-with(@class,'closeBtn')]")));
        if (btnClose2.size()>0){
            btnClose2.get(0).click();
        }

        // Step 3: Click Đăng nhập
        WebElement btnLogin = driver.findElement(By.xpath("//button[@id='login']"));
        btnLogin.click();

        // Step 4: Click link "Đã có SendoID"
        WebElement eleHaveSendoId = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Đã có SendoID']")));
        eleHaveSendoId.click();

        // Step 5: Nhập textbox Email
        WebElement txtEmail = driver.findElement(By.xpath("//input[@name='username']"));
        txtEmail.sendKeys(emailValue);

        // Step 6: Nhập text Pass
        WebElement txtPass = driver.findElement(By.xpath("//input[@name='password']"));
        txtPass.sendKeys(passwordValue);

        // Step 7: Click button Đăng nhập
        WebElement btnLogin2 = driver.findElement(By.xpath("//button[starts-with(@class,'btnLogin')]"));
        btnLogin2.click();

        // Step 8: Get error text
        WebElement eleErrorText = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[starts-with(@class,'error')]")));
        String actualResult = eleErrorText.getText();
        System.out.println(actualResult);

        // Verify message
        String expectedResult = "Độ dài mật khẩu từ 6 đến 32 ký tự, vui lòng nhập lại.";
//        if(actualResult.equals(expectedResult)){
//            System.out.println("TC PASSED");
//        } else {
//            System.out.println("TC FAILED");
//        }
        Assert.assertEquals(actualResult,expectedResult,"Error message is not matched!");
    }

    @Parameters({"email_3" , "password_3"})
    @Test
    public void TC_Login_03_EnterWrongPassword(String emailValue, String passwordValue) {
        // Step 1: Tắt popup "Ở nhà là nhất - 10K
        List<WebElement> btnClose1 =
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='modal-content']/button[starts-with(@class,'close')]")));
        if (btnClose1.size()>0) {
            btnClose1.get(0).click();
        }

        // Step 2: Tắt popup "Bật thông báo để không bỏ lỡ..."
        List<WebElement> btnClose2 =
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//button[starts-with(@class,'closeBtn')]")));
        if (btnClose2.size()>0){
            btnClose2.get(0).click();
        }

        // Step 3: Click Đăng nhập
        WebElement btnLogin = driver.findElement(By.xpath("//button[@id='login']"));
        btnLogin.click();

        // Step 4: Click link "Đã có SendoID"
        WebElement eleHaveSendoId = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Đã có SendoID']")));
        eleHaveSendoId.click();

        // Step 5: Nhập textbox Email
        WebElement txtEmail = driver.findElement(By.xpath("//input[@name='username']"));
        txtEmail.sendKeys(emailValue);

        // Step 6: Nhập text Pass
        WebElement txtPass = driver.findElement(By.xpath("//input[@name='password']"));
        txtPass.sendKeys(passwordValue);

        // Step 7: Click button Đăng nhập
        WebElement btnLogin2 = driver.findElement(By.xpath("//button[starts-with(@class,'btnLogin')]"));
        btnLogin2.click();

        // Step 8: Get error text
        WebElement eleErrorText = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[starts-with(@class,'error')]")));
        String actualResult = eleErrorText.getText();
        System.out.println(actualResult);

        // Verify message
        String expectedResult = "Sai mật khẩu hoặc tài khoản đăng nhập. Vui lòng nhập lại.";
//        if(actualResult.equals(expectedResult)){
//            System.out.println("TC PASSED");
//        } else {
//            System.out.println("TC FAILED");
//        }
        Assert.assertEquals(actualResult,expectedResult,"Error message is not matched!");
    }

    @AfterMethod
    public void afterMethod(){
        // Post-condition: Đóng trình duyệt
        driver.close();
    }
}
