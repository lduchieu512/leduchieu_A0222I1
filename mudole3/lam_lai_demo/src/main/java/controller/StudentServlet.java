package controller;

import model.Student;
import service.IStudentSevice;
import service.impl.StudentSevice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

@WebServlet(name = "StudentServlet",urlPatterns = "/student")
public class StudentServlet extends HttpServlet {

    private IStudentSevice studentSevice = new StudentSevice();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws  ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action="";
        }
        switch (action){
            case "create" :
                create(request,response);
                break;
            case "delete":
                break;
        }

    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        String birthday = request.getParameter("birthday");
        String account = request.getParameter("account");
        String email = request.getParameter("email");
        int point = Integer.parseInt(request.getParameter("point"));
        int classId = Integer.parseInt(request.getParameter("classId"));
        Student student = new Student(name,gender,birthday,point,account,classId,email);
        Map<String,String> map = studentSevice.add(student);
        String mess = "them moi thanh cong";
        if (!map.isEmpty()){
            mess ="them moi khong thanh cong";
            request.setAttribute("error",map);
        }
        request.setAttribute("mess",mess);
        try {
            response.sendRedirect("/student");
        }catch (IOException e){
            e.printStackTrace();
        }





    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
