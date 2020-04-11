import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Buoi03_LocateById {
    public static void main (String [] args)
    {
        String projectPath = System.getProperty("user.dir");

        System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        //Truy cập vào trang FB
        driver.get("https://facebook.com");

        //Tìm element của Email, Pass bằng By.id
        WebElement txtEmail = driver.findElement(By.id("email"));
        WebElement txtPass = driver.findElement(By.id("pass"));

        //Nhập dữ liệu cho field Email và Pass
        txtEmail.sendKeys("tester01gm@gmail.com");
        txtPass.sendKeys("123456");

        //Lấy thông tin trong textbox Email và Pass in ra màn hình console
        String valEmail = txtEmail.getAttribute("value");
        System.out.println(valEmail);
        String valPass = txtPass.getAttribute("value");
        System.out.println(valPass);

        //Xóa giá trị từ textbox Email và Pass
        txtEmail.clear();
        txtPass.clear();

        //Kiểm tra ký tự trong ô textbox Email và Pass có hiển thị *** hay ko
        boolean typeEmail = txtEmail.getAttribute("type").equals("password");
        System.out.println(typeEmail);
        boolean typePass = txtPass.getAttribute("type").equals("password");
        System.out.println(typePass);

        //Đóng tab/window hiện tại của trình duyệt đang mở
        driver.close();
    }
}
