package ru.stqa.pft.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;
import ru.stqa.pft.addressbook.model.AddressData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {


  @Parameter(names = "-c", description = "Address count")
  public int count;

  @Parameter(names = "-f", description = "Target file")
  public String file;

  @Parameter(names = "-d", description = "Target file")
  public String format;


  public static void main(String[] args) throws IOException {

    ContactDataGenerator generator = new ContactDataGenerator();
    JCommander jCommander = new JCommander(generator);
    try {
      jCommander.parse(args);
    }catch (ParameterException ex){
      jCommander.usage();
      return;
    }
    generator.run();

  }


  private void run() throws IOException {

    List<AddressData> contacts = generateContacts(count);
    if (format.equals("csv")){
      saveAsCsv(contacts, new File(file));
    }else if (format.equals("xml")) {
      saveAsXml(contacts, new File(file));
    }else if (format.equals("json")) {
      saveAsJson(contacts, new File(file));
    }else{
      System.out.println("Unregnized format" + format);
    }
  }

  private  List<AddressData> generateContacts(int count) {
    List<AddressData> contacts = new ArrayList<AddressData>();
    for (int i = 0; i < count; i++ ){
      contacts.add(new AddressData().withFirstName(String.format("name %s", i))
              .withLastName(String.format("surname %s", i)).withAddress(String.format("address %s", i)).withEmail1(String.format("email@wp.pl %s", i)).withHomeTelephoneNumber(String.format("555-555-555 %s", i)));
    }
    return contacts;
  }

  private void saveAsJson(List<AddressData> contacts, File file) throws IOException {
    Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
    String json = gson.toJson(contacts);
    Writer writer = new FileWriter(file);
    writer.write(json);
    writer.close();

  }


  private void saveAsXml(List<AddressData> contacts, File file) throws IOException {
    XStream xstream = new XStream();
    xstream.processAnnotations(AddressData.class);
    String xml = xstream.toXML(contacts);
    Writer writer = new FileWriter(file);
    writer.write(xml);
    writer.close();
  }

  private  void saveAsCsv(List<AddressData> contacts, File file) throws IOException {
    System.out.println(new File(".").getAbsolutePath());
    Writer writer = new FileWriter(file);
    for (AddressData contact : contacts){
      writer.write(String.format("%s;%s;%s;%s;%s\n", contact.getFirstName(), contact.getLastName(), contact.getAddress(), contact.getEmail1(), contact.getHomeTelephoneNumber()));
    }
    writer.close();
  }

}
