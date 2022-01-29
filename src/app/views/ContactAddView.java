package app.views;

import app.database.entities.Contact;
import app.models.ContactAddModel;
import app.utils.Validator;

import java.util.Scanner;


public class ContactAddView {

    ContactAddModel model;
    Contact contact;
    String title;
    String name;
    String phone;
    Scanner scanner;

    public ContactAddView(ContactAddModel model) {
        this.model = model;
    }

    public Contact doInputs() {

        scanner = new Scanner(System.in);
        contact = new Contact();

        // Ввод и валидация данных

        title = "Введите имя: ";
        System.out.print(title);
        name = Validator.validateNameInput(scanner);
        contact.setName(name);

        title = "Введите телефон: ";
        System.out.print(title);
        phone = Validator.validatePhoneInput(scanner);
        contact.setPhone(phone);

        return contact;
    }

    // Вывод уведомления
    public void getOutput(String output) {
        System.out.println(output);
    }
}