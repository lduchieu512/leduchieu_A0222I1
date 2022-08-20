import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet " ,value = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");



        if ("admin".equals(username)&& "admin".equals(password)){
            String user ="Welcome admin to website";
            request.setAttribute("ketqua",user);
            request.getRequestDispatcher("hello.jsp").forward(request,response);
        }else {
            String error = "Error!";
            request.setAttribute("ketqua",error);
            request.getRequestDispatcher("hello.jsp").forward(request,response);
        }


//        PrintWriter  writer = response.getWriter();
//        writer.println("<html>");
//        if ("admin".equals(username)&& "admin".equals(password)){
//            writer.println("<h1> Welcome "+username+" to website </h1>");
//        }else {
//            writer.println("<h1> Login Error </h1>");
//        }
//
//        writer.println("<html>");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
