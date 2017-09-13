package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AddressData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.*;
import static org.testng.Assert.assertEquals;

public class AddressModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.address().all().size() == 0) {
      app.address().create(new AddressData().withFirstName("Agnieszka").withLastName("Budzyńska").withGroup(null).withAddress(null).withHomeTelephoneNumber(null));
    }
  }

  @Test
  public void testsAddressModification() {

    Contacts before = app.address().all();
    AddressData modifiedAddress = before.iterator().next();
    AddressData group = new AddressData().withId(modifiedAddress.getId()).withFirstName("Agnieszka").withLastName("Budzyńska").withGroup(null).withAddress(null).withHomeTelephoneNumber(null);
    app.address().modify(group);

    Contacts after = app.address().all();
    assertEquals(after.size(), before.size());


    assertThat(after, equalTo(before.without(modifiedAddress).withAdded(group)));
  }

}
