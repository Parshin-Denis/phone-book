package practice;

import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите номер, имя или команду:");
            String input = scanner.nextLine();

            if (input.equals("EXIT")) { break; }

            if (input.equals("LIST")) {
                for (String contact : phoneBook.getAllContacts()) { System.out.println(contact); }
                continue;
            }

            if (phoneBook.isCorrectPhone(input)) {
                String contact = phoneBook.getContactByPhone(input);
                if (contact.isBlank()) {
                    System.out.println("Такого номера нет в телефонной книге.");
                    System.out.println("Введите имя аббонента для \"" + input + "\"");
                    String name = scanner.nextLine();
                    phoneBook.addContact(input, name);
                }
                else {
                    System.out.println(contact);
                }
                continue;
            }

            if (phoneBook.isCorrectName(input)) {
                Set<String> contacts = phoneBook.getContactByName(input);
                if (contacts.isEmpty()) {
                    System.out.println("Такого имени нет в телефонной книге.");
                    System.out.println("Введите номер телефона для абонента \"" + input + "\"");
                    String phone = scanner.nextLine();
                    phoneBook.addContact(phone, input);
                }
                else {
                    System.out.println(contacts);
                }
                continue;
            }
            System.out.println("Неверный формат ввода");
        }
    }
}
