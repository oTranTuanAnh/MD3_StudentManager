package controller;

import model.Student;
import service.classroom.ClassService;
import service.classroom.IClassService;
import service.student.IStudentService;
import service.student.StudentService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebServlet( urlPatterns = "/student")
public class StudentServlet extends HttpServlet {
    IClassService classService = new ClassService();
    IStudentService studentService = new StudentService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String act = req.getParameter("action");
        if (act == null) {
            act = "";
        }
        switch (act){
            case "create":
                showFormCreate(req, resp);
                break;
            case "search":
                showSearch(req, resp);
                break;
            case "delete":
                deleteByID(req, resp);
                showList(req, resp);
                break;
            case "edit":
                showFormEdit(req, resp);
                break;
            default:
                showList(req, resp);
                break;
        }
    }

    private void showFormEdit(HttpServletRequest req, HttpServletResponse resp) {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/edit.jsp");
        req.setAttribute("students", studentService.findById(Integer.parseInt(req.getParameter("id"))));
        req.setAttribute("classroom", classService.findAll());
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void showSearch(HttpServletRequest req, HttpServletResponse resp) {
        String s_name = "%"+req.getParameter("search")+"%";
        req.setAttribute("studentResult", studentService.findByName(s_name));
        RequestDispatcher dispatcher = req.getRequestDispatcher("/search.jsp");
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private void showFormCreate(HttpServletRequest req, HttpServletResponse resp) {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/create.jsp");
        req.setAttribute("classroom", classService.findAll());
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void showList(HttpServletRequest req, HttpServletResponse resp) {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/list.jsp");
        req.setAttribute("students", studentService.findAll());

        try {
            dispatcher.forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String act = req.getParameter("action");
        if (act == null) {
            act = "";
        }
        switch (act){
            case "create":
                createNewStudent(req, resp);
                showList(req, resp);
                break;

            case "edit":
                editStudent(req, resp);
                showList(req, resp);
                break;
            default:
                showList(req, resp);
        }
    }

    private void editStudent(HttpServletRequest req, HttpServletResponse resp) {
        int s_id = Integer.parseInt(req.getParameter("id"));
        String s_name = req.getParameter("name");
        String s_email = req.getParameter("email");
        DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate s_date = LocalDate.parse(req.getParameter("dateOfBirth"), fmt2);
        String s_add = req.getParameter("address");
        String s_phone = req.getParameter("phone");
        int s_c_id = Integer.parseInt(req.getParameter("classroom"));

        Student student = new Student(s_name, s_email, s_date,s_add, s_phone, s_c_id );
        studentService.edit(student, s_id);
    }

    private void deleteByID(HttpServletRequest req, HttpServletResponse resp) {
        int s_id = Integer.parseInt(req.getParameter("id"));
        studentService.delete(s_id);
    }


    private void createNewStudent(HttpServletRequest req, HttpServletResponse resp) {
        String s_name = req.getParameter("name");
        String s_email = req.getParameter("email");
        DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate s_date = LocalDate.parse(req.getParameter("dateOfBirth"), fmt2);
        String s_add = req.getParameter("address");
        String s_phone = req.getParameter("phone");
        int s_c_id = Integer.parseInt(req.getParameter("classroom"));

        Student student = new Student(s_name, s_email, s_date,s_add, s_phone, s_c_id );
        studentService.save(student);
    }
}
