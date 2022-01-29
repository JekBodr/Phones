package app.utils;

import app.controllers.AppController;
import app.models.AppModel;
import app.views.AppView;

public class AppStarter {

    public static void startApp() {
        AppModel appModel = new AppModel();
        AppView appView = new AppView(appModel);
        AppController controller = new AppController(appModel, appView);
        controller.runApp();
    }
}
