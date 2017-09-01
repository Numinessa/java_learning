package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AddressData;

import java.util.HashSet;
import java.util.List;

public class AddressModificationTests extends TestBase {

  @Test //(enabled = false)
  public void testsAddressModification(){
    app.goTo().goToHomePage();


    if (! app.getContactHelper().isThereAnyAddress()){
      app.getContactHelper().createAAddress(new AddressData("Agnieszka","Budzyńska",null, null, null));
    }
    List<AddressData> before = app.getContactHelper().getContactList();

    app.getContactHelper().selectFirstAddress(before.size() -1);
    app.getContactHelper().clickEditAddress(before.size() -1);

    AddressData group = new AddressData("Agnieszka", "Budzyńska", null, null, null);
   // app.getContactHelper().fillAddressForm(new AddressData("Monika", "Sara","Budzyńska", "test2", "Ładna 10/15", "555-555-555"), false);
    app.getContactHelper().fillAddressForm((group), false);

    app.getContactHelper().updateButton();
    app.goTo().goToHomePage();

    List<AddressData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() );

    before.remove(before.size() -1);
    before.add(group);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
  }
}
