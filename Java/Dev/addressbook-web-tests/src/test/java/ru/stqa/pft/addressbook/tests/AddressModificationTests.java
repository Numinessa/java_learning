package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AddressData;

import java.util.Comparator;
import java.util.List;

public class AddressModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.address().getContactList().size() == 0) {
      app.address().create(new AddressData().withFirstName("Agnieszka").withLastName("Budzyńska").withGroup(null).withAddress(null).withTelephoneNumber(null));
    }
  }

  @Test
  public void testsAddressModification() {

    List<AddressData> before = app.address().getContactList();
    int index = before.size() - 1;
    AddressData group = new AddressData().withId(before.get(index).getId()).withFirstName("Agnieszka").withLastName("Budzyńska").withGroup(null).withAddress(null).withTelephoneNumber(null);
    app.address().modify(index, group);

    List<AddressData> after = app.address().getContactList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(index);
    before.add(group);

    Comparator<? super AddressData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }

}
