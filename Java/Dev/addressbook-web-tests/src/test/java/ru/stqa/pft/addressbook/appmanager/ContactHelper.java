package ru.stqa.pft.addressbook.appmanager;

import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.AddressData;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase{

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void submitNewAddress() {
    clickSub(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void fillAddressForm(AddressData addressData, boolean creation) {
    typeName(By.name("firstname"), addressData.getFirstName());
//    clickSub(By.name("middlename"));
//    wd.findElement(By.name("middlename")).sendKeys(addressData.getMiddleName());
    typeName(By.name("lastname"), addressData.getLastName());


    typeName(By.name("address"), addressData.getAddress());
    typeName(By.name("mobile"), addressData.getTelephoneNumber());

    if (creation){
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(addressData.getGroup());
    }else {
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

  public void acceptDelete() {
    wd.switchTo().alert().accept();
  }

  public void goToGroupPage() {
    clickSub(By.linkText("group_pgae"));
  }

  public void goToHomePage(){
    click(By.linkText("home"));
  }

 // public void clickEditAddress() {
 //   click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
 // }
 public void clickEditAddress(int Index) {
   wd.findElements(By.xpath("//table//td[8]")).get(Index).click();
 }

  public void updateButton() {
    click(By.xpath("//div[@id='content']/form[1]/input[22]"));
  }

  public boolean isThereAnyAddress() {
    return isElementPresent(By.name("selected[]"));
  }


  public void createAAddress(AddressData address) {
    initAddressCreation();
    fillAddressForm(new AddressData("Agnieszka","Budzyńska","test2", "Ładna 10/15", "555-555-555"), true);
    submitNewAddress();
    goToHomePage();
  }

  public int getContactCount() {
   return wd.findElements(By.name("selected[]")).size();
  }

//  public List<AddressData> getContactList() {
//    List<AddressData> groups = new ArrayList<AddressData>();
//    List<WebElement> elements = wd.findElements(By.xpath("//table[@class='sortcompletecallback-applyZebra']//tr[@name='entry']"));
//    for (WebElement element : elements) {
//      String name = element.getText();
//      AddressData group = new AddressData(name, null, null, null, null, null);
//    groups.add(group);
//    }
//    return groups;
//  }
public List<AddressData> getContactList() {
  List<AddressData> groups = new ArrayList<AddressData>();
  List<WebElement> elements = wd.findElements(By.xpath("//table[@class='sortcompletecallback-applyZebra']//tr[@name='entry']"));
  for (WebElement element : elements) {
    List<WebElement> cells = element.findElements(By.tagName("td"));
 //   String name = element.getText();
    String name = cells.get(1).getText();
 //   String middlename = cells.get(2).getText();
    String last = cells.get(3).getText();
    AddressData group = new AddressData( name , last,null, null, null);
    groups.add(group);
  }
  return groups;
}
}
