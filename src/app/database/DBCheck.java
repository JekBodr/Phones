package app.database;

import app.utils.Constants;
import java.io.File;

// Класс-проверка наличия файла БД.
public class DBCheck {

    public static boolean isDBExists() {
        String filePath = Constants.DB_BASE_URL + Constants.DB_NAME;
        File dbFile = new File(filePath);
        return dbFile.exists();
    }
}
