package org.example.mobile;

import java.util.List;

public class MobilePhone {
    private String myNumber;
    private List<Contact> myContacts;

    // Constructor
    public MobilePhone(String myNumber, List<Contact> myContacts) {
        this.myNumber = myNumber;
        this.myContacts = myContacts;
    }

    // Getter metodları
    public String getMyNumber() {
        return myNumber;
    }

    public List<Contact> getMyContacts() {
        return myContacts;
    }

    // 1) addNewContact
    public boolean addNewContact(Contact contact) {
        if (findContact(contact.getName()) >= 0) {
            return false; // zaten var
        }
        myContacts.add(contact);
        return true;
    }

    // 2) updateContact
    public boolean updateContact(Contact oldContact, Contact newContact) {
        int position = findContact(oldContact);
        if (position < 0) {
            return false; // bulunamadı
        }
        myContacts.set(position, newContact);
        return true;
    }

    // 3) removeContact
    public boolean removeContact(Contact contact) {
        int position = findContact(contact);
        if (position < 0) {
            return false; // bulunamadı
        }
        myContacts.remove(position);
        return true;
    }

    // 4) findContact (Contact parametreli)
    public int findContact(Contact contact) {
        return myContacts.indexOf(contact);
    }

    // 5) findContact (String parametreli)
    public int findContact(String contactName) {
        for (int i = 0; i < myContacts.size(); i++) {
            if (myContacts.get(i).getName().equals(contactName)) {
                return i;
            }
        }
        return -1;
    }

    // 6) queryContact
    public Contact queryContact(String name) {
        int position = findContact(name);
        if (position >= 0) {
            return myContacts.get(position);
        }
        return null;
    }

    // 7) printContacts
    public void printContacts() {
        System.out.println("Contact List:");
        for (Contact c : myContacts) {
            System.out.println(c.getName() + " -> " + c.getPhoneNumber());
        }
    }
}
