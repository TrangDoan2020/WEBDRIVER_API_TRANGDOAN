import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.SQLOutput;

public class Buoi03_LocateByClassName {
    public static void main (String [] args)
    {
        String projectPath = System.getProperty("user.dir");

        System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        //Truy cập vào trang FB
        driver.get("https://facebook.com");

        //Tìm element bằng By.className
        String lblWelcomText = driver.findElement(By.className("_5iyx")).getText();
        System.out.println(lblWelcomText);

        //Tìm element của Email, Pass bằng By.className
//        WebElement eleEmail = driver.findElement(By.className("inputtext login_form_input_box"));
//        WebElement elePass = driver.findElement(By.className("inputtext login_form_input_box"));
//
//        //Nhập dữ liệu cho field Email và Pass
//        eleEmail.sendKeys("tester01gm@gmail.com");
//        elePass.sendKeys("123456");

        //Đóng tab/window hiện tại của trình duyệt đang mở
        driver.close();
    }
}
