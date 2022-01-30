package app.utils;

import java.util.Scanner;

public class Validator {

    // Валидация ввода номера опции действия
    public static int validateOptionInput(Scanner scanner) {

        // Массив для выбора действий
        int[] options = {0, 1, 2, 3, 4};

        while (!scanner.hasNextInt()) {
            String str = scanner.nextLine().trim();
            System.out.printf(Constants.NOT_A_NUMBER_MSG, str);
        }
        int inputData = scanner.nextInt();

        while (!contains(options, inputData)) {
            System.out.println(Constants.NO_SUCH_OPTION_MSG);
            while (!scanner.hasNextInt()) {
                String str = scanner.next().trim();
                System.out.printf(Constants.NOT_A_NUMBER_MSG, str);
            }
            inputData = scanner.nextInt();
        }
        return inputData;
    }

    // Валидация ввода имени
    public static String validateNameInput(Scanner scanner) {
        String str = scanner.nextLine().trim();
        while (str.isEmpty()) {
            System.out.print(Constants.NAME_EMPTY_MSG);
            str = scanner.nextLine().trim();
        }
        return str;
    }

    // Валидация ввода телефона
    public static String validatePhoneInput(Scanner scanner) {
        String str = scanner.nextLine().trim();
        while (str.isEmpty()) {
            System.out.print(Constants.PHONE_EMPTY_MSG);
            str = scanner.nextLine().trim();
        }
        return str;
    }

    // Валидация ввода ID
    public static int validateIdInput(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            String str = scanner.next().trim();
            System.out.printf(Constants.NOT_A_NUMBER_MSG, str);
        }
        int id = scanner.nextInt();
        while (id <= 0) {
            System.out.println(Constants.WRONG_VALUE_MSG);
            while (!scanner.hasNextInt()) {
                String str = scanner.next().trim();
                System.out.printf(Constants.NOT_A_NUMBER_MSG, str);
            }
            id = scanner.nextInt();
        }
        return id;
    }

    // Проверка наличия ввода в массиве выбора
    // действий через contains()
    public static boolean contains(final int[] array, final int value) {
        boolean result = false;
        for (int i : array) {
            if (i == value) {
                result = true;
                break;
            }
        }
        return result;
    }
}
