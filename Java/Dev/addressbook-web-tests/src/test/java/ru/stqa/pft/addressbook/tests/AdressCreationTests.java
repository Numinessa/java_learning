package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import ru.stqa.pft.addressbook.model.AddressData;

public class AdressCreationTests extends TestBase{
  FirefoxDriver wd;

  @BeforeMethod
  public void setUp() throws Exception {
    System.setProperty("webdriver.gecko.driver", "C:\\geckodriver-v0.18.0-arm7hf\\geckodriver.exe");
    wd = new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

    wd.get("http://localhost/addressbook/");
    login("admin", "secret");
  }

  private void login(String username, String password) {
    wd.findElement(By.name("user")).click();
    wd.findElement(By.name("user")).sendKeys(username);
    wd.findElement(By.name("pass")).click();
    wd.findElement(By.name("pass")).sendKeys(password);
    wd.findElement(By.id("LoginForm")).click();
    wd.findElement(By.xpath("//form[@id='LoginForm']/input[3]")).click();
  }

  @Test
  public void AddressCreationTests() {
    goToHomePage();
    initAddressCreation();
    fillAddressForm(new AddressData("Agnieszka", "Sara","Budzyńska", "Ładna 10/15", "555-555-555"));
    submitNewAddress();
    goToHomePage();
 //   wd.findElement(By.linkText("home")).click();
  }

  private void submitNewAddress() {
    wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
  }

  private void fillAddressForm(AddressData addressData) {
    wd.findElement(By.name("firstname")).click();
    wd.findElement(By.name("firstname")).clear();
    wd.findElement(By.name("firstname")).sendKeys(addressData.getFirstName());
    wd.findElement(By.name("middlename")).click();
    wd.findElement(By.name("middlename")).sendKeys(addressData.getMiddleName());
    wd.findElement(By.name("lastname")).click();
    wd.findElement(By.name("lastname")).clear();
    wd.findElement(By.name("lastname")).sendKeys(addressData.getLastName());
    wd.findElement(By.name("address")).click();
    wd.findElement(By.name("address")).clear();
    wd.findElement(By.name("address")).sendKeys(addressData.getAddress());
    wd.findElement(By.name("mobile")).click();
    wd.findElement(By.name("mobile")).clear();
    wd.findElement(By.name("mobile")).sendKeys(addressData.getTelephoneNumber());
  }

  private void initAddressCreation() {
    wd.findElement(By.linkText("add new")).click();
  }

  private void goToHomePage() {
    wd.findElement(By.linkText("home")).click();
  }

  @AfterMethod
 public void tearDown() {
   wd.quit();
  }

  public static boolean isAlertPresent(FirefoxDriver wd) {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }
}
