import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CalculatorServlet",urlPatterns = {"/Calculator"})
public class CalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int first = Integer.parseInt(request.getParameter("First"));
        String operator = request.getParameter("Operator");
        int second = Integer.parseInt(request.getParameter("Second"));

        Calculator result =new Calculator(first,operator,second);
        result.calculate();


        request.setAttribute("First",first);
        request.setAttribute("Operator",operator);
        request.setAttribute("Second",second);
        request.setAttribute("result",result);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("calculate.jsp");
        requestDispatcher.forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
