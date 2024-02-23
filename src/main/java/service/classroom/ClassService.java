package service.classroom;

import controller.ConnectionJDBC;
import model.ClassRoom;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ClassService implements IClassService{
    public static final String SELECT_FROM_CLASS_ROOM_WHERE_ID = "select * from class_room where id=?;";
    Connection connection = ConnectionJDBC.getConnection();

    @Override
    public List<ClassRoom> findAll() {
        return null;
    }

    @Override
    public ClassRoom findById(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_FROM_CLASS_ROOM_WHERE_ID);
            statement.setString(1, String.valueOf(id));
            ResultSet resultSet = statement.executeQuery();
            ClassRoom classRoom = null;
            while (resultSet.next()){
                int c_id = resultSet.getInt("id");
                String c_name = resultSet.getString("name");
                classRoom = new ClassRoom(c_id,c_name);
            }
            return classRoom;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(ClassRoom classRoom) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void edit(int id) {

    }
}
