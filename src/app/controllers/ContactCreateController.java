package app.controllers;

import app.models.AppModel;
import app.models.ContactCreateModel;
import app.views.AppView;
import app.views.ContactCreateView;


public class ContactCreateController {

    ContactCreateModel model;
    ContactCreateView view;

    public ContactCreateController(ContactCreateModel model, ContactCreateView view) {
        this.model = model;
        this.view = view;
    }

    public void addContacts() {
        String str = model.createContacts();
        view.getOutput(str);
        restartApp();
    }

    private void restartApp() {
        AppModel appModel = new AppModel();
        AppView appView = new AppView(appModel);
        AppController controller = new AppController(appModel, appView);
        controller.runApp();
    }
}
