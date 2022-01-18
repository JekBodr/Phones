import controllers.AppController;
import models.AppModel;
import views.AppView;

public class App {

    public static void main(String[] args) {

        AppModel model = new AppModel();
        AppView view = new AppView(model);
        AppController controller = new AppController(model, view);
        controller.runApp();
    }
}
