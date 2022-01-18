package models;

import java.util.HashMap;

public class ContactCreateModel {

    // Имитация записи в БД.
    public String createContacts() {

        // TASK Средствами HashMap<> создайте перечень контактов,
        // где имя - ключ, номер телефона - значение.

        // TASK должно возвращаться уведомление о создании
        // со значением типа HashMap<>.
        HashMap<String,String> contacts = new HashMap<>();
        contacts.put("Андрей","+38050050050");
        contacts.put("Антон","+38050050055");
        contacts.put("Антип","+38050050056");
        contacts.put("Алексей","+38050050058");
        contacts.put("Артёи","+38050050059");
        return "Контакты созданы";
    }
}
