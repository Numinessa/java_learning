package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AddressData;

public class AddressModificationTests extends TestBase {

  @Test
  public void testsAddressModification(){

    app.getNavigationHelper().goToHomePage();
    if (! app.getContactHelper().isThereAnyAddress()){
      app.getContactHelper().createAAddress(new AddressData("Agnieszka", "Sara","Budzyńska","test2", "Ładna 10/15", "555-555-555"));
    }
    app.getContactHelper().clickEditAddress();
    app.getContactHelper().fillAddressForm(new AddressData("Monika", "Sara","Budzyńska", "test2", "Ładna 10/15", "555-555-555"), false);
    app.getContactHelper().updateButton();
    app.getNavigationHelper().goToHomePage();
  }
}
