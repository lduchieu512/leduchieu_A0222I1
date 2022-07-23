package BenhVien.Uliti;



import BenhVien.Model.BenhAn;

import java.util.List;

public class IncreaseID {
    private static final String CSV_PATH_FILE_BENHVIEN = "src\\BenhVien\\Data\\benhvien.csv";
    public static int increaseID() {
        List<BenhAn> list = ReadAndWrite.readFileBA(CSV_PATH_FILE_BENHVIEN);
        int stt;
        if (list.isEmpty()) stt = 1;
        else {
            boolean flag;
            do {
                flag = false;
                stt = Integer.parseInt(list.get(list.size() - 1).getStt()) + 1;
                for (BenhAn c : list) {
                    if (Integer.parseInt(c.getStt()) == stt) {
                        stt++;
                        flag = true;
                    }
                }
            } while (flag);
        }
        return stt;
    }
}
