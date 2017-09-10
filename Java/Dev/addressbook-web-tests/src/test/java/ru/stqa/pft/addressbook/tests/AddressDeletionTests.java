package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AddressData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.*;
import static org.testng.Assert.assertEquals;

public class AddressDeletionTests extends TestBase {


  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.address().all().size() == 0) {
      app.address().create(new AddressData().withFirstName("Agnieszka").withLastName("Budzyńska").withGroup(null).withAddress(null).withTelephoneNumber(null));
    }
  }

  @Test
  public void testAddressDeletion() {
    Contacts before = app.address().all();
    AddressData deletedAddress = before.iterator().next();
    app.address().delete(deletedAddress);
    Contacts after = app.address().all();

    assertEquals(after.size(), before.size() - 1);

    assertThat(after, equalTo(before.without(deletedAddress)));

  }
}
