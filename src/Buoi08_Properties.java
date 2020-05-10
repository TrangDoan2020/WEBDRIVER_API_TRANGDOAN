import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Buoi08_Properties {
    public static void main(String[] args) throws IOException {
        String projectPath = System.getProperty("user.dir");

        FileInputStream fis = new FileInputStream(projectPath + "/source/config.properties");
        Properties p = new Properties();
        p.load(fis);

        String emailValue = p.getProperty("email");
        String passValue = p.getProperty("password");
        String envValue = p.getProperty("environment");

        System.out.println("Email: " + emailValue);
        System.out.println("Password: " + passValue);
        System.out.println("Environment: " + envValue);
    }
}
