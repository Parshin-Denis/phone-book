package practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class PhoneBook {
    private HashMap <String, String> phoneBook = new HashMap<>();

    public boolean isCorrectName(String name) {
        String regex = "[А-Яа-яA-Za-z]+";
        return name.matches(regex);
    }

    public boolean isCorrectPhone(String phone) {
        String regex = "7[0-9]{10}";
        return phone.matches(regex);
    }
    public void addContact(String phone, String name) {
        if (isCorrectName(name) && isCorrectPhone(phone)) {
            phoneBook.put(phone, name);
            System.out.println("Контакт сохранен");
        }
        else {
            System.out.println("Неверный формат ввода");
        }
    }

    public String getContactByPhone(String phone) {
        if (phoneBook.containsKey(phone)) {
            return phoneBook.get(phone) + " - " + phone;
        }
        return "";
    }

    public Set<String> getContactByName(String name) {
        TreeSet <String> contacts = new TreeSet<>();
        for (Map.Entry<String, String> entry : phoneBook.entrySet()){
            String key = entry.getKey();
            String value = entry.getValue();
            if (value.equals(name)) {
                contacts.add(value + " - " + key);
            }
        }
        return contacts;
    }

    public Set<String> getAllContacts() {
        TreeSet <String> allContacts = new TreeSet<>();
        for (Map.Entry<String, String> entry : phoneBook.entrySet()){
            String key = entry.getKey();
            String value = entry.getValue();
            String contactToAdd = value + " - " + key;
            for (String contact : allContacts) {
                if (contact.contains(value)) {
                    allContacts.remove(contact);
                    contactToAdd = contact + ", " + key;
                    break;
                }
            }
            allContacts.add(contactToAdd);
        }
        return allContacts;
    }
}