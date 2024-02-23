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
    public static final String SELECT_FROM_STUDENT_WHERE_ID = "select * from student where id=?;";
    public static final String INSERT_INTO_STUDENT = "insert into student (name, email, date_of_birth, address, phone, class_id) values (?,?,?,?,?,?);";
    public static final String SELECT_FROM_STUDENT_WHERE_NAME_LIKE = "select * from student where name like ?;";
    public static final String DELETE_FROM_STUDENT_WHERE_ID = "delete from student where id = ?;";
    public static final String UPDATE_STUDENT_WHERE_ID = "update student set name = ?, email =?, date_of_birth=?,address = ?, phone= ?,class_id = ? where id =?;";
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
        try {

            PreparedStatement statement = connection.prepareStatement(SELECT_FROM_STUDENT_WHERE_ID);
            statement.setString(1, String.valueOf(id));
            ResultSet resultSet = statement.executeQuery();
           Student student = null;
            while (resultSet.next()){
                int s_id = resultSet.getInt("id");
                String s_name = resultSet.getString("name");
                String s_email = resultSet.getString("email");
                LocalDate s_dob = resultSet.getDate("date_of_birth").toLocalDate();
                String s_add = resultSet.getString("address");
                String s_phone = resultSet.getString("phone");
                int s_c_id = resultSet.getInt("class_id");
                String s_c_name = classService.findById(s_c_id).getName();
                student = new Student(s_id, s_name, s_email, s_dob, s_add, s_phone, s_c_id, s_c_name);
            }
            return student;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(Student student) {
        try {
            PreparedStatement statement = connection.prepareStatement(INSERT_INTO_STUDENT);
//            name, email, date_of_birth, address, phone, class_id
            statement.setString(1,student.getName());
            statement.setString(2,student.getEmail());
            statement.setString(3, String.valueOf(student.getDateOfBirth()));
            statement.setString(4,student.getAddress());
            statement.setString(5,student.getPhone());
            statement.setString(6, String.valueOf(student.getClassID()));
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement(DELETE_FROM_STUDENT_WHERE_ID);
            statement.setString(1, String.valueOf(id));
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void edit(int id) {

    }

    @Override
    public List<Student> findByName(String name) {
        try {

            PreparedStatement statement = connection.prepareStatement(SELECT_FROM_STUDENT_WHERE_NAME_LIKE);
            statement.setString(1,name);
            ResultSet resultSet = statement.executeQuery();
            List<Student> studentList = new ArrayList<>();
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
    public void edit(Student s, int id) {
        try {
            PreparedStatement statement = connection.prepareStatement(UPDATE_STUDENT_WHERE_ID);
            statement.setString(1, s.getName());
            statement.setString(2, s.getEmail());
            statement.setString(3, String.valueOf(s.getDateOfBirth()));
            statement.setString(4, s.getAddress());
            statement.setString(5, s.getPhone());
            statement.setString(6, String.valueOf(s.getClassID()));
            statement.setString(7, String.valueOf(id));
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
