package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AddressData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.*;
import static org.testng.Assert.assertEquals;

public class AddressDeletionTests extends TestBase {


  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().address().size() == 0){
      app.goTo().homePage();
      app.address().create(new AddressData().withFirstName("Agnieszka").withLastName("Budzyńska")./*withGroup(null).*/withAddress(null).withHomeTelephoneNumber(null));
    }
  }

  @Test
  public void testAddressDeletion() {
    Contacts before = app.db().address();
    AddressData deletedAddress = before.iterator().next();
    app.address().delete(deletedAddress);
    Contacts after = app.db().address();

    assertEquals(after.size(), before.size() - 1);

    assertThat(after, equalTo(before.without(deletedAddress)));
    verifyContactListUi();
  }
}
