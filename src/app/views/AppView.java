package views;

import models.AppModel;
import utils.Validator;

import java.util.Scanner;

public class AppView {

    AppModel model;
    Scanner scanner;
    int choice;

    public AppView(AppModel model) {
        this.model = model;
    }

    public int doChoice() {

        int option;
        scanner = new Scanner(System.in);

        System.out.print("""
                --------------------------
                Выберите опцию:
                1 - Создать контакты.
                2 - Посмотреть контакты.
                0 - Закрыть приложение.
                """);

        choice = Validator.validateChoice(scanner);
        model.setChoice(choice);
        option = model.getChoice();

        return option;
    }

    public void getOutput(String output, int choice) {
        if (choice == 0) System.out.println(output);
        // Scanner лучше закрыть здесь,
        // т.к. в этом методе завершаем программу.
        scanner.close();
        System.exit(0);
    }
}
