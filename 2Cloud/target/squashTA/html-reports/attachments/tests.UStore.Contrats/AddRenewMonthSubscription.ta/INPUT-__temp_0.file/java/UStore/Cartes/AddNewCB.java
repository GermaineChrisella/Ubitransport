
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

  public class AddNewCB {
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
    baseUrl = "https://dev.plateforme-2cloud.com/moncompte/connexion";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testAddNewCB() throws Exception {
    driver.get(baseUrl);
    driver.manage().window().setSize(new Dimension(1280, 680));
    driver.findElement(By.cssSelector(".header-right-menu > nav > ul > li:nth-child(1) > a")).click();
    driver.findElement(By.id("PassengerPassengerFileNumber")).clear();
    driver.findElement(By.id("PassengerPassengerFileNumber")).click();
    driver.findElement(By.id("PassengerPassengerFileNumber")).sendKeys("108026");
    driver.findElement(By.id("PassengerPassengerDateofbirth")).clear(); 
    driver.findElement(By.id("PassengerPassengerDateofbirth")).click();
    driver.findElement(By.id("PassengerPassengerDateofbirth")).sendKeys("01/08/1967");
    driver.findElement(By.cssSelector(".year:nth-child(9)")).click();
    driver.findElement(By.cssSelector(".month:nth-child(8)")).click();
    driver.findElement(By.cssSelector("tr > .active")).click();
    driver.findElement(By.cssSelector("button")).click(); 
    driver.findElement(By.cssSelector(".tab-label:nth-child(11)")).click();
    //driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)=concat('Date d', \"'\", 'expiration')])[1]/following::button[1]")).click();
	//driver.findElement(By.cssSelector(".list-group-item:nth-child(1) form")).submit(); 
    driver.findElement(By.cssSelector(".btn")).submit();
    assertThat(driver.switchTo().alert().getText(), is("Voulez-vous vraiment supprimer cette carte?"));
    driver.switchTo().alert().accept();
    driver.findElement(By.cssSelector(".gt-button")).click();
    driver.findElement(By.cssSelector("#MASTERCARD")).click(); 
    vars.put("iban", driver.findElement(By.cssSelector("#message_mode_test>ul>li:nth-child(1)>a")).getText());
    driver.findElement(By.cssSelector("#message_mode_test>ul>li:nth-child(1)>a")).click();
    Thread.sleep((3000));
    driver.findElement(By.linkText("5970 1003 0000 0018")).click();
    driver.findElement(By.id("validationButtonCard")).click();
    driver.findElement(By.cssSelector("#boutiqueInfoBlock > #backToBoutiqueFormEnd button")).click();    
    //driver.findElement(By.cssSelector(".header-right-menu > nav > ul > li:nth-child(1) > a")).click();
    js.executeScript("window.scrollTo(0,56)");
    Thread.sleep((5000)); 
     
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
