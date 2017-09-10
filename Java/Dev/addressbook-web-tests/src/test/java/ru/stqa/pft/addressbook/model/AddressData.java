package ru.stqa.pft.addressbook.model;

public class AddressData {
  private int id = Integer.MAX_VALUE;
  ;
  private String firstName;
  private String lastName;

  private String group;
  private String address;
  private String telephoneNumber;

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

  public AddressData withTelephoneNumber(String telephoneNumber) {
    this.telephoneNumber = telephoneNumber;
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

  public String getTelephoneNumber() {
    return telephoneNumber;
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

    if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
    return lastName != null ? lastName.equals(that.lastName) : that.lastName == null;
  }

  @Override
  public int hashCode() {
    int result = firstName != null ? firstName.hashCode() : 0;
    result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
    return result;
  }


}
