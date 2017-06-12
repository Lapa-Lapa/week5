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
        driver.get("https://accounts.google.com/signin");
        driver.findElement(By.id("identifierId")).sendKeys("daryatarelkoatm2017@gmail.com");
        driver.findElement(By.cssSelector("span.RveJvd.snByac")).click();
        driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")).sendKeys("123dartar");
        Thread.sleep(5000);
        driver.findElement(By.cssSelector("span.RveJvd.snByac")).click();
        driver.findElement(By.xpath("//*[@id=\"gbwa\"]/div[1]/a")).click();//9 квадратиков
        driver.findElement(By.xpath("//*[@id=\"gb23\"]/span[1]")).click();//Выбор Gmaila
        //driver.get("https://mail.google.com/mail/?ui=html&zy=h");
        driver.findElement(By.xpath("html/body/table[2]/tbody/tr/td[1]/table[1]/tbody/tr[1]/td/b/a")).click();//нажать Compose
        String a0 = "test" + System.nanoTime() + "@gmail.com";
        driver.findElement(By.xpath(".//*[@id='to']")).sendKeys(a0);
        String a1 = "smth";
        driver.findElement(By.xpath("html/body/table[2]/tbody/tr/td[2]/table[1]/tbody/tr/td[2]/form/table[2]/tbody/tr[8]/td[2]/textarea")).sendKeys(a1);
        driver.findElement(By.xpath("html/body/table[2]/tbody/tr/td[2]/table[1]/tbody/tr/td[2]/form/table[2]/tbody/tr[4]/td[2]/input")).click();
        String a2 = "HW week 5";
        driver.findElement(By.xpath("html/body/table[2]/tbody/tr/td[2]/table[1]/tbody/tr/td[2]/form/table[2]/tbody/tr[4]/td[2]/input")).sendKeys(a2);
        driver.findElement(By.xpath("html/body/table[2]/tbody/tr/td[2]/table[1]/tbody/tr/td[2]/form/table[3]/tbody/tr/td/input[2]")).click();
        driver.findElement(By.xpath("html/body/table[2]/tbody/tr/td[1]/table[1]/tbody/tr[6]/td/h3/b/a")).click();
        driver.findElement(By.xpath("html/body/table[2]/tbody/tr/td[2]/table[1]/tbody/tr/td[2]/form/table[2]/tbody/tr[1]/td[3]/a/span")).click();
        String to = driver.findElement(By.xpath(".//*[@id='to']")).getText();
        Assert.assertEquals(to, a0);
        driver.findElement(By.xpath("html/body/table[2]/tbody/tr/td[2]/table[1]/tbody/tr/td[2]/form/table[3]/tbody/tr/td[1]/input[1]")).click();//Send
        driver.findElement(By.xpath("html/body/table[2]/tbody/tr/td[2]/table[1]/tbody/tr/td[2]/form/table[2]/tbody/tr[1]/td[3]/a/span")).click();
        String to2 = driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td[2]/table[1]/tbody/tr/td[2]/table[4]/tbody/tr/td/table[3]/tbody/tr[4]/td/div/div/table/tbody/tr[1]/td/table/tbody/tr/td/table/tbody/tr[2]/td/a/b")).getText();
        Assert.assertNotEquals(to2, a0);
        driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td[1]/table[1]/tbody/tr[5]/td/a")).click();//Sent folder
        driver.findElement(By.xpath("//html/body/table[2]/tbody/tr/td[2]/table[1]/tbody/tr/td[2]/form/table[2]/tbody/tr[1]/td[3]/a/span/b")).click();
        String send1to = driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td[2]/table[1]/tbody/tr/td[2]/table[5]/tbody/tr/td/table[1]/tbody/tr[4]/td/div/div/table/tbody/tr[1]/td/table/tbody/tr/td/table/tbody/tr[2]/td/a/b")).getText();
        Assert.assertEquals(send1to, a0);
        driver.close();
    }
}