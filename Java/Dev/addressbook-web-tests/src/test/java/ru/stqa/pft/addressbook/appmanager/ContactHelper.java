package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.AddressData;

public class ContactHelper extends HelperBase{

  public ContactHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void submitNewAddress() {
    clickSub(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void fillAddressForm(AddressData addressData) {
    typeName(By.name("firstname"), addressData.getFirstName());
    clickSub(By.name("middlename"));
    wd.findElement(By.name("middlename")).sendKeys(addressData.getMiddleName());
    typeName(By.name("lastname"), addressData.getLastName());
    typeName(By.name("address"), addressData.getAddress());
    typeName(By.name("mobile"), addressData.getTelephoneNumber());
  }

  public void initAddressCreation() {
    clickSub(By.linkText("add new"));
  }

  public void selectFirstAddress() {
    click(By.name("selected[]"));
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

  public void clickEditAddress() {
    click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
  }

  public void updateButton() {
    click(By.xpath("//div[@id='content']/form[1]/input[22]"));
  }
}
