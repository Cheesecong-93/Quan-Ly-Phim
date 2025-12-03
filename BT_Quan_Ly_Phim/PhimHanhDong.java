package BT_Quan_Ly_Phim;

public class PhimHanhDong extends Phim {
    private int gioiHanTuoi;
    private boolean coCanhBaoBaoLuc;

    public PhimHanhDong(String maPhim, String tenPhim, String theLoai, int thoiLuong, double giaVe,
                        String daoDien, int namSX, String ngonNgu, double danhGia,
                        int gioiHanTuoi, boolean coCanhBaoBaoLuc) {
        super(maPhim, tenPhim, theLoai, thoiLuong, giaVe, daoDien, namSX, ngonNgu, danhGia);
        this.gioiHanTuoi = gioiHanTuoi;
        this.coCanhBaoBaoLuc = coCanhBaoBaoLuc;
    }

    @Override
    public void hienThiThongTin() {
        System.out.println("[Hanh dong] " + maPhim + " - " + tenPhim + " - " + theLoai +
                " - " + thoiLuong + "p - " + giaVe + " VND - GH tuoi: " + gioiHanTuoi +
                " - Bao luc: " + (coCanhBaoBaoLuc ? "Co" : "Khong") +
                " - Dao dien: " + daoDien + " - NSX: " + namSX +
                " - Ngon ngu: " + ngonNgu +
                " - DG: " + danhGia);
    }

    @Override
    public String toData() {
        return "HD;" + super.toData() + ";" + gioiHanTuoi + ";" + coCanhBaoBaoLuc;
    }
}