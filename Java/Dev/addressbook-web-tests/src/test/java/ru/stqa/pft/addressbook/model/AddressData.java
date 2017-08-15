package ru.stqa.pft.addressbook.model;

public class AddressData {
  private final String firstName;
  private final String middleName;
  private final String lastName;
  private String group;
  private final String address;
  private final String telephoneNumber;

  public AddressData(String firstName,String middleName, String LastName,String group, String address, String telephoneNumber) {
    this.firstName = firstName;
    this.middleName = middleName;
    lastName = LastName;
    this.group = group;
    this.address = address;
    this.telephoneNumber = telephoneNumber;
  }

  public String getFirstName() {
    return firstName;
  }
  public String getMiddleName() {
    return middleName;
  }

  public String getLastName() {
    return lastName;
  }
  public String getGroup() {
    return group;
  }

  public String getAddress() {
    return address;
  }

  public String getTelephoneNumber() {
    return telephoneNumber;
  }


}
