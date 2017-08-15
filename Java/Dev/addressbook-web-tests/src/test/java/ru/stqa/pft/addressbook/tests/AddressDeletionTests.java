package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AddressData;

public class AddressDeletionTests extends TestBase {

  @Test
  public void testAddressDeletion(){

    app.getContactHelper().goToHomePage();
    if (! app.getContactHelper().isThereAnyAddress()){
      app.getContactHelper().createAAddress(new AddressData("Agnieszka", "Sara","Budzyńska","test2", "Ładna 10/15", "555-555-555"));
    }
    app.getContactHelper().selectFirstAddress();
    app.getContactHelper().deleteSelectedAddress();
    app.getContactHelper().acceptDelete();
    app.getContactHelper().goToHomePage();
  }
}
