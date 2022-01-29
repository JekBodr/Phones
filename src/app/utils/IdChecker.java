package app.utils;

import app.database.DBConn;
import app.database.entities.Contact;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// Класс-проверка наличия id в БД
public class IdChecker {

    public static boolean isIdExists(Contact contact) {

        try {
            String query = "SELECT COUNT(id) FROM " + Constants.TABLE_NAME + " WHERE id = ?";
            PreparedStatement pst = DBConn.connect().prepareStatement(query);
            pst.setInt(1, contact.getId());

            try (ResultSet rs = pst.executeQuery()) {
                // Ожидаем только один результат
                if (rs.next()) {
                    return rs.getBoolean(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
