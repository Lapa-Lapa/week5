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
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://accounts.google.com/signin");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.id("identifierId")).sendKeys("daryatarelkoatm2017@gmail.com");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("span.RveJvd.snByac")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")).sendKeys("123dartar");
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("span.RveJvd.snByac")).click();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"gbwa\"]/div[1]/a")).click();//9 квадратиков
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"gb23\"]/span[1]")).click();//Выбор Gmaila
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\":45\"]/div/div[2]/span/a")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("#\\3a 3t > div > div")).click();//нажать Compose
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        driver.findElement(By.name("to")).sendKeys("test" + System.nanoTime() + "@gmail.com");
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        driver.findElement(By.xpath(".//*[@class='Ar Au']/div")).sendKeys("smth");
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        driver.findElement(By.name("subjectbox")).click();
        driver.findElement(By.name("subjectbox")).sendKeys("HW week 5");
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        Thread.sleep(10000);
        driver.findElement(By.xpath(".//*[@alt='Close']")).click();//
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        driver.get("https://mail.google.com/mail/#drafts");
        Thread.sleep(15000);
        String draft1 = driver.findElement(By.xpath("/.//*[@class='AO']")).getText();
        String a1 = draft1.substring(0, 22);
        Assert.assertEquals(a1, "Draft\n" +
                "HW week 5 - smth", "Expected to be equal");
        driver.findElement(By.xpath("/.//*[@class='AO']")).click();//letter link
        driver.findElement(By.xpath("//*[@id=\":n0\"]")).click();//Send
        Thread.sleep(15000);
        String draft2 = driver.findElement(By.xpath(".//*[@id=':o2']/div")).getText();//new first draft
        Assert.assertNotEquals(draft1, draft2, "Expected to be NOT equal");
        String send1 = driver.findElement(By.xpath("/.//*[@id=':4']")).getText();//find in Sent folder
        Assert.assertNotEquals(draft1, send1, "Expected to be equal");
        driver.close();
    }
}