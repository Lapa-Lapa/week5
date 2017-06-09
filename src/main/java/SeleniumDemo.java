import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class SeleniumDemo {

    String LOGIN = "daryatarelkoatm2017";
    String PASSWORD = "123dartar";


    @FindBy(css = "input#identifierId.whsOnd.zHQkBf")
    private WebElement loginField;

    @FindBy(css = "span.RveJvd.snByac")
    private WebElement submitButtonForLogin;

    @FindBy(xpath = "id('password')/x:div[1]/x:div/x:div[1]/x:input")
    private WebElement passwordField;

    @FindBy(css = "span.RveJvd.snByac")
    private WebElement submitButtonForPassword;

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://accounts.google.com/signin");
    }

        public void authorization (String LOGIN, String PASSWORD){
            //loginField.click();
            //loginField.clear();
            loginField.sendKeys(LOGIN);
            submitButtonForLogin.click();
            passwordField.click();
            passwordField.clear();
            passwordField.sendKeys(PASSWORD);
            passwordField.click();
        }
    }



//        driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("Iphone SE");
//        driver.findElement(By.xpath("//input[@value='Go']")).click();
//        driver.findElement(By.cssSelector("#result_0 a.s-access-detail-page")).click();
//        String price = driver.findElement(By.cssSelector("#priceblock_ourprice")).getText();
//        driver.close();
//        System.out.println("iPhone SE price is " + price);


/**
 * import java.util.regex.Pattern;  import java.util.concurrent.TimeUnit;
 * import org.testng.annotations.*;   import static org.testng.Assert.*;
 * import org.openqa.selenium.*;      import org.openqa.selenium.firefox.FirefoxDriver;
 * import org.openqa.selenium.support.ui.Select;
 * private boolean acceptNextAlert = true;
 * private StringBuffer verificationErrors = new StringBuffer();
 * public void setUp() throws Exception {
 * baseUrl = "";
 * driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); }
 *
 * @Test public void testNewHW() throws Exception {
 * // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | null | ]]
 * @AfterClass(alwaysRun = true) public void tearDown() throws Exception { driver.quit();
 * String verificationErrorString = verificationErrors.toString();
 * if (!"".equals(verificationErrorString)) { fail(verificationErrorString); } }
 * private boolean isElementPresent(By by) { try { driver.findElement(by); return true; }
 * catch (NoSuchElementException e) { return false; } }
 * private boolean isAlertPresent() { try { driver.switchTo().alert(); return true; }
 * catch (NoAlertPresentException e) { return false; } }
 * private String closeAlertAndGetItsText() { try { Alert alert = driver.switchTo().alert(); String alertText = alert.getText(); if (acceptNextAlert) { alert.accept(); } else { alert.dismiss(); } return alertText; } finally { acceptNextAlert = true; } } }
 */