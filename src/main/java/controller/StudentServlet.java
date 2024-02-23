package controller;

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
//                showFormCreate(req, resp);
                break;
            case "edit":
//                showFormEdit(req, resp);
                break;
            default:
                showList(req, resp);
                break;
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
//        super.doPost(req, resp);
    }
}
