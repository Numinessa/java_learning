package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

import ru.stqa.pft.addressbook.model.AddressData;
import ru.stqa.pft.addressbook.model.Contacts;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class AddressCreationTests extends TestBase {


  @Test
  public void testAddressCreation() {
    app.goToHomePage();

    Contacts before =  app.address().all();

    AddressData group = new AddressData().withFirstName("Agnieszka").withLastName("Budzyńska").withGroup("test2").withAddress("Ładna 10/15").withHomeTelephoneNumber("555-555-555");//("Agnieszka", "Budzyńska", "test2", "Ładna 10/15", "555-555-555");
    app.address().makeNewAddress(group);

    Contacts after = app.address().all();

    assertThat(after.size(), equalTo(before.size() + 1));
    //   wd.findElement(By.linkText("home")).click();

    assertThat(after, equalTo(
            before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
  }

}
