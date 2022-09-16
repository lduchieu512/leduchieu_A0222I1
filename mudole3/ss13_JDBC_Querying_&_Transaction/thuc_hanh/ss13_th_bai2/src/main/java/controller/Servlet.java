package controller;

import model.User;
import repository.IUserDao;
import repository.impl.UserDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "Servlet",urlPatterns = "/users")
public class Servlet extends HttpServlet {
    private static final long serialVersionUID =1L;
    private IUserDao userDao;

    @Override
    public void init() throws ServletException {
        userDao = new UserDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws   ServletException, IOException {
        String action = request.getParameter("action");
        if (action ==null){
            action="";
        }
        switch (action){
            case "create":
                try {
                    insertUser(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "edit":
                try {
                    updateUser(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            }
        try {
            SearchName(request,response);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    private void SearchName(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException  {
        String sname = request.getParameter("search");
        List<User> searchName = userDao.searchName(sname);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/list.jsp");
        request.setAttribute("userList",searchName);
        dispatcher.forward(request,response);
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException  {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        User user = new User(id,name,email,country);
        userDao.updateUser(user);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/edit.jsp");
        dispatcher.forward(request,response);
    }

    private void insertUser(HttpServletRequest request, HttpServletResponse response) throws  SQLException, ServletException, IOException {
      //  int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        User user = new User(name,email,country);
        userDao.insertUserStore(user);
//        userDao.insertUser(user);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/create.jsp");
        dispatcher.forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action ==null){
            action="";
        }
            switch (action) {
            case "create":
                try {
                    showNewForm(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "edit":
                try {
                    showEditForm(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
                case "sort":
                    try {
                        SortCountry(request,response);
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    break;
            case "delete":
                try {
                    deleteUser(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "permision":
                addUserPermision(request, response);
                break;
            default:
                try {
                    listUser(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            }

    }

    private void addUserPermision(HttpServletRequest request, HttpServletResponse response) {
        User user = new User("quan", "quan.nguyen@codegym.vn", "vn");
        int[] permision = {1, 2, 4};
        userDao.addUserTransaction(user, permision);
    }

    private void SortCountry(HttpServletRequest request, HttpServletResponse response)throws ServletException,SQLException,IOException {
       // String name = request.getParameter("name");
        List<User> sortUsers = userDao.sortName();
       // List<User> sortUsers =userDao.sortName(userDao.selectAllUser());
        request.setAttribute("userList",sortUsers);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/list.jsp");
        dispatcher.forward(request,response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException,SQLException,IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        User existingUser = userDao.getUserById(id);
//        User user = userDao.selectUser(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/edit.jsp");
        request.setAttribute("user",existingUser);
        dispatcher.forward(request,response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException,SQLException,IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/create.jsp");
        dispatcher.forward(request, response);
    }

    private void listUser(HttpServletRequest request, HttpServletResponse response) throws ServletException,SQLException,IOException {
        List<User> userList = userDao.selectAllUser();
        request.setAttribute("userList",userList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/list.jsp");
        dispatcher.forward(request,response);
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, IOException{
        int id = Integer.parseInt(request.getParameter("id"));
        userDao.delete(id);
        List<User> userList = userDao.selectAllUser();
//      cach1:
//        response.sendRedirect("/users");
        //cach2:
        request.setAttribute("userList",userList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/list.jsp");
        requestDispatcher.forward(request,response);
    }


}
