package models;

import java.util.HashMap;

public class ContactReadModel {

//    // Имитация чтения из БД.
    public HashMap<String, String> readContacts() {
      // TASK Средствами HashMap<> создайте перечень контактов,
       // где имя - ключ, номер телефона - значение.
       // TASK должно возвращаться значение типа HashMap<>.
        HashMap<String,String> contacts = new HashMap<>();
        contacts.put("Андрей","+38050050050");
        contacts.put("Антон","+38050050055");
        contacts.put("Антип","+38050050056");
        contacts.put("Алексей","+38050050058");
        contacts.put("Артёи","+38050050059");
        return contacts;

    }
}
