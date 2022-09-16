package controller;

import model.Category;
import model.Product;
import repository.ICategoryDao;
import repository.IProductDao;
import repository.Impl.CategoryDao;
import repository.Impl.ProductDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = "/products")
public class ProductServlet extends HttpServlet {
    private  static final long serialVersionUID =1L;

    private IProductDao productDao;
    private ICategoryDao categoryDao;

    @Override
    public void init() throws ServletException {
          productDao =new ProductDao();
        categoryDao = new CategoryDao();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null){
            action ="";
        }
        switch (action){
            case "create":
                try {
                    insertProduct(request,response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "edit":
//                try {
//                    updateProduct(request,response);
//                } catch (SQLException throwables) {
//                    throwables.printStackTrace();
//                }
                break;
        }
        

    }

    private void insertProduct(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException,SQLException {
        String name = request.getParameter("name");
        Double price =Double.parseDouble(request.getParameter("price"));
        Integer quantity =Integer.parseInt(request.getParameter("quantity"));
        String color = request.getParameter("color");
        String description = request.getParameter("description");
        int category_id =Integer.parseInt(request.getParameter("category"));
        Product product = new Product(name,price,quantity,color,description,category_id);
        productDao.insertProduct(product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/create.jsp");
        dispatcher.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action ==  null){
            action="";
        }
        switch (action){
            case "create":
                try {
                    showNewForm(request,response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "edit":
//                try {
//                    showEditForm(request,response);
//                } catch (SQLException throwables) {
//                    throwables.printStackTrace();
//                }
                break;
            case"delete":
//                try {
//                    deleteProduct(request,response);
//                } catch (SQLException throwables) {
//                    throwables.printStackTrace();
//                }
                break;
            default:
                try {
                    listProduct(request,response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
        }
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException,SQLException,IOException {
        request.setAttribute("category",this.categoryDao.findByAll());
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/create.jsp");
        dispatcher.forward(request,response);
    }

    private void listProduct(HttpServletRequest request, HttpServletResponse response)throws ServletException, SQLException,IOException {
        List<Product> productsList = productDao.selectAllProduct();
        List<Category> categoryList = categoryDao.findByAll();
        request.setAttribute("productList",productsList);
        request.setAttribute("categoryList",categoryList);
        RequestDispatcher dispatcher =request.getRequestDispatcher("view/list.jsp");
        dispatcher.forward(request,response);
    }

}
