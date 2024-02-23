package service.student;

import model.Student;
import service.IService;

import java.util.List;

public interface IStudentService extends IService<Student> {
    List<Student> findByName (String name);

    void edit(Student s, int id);
}
