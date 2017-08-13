package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AddressData;

public class AddressModificationTests extends TestBase {

  @Test
  public void testsAddressModification(){

    app.getNavigationHelper().goToHomePage();
    app.getContactHelper().clickEditAddress();
    app.getContactHelper().fillAddressForm(new AddressData("Monika", "Sara","Budzyńska", "Ładna 10/15", "555-555-555"));
    app.getContactHelper().updateButton();
    app.getNavigationHelper().goToHomePage();
  }
}
