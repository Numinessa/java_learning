package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AddressData;

public class ContactPhoneTests  extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.address().all().size() == 0) {
      app.address().create(new AddressData().withFirstName("Agnieszka").withLastName("Budzyńska").withGroup(null).withAddress(null).withHomeTelephoneNumber(null));
    }
  }


  @Test
  public void testContactPhone() {
    app.goTo().homePage();
    AddressData contact = app.address().all().iterator().next();
    AddressData contactInfoFromEditForm = app.address().infoFromEditForm(contact);
    System.out.println(contactInfoFromEditForm);
  }
}
