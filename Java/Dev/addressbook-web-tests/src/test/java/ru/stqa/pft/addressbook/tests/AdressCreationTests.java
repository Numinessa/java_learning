package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

import ru.stqa.pft.addressbook.model.AddressData;

public class AdressCreationTests extends TestBase{

//  @BeforeMethod
//  public void setUp() throws Exception {
//    System.setProperty("webdriver.gecko.driver", "C:\\geckodriver-v0.18.0-arm7hf\\geckodriver.exe");
//    wd = new FirefoxDriver();
//    wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//
//    wd.get("http://localhost/addressbook/");
//    login("admin", "secret");
//  }

  @Test
  public void testAddressCreation() {
    app.goToHomePage();
    app.initAddressCreation();
    app.fillAddressForm(new AddressData("Agnieszka", "Sara","Budzyńska", "Ładna 10/15", "555-555-555"));
    app.submitNewAddress();
    app.goToHomePage();
 //   wd.findElement(By.linkText("home")).click();
  }

 // @AfterMethod
// public void tearDown() {
//   wd.quit();
//  }

}
