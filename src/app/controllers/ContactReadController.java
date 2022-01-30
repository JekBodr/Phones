package app.controllers;

import app.database.entities.Contact;
import app.models.ContactReadModel;
import app.utils.AppStarter;
import app.utils.Constants;
import app.views.ContactReadView;
import java.util.List;

public class ContactReadController {

    ContactReadModel model;
    ContactReadView view;

    public ContactReadController(ContactReadModel model, ContactReadView view) {
        this.model = model;
        this.view = view;
    }

    public void getContacts() {
        String str = readContacts();
        // Проверяем возврат чтения данных.
        // Если БД отсутствует, выводим сообщение об этом
        // и закрываем приложение.
        // Иначе выводим сообщение и перезапускаем приложение.
        if (str.equals(Constants.DB_ABSENT_MSG)) {
            // Выводим уведомление.
            view.getOutput(str);
            // Закрываем приложение.
            System.exit(0);
        } else {
            // Выводим уведомление или данные.
            view.getOutput(str);
            // Перезапускаем приложение.
            AppStarter.startApp();
        }
    }

    private String readContacts() {

        // Получаем данные в коллекцию.
        List<Contact> contacts = model.readContacts();

        // Если коллекция не null, формируем вывод.
        // Иначе уведомление об отсутствии БД.
        if (contacts != null) {
            // Если коллекция не пуста, формируем вывод.
            // Иначе уведомление об отсутствии данных.
            if (!contacts.isEmpty()) {
                int count = 0;
                String str;

                // Применяем StringBuilder для формирования вывода.
                // В Java объекты String неизменяемы.
                // Это означает, что любая операция с объектом String
                // не изменит содержимое объекта, а создаст новое с
                // преобразованным значением.
                // Конкатенация - дорогостоящая операция
                // (с точки зрения производительности)
                // из-за неизменности строки.
                // Поэтому использовать StringBuilder.
                StringBuilder stringBuilder = new StringBuilder();

                for (Contact contact : contacts) {
                    count++;
                    str = count + ") ID: "
                            + contact.getId() + " - "
                            + " " + contact.getName()
                            + " " + contact.getPhone()
                            + "\n";
                    stringBuilder.append(str);
                }
                return stringBuilder.toString();
            } else
                return Constants.DATA_ABSENT_MSG;
        } else
            return Constants.DB_ABSENT_MSG;
    }
}
