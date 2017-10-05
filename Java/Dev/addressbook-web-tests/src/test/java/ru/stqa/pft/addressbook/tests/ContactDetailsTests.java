package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AddressData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDetailsTests extends TestBase {


  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.address().all().size() == 0) {
      app.address().create(new AddressData().withFirstName("Agnieszka").withLastName("Budzyńska")/*.withGroup(null).*/.withAddress(null).withHomeTelephoneNumber(null));
    }
  }

  @Test
  public void testContactDetails(){
    app.goTo().homePage();
    AddressData details = app.address().all().iterator().next();
  //  AddressData contactInfoFromEditForm = app.address().infoFromEditForm(details);
    AddressData contactInfoFromEditForm = app.address().infoFromDetailsForm(details);

 //   MatcherAssert.assertThat(details.getFirstName(), CoreMatchers.equalTo(margeName(contactInfoFromEditForm)));
    MatcherAssert.assertThat(details.getAllEmail(), CoreMatchers.equalTo(margeEmails(contactInfoFromEditForm)));
    assertThat(details.getAllPhones(), equalTo(margePhones(contactInfoFromEditForm)));
    MatcherAssert.assertThat(details.getAllAddress(), CoreMatchers.equalTo(margeAddresses(contactInfoFromEditForm)) );
  }
  private String margeEmails(AddressData emails) {
    return Arrays.asList(emails.getEmail1(), emails.getEmail2(),
            emails.getEmail3()).stream().filter((s) -> !s.equals("")).
            collect(Collectors.joining("\n"));

  }

  private String margePhones(AddressData contact) {
    return Arrays.asList(contact.getHomeTelephoneNumber(), contact.getMobileTelephoneNumber(),
            contact.getWorkTelephoneNumber()).stream().filter((s) -> !s.equals("")).
            map(ContactDetailsTests::cleaned).
            collect(Collectors.joining("\n"));

  }

  public static String cleaned(String phone) {
    return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
  }

  private String margeAddresses(AddressData contact) {
    return Arrays.asList(contact.getAddress()).stream().filter((s) -> !s.equals("")).
            collect(Collectors.joining("\n"));

  }
}
