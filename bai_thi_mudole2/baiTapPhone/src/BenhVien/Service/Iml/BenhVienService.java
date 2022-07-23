package BenhVien.Service.Iml;

import BenhVien.Model.BenhAn;
import BenhVien.Model.BenhAnThuong;
import BenhVien.Model.BenhAnVip;
import BenhVien.Service.IBenhAn;


import BenhVien.Uliti.ChonVip;
import BenhVien.Uliti.ReadAndWrite;
import BenhVien.Uliti.Regex;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static BenhVien.Controller.BenhVienControl.getDateCorrect;
import static BenhVien.Controller.BenhVienControl.getDateOut;

public class BenhVienService implements IBenhAn {
    static Scanner scanner = new Scanner(System.in);
    public static final String PATH_FILE_BENHVIEN = "src\\BenhVien\\Data\\benhvien.csv";

    @Override
    public void add() {
        do {
            System.out.println("=====Thêm mới=====\n" +
                    "1. Thêm bệnh án thường\n" +
                    "2. Thêm bệnh án VIP\n" +
                    "3. Quay lại menu");
            System.out.println("****Nhập lựa chọn****");
            String choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    themBenhAnThuong();
                    break;
                case "2":
                    themBenhAnVIP();
                    break;
                case "3":
                    return;
                default:
                    System.out.printf("Chỉ chọn 1 - 3 \n");
            }
        } while (true);

    }

    private void themBenhAnVIP() {
        //String stt,
        // String maBA,
        // String tenBA,
        // String ngayNhapVien,
        // String ngayRaVien,
        // String lyDo,
        //goiVIP;
        // thoiHanVIP;
        String stt;
        stt= BenhVien.Uliti.IncreaseID.increaseID() +"";
        System.out.println("Nhập mã bệnh án BN-XXX!: ");
        String maBA = scanner.nextLine();
        System.out.println("Nhập tên bệnh án: ");
        String tenBA = Regex.inputStr();
        System.out.println("Nhập ngày nhập viện: ");
        String ngayNhapVien = scanner.nextLine();
        System.out.println("Nhập ngày ra viện: ");
        String ngayRaVien = scanner.nextLine();
        System.out.println("Nhập lý do: ");
        String lyDo =  Regex.inputStr();
        System.out.println("Nhập gói VIP: ");
        String goiVIP = ChonVip.area();
        System.out.println("Nhập thời hạn VIP: ");
        String thoiHanVIP = Regex.inputNumber();
        List<BenhAn> benhAns = new ArrayList<>();
        benhAns.add(new BenhAnVip(stt,maBA,tenBA,ngayNhapVien,ngayRaVien,lyDo,goiVIP,thoiHanVIP));
        ReadAndWrite.writeList(benhAns,PATH_FILE_BENHVIEN,true);
        System.out.println("Thêm mới thành công");


    }

    private void themBenhAnThuong() {
            //String stt,
        // String maBA,
        // String tenBA,
        // String ngayNhapVien,
        // String ngayRaVien,
        // String lyDo,
        // String vienPhi

        String stt;
        stt= BenhVien.Uliti.IncreaseID.increaseID() +"";
        System.out.println("Nhập mã bệnh án BN-XXX!: ");
        String maBA = Regex.inputBenhAn();
        System.out.println("Nhập tên bệnh án : ");
        String tenBA = Regex.inputStr();
        System.out.println("Nhập ngày nhập viện: ");
        String ngayNhapVien = scanner.nextLine();
        ngayNhapVien =getDateCorrect(ngayNhapVien);
        System.out.println("Nhập ngày ra viện: ");
        String ngayRaVien = scanner.nextLine();
        ngayRaVien = getDateOut(ngayRaVien,ngayNhapVien);
        System.out.println("Nhập lý do: ");
        String lyDo = Regex.inputStr();
        System.out.println("Nhập viện phí: ");
        String vienPhi = Regex.inputNumber();
        List<BenhAn> benhAns = new ArrayList<>();
        benhAns.add(new BenhAnThuong(stt,maBA,tenBA,ngayNhapVien,ngayRaVien,lyDo,vienPhi));
        ReadAndWrite.writeList(benhAns,PATH_FILE_BENHVIEN,true);
        System.out.println("Thêm mới thành công");
    }

    @Override
    public void delete() {
        boolean flag = false;
        List<BenhAn> benhAns = BenhVien.Uliti.ReadAndWrite.readFileBA(PATH_FILE_BENHVIEN);

            System.out.println("nhập stt bệnh án cần xóa");
            String stt = scanner.nextLine();
            for (BenhAn e : benhAns) {
                if (e.getStt().equals(stt)) {
                    System.out.println(e);
                    do {
                        System.out.println("Bạn muốn xóa hay không: \n" +
                                "1. Xóa\n" +
                                "2. không xóa");
                        int choose = Integer.parseInt(scanner.nextLine());
                        if (choose == 1) {
                            flag = true;
                            benhAns.remove(e);
                            System.out.println("Đã xóa");
                            BenhVien.Uliti.ReadAndWrite.writeList(benhAns, PATH_FILE_BENHVIEN, false);
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
                System.out.println("Bệnh án này không có trong danh sách \nVui lòng nhập lại.");
                delete();
            }
    }

    @Override
    public void display() {
        List<BenhAn> benhAns = BenhVien.Uliti.ReadAndWrite.readFileBA(PATH_FILE_BENHVIEN);
        if (benhAns.isEmpty()){
            System.out.println("Chưa có bệnh án được thêm vào: ");
        }else
            for (BenhAn e : benhAns) {
                System.out.println(e);
            }

    }
}
