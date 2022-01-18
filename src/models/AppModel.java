package models;

import controllers.ContactCreateController;
import controllers.ContactReadController;
import views.ContactCreateView;
import views.ContactReadView;

// TASK исправьте ошибки компиляции
public class AppModel {

    private int choice;

    public int getChoice() {
        return choice;
    }

    public void setChoice(int choice) {
        this.choice = choice;
    }

    public void addContacts() {
        ContactCreateModel model = new ContactCreateModel();
        ContactCreateView view = new ContactCreateView(model);
        ContactCreateController controller = new ContactCreateController(model, view);
        controller.addContacts();
    }

    public void readContacts() {
        // TASK создайте необходимые экземпляры
        // и исправьте ошибки компиляции+++
        ContactReadModel model = new ContactReadModel();
        ContactReadView view = new ContactReadView(model);
        ContactReadController controller = new ContactReadController(model,view);
        controller.getContacts();
    }
}
