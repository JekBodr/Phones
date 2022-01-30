package app.models;


import app.database.DBCheck;
import app.database.DBConn;
import app.database.entities.Contact;
import app.utils.Constants;
import app.utils.IdChecker;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ContactUpdateModel {

    public String updateContact(Contact contact) {
        // Проверяем на наличие файла БД.
        // Если ДА, обновляем данные и уведомляем об этом,
        // НЕТ - уведомление об отсутствии БД.
        if (DBCheck.isDBExists()) {
            return updateData(contact);
        } else {
            return Constants.DB_ABSENT_MSG;
        }
    }

    // Обновление по id, при условии его наличия в БД.
    // Если ДА - обновляем и выводим сообщение об удалении,
    // НЕТ - выводим сообщение об отсутствии id.
    private String updateData(Contact contact) {

        if (IdChecker.isIdExists(contact)) {

            String sql = "UPDATE " + Constants.TABLE_NAME + " SET phone = ? WHERE id = ?";
            // PreparedStatement - подготовленное выражение, чтобы избежать SQL-инъекций
            try (PreparedStatement pstmt = DBConn.connect().prepareStatement(sql)) {
                pstmt.setString(1, contact.getPhone());
                pstmt.setInt(2, contact.getId());
                pstmt.executeUpdate();
                return Constants.DATA_UPDATE_MSG;
            } catch (SQLException e) {
                return e.getMessage();
            }
        } else {
            return Constants.ID_NO_EXISTS_MSG;
        }
    }
}
