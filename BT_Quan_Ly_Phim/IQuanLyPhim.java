package BT_Quan_Ly_Phim;

import java.util.*;

public interface IQuanLyPhim {
    void them(Phim p);
    boolean xoa(String ma);
    void capNhat(String ma);
    List<Phim> timKiem(String key);
    List<Phim> locTheoTheLoai(String theLoai);
    List<Phim> locTheoDaoDien(String daoDien);
    List<Phim> sapXepTheoGiaVe(boolean tangDan);
    Phim timPhimCoDanhGiaCaoNhat();
    void hienThi();
    void ghiFile(String tenFile);
    void docFile(String tenFile);
}
