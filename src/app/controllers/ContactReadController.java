package controllers;

import models.AppModel;
import models.ContactReadModel;
import views.AppView;
import views.ContactReadView;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

// TASK исправьте ошибки компиляции
public class ContactReadController {

    ContactReadModel model;
    ContactReadView view;

    public ContactReadController(ContactReadModel model, ContactReadView view) {
        this.model = model;
        this.view = view;
    }

    public void getContacts() {
        String str = readContacts();
        view.getOutput(str);
        restartApp();
    }

    public String readContacts() {
        HashMap<String, String> map = model.readContacts();
        AtomicInteger count = new AtomicInteger(0);
        StringBuilder stringBuilder = new StringBuilder();
        map.forEach((key, value) ->
                stringBuilder.append(count.incrementAndGet())
                        .append(") ")
                        .append(key)
                        .append(" ")
                        .append(value)
                        .append("\n")
        );
        return stringBuilder.toString();
    }

    private void restartApp() {
        AppModel appModel = new AppModel();
        AppView appView = new AppView(appModel);
        AppController controller = new AppController(appModel, appView);
        controller.runApp();
    }
}
