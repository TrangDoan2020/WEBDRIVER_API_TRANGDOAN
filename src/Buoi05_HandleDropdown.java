import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Buoi05_HandleDropdown {
    public static void main (String [] args) {
        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //Truy cập vào trang FB
        driver.get("https://facebook.com");

        //Khởi tạo lớp Select
        //Select drpMonth = new Select(driver.findElement(By.xpath("//select[@id='month']")));
        WebElement eleMonth = driver.findElement(By.xpath("//select[@id='month']"));
        Select drpMonth = new Select(eleMonth);

        //Chọn giá trị theo index (optionID)
        drpMonth.selectByIndex(5);

        //Chọn giá trị theo value
        drpMonth.selectByValue("3");

        //Chọn giá trị theo text
        drpMonth.selectByVisibleText("Tháng 7");

        //Lấy giá trị đầu tiên đang đc selected trong dropdown và in giá trị đó lên màn hình console
        WebElement selectedOption = drpMonth.getFirstSelectedOption();
        System.out.println(selectedOption.getText());

        //Lấy danh sách các giá trị trong dropdown
        int drpSize = drpMonth.getOptions().size();
        System.out.println(drpSize);

        for (int i=0;i<drpSize;i++){
            String optText = drpMonth.getOptions().get(i).getText();
            System.out.println(optText);
        }

        //Đóng tab/window hiện tại của trình duyệt đang mở
        driver.close();
    }
}
