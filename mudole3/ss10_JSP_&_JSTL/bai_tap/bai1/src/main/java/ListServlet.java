import model.Customer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ListServlet",urlPatterns = {"/customer"})
public class ListServlet extends HttpServlet {
    private static List<Customer> customerList = new ArrayList<>();
    static {
        customerList.add(new Customer("Mai Van Hoan","20-08-1983", "Ha Noi","https://kenh14cdn.com/203336854389633024/2022/6/29/photo-1-1656495058620646444149.jpg"));
        customerList.add(new Customer("Nguyen Van A","02-10-1973", "Da Nang","https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/d828fbb7-2145-4d18-97bf-9d030441129a/d850nek-ba2764ef-151f-44cf-accc-b505576b7c75.jpg/v1/fill/w_774,h_1032,q_70,strp/guku___dragon_ball_by_cloud22ds_d850nek-pre.jpg?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1cm46YXBwOjdlMGQxODg5ODIyNjQzNzNhNWYwZDQxNWVhMGQyNmUwIiwiaXNzIjoidXJuOmFwcDo3ZTBkMTg4OTgyMjY0MzczYTVmMGQ0MTVlYTBkMjZlMCIsIm9iaiI6W1t7ImhlaWdodCI6Ijw9NTE1MiIsInBhdGgiOiJcL2ZcL2Q4MjhmYmI3LTIxNDUtNGQxOC05N2JmLTlkMDMwNDQxMTI5YVwvZDg1MG5lay1iYTI3NjRlZi0xNTFmLTQ0Y2YtYWNjYy1iNTA1NTc2YjdjNzUuanBnIiwid2lkdGgiOiI8PTM4NjQifV1dLCJhdWQiOlsidXJuOnNlcnZpY2U6aW1hZ2Uub3BlcmF0aW9ucyJdfQ.FTQLuCQZK_XJTwYcdV7AfvL1mUcl0kZ67i2yX6mE4TE"));
        customerList.add(new Customer("Tran Viet B","10-01-2012", "Quang Nam","https://genk.mediacdn.vn/thumb_w/640/139269124445442048/2022/3/23/1-1648003672575563037568.jpg"));
        customerList.add(new Customer("Ho Van C","12-09-1989", "Bac Giang","https://cdn.nguyenkimmall.com/images/companies/_1/tin-tuc/review/phim/the-wind-rises-gio-noi-2013.jpg"));
        customerList.add(new Customer("Bui Mai D","19-04-2002", "Can Tho","https://cdn.nguyenkimmall.com/images/companies/_1/tin-tuc/review/phim/from-up-on-poppy-hill-ngon-doi-hoa-hong-anh-2011.jpg"));
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/customer.jsp");
        request.setAttribute("customerList",customerList);
        requestDispatcher.forward(request,response);
    }
}
