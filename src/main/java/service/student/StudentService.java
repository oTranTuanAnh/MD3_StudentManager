package service.student;

import controller.ConnectionJDBC;
import model.Student;
import service.classroom.ClassService;
import service.classroom.IClassService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

public class StudentService implements IStudentService{
    public static final String SELECT_ALL_FROM_STUDENT = "select * from student;";
    Connection connection = ConnectionJDBC.getConnection();
    IClassService classService = new ClassService();
    @Override
    public List<Student> findAll() {
        List<Student> studentList = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_FROM_STUDENT);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int s_id = resultSet.getInt("id");
                String s_name = resultSet.getString("name");
                String s_email = resultSet.getString("email");
                LocalDate s_dob = resultSet.getDate("date_of_birth").toLocalDate();
                String s_add = resultSet.getString("address");
                String s_phone = resultSet.getString("phone");
                int s_c_id = resultSet.getInt("class_id");
                String s_c_name = classService.findById(s_c_id).getName();
                Student student = new Student(s_id, s_name, s_email, s_dob, s_add, s_phone, s_c_id, s_c_name);
                studentList.add(student);
            }
            return studentList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public Student findById(int id) {
        return null;
    }

    @Override
    public void save(Student student) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void edit(int id) {

    }
}
