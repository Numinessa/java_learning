package ru.stqa.pft.addressbook.model;

import com.google.common.collect.ForwardingSet;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Contacts extends ForwardingSet<AddressData> {

  private Set<AddressData> delegate;

  public Contacts(Contacts contacts) {
    this.delegate = new HashSet<AddressData>(contacts.delegate);
  }

  public Contacts(List<AddressData> result) {
    this.delegate = new HashSet<AddressData>();
  }

  @Override
  protected Set<AddressData> delegate() {
    return delegate;
  }

  public Contacts withAdded(AddressData group) {
    Contacts contacts = new Contacts(this);
    contacts.add(group);
    return contacts;
  }

  public Contacts without(AddressData group) {
    Contacts contacts = new Contacts(this);
    contacts.remove(group);
    return contacts;
  }
}
