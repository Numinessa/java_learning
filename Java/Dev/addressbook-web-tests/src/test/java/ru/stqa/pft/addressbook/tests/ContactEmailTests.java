package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AddressData;

import java.util.Arrays;
import java.util.stream.Collectors;



public class ContactEmailTests extends TestBase{

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.address().all().size() == 0) {
      app.address().create(new AddressData().withFirstName("Agnieszka").withLastName("Budzyńska")./*withGroup(null).*/withAddress(null).withHomeTelephoneNumber(null));
    }
  }
  @Test

  public void testContactEmail(){
    app.goTo().homePage();
    AddressData email = app.address().all().iterator().next();
    AddressData contactInfoFromEditForm = app.address().infoFromEditForm(email);
    MatcherAssert.assertThat(email.getAllEmail(), CoreMatchers.equalTo(margeEmails(contactInfoFromEditForm)));
  }

  private String margeEmails(AddressData emails) {
    return Arrays.asList(emails.getEmail1(), emails.getEmail2(),
            emails.getEmail3()).stream().filter((s) -> !s.equals("")).
            collect(Collectors.joining("\n"));

  }
}
