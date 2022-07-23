package Service.Iml;

import Model.HocVien;
import Model.NhanSu;
import Model.NhanVien;
import Service.INhanSu;
import Utili.PhongBan;
import Utili.ReadAndWrite;
import Utili.Regex;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static Controller.NhanSuController.getDateCorrect;
import static Controller.NhanSuController.getDateOut;

public class NhanSuService implements INhanSu {
    static Scanner scanner = new Scanner(System.in);
    public static final String PATH_FILE_NHANSU = "src\\Data\\data.csv";

    @Override
    public void add() {
        do {
            System.out.println("===== Thêm mới =====\n" +
                    "1. Thêm nhân viên mới\n" +
                    "2. Thêm học viên mới\n" +
                    "3. Quay lại menu");
            System.out.println("**** Nhập lựa chọn ****");
            String choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    themNhanVien();
                    break;
                case "2":
                    themHocVien();
                    break;
                case "3":
                    return;
                default:
                    System.out.printf("Chỉ chọn 1 - 3 \n");
            }
        } while (true);
    }

    private void themNhanVien() {

        System.out.println("Nhập mã định danh (NV-XXX): ");
        String maDD = Regex.inputNhanVien();
        System.out.println("Nhập họ và tên ");
        String hoTen = Regex.inputStr();
        System.out.println("Nhập ngày sinh ");
        String ngaySinh = scanner.nextLine();
        ngaySinh = getDateCorrect(ngaySinh);
        System.out.println("Nhập địa chỉ: ");
        String diaChi =  Regex.inputStr();
        System.out.println("Nhập số điện thoại: ");
        String soDienThoai = Regex.checkPhone();
        System.out.println("Nhập lương");
        String luong = Regex.inputNumber();
        System.out.println("Nhập phòng ban");
        String phongBan = PhongBan.area();
        System.out.println("Nhập vị trí");
        String viTri = scanner.nextLine();


        List<NhanSu> nhanSus = new ArrayList<>();
        nhanSus.add(new NhanVien(maDD,hoTen,ngaySinh,diaChi,soDienThoai,luong,phongBan,viTri));
        ReadAndWrite.writeList(nhanSus,PATH_FILE_NHANSU,true);
        System.out.println("Thêm mới thành công");


    }

    private void themHocVien() {

        System.out.println("Nhập mã định danh(HV-XXX): ");
        String maDD = Regex.inputHocVien();
        System.out.println("Nhập họ và tên ");
        String hoTen = Regex.inputStr();
        System.out.println("Nhập ngày sinh ");
        String ngaySinh = scanner.nextLine();
        ngaySinh = getDateCorrect(ngaySinh);
        System.out.println("Nhập địa chỉ: ");
        String diaChi =  Regex.inputStr();
        System.out.println("Nhập số điện thoại: ");
        String soDienThoai = Regex.checkPhone();

        System.out.println("Nhập điểm thi");
        String diem = Regex.inputNumberDouble();
        System.out.println("Nhập tên lớp");
        String tenLop = scanner.nextLine();
        System.out.println("Ngày nhập học");
        String ngayNhapHoc = scanner.nextLine();
        ngayNhapHoc = getDateOut(ngayNhapHoc,ngaySinh);

        List<NhanSu> nhanSus = new ArrayList<>();
        nhanSus.add(new HocVien(maDD,hoTen,ngaySinh,diaChi,soDienThoai,diem,tenLop,ngayNhapHoc));
        ReadAndWrite.writeList(nhanSus,PATH_FILE_NHANSU,true);
        System.out.println("Thêm mới thành công");
    }

    @Override
    public void delete() {
        boolean flag = false;
        List<NhanSu> nhanSus = ReadAndWrite.readFileBA(PATH_FILE_NHANSU);

            System.out.println("nhập mã định danh cần xóa");
            String id = scanner.nextLine();
            for (NhanSu e : nhanSus) {
                if (e.getMadd().equals(id)) {
                    System.out.println(e);
                    do {
                        System.out.println("Bạn muốn xóa hay không: \n" +
                                "1. Xóa\n" +
                                "2. không xóa");
                        int choose = Integer.parseInt(scanner.nextLine());
                        if (choose == 1) {
                            flag = true;
                            nhanSus.remove(e);
                            System.out.println("Đã xóa");
                            ReadAndWrite.writeList(nhanSus, PATH_FILE_NHANSU, false);
                            System.out.println("Cập nhập thành công");
                            display();
                            return;
                        } else if (choose == 2) {
                            System.out.println(" không xóa");
                            display();
                            return;
                        } else {
                            try {
                                throw new NumberFormatException("Không đúng định dạng");
                            } catch (NumberFormatException exception) {
                                System.out.println("Chỉ chọn 1 hoặc 2");
                            }
                        }
                    }while (true);
                }
            }
            if (flag==false){
                System.out.println("Mã định danh này không có trong danh sách \nVui lòng nhập lại.");
                delete();
            }
    }

    @Override
    public void display() {
        List<NhanSu> nhanSus = ReadAndWrite.readFileBA(PATH_FILE_NHANSU);
        if (nhanSus.isEmpty()){
            System.out.println("Chưa có nhân sự được thêm vào: ");
        }else
            for (NhanSu e : nhanSus) {
                System.out.println(e);
            }

    }
}
