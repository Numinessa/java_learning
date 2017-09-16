package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

import ru.stqa.pft.addressbook.model.AddressData;
import ru.stqa.pft.addressbook.model.Contacts;


import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class AddressCreationTests extends TestBase {


  @Test
  public void testAddressCreation() {
    app.goToHomePage();

    Contacts before =  app.address().all();
    File foto = new File("src/test/resources/cat.jpg");
    AddressData group = new AddressData().withFirstName("Agnieszka").withLastName("Budzyńska").withGroup("test2").withAddress("Ładna 10/15").withHomeTelephoneNumber("555-555-555").withFoto(foto);
    app.address().makeNewAddress(group);
    Contacts after = app.address().all();
    assertThat(after.size(), equalTo(before.size() + 1));

    assertThat(after, equalTo(
            before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
  }
  @Test
  public void testCurrentDir(){
    File currentDir = new File(".");
    System.out.println(currentDir.getAbsolutePath());
    File foto = new File("src/test/resourses/stru.png");
    System.out.println(foto.getAbsolutePath());
    System.out.println(foto.exists());
  }
}
