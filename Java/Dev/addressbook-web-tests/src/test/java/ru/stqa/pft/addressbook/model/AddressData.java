package ru.stqa.pft.addressbook.model;

import java.io.File;

public class AddressData {
  private int id = Integer.MAX_VALUE;
  private String firstName;
  private String lastName;
  private String group;
  private String address;
  private String address2;
  private String allEmail;
  private String homeTelephoneNumber;
  private String mobileTelephoneNumber;
  private String workTelephoneNumber;
  private String email1;
  private String email2;
  private String email3;
  private String allAddress;
  private String allPhones;
  private File foto;


  public File getFoto() {
    return foto;

  }

  public AddressData withFoto(File foto) {
    this.foto = foto;
    return this;
  }

  public String getAllAddress() {
    return allAddress;
  }

  public AddressData withAllAddress(String allAddress) {
    this.allAddress = allAddress;
    return this;
  }

  public String getEmail1() {
    return email1;
  }

  public AddressData withEmail1(String email1) {
    this.email1 = email1;
    return this;
  }

  public String getEmail2() {
    return email2;
  }

  public AddressData withEmail2(String email2) {
    this.email2 = email2;
    return this;
  }

  public String getEmail3() {
    return email3;
  }

  public AddressData withEmail3(String email3) {
    this.email3 = email3;
    return this;
  }

  public String getAllEmail() {
    return allEmail;
  }

  public AddressData withAllEmail(String email) {
    this.allEmail = email;
    return this;
  }


  public String getAddress2() {
    return address2;
  }

  public AddressData withAddress2(String address2) {
    this.address2 = address2;
    return this;
  }

  public String getAllPhones() {
    return allPhones;
  }

  public AddressData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }



  public AddressData withId(int id) {
    this.id = id;
    return this;
  }

  public int getId() {
    return id;

  }

  public AddressData withFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public AddressData withLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public AddressData withGroup(String group) {
    this.group = group;
    return this;
  }

  public AddressData withAddress(String address) {
    this.address = address;
    return this;
  }

  public AddressData withHomeTelephoneNumber(String telephoneNumber) {
    this.homeTelephoneNumber = telephoneNumber;
    return this;
  }

  public AddressData withMobileTelephoneNumber (String mobileTelephoneNumber){
    this.mobileTelephoneNumber = mobileTelephoneNumber;
    return this;
  }

  public AddressData withWorkTelephoneNumber (String workTelephoneNumber){
    this.workTelephoneNumber = workTelephoneNumber;
    return this;
  }

  public String getFirstName() {
    return firstName;
  }
//  public String getMiddleName() {
//    return middleName;
  // }

  public String getLastName() {
    return lastName;
  }

  public String getGroup() {
    return group;
  }

  public String getAddress() {
    return address;
  }

  public String getHomeTelephoneNumber() {
    return homeTelephoneNumber;
  }

  public String getMobileTelephoneNumber() {
    return mobileTelephoneNumber;
  }

  public String getWorkTelephoneNumber() {
    return workTelephoneNumber;
  }

  @Override
  public String toString() {
    return "AddressData{" +
            "id='" + id + '\'' +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    AddressData that = (AddressData) o;

    if (id != that.id) return false;
    if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
    return lastName != null ? lastName.equals(that.lastName) : that.lastName == null;
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
    result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
    return result;
  }

}
