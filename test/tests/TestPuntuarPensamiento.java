package tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TestPuntuarPensamiento {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	//Indicamos donde se encuentra el archivo con el driver de chrome
	  System.setProperty( "webdriver.chrome.driver", "/home/isst/chromedriver");
	  driver = new ChromeDriver();
    baseUrl = "https://www.katalon.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void test3TestPuntuarPensamiento() throws Exception {
    driver.get("http://localhost:8080/ThinkingPlace/Login.jsp");
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    driver.findElement(By.xpath("//a[3]/i")).click();
    driver.findElement(By.id("pac-input")).click();
    driver.findElement(By.id("pac-input")).clear();
    driver.findElement(By.id("pac-input")).sendKeys("Etsit");
    driver.findElement(By.xpath("//body")).click();
    driver.findElement(By.name("radio")).click();
    driver.findElement(By.name("radio")).clear();
    driver.findElement(By.name("radio")).sendKeys("400");
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    driver.findElement(By.xpath("//button/i")).click();
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    driver.findElement(By.xpath("//div[2]/div/button[2]/i")).click();
    driver.findElement(By.xpath("//div[2]/div/button[2]/i")).click();
    assertEquals("(1)", driver.findElement(By.xpath("//button[@type='submit']")).getText());
    assertEquals("(1)", driver.findElement(By.xpath("(//button[@type='submit'])[7]")).getText());
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
