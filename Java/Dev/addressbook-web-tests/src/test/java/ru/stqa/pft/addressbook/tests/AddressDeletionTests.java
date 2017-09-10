package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AddressData;

import java.util.List;

public class AddressDeletionTests extends TestBase {


  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.address().getContactList().size() == 0) {
      app.address().create(new AddressData().withFirstName("Agnieszka").withLastName("Budzyńska").withGroup(null).withAddress(null).withTelephoneNumber(null));
    }
  }

  @Test
  public void testAddressDeletion() {
    List<AddressData> before = app.address().getContactList();
    int index = before.size() - 1;
    app.address().delete(index);
    List<AddressData> after = app.address().getContactList();

    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(index);

    Assert.assertEquals(before, after);

  }
}
