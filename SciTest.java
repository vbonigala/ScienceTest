import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.io.File;
import java.lang.Boolean;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver.Options;
import static org.openqa.selenium.OutputType.*;

public class SciTest {
    public static void main(String[] args) throws Exception {
        FirefoxDriver wd;
        wd = new FirefoxDriver();
        Options op = wd.manage();
        op.timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        wd.get("https://www.google.com/");
        wd.findElement(By.id("lst-ib")).click();
        wd.findElement(By.id("lst-ib")).clear();
        wd.findElement(By.id("lst-ib")).sendKeys("science");
        wd.findElement(By.name("btnG")).click();
        wd.findElement(By.linkText("Science - Wikipedia, the free encyclopedia")).click();
        Boolean ver = wd.findElement(By.id("firstHeading")).getText().equals("Science");
        if (!ver) {
            System.out.println("verifyText failed");
        }
        wd.quit();
    }

    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}
