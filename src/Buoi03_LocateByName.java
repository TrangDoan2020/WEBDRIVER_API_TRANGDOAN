import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Buoi03_LocateByName {
    public static void main (String [] args)
    {
        String projectPath = System.getProperty("user.dir");

        System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        //Truy cập vào trang FB
        driver.get("https://facebook.com");

        //Tìm element của Email, Pass bằng By.name
        WebElement eleEmail = driver.findElement(By.name("email"));
        WebElement elePass = driver.findElement(By.name("pass"));

        //Nhập dữ liệu cho field Email và Pass
        eleEmail.sendKeys("tester01gm@gmail.com");
        elePass.sendKeys("123456");

        //Lấy thông tin trong textbox Email và Pass in ra màn hình console
        String valEmail = eleEmail.getAttribute("value");
        System.out.println(valEmail);
        String valPass = elePass.getAttribute("value");
        System.out.println(valPass);

        //Xóa giá trị từ textbox Email và Pass
        eleEmail.clear();
        elePass.clear();

        //Kiểm tra ký tự trong ô textbox Email và Pass có hiển thị *** hay ko
        boolean typeEmail = eleEmail.getAttribute("type").equals("password");
        System.out.println(typeEmail);
        boolean typePass = elePass.getAttribute("type").equals("password");
        System.out.println(typePass);

        //Đóng tab/window hiện tại của trình duyệt đang mở
        driver.close();
    }
}
