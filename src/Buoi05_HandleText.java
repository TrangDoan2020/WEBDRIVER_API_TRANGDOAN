import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;

public class Buoi05_HandleText {
    public static void main (String [] args){
        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //Truy cập vào trang FB
        driver.get("https://facebook.com");

        //Lấy giá trị text
        //String lblWelcome = driver.findElement(By.xpath("//div[@class='_5iyx']")).getText();
        WebElement lblWelcome = driver.findElement(By.xpath("//div[starts-with(text(),'Facebook')]"));
        String textValue = lblWelcome.getText();
        System.out.println(textValue);

        //Lấy giá trị font-family và in kết quả ra màn hình console
        String fontFamily = lblWelcome.getCssValue("font-family");
        System.out.println("Font-Family là: " + fontFamily);

        //Lấy giá trị font-size và in kết quả ra màn hình console
        String fontSize = lblWelcome.getCssValue("font-size");
        System.out.println("Font-Size là: " + fontSize);

        //Lấy giá trị color và in kết quả ra màn hình console
        String txtColor = lblWelcome.getCssValue("color");
        System.out.println("Color là: " + Color.fromString(txtColor).asHex());

        //Đóng tab/window hiện tại của trình duyệt đang mở
        driver.close();
    }
}
