package views;

import models.ContactCreateModel;

public class ContactCreateView {

    ContactCreateModel model;

    // TASK допишите недостающий конструктор.

    public ContactCreateView(ContactCreateModel model) {
        this.model = model;
    }

    // Вывод уведомления
    public void getOutput(String output) {
        System.out.println(output);
    }
}
