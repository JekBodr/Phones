package app.models;

import app.controllers.ContactAddController;
import app.controllers.ContactDeleteController;
import app.controllers.ContactReadController;
import app.controllers.ContactUpdateController;
import app.views.ContactAddView;
import app.views.ContactReadView;
import app.views.ContactDeleteView;
import app.views.ContactUpdateView;

public class AppModel {

    private int choice;

    public int getChoice() {
        return choice;
    }

    public void setChoice(int choice) {
        this.choice = choice;
    }

    public void createContact() {
        ContactAddModel model = new ContactAddModel();
        ContactAddView view = new ContactAddView(model);
        ContactAddController controller = new ContactAddController(model, view);
        controller.addContact();
    }

    public void readContacts() {
        ContactReadModel model = new ContactReadModel();
        ContactReadView view = new ContactReadView(model);
        ContactReadController controller = new ContactReadController(model, view);
        controller.getContacts();
    }

    public void updateContact() {
        ContactUpdateModel model = new ContactUpdateModel();
        ContactUpdateView view = new ContactUpdateView(model);
        ContactUpdateController controller = new ContactUpdateController(model, view);
        controller.updateContact();
    }

    public void deleteContact() {
        ContactDeleteModel model = new ContactDeleteModel();
        ContactDeleteView view = new ContactDeleteView(model);
        ContactDeleteController controller = new ContactDeleteController(model, view);
        controller.deleteContact();
    }
}

