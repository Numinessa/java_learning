package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AddressData;

import java.util.List;

public class AddressDeletionTests extends TestBase {

  @Test
  public void testAddressDeletion() {
    app.getContactHelper().goToHomePage();
    if (!app.getContactHelper().isThereAnyAddress()) {
      app.getContactHelper().createAAddress(new AddressData("Agnieszka", "Budzyńska", "test2", "Ładna 10/15", "555-555-555"));
    }

    List<AddressData> before = app.getContactHelper().getContactList();

    app.getContactHelper().selectFirstAddress(before.size() - 1);
    app.getContactHelper().deleteSelectedAddress();
    app.getContactHelper().acceptDelete();
    app.getContactHelper().goToHomePage();
    List<AddressData> after = app.getContactHelper().getContactList();

    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(before.size() - 1);

      Assert.assertEquals(before, after);

  }
}
