package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

import ru.stqa.pft.addressbook.model.AddressData;

public class AdressCreationTests extends TestBase{


  @Test
  public void testAddressCreation() {
    app.goToHomePage();
    app.getContactHelper().initAddressCreation();
    app.getContactHelper().fillAddressForm(new AddressData("Agnieszka", "Sara","Budzyńska","test2", "Ładna 10/15", "555-555-555"), true);
    app.getContactHelper().submitNewAddress();
    app.goToHomePage();
 //   wd.findElement(By.linkText("home")).click();
  }

}
