package app.views;

import app.database.entities.Contact;
import app.utils.Validator;
import app.models.ContactDeleteModel;

import java.util.Scanner;

public class ContactDeleteView {

    ContactDeleteModel model;

    public ContactDeleteView(ContactDeleteModel model) {
        this.model = model;
    }

    public Contact doInput() {

        Scanner scanner = new Scanner(System.in);
        Contact contact = new Contact();

        // Ввод и валидация данных
        String title = "Введите ID контакта: ";
        System.out.print(title);
        contact.setId(Validator.validateIdInput(scanner));

        return contact;
    }

    // Вывод уведомления
    public void getOutput(String output) {
        System.out.println(output);
    }
}
