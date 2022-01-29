package app.models;

import app.database.DBCheck;
import app.database.DBConn;
import app.database.entities.Contact;
import app.utils.Constants;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class ContactAddModel {

    public String addContact(Contact contact) {
        // Проверяем на наличие файла БД.
        // Если ДА, вносим данные и уведомляем об этом,
        // НЕТ - уведомление об отсутствии БД.
        if (DBCheck.isDBExists()) {
            return addData(contact);
        } else {
            return Constants.DB_ABSENT_MSG;
        }
    }

    private String addData(Contact contact) {

        String sql = "INSERT INTO " + Constants.TABLE_NAME + "(name, phone) VALUES(?, ?)";
        // PreparedStatement - подготовленное выражение, чтобы избежать SQL-инъекций
        try (PreparedStatement pstmt = DBConn.connect().prepareStatement(sql)) {
            pstmt.setString(1, contact.getName());
            pstmt.setString(2, contact.getPhone());
            pstmt.executeUpdate();
            return Constants.DATA_INSERT_MSG;
        } catch (SQLException e) {
            return e.getMessage();
        }
    }
}
