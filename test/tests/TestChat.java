package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class UntitledTestCase {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://www.katalon.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testUntitledTestCase() throws Exception {
    driver.get("http://localhost:8080/ISST-Grupo11-PCG/PensamientosFiltrados.jsp");
    driver.findElement(By.xpath("//div[@id='map']/div/div/div/div[3]/div")).click();
    driver.findElement(By.name("radio")).click();
    driver.findElement(By.name("radio")).clear();
    driver.findElement(By.name("radio")).sendKeys("20000");
    driver.findElement(By.xpath("(//button[@type='submit'])[3]")).click();
    driver.findElement(By.xpath("(//button[@type='submit'])[6]")).click();
    driver.findElement(By.xpath("(//button[@type='submit'])[6]")).click();
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    driver.findElement(By.xpath("//a[4]/i")).click();
    driver.findElement(By.xpath("(//button[@type='submit'])[6]")).click();
    driver.findElement(By.id("msg")).clear();
    driver.findElement(By.id("msg")).sendKeys("Hola");
    driver.findElement(By.id("msg")).sendKeys(Keys.ENTER);
    driver.findElement(By.id("msg")).clear();
    driver.findElement(By.id("msg")).sendKeys("Buen pensamiento!");
    driver.findElement(By.id("msg")).sendKeys(Keys.ENTER);
    driver.findElement(By.id("msg")).clear();
    driver.findElement(By.id("msg")).sendKeys("Me gusta :)");
    driver.findElement(By.id("msg")).sendKeys(Keys.ENTER);
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    driver.findElement(By.xpath("//a[contains(@href, 'misChatsServlet')]")).click();
    driver.findElement(By.xpath("(//button[@type='submit'])[4]")).click();
    driver.findElement(By.xpath("//button[@type='submit']")).click();
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
