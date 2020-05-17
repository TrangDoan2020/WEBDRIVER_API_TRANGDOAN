import org.testng.annotations.*;

public class Buoi09_TestNG_Annotations {
    @BeforeTest
    public void beforeTest(){
        System.out.println("Run Before Test");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Rune Before Method");
    }

    @Test
    public void TC_01(){
        System.out.println("Run TC_01");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("Run After Method");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("Run After Test");
    }

    @Test
    public void TC_02(){
        System.out.println("Run TC_02");
    }
}
