package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import ru.stqa.pft.addressbook.model.AddressData;

import java.util.Comparator;
import java.util.List;

public class AddressCreationTests extends TestBase {


  @Test
  public void testAddressCreation() {
    app.goToHomePage();

    List<AddressData> before = app.address().getContactList();

    AddressData group = new AddressData().withFirstName("Agnieszka").withLastName("Budzyńska").withGroup("test2").withAddress("Ładna 10/15").withTelephoneNumber("555-555-555");//("Agnieszka", "Budzyńska", "test2", "Ładna 10/15", "555-555-555");
    app.address().makeNewAddress(group);

    List<AddressData> after = app.address().getContactList();

    Assert.assertEquals(after.size(), before.size() + 1);
    //   wd.findElement(By.linkText("home")).click();
    before.add(group);
    Comparator<? super AddressData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }

}
