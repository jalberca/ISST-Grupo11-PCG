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

public class TestPensamientosMapa {
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
  public void testPensamientosMapa() throws Exception {
    driver.get("http://localhost:8080/ThinkingPlace/Login.jsp");
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    driver.findElement(By.xpath("//a[4]/i")).click();
    driver.findElement(By.id("pac-input")).click();
    driver.findElement(By.id("pac-input")).clear();
    driver.findElement(By.id("pac-input")).sendKeys("puerta");
    driver.findElement(By.name("radio")).click();
    driver.findElement(By.name("radio")).clear();
    driver.findElement(By.name("radio")).sendKeys("500");
    driver.findElement(By.xpath("//form[@action='PensamientosFiltradosServlet']")).click();
    driver.findElement(By.xpath("(//button[@type='submit'])[3]")).click();
    driver.findElement(By.xpath("//p")).click();
    assertEquals("estoy en sol", driver.findElement(By.xpath("//p")).getText());
    driver.findElement(By.xpath("//map[@id='gmimap1']/area")).click();
    driver.findElement(By.xpath("//div[@id='map']/div/div/div/div[3]/div[2]/div[4]/div/div[2]")).click();
    assertEquals("estoy en sol", driver.findElement(By.xpath("//div[@id='map']/div/div/div/div[3]/div[2]/div[4]/div/div[2]/div/div")).getText());
    driver.findElement(By.xpath("//img[contains(@src,'https://maps.gstatic.com/mapfiles/api-3/images/tmapctrl.png')]")).click();
    driver.findElement(By.xpath("//div[@id='map']/div/div/div/div[3]/div")).click();
    driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
    driver.findElement(By.xpath("//div[@id='map']/div/div/div/div[3]/div")).click();
    driver.findElement(By.name("radio")).click();
    driver.findElement(By.name("radio")).clear();
    driver.findElement(By.name("radio")).sendKeys("250");
    driver.findElement(By.xpath("(//button[@type='submit'])[13]")).click();
    driver.findElement(By.xpath("//p")).click();
    assertEquals("estoy en el retiro", driver.findElement(By.xpath("//p")).getText());
    driver.findElement(By.xpath("//map[@id='gmimap0']/area")).click();
    driver.findElement(By.xpath("//div[@id='map']/div/div/div/div[3]/div[2]/div[4]/div/div[2]")).click();
    assertEquals("estoy en el retiro", driver.findElement(By.xpath("//div[@id='map']/div/div/div/div[3]/div[2]/div[4]/div/div[2]/div/div")).getText());
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
