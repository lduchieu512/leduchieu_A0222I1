package Service.Iml;

import Model.Nhapkhau;
import Model.SanPham;
import Model.XuatKhau;
import Service.ISanPham;
import Uliti.IncreaseID;
import Uliti.Area;
import Uliti.ReadAndWrite;
import Uliti.Regex;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SanPhamSevice implements ISanPham {
    static Scanner scanner = new Scanner(System.in);
    public static final String PATH_FILE_SP = "src\\Data\\sanpham.csv";
    @Override
    public void add() {
        do {
            System.out.println("=====Thêm mới=====\n" +
                    "1. Thêm sản phẩm nhập khẩu\n" +
                    "2. Thêm sản phảm xuất khẩu\n" +
                    "3. Quay lại menu");
            System.out.println("****Nhập lựa chọn****");
            String choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    nhapkhau();
                    break;
                case "2":
                    xuatKhau();
                    break;
                case "3":
                    return;
                default:
                    System.out.printf("Chỉ chọn 1 - 3 \n");
            }
        } while (true);


    }

    @Override
    public void delete() {
        display();
        Boolean flag = false;
        List<SanPham> sanPhams = ReadAndWrite.readFileList(PATH_FILE_SP);
        System.out.println("nhập id  cần xóa");
        String id = scanner.nextLine();
        for (SanPham e : sanPhams) {
            if (e.getId().equals(id)) {
                System.out.println(e);
                do {
                    System.out.println("Bạn muốn xóa hay không: \n" +
                            "1. Xóa\n" +
                            "2. không xóa");
                    int choose = Integer.parseInt(scanner.nextLine());
                    if (choose==1) {
                      flag = true;
                      sanPhams.remove(e);
                      System.out.println("Đã xóa");
                      ReadAndWrite.writeList(sanPhams, PATH_FILE_SP, false);
                      System.out.println("Cập nhập thành công");
                      display();
                      return;
                    }else if (choose==2) {
                      System.out.println(" không xóa");
                      display();
                      return;
                    }else {
                            System.out.println("Chỉ chọn 1 hoạc 2");
                    }
                }while (true);
            }
        }
        if (flag==false){
            System.out.println("Sản phẩm này không có trong danh sách \nVui lòng nhập lại.");
            delete();
        }
    }
    @Override
    public void display() {
        List<SanPham> sanPhams = ReadAndWrite.readFileList(PATH_FILE_SP);
        if (sanPhams.isEmpty()){
            System.out.println("Chưa có đt được thêm vào: ");
        }else
            for (SanPham e : sanPhams) {
                System.out.println(e);
            }
    }


    @Override
    public void find() {
        List<SanPham> sanPhams = ReadAndWrite.readFileList(PATH_FILE_SP);
        do {
            System.out.println("Chức năng của hệ thống " +
                    "\n 1.Tìm theo id" +
                    "\n 2.Tìm theo tên sản phẩm" +
                    "\n 3.Exit");
            Scanner scanner = new Scanner(System.in);
            int index =-1;
            System.out.println("Chọn chức năng");
            String choose =scanner.nextLine();
            switch (choose) {
                case "1":
                    System.out.println("Nhập id cần tìm");
                    String findID = scanner.nextLine();
                    for (int i = 0; i< sanPhams.size(); i++){
                        if (findID.equals(sanPhams.get(i).getId())){
                            index = 1;
                            System.out.println(sanPhams.get(i));
                        }
                    }if (index == -1){
                    System.out.println("Không tìm thấy");
                }
                    break;
                case "2":
                    System.out.println("Tên sản phảm cần tìm");
                    String findName = scanner.nextLine();
                    for (int i = 0; i< sanPhams.size(); i++){
                        if ((sanPhams.get(i).getTenSP()).contains(findName)){
                            System.out.println(sanPhams.get(i));
                            index=1;
                        }
                    }if (index == -1){
                    System.out.println("Không tìm thấy");
                }
                    break;
                case "3":
                    return;
                default:
                    System.out.println("Chọn 1 - 3");
            }
        } while (true);

    }
    private void nhapkhau(){

        String id;
        id= IncreaseID.increaseID()+"";
        System.out.println("Nhập mã sản phẩm nhập khẩu: ");
        String maSP = Regex.inputNhapKhau();
        System.out.println("Nhập tên sản phẩm nhập khẩu: ");
        String tenSP = scanner.nextLine();
        System.out.println("Nhập giá sản phẩm nhập khẩu: ");
        String giaSP = Regex.inputNumber();
        System.out.println("Nhập số lượng sản phẩm nhập khẩu: ");
        String soLuongSP = Regex.inputNumber();
        System.out.println("Nhập nhà sản xuất: ");
        String nhaSanXuat = Regex.checkStr();


        System.out.println("Giá nhập khẩu ");
        String giaNK = Regex.inputNumber();
        System.out.println("Tỉnh thành nhập");
        String tinhNK = Area.tinhThanh();
        System.out.println("Thuế nhập khẩu ");
        String thueNK = Regex.inputNumber();
        List<SanPham> sanPhams = new ArrayList<>();
        sanPhams.add(new Nhapkhau(id,maSP,tenSP,giaSP,soLuongSP,nhaSanXuat,giaNK,tinhNK,thueNK));
        ReadAndWrite.writeList(sanPhams, PATH_FILE_SP, true);
        System.out.println("Thêm mới nhập khẩu thành công");
    }
    private void xuatKhau(){
        String id;
        id= IncreaseID.increaseID()+"";
        System.out.println("Nhập mã sản phẩm nhập khẩu: ");
        String maSP = Regex.inputXuatKhau();
        System.out.println("Nhập tên sản phẩm nhập khẩu: ");
        String tenSP = scanner.nextLine();
        System.out.println("Nhập giá sản phẩm nhập khẩu: ");
        String giaSP = Regex.inputNumber();
        System.out.println("Nhập số lượng sản phẩm nhập khẩu: ");
        String soLuongSP = Regex.inputNumber();
        System.out.println("Nhập nhà sản xuất: ");
        String nhaSanXuat = Regex.checkStr();

        System.out.println("Giá xuất khẩu");
        String giaXK =Regex.inputNumber();
        System.out.println("Quốc gia nhập sản phẩm");
        String guocGiaNSP = Area.quocGia();
        List<SanPham> sanPhams = new ArrayList<>();
        sanPhams.add(new XuatKhau(id,maSP,tenSP,giaSP,soLuongSP,nhaSanXuat,giaXK,guocGiaNSP));
        ReadAndWrite.writeList(sanPhams, PATH_FILE_SP, true);
        System.out.println("Thêm mới thành công");
    }
}
