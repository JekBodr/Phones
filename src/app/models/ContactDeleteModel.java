package app.models;

import app.database.DBCheck;
import app.database.DBConn;
import app.database.entities.Contact;
import app.utils.Constants;
import app.utils.IdChecker;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ContactDeleteModel {

    public String deleteContact(Contact contact) {
        // Проверяем на наличие файла БД.
        // Если ДА, удаляем данные и уведомляем об этом,
        // НЕТ - уведомление об отсутствии БД.
        if (DBCheck.isDBExists()) {
            return deleteData(contact);
        } else {
            return Constants.DB_ABSENT_MSG;
        }
    }

    // Удаление по id, при условии его наличия в БД.
    // Если ДА - удаляем и выводим сообщение об удалении,
    // НЕТ - выводим сообщение об отсутствии id.
    private String deleteData(Contact contact) {

        if (IdChecker.isIdExists(contact)) {

            String sql = "DELETE FROM " + Constants.TABLE_NAME + " WHERE id = ?";

            try (PreparedStatement stmt = DBConn.connect().prepareStatement(sql)) {
                // установка соответствующих параметров
                stmt.setInt(1, contact.getId());
                // выполнение запроса в БД
                stmt.executeUpdate();
                return Constants.DATA_DELETE_MSG;
            } catch (SQLException e) {
                return e.getMessage();
            }
        } else {
            return Constants.ID_NO_EXISTS_MSG;
        }
    }
}
