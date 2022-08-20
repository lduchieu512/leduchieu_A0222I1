import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "DictionaryServlet",value = "/dictionary")
public class DictionaryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         Map<String, String> dic = new HashMap<>();
        dic.put("hello", "Xin chào");
        dic.put("how", "Thế nào");
        dic.put("book", "Quyển vở");
        dic.put("computer", "Máy tính");
        String search = request.getParameter("search");
        String result = dic.get(search);
        if (result != null) {
            request.setAttribute("word",search);
            request.setAttribute("result",result);
            request.getRequestDispatcher("dictionary.jsp").forward(request,response);
        } else {
            String not_found = "Not found";
            request.setAttribute("word",search);
            request.setAttribute("result",not_found);
            request.getRequestDispatcher("dictionary.jsp").forward(request,response);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
