import com.google.common.base.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static java.util.concurrent.TimeUnit.SECONDS;

public class Gmail {
    @Test
    public void testMethod1() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(20, SECONDS);
        driver.manage().timeouts().implicitlyWait(15, SECONDS);
        Wait wait = new FluentWait(driver)
                .withTimeout(30, SECONDS)
                .pollingEvery(5, SECONDS)
                .ignoring(NoSuchElementException.class);
        driver.manage().window().maximize();
        //          *       *       *       *       *
        System.out.println("Singning in and Gmail open");
        //          *       *       *       *       *
        driver.get("https://accounts.google.com/signin");
        WebElement loginPage = (WebElement) wait.until(
                new Function<WebDriver, WebElement>() {
                    public WebElement apply(WebDriver driver) {
                        return driver.findElement(By.id("identifierId"));
                    }
                });
        driver.findElement(By.id("identifierId")).sendKeys("daryatarelkoatm2017@gmail.com");
        driver.findElement(By.cssSelector("span.RveJvd.snByac")).click();
        driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")).sendKeys("123dartar");
        //Thread.sleep(5000);
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.RveJvd.snByac")));
        driver.findElement(By.cssSelector("span.RveJvd.snByac")).click();
        driver.findElement(By.xpath("//*[@id=\"gbwa\"]/div[1]/a")).click();//9 квадратиков
        driver.findElement(By.xpath("//*[@id=\"gb23\"]/span[1]")).click();//Выбор Gmaila
        //          *       *       *       *       *
        System.out.println("New message creating with filling recipient, subject and text of mail");
        //          *       *       *       *       *
        String recipient = "test" + System.nanoTime() + "@gmail.com";
        String subject = "HW week 5";
        String textOfMail = "smth";
        driver.findElement(By.xpath("//a[contains(text(),'Compose')]")).click();
        driver.findElement(By.xpath(".//*[@id='to']")).sendKeys(recipient);
        driver.findElement(By.name("subject")).sendKeys(subject);
        driver.findElement(By.name("body")).sendKeys(textOfMail);
        //          *       *       *       *       *
        System.out.println("Save as draft and check in folder if it is created mail");
        //          *       *       *       *       *
        driver.findElement(By.xpath("//input[@value='Save Draft']")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Drafts')]")).click();
        driver.findElement(By.xpath("//td[3]/a/span")).click();//first draft

        Function<WebDriver, WebElement> function = new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver arg0) {
                System.out.println("Checking presence of the locator");
                WebElement element = arg0.findElement(By.id("to"));
                if (element != null) {
                    System.out.println("Locator is found.");
                }
                return element;
            }
        };
        wait.until(function);
        String draftRecipient = driver.findElement(By.xpath(".//*[@id='to']")).getText();
        SoftAssert asert = new SoftAssert();//We are goint to collect assertions
        asert.assertEquals(draftRecipient, recipient);
        //          *       *       *       *       *
        System.out.println("Send from draft folder and check new first draft to be not equals (garantee that we send mail)");
        //          *       *       *       *       *
        driver.findElement(By.xpath("//input[@value='Send']")).click();
        driver.findElement(By.xpath("//td[3]/a/span")).click();//first draft
        String newFirstDraftRecipient = driver.findElement(By.xpath("//tr[2]/td/a/b")).getText();
        asert.assertNotEquals(newFirstDraftRecipient, recipient);
        //          *       *       *       *       *
        System.out.println("Final check in send folder by uniqe generated recipient");
        //          *       *       *       *       *
        driver.findElement(By.xpath("//tr[5]/td/a")).click();//Sent folder
        driver.findElement(By.xpath("//td[3]/a/span/b")).click();
        String sendRecipient = driver.findElement(By.xpath("//tr[2]/td/a/b")).getText();
        asert.assertEquals(sendRecipient, recipient);
        driver.close();
        asert.assertAll();//Collected assertions final check
    }
}
