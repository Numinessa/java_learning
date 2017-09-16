package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.AddressData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.List;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void submitNewAddress() {
    clickSub(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void fillAddressForm(AddressData addressData, boolean creation) {
    typeName(By.name("firstname"), addressData.getFirstName());
    typeName(By.name("lastname"), addressData.getLastName());
    attach(By.name("photo"), addressData.getFoto());
    typeName(By.name("address"), addressData.getAddress());
    typeName(By.name("mobile"), addressData.getHomeTelephoneNumber());
    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(addressData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }

  }

  public void initAddressCreation() {
    clickSub(By.linkText("add new"));
  }

  public void selectFirstAddress(int Index) {
    wd.findElements(By.name("selected[]")).get(Index).click();
  }

  public void deleteSelectedAddress() {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
  }

  public void selectFirstAddressById(int id) {
    wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
  }

  public void acceptDelete() {
    wd.switchTo().alert().accept();
  }

  public void goToGroupPage() {
    clickSub(By.linkText("group_pgae"));
  }

  public void goToHomePage() {
    click(By.linkText("home"));
  }

   public void clickEditAddress() {
     wd.findElement(By.xpath("//table//td[8]")).click();
   }
  public void clickEditAddress(int Index) {
    wd.findElements(By.xpath("//table//td[8]")).get(Index).click();
  }


 // public void clickEditAddressById(int id) {
 //   wd.findElement(By.xpath("//table//td[8]")).click();
//  }
  public void clickEditAddressById(int id) {
    wd.findElement(By.xpath(String.format("//input[@value='%s']/../../td[8]/a", id))).click();
  }

  public void clickDetailsAddressById( int id){
    wd.findElement(By.xpath(String.format("//input[@value='%s']/../../td[7]/a", id))).click();
  }

  public void updateButton() {
    click(By.xpath("//div[@id='content']/form[1]/input[22]"));
  }

  public boolean isThereAnyAddress() {
    return isElementPresent(By.name("selected[]"));
  }


  public void create(AddressData address) {
    initAddressCreation();
    fillAddressForm(new AddressData().withFirstName("Agnieszka").withLastName("Budzyńska").withGroup("test2").withAddress("Ładna 10/15").withHomeTelephoneNumber("555-555-555"), true);
    submitNewAddress();
    goToHomePage();
  }

  public void modify( AddressData group) {
    clickEditAddressById(group.getId());
 //   clickEditAddress();
    fillAddressForm((group), false);
    updateButton();
    goToHomePage();
  }
  public void details( AddressData group){
    clickDetailsAddressById(group.getId());
    fillAddressForm((group), false);
    updateButton();
    goToHomePage();
  }

  public void delete(int index) {
    selectFirstAddress(index);
    deleteSelectedAddress();
    acceptDelete();
    goToHomePage();
  }

  public void delete(AddressData group) {
    selectFirstAddressById(group.getId());
    deleteSelectedAddress();
    acceptDelete();
    goToHomePage();
  }

  public void makeNewAddress(AddressData group) {
    initAddressCreation();
    fillAddressForm((group), true);
    submitNewAddress();
    goToHomePage();
  }

  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }


  public Contacts all() {
    Contacts groups = new Contacts();
    List<WebElement> elements = wd.findElements(By.xpath("//table[@class='sortcompletecallback-applyZebra']//tr[@name='entry']"));
    for (WebElement element : elements) {
      List<WebElement> cells = element.findElements(By.tagName("td"));
      String name = cells.get(2).getText();
      String last = cells.get(1).getText();
      String allAddress = cells.get(3).getText();
      String allEmails = cells.get(4).getText();
      String allPhones = cells.get(5).getText();

      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      groups.add(new AddressData().withId(id).withFirstName(name).withLastName(last).withGroup(null).withAllAddress(allAddress).withAllEmail(allEmails).
              withAllPhones(allPhones));
    }
    return groups;

  }
  public AddressData infoFromEditForm(AddressData contact){
    clickEditAddressById(contact.getId());
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String address = wd.findElement(By.name("address")).getAttribute("value");
    String address2 = wd.findElement(By.name("address2")).getAttribute("value");
    String email1 = wd.findElement(By.name("email")).getAttribute("value");
    String email2 = wd.findElement(By.name("email2")).getAttribute("value");
    String email3 = wd.findElement(By.name("email3")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");
    wd.navigate().back();
    return new AddressData().withId(contact.getId()).withFirstName(firstname).
            withLastName(lastname).withAddress(address).withAddress2(address2).withEmail1(email1).withEmail2(email2).withEmail3(email3).
            withHomeTelephoneNumber(home).withMobileTelephoneNumber(mobile).withWorkTelephoneNumber(work);
  }

  public AddressData infoFromDetailsForm(AddressData contact){
    clickDetailsAddressById(contact.getId());
//    String firstname = wd.findElement(By.xpath("//div[@id='content']//b")).getText();
    String all = wd.findElement(By.xpath("//div[@id='content']")).getText();
    return new AddressData().withId(contact.getId()).withFirstName(all).withAddress(all).withEmail1(all).withWorkTelephoneNumber(all);
  }


}
