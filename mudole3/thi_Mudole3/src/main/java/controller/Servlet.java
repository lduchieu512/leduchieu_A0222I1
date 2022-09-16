package controller;

import model.Quan_ly;
import model.Trang_thai;
import model.Van_phong;
import repository.IQuan_ly;
import repository.ITrang_thai;
import repository.IVan_phong;
import repository.Impl.Quan_ly_Dao;
import repository.Impl.Trang_thai_Dao;
import repository.Impl.Van_phong_Dao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "Servlet",urlPatterns = "/quanlys")
public class Servlet extends HttpServlet {
    private  static final long serialVersionUID =1L;
    private IQuan_ly quan_lyDao;
    private ITrang_thai trang_thaiDao;
    private IVan_phong van_phongDao;

    @Override
    public void init() throws ServletException {
        quan_lyDao =new Quan_ly_Dao();
        trang_thaiDao = new Trang_thai_Dao();
        van_phongDao = new Van_phong_Dao();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action ="";
        }
        switch (action){
            case "create":
                try {
                    insertQuanLy(request,response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "edit":
                try {
                    updateProduct(request,response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
        }
    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException,ServletException ,IOException{
        int id = Integer.parseInt(request.getParameter("id"));
        String ma_mat_bang = request.getParameter("maMB");
        Double dien_tich =Double.parseDouble(request.getParameter("dienTich"));
        Integer tang =Integer.parseInt(request.getParameter("tang"));
        String mo_ta = request.getParameter("moTa");
        Integer gia_cho_thue =Integer.parseInt(request.getParameter("giaChoThue"));
        String ngay_bat_dau =request.getParameter("ngayBatDau");
        String ngay_ket_thuc =request.getParameter("ngayKetThuc");
        Integer trang_thai_id =Integer.parseInt(request.getParameter("trangThai"));
        Integer van_phong_id =Integer.parseInt(request.getParameter("vanPhong"));
        Quan_ly quan_lys = new Quan_ly(id,ma_mat_bang,dien_tich,trang_thai_id,tang,van_phong_id,mo_ta,gia_cho_thue,ngay_bat_dau,ngay_ket_thuc);
        quan_lyDao.updateQuanly(quan_lys);
        request.setAttribute("trangThai",trang_thaiDao.findByAll());
        request.setAttribute("vanPhong",van_phongDao.findByAll());
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/edit.jsp");
        dispatcher.forward(request,response);
    }

    private void insertQuanLy(HttpServletRequest request, HttpServletResponse response) throws ServletException,SQLException,IOException {
        String ma_mat_bang = request.getParameter("maMB");
        Double dien_tich =Double.parseDouble(request.getParameter("dienTich"));
        Integer tang =Integer.parseInt(request.getParameter("tang"));
        String mo_ta = request.getParameter("moTa");
        Integer gia_cho_thue =Integer.parseInt(request.getParameter("giaChoThue"));
        String ngay_bat_dau =request.getParameter("ngayBatDau");
        String ngay_ket_thuc =request.getParameter("ngayKetThuc");
        Integer trang_thai_id =Integer.parseInt(request.getParameter("trangThai"));
        Integer van_phong_id =Integer.parseInt(request.getParameter("vanPhong"));

        Quan_ly quan_ly = new Quan_ly(ma_mat_bang,dien_tich,trang_thai_id,tang,van_phong_id,mo_ta,gia_cho_thue,ngay_bat_dau,ngay_ket_thuc);
        quan_lyDao.insertQuanly(quan_ly);
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
                try {
                    showEditForm(request,response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case"delete":
                try {
                    deleteProduct(request,response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case"search":
                try {
                    searchMatBang(request,response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            default:
                try {
                    listQuanLy(request,response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
        }
    }

    private void searchMatBang(HttpServletRequest request, HttpServletResponse response) throws SQLException,IOException,ServletException{
        String maMB = request.getParameter("search");
        List<Quan_ly> quanLy = quan_lyDao.searchName(maMB);
        RequestDispatcher requestDispatcher;
        if (quanLy==null){
            requestDispatcher = request.getRequestDispatcher("view/error.jsp");
        } else {
            requestDispatcher = request.getRequestDispatcher("view/list.jsp");
            request.setAttribute("quan_lyList",quanLy);
            request.setAttribute("trangThai",trang_thaiDao.findByAll());
            request.setAttribute("vanPhong",van_phongDao.findByAll());
        }
        requestDispatcher.forward(request,response);



    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException,IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        quan_lyDao.delete(id);
        response.sendRedirect("/quanlys");
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)throws ServletException, SQLException,IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Quan_ly quan_lys = quan_lyDao.selectQuanly(id);
        request.setAttribute("quanlys",quan_lys);
        request.setAttribute("trangThai",trang_thaiDao.findByAll());
        request.setAttribute("vanPhong",van_phongDao.findByAll());
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/edit.jsp");
        dispatcher.forward(request,response);

    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)throws ServletException, SQLException,IOException {
        request.setAttribute("trang_thaiList",this.trang_thaiDao.findByAll());
        request.setAttribute("van_phongList",this.van_phongDao.findByAll());
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/create.jsp");
        dispatcher.forward(request,response);
    }

    private void listQuanLy(HttpServletRequest request, HttpServletResponse response)throws ServletException, SQLException,IOException  {
        List<Quan_ly> quan_lyList = quan_lyDao.selectAllQuanly();
        List<Trang_thai> trang_thaiList = trang_thaiDao.findByAll();
        List<Van_phong> van_phongList = van_phongDao.findByAll();
        request.setAttribute("quan_lyList",quan_lyList);
        request.setAttribute("trang_thaiList",trang_thaiList);
        request.setAttribute("van_phongList",van_phongList);
        RequestDispatcher dispatcher =request.getRequestDispatcher("view/list.jsp");
        dispatcher.forward(request,response);
    }
}
