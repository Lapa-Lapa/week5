import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Gmail {
    @Test
    public void testMethod1() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        //          *       *       *       *       *
        System.out.println("Singning in and Gmail open");
        //          *       *       *       *       *
        driver.get("https://accounts.google.com/signin");
        driver.findElement(By.id("identifierId")).sendKeys("daryatarelkoatm2017@gmail.com");
        driver.findElement(By.cssSelector("span.RveJvd.snByac")).click();
        driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")).sendKeys("123dartar");
        Thread.sleep(5000);
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
        String draftRecipient = driver.findElement(By.xpath(".//*[@id='to']")).getText();
        Assert.assertEquals(draftRecipient, recipient);
        //          *       *       *       *       *
        System.out.println("Send from draft folder and check new first draft to be not equals (garantee that we send mail)");
        //          *       *       *       *       *
        driver.findElement(By.xpath("//input[@value='Send']")).click();
        driver.findElement(By.xpath("//td[3]/a/span")).click();//first draft
        String newFirstDraftRecipient = driver.findElement(By.xpath("//tr[2]/td/a/b")).getText();
        Assert.assertNotEquals(newFirstDraftRecipient, recipient);
        //          *       *       *       *       *
        System.out.println("Final check in send folder by uniqe generated recipient");
        //          *       *       *       *       *
        driver.findElement(By.xpath("//tr[5]/td/a")).click();//Sent folder
        driver.findElement(By.xpath("//td[3]/a/span/b")).click();
        String sendRecipient = driver.findElement(By.xpath("//tr[2]/td/a/b")).getText();
        Assert.assertEquals(sendRecipient, recipient);
        driver.close();
    }
}