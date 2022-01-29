package app.controllers;

import app.database.entities.Contact;
import app.models.ContactAddModel;
import app.utils.AppStarter;
import app.utils.Constants;
import app.views.ContactAddView;


public class ContactAddController {

    ContactAddModel model;
    ContactAddView view;
    Contact contact;

    public ContactAddController(ContactAddModel model, ContactAddView view) {
        this.model = model;
        this.view = view;
    }

    public void addContact() {

        contact = view.doInputs();
        // Вносим данные и получаем сообщение.
        String str = model.addContact(contact);
        // Проверяем сообщение на внесение данных.
        // Если БД отсутствует, выводим сообщение об этом
        // и закрываем приложение.
        // Иначе выводим сообщение и перезапускаем приложение.
        if (str.equals(Constants.DB_ABSENT_MSG)) {
            // Выводим уведомление.
            view.getOutput(str);
            // Закрываем приложение.
            System.exit(0);
        } else {
            // Выводим уведомление.
            view.getOutput(str);
            // Перезапускаем приложение.
            AppStarter.startApp();
        }
    }
}
