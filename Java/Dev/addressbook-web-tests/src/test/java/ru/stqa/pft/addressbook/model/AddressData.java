package ru.stqa.pft.addressbook.model;

public class AddressData {
  private int id;
  private final String firstName;

  private final String lastName;
  private String group;
  private final String address;
  private final String telephoneNumber;



  public AddressData(String firstName, String LastName, String group, String address, String telephoneNumber) {
    this.id = Integer.MAX_VALUE;
    this.firstName = firstName;
//    this.middleName = middleName;
    lastName = LastName;
    this.group = group;
    this.address = address;
    this.telephoneNumber = telephoneNumber;
  }

  public AddressData(int id, String firstName, String LastName, String group, String address, String telephoneNumber) {
    this.id = id;
    this.firstName = firstName;
//    this.middleName = middleName;
    lastName = LastName;
    this.group = group;
    this.address = address;
    this.telephoneNumber = telephoneNumber;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getId() {

    return id;
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
