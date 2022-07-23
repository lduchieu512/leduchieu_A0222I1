package Uliti;


import Model.SanPham;

import java.util.List;

public class IncreaseID {
    private static final String CSV_PATH_FILE_SP = "src\\Data\\sanpham.csv";
    public static int increaseID() {
        List<SanPham> list = ReadAndWrite.readFileList(CSV_PATH_FILE_SP);
        int id;
        if (list.isEmpty()) id = 1;
        else {
            boolean flag;
            do {
                flag = false;
                id = Integer.parseInt(list.get(list.size() - 1).getId()) + 1;
                for (SanPham c : list) {
                    if (Integer.parseInt(c.getId()) == id) {
                        id++;
                        flag = true;
                    }
                }
            } while (flag);
        }
        return id;
    }
}
