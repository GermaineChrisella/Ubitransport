
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


  public class ChoiceNoCB {
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
  public void testChoiceNoCB() throws Exception {
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
 
    driver.findElement(By.cssSelector(".row:nth-child(2) .product-price")).click();
    {
      WebElement element = driver.findElement(By.cssSelector(".single-product-item"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    {
      WebElement element = driver.findElement(By.cssSelector(".pro-add-to-cart:nth-child(1)"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    {
      WebDriverWait wait = new WebDriverWait(driver, 30);
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".pro-add-to-cart:nth-child(1)>p>a>i")));
    }
    driver.findElement(By.cssSelector(".pro-add-to-cart:nth-child(1)>p>a")).click();
    driver.findElement(By.cssSelector(".pro-add-to-cart a")).click();
    driver.findElement(By.id("FareBasketEmail")).click();
    driver.findElement(By.cssSelector("button")).click();
    driver.findElement(By.id("FareBasketPt")).click();
    driver.findElement(By.id("FareBasketSavePaymentToken")).click();
    driver.findElement(By.id("FareBasketCgv")).click();
    driver.findElement(By.cssSelector("button")).click();
    driver.findElement(By.cssSelector("#E-CARTEBLEUE")).click();
    
                /********* E-CARTEBLEUE **********/
    //BOUTIKE-CARTEBLEUE - Paiement accepté, acheteur enrôlé 3D Secure, statut = ATTEMP
    driver.findElement(By.linkText("4150 5600 0000 0011")).click();
    
    //BOUTIKE-CARTEBLEUE - Paiement refusé, autorisation refusée pour cause de plafond dépassé
    //driver.findElement(By.linkText("4150 5630 0000 0098")).click();
   
                    /********* CB, VISA **********/
    //BOUTIKCB, VISA - Paiement accepté, avec authentification 3D Secure
    //driver.findElement(By.linkText("4970 1000 0000 0014")).click();
    
    
    //BOUTIKCB, VISA - Paiement accepté, acheteur non enrôlé 3D Secure
    //driver.findElement(By.linkText("4970 1000 0000 0048")).click();
    
    //BOUTIKCB, VISA - Paiement accepté, contrôle clé de Luhn effectué
    //driver.findElement(By.linkText("4970 1000 0000 0006")).click();
    
    //BOUTIKCB, VISA - Paiement accepté, garantie de paiement = NO
    //driver.findElement(By.linkText("4970 1000 0000 0055")).click();
    
    //BOUTIKCB, VISA - Paiement accepté, marchand non enrôlé 3D Secure
    //driver.findElement(By.linkText("4970 1000 0000 0030")).click();
    
    //BOUTIKCB, VISA - Paiement avec authentification 3D Secure interactive
    //driver.findElement(By.linkText("4970 1000 0000 0022")).click();
    
    
    //BOUTIKCB, VISA - Paiement refusé pour cause d'authentification 3D Secure échouée, l'acheteur n'est pas parvenu à s'authentifier
    //driver.findElement(By.linkText("4970 1000 0000 0063")).click();
    
    //BOUTIKCB, VISA - Paiement refusé, autorisation refusée pour cause de plafond dépassé
    //driver.findElement(By.linkText("4970 1000 0000 0071")).click();
    
    //BOUTIKCB, VISA - Paiement refusé, autorisation refusée suite à erreur dans le cryptogramme visuel saisi
    //driver.findElement(By.linkText("4970 1000 0000 0089")).click();
    
    //BOUTIKCB, VISA - Paiement refusé, transaction à forcer, contacter l'émetteur de carte
    //driver.findElement(By.linkText("4970 1000 0000 0002")).click();
    
    
	                     /********* MASTERCARD **********/
	
	//BOUTIKMASTERCARD - Paiement accepté avec authentification 3D Secure
	//driver.findElement(By.linkText("5970 1003 0000 0018")).click();
	
    //BOUTIKMASTERCARD - Paiement avec authentification 3D Secure interactive
  	//driver.findElement(By.linkText("5970 1003 0000 0026")).click();
    
	//BOUTIKMASTERCARD - Paiement accepté, garantie de paiement = NO
	//driver.findElement(By.linkText("5970 1003 0000 0067")).click();
	
	//BOUTIKMASTERCARD - Paiement accepté, marchand non enrôlé 3D Secure
	//driver.findElement(By.linkText("5970 1003 0000 0034")).click();
	
	//BOUTIKMASTERCARD - Paiement accepté, acheteur non enrôlé 3D Secure
	//driver.findElement(By.linkText("5970 1003 0000 0042")).click();
    
	//BOUTIKMASTERCARD - Paiement accepté, acheteur enrôlé 3D Secure, statut = ATTEMP
	//driver.findElement(By.linkText("5970 1003 0000 0004")).click();
	
    
    //BOUTIKMASTERCARD - Paiement refusé, transaction à forcer, contacter l'émetteur de carte
  	//driver.findElement(By.linkText("5970 1003 0000 0059")).click();
	 
	//BOUTIKMASTERCARD - Paiement refusé pour cause d'authentification 3D Secure échouée, l'acheteur n'est pas parvenu à s'authentifier
	//driver.findElement(By.linkText("5970 1003 0000 0075")).click();
	
	//BOUTIKMASTERCARD - Paiement refusé, autorisation refusée pour cause de plafond dépassé
	//driver.findElement(By.linkText("5970 1003 0000 0083")).click();
	
	//BOUTIKMASTERCARD - Paiement refusé, autorisation refusée suite à erreur dans le cryptogramme visuel saisi
	//driver.findElement(By.linkText("5970 1003 0000 0091")).click();
	
    
	          /********* VISA ELECTRON **********/
	//BOUTIK-VISAELECTRON - Paiement accepté, avec authentification 3D Secure
	//driver.findElement(By.linkText("4917 4800 0000 0008")).click();
	
    //BOUTIK-VISAELECTRON - Paiement avec authentification 3D Secure interactive
  	//driver.findElement(By.linkText("4917 4800 0000 0016")).click();
	
	//BOUTIK-VISAELECTRON - Paiement accepté, marchand non enrôlé 3D Secure
	//driver.findElement(By.linkText("4917 4800 0000 0024")).click();
	
	//BOUTIK-VISAELECTRON - Paiement accepté, acheteur non enrôlé 3D Secure
	//driver.findElement(By.linkText("4917 4800 0000 0032")).click();
	
	//BOUTIK-VISAELECTRON - Paiement accepté, garantie de paiement = NO
	//driver.findElement(By.linkText("4917 4800 0000 0057")).click();
	
    
	//BOUTIK-VISAELECTRON - Paiement refusé, transaction à forcer, contacter l'émetteur de carte
	//driver.findElement(By.linkText("4917 4800 0000 0040")).click();
	
	//BOUTIK-VISAELECTRON - Paiement refusé pour cause d'authentification 3D Secure échouée, l'acheteur n'est pas parvenu à s'authentifier
	//driver.findElement(By.linkText("4917 4800 0000 0065")).click();
	
	//BOUTIK-VISAELECTRONA - Paiement refusé, autorisation refusée pour cause de plafond dépassé
	//driver.findElement(By.linkText("4917 4800 0000 0073")).click();
	
	//BOUTIK-VISAELECTRON - Paiement refusé, autorisation refusée suite à erreur dans le cryptogramme visuel saisi
	//driver.findElement(By.linkText("4917 4800 0000 0081")).click();
	


    vars.put("iban", driver.findElement(By.cssSelector("#message_mode_test>ul>li:nth-child(1)>a")).getText());
    driver.findElement(By.cssSelector("#message_mode_test>ul>li:nth-child(1)>a")).click();
    Thread.sleep((3000));     
    driver.findElement(By.id("validationButtonCard")).click();
    driver.findElement(By.cssSelector("#boutiqueInfoBlock > #backToBoutiqueFormEnd button")).click();
    driver.findElement(By.cssSelector(".mainmenu li:nth-child(1) > a")).click();
    driver.findElement(By.id("PassengerPassengerFileNumber")).sendKeys("108026");
    driver.findElement(By.id("PassengerPassengerDateofbirth")).click();
    driver.findElement(By.id("PassengerPassengerDateofbirth")).sendKeys("01/08/1967");
    driver.findElement(By.cssSelector(".year:nth-child(9)")).click();
    driver.findElement(By.cssSelector(".month:nth-child(8)")).click();;
    driver.findElement(By.cssSelector("tr > .active")).click();
    driver.findElement(By.cssSelector("button")).click();
    driver.findElement(By.xpath("//label[contains(.,'Mes moyens de paiement')]")).click();
    js.executeScript("window.scrollTo(0,56)");
    Thread.sleep((5000));
    
  //historique des commandes
    //driver.findElement(By.cssSelector(".header-right-menu > nav > ul > li:nth-child(2) > a")).click();
 
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
