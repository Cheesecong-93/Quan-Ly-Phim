package BT_Quan_Ly_Phim;

public class PhimTinhCam extends Phim {
    private String quocGia;
    private int tuoiKhamPha;

    public PhimTinhCam(String maPhim, String tenPhim, String theLoai, int thoiLuong, double giaVe,
                       String daoDien, int namSX, String ngonNgu, double danhGia,
                       String quocGia, int tuoiKhamPha) {
        super(maPhim, tenPhim, theLoai, thoiLuong, giaVe, daoDien, namSX, ngonNgu, danhGia);
        this.quocGia = quocGia;
        this.tuoiKhamPha = tuoiKhamPha;
    }

    @Override
    public void hienThiThongTin() {
        System.out.println("[Tinh cam] " + maPhim + " - " + tenPhim + " - " + theLoai +
                " - " + thoiLuong + "p - " + giaVe + " VND - QG: " + quocGia +
                " - Tuoi kham pha: " + tuoiKhamPha +
                " - Dao dien: " + daoDien + " - NSX: " + namSX +
                " - Ngon ngu: " + ngonNgu +
                " - DG: " + danhGia);
    }

    @Override
    public String toData() {
        return "TC;" + super.toData() + ";" + quocGia + ";" + tuoiKhamPha;
    }
}