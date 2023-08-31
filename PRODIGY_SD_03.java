import java.util.ArrayList;
import java.util.Scanner;

class Contact {
    private String name;
    private String phoneNumber;
    private String emailAddress;

    public Contact(String name, String phoneNumber, String emailAddress) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }
}

public class ContactManagementSystem {
    private static ArrayList<Contact> contacts = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;

        while (!exit) {
            System.out.println("Contact Management System");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Edit Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline

            switch (choice) {
                case 1:
                    addContact();
                    break;
                case 2:
                    viewContacts();
                    break;
                case 3:
                    editContact();
                    break;
                case 4:
                    deleteContact();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }

        scanner.close();
    }

    private static void addContact() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Enter email address: ");
        String emailAddress = scanner.nextLine();

        Contact contact = new Contact(name, phoneNumber, emailAddress);
        contacts.add(contact);

        System.out.println("Contact added successfully!");
    }

    private static void viewContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts available.");
            return;
        }

        System.out.println("Contact List:");
        for (int i = 0; i < contacts.size(); i++) {
            Contact contact = contacts.get(i);
            System.out.println((i + 1) + ". Name: " + contact.getName() + ", Phone: " + contact.getPhoneNumber() + ", Email: " + contact.getEmailAddress());
        }
    }

    private static void editContact() {
        viewContacts();
        System.out.print("Enter the index of the contact to edit: ");
        int index = scanner.nextInt();
        scanner.nextLine();  // Consume the newline

        if (index < 1 || index > contacts.size()) {
            System.out.println("Invalid index.");
            return;
        }

        Contact contact = contacts.get(index - 1);

        System.out.println("Editing contact: " + contact.getName());
        System.out.print("Enter new name: ");
        String newName = scanner.nextLine();
        System.out.print("Enter new phone number: ");
        String newPhoneNumber = scanner.nextLine();
        System.out.print("Enter new email address: ");
        String newEmailAddress = scanner.nextLine();

        contact = new Contact(newName, newPhoneNumber, newEmailAddress);
        contacts.set(index - 1, contact);

        System.out.println("Contact updated successfully!");
    }

    private static void deleteContact() {
        viewContacts();
        System.out.print("Enter the index of the contact to delete: ");
        int index = scanner.nextInt();
        scanner.nextLine();  // Consume the newline

        if (index < 1 || index > contacts.size()) {
            System.out.println("Invalid index.");
            return;
        }

        Contact contact = contacts.remove(index - 1);
        System.out.println("Contact " + contact.getName() + " deleted.");
    }
}
