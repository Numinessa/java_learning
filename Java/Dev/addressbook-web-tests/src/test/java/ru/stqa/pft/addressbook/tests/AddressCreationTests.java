package ru.stqa.pft.addressbook.tests;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ru.stqa.pft.addressbook.model.AddressData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class AddressCreationTests extends TestBase {

  @DataProvider
  public Iterator<Object []> validContactsFromXml() throws IOException {
    try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.xml")))){
      String xml = "";
      String line = reader.readLine();
      while (line != null){
        xml += line;
        line = reader.readLine();
      }
      XStream xStream = new XStream();
      xStream.processAnnotations(GroupData.class);
      List<AddressData> contacts = (List<AddressData>)xStream.fromXML(xml);
      return contacts.stream().map((g) -> new Object[] {g}).collect(Collectors.toList()).iterator();
    }
}

  @DataProvider
  public Iterator<Object []> validContactsFromJson() throws IOException {
    try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.json")))){
      String json = "";
      String line = reader.readLine();
      while (line != null){
        json += line;
        line = reader.readLine();
      }
      Gson gson = new Gson();
      List<AddressData> contacts = gson.fromJson(json, new TypeToken<List<AddressData>>(){}.getType());
      return contacts.stream().map((g) -> new Object[] {g}).collect(Collectors.toList()).iterator();
    }
 }


  @Test(dataProvider = "validContactsFromJson")
  public void testAddressCreation(AddressData contact) {
    app.goToHomePage();

    Contacts before =  app.db().address();
   // File foto = new File("src/test/resources/cat.jpg");
 //   AddressData group = new AddressData().withFirstName("Agnieszka").withLastName("Budzyńska").withGroup("test2").withAddress("Ładna 10/15").withHomeTelephoneNumber("555-555-555").withFoto(foto);
    app.address().makeNewAddress(contact);

    Contacts after = app.db().address();
    assertThat(after.size(), equalTo(before.size() + 1));

    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
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
