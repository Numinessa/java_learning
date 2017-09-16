package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AddressData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.*;

public class ContactPhoneTests extends TestBase {

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

    assertThat(contact.getAllPhones(), equalTo(margePhones(contactInfoFromEditForm)));

  }

  private String margePhones(AddressData contact) {
    return Arrays.asList(contact.getHomeTelephoneNumber(), contact.getMobileTelephoneNumber(),
            contact.getWorkTelephoneNumber()).stream().filter((s) -> !s.equals("")).
            map(ContactPhoneTests::cleaned).
            collect(Collectors.joining("\n"));

  }

  public static String cleaned(String phone) {
    return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
  }
}
