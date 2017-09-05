package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import ru.stqa.pft.addressbook.model.AddressData;

import java.util.HashSet;
import java.util.List;

public class AddressCreationTests extends TestBase{


  @Test (enabled = false)
  public void testAddressCreation() {
    app.goToHomePage();

    List<AddressData> before = app.getContactHelper().getContactList();

    AddressData group = new AddressData("Agnieszka","Budzyńska","test2", "Ładna 10/15", "555-555-555");
    app.getContactHelper().initAddressCreation();
    app.getContactHelper().fillAddressForm((group), true);
    app.getContactHelper().submitNewAddress();
    app.goToHomePage();

    List<AddressData> after = app.getContactHelper().getContactList();

    Assert.assertEquals(after.size(), before.size() +1);
 //   wd.findElement(By.linkText("home")).click();
    before.add(group);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
  }

}
