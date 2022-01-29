package app;

import app.controllers.AppController;
import app.models.AppModel;
import app.views.AppView;



public class App {
     //Вход в программу
    public static void main(String[] args) {

        AppModel model = new AppModel();
        AppView view = new AppView(model);
        AppController controller = new AppController(model, view);
        controller.runApp();
    }
}
