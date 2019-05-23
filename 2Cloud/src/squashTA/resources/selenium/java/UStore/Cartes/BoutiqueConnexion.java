import java.util.regex.Pattern;
import java.lang.Thread;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxProfile; 
import java.io.File;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

  public class BoutiqueConnexion {
  private FirefoxBinary binary = new FirefoxBinary(new File("C:/Users/gcmbembeyegdjong/Desktop/Squash/Firefox12/firefox.exe"));
  private FirefoxProfile profile = new FirefoxProfile();
  private WebDriver driver;
  private String baseUrl;
  private Map<String, Object> vars;
   JavascriptExecutor js;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	driver = new FirefoxDriver(binary,profile);
	 js = (JavascriptExecutor) driver;
	 vars = new HashMap<String, Object>();
    baseUrl = "https://dev.plateforme-2cloud.com/boutique/connexion";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testBoutiqueConnexion() throws Exception {
	driver.get(baseUrl);
	driver.manage().window().setSize(new Dimension(1280, 680));
	driver.findElement(By.cssSelector(".header-right-menu > nav > ul > li:nth-child(1) > a")).click();
	driver.findElement(By.id("FareUserFileNumber")).click();
	driver.findElement(By.id("FareUserFileNumber")).clear();
	driver.findElement(By.id("FareUserFileNumber")).sendKeys("108026");
	driver.findElement(By.id("FareUserBirthDate")).click();
	driver.findElement(By.id("FareUserBirthDate")).clear();
	driver.findElement(By.id("FareUserBirthDate")).sendKeys("01/08/1967");
	driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Effacer'])[2]/following::span[9]")).click();
	driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Jul'])[1]/following::span[1]")).click();
	driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='D'])[1]/following::td[2]")).click();
	driver.findElement(By.cssSelector("p>button[type='submit']")).click();
	driver.findElement(By.cssSelector(".header-right-menu > nav > ul > li:nth-child(2) > a")).click();
	 js.executeScript("window.scrollTo(0,56)");
	  Thread.sleep((3000));
	  
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
