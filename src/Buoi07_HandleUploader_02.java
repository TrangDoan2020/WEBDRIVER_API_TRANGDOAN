import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class Buoi07_HandleUploader_02 {
    public static void main(String[] args) {
        String projectPath = System.getProperty("user.dir");
        System.out.println(projectPath);
        System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        // Vào trang http://blueimp.github.io/jQuery-File-Upload/
        driver.get("http://blueimp.github.io/jQuery-File-Upload/");

        //Nhấn button Add Files..
        //driver.findElement(By.xpath("//span[@class='btn btn-success fileinput-button']")).click();
        WebElement btnAddFiles = driver.findElement(By.xpath("//span[contains(@class,'fileinput-button')]"));
        btnAddFiles.click();

        uploadFileWithRobot(projectPath + "\\images\\CoMayMan.jpg");

        //Nhấn button Start
        driver.findElement(By.xpath("//button[@class='btn btn-primary start']")).click();
    }

    public static void uploadFileWithRobot (String filePath) {
        System.out.println(filePath);
        try{
            Thread.sleep(1000);
            StringSelection stringSelection = new StringSelection(filePath);
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(stringSelection, null);

            Robot robot = null;

            try {
                robot = new Robot();
            } catch (AWTException e) {
                e.printStackTrace();
            }

            robot.delay(250);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.delay(150);
            robot.keyRelease(KeyEvent.VK_ENTER);
        }catch (Exception e){

        }
    }
}
