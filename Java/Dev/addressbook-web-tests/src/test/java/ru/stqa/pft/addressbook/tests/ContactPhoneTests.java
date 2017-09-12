package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AddressData;

public class ContactPhoneTests  extends TestBase {


  @Test
  public void testContactPhone() {
    app.goTo().homePage();
    AddressData contact = app.address().all().iterator().next();
  //  AddressData contactInfoFromEditForm = app.address();
  }
}
