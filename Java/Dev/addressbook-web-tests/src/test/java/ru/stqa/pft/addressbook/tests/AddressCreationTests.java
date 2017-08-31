package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import ru.stqa.pft.addressbook.model.AddressData;

import java.util.List;

public class AddressCreationTests extends TestBase{


  @Test
  public void testAddressCreation() {
    app.goToHomePage();

    List<AddressData> before = app.getContactHelper().getContactList();

    app.getContactHelper().initAddressCreation();
    app.getContactHelper().fillAddressForm(new AddressData("Agnieszka","Budzyńska","test2", "Ładna 10/15", "555-555-555"), true);
    app.getContactHelper().submitNewAddress();
    app.goToHomePage();

    List<AddressData> after = app.getContactHelper().getContactList();

    Assert.assertEquals(after.size(), before.size() +1);
 //   wd.findElement(By.linkText("home")).click();
  }

}
