package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AddressData;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ContactAddressTests extends TestBase {


  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.address().all().size() == 0) {
      app.address().create(new AddressData().withFirstName("Agnieszka").withLastName("Budzyńska")./*withGroup(null).*/withAddress(null).withHomeTelephoneNumber(null));
    }
  }

  @Test
  public void testContactAddress() {
    app.goTo().homePage();
    AddressData address = app.address().all().iterator().next();
    AddressData contactInfoFromEditForm = app.address().infoFromEditForm(address);

    MatcherAssert.assertThat(address.getAllAddress(), CoreMatchers.equalTo(margeAddresses(contactInfoFromEditForm)) );

  }

  private String margeAddresses(AddressData contact) {
    return Arrays.asList(contact.getAddress()).stream().filter((s) -> !s.equals("")).
            collect(Collectors.joining("\n"));

  }

}
