package BT_Quan_Ly_Phim;

public class PhimHoatHinh extends Phim {
    private int doTuoiXem;
    private boolean coPhimNgheThuat;

    public PhimHoatHinh(String maPhim, String tenPhim, String theLoai, int thoiLuong, double giaVe,
                        String daoDien, int namSX, String ngonNgu, double danhGia,
                        int doTuoiXem, boolean coPhimNgheThuat) {
        super(maPhim, tenPhim, theLoai, thoiLuong, giaVe, daoDien, namSX, ngonNgu, danhGia);
        this.doTuoiXem = doTuoiXem;
        this.coPhimNgheThuat = coPhimNgheThuat;
    }

    @Override
    public void hienThiThongTin() {
        System.out.println("[Hoat hinh] " + maPhim + " - " + tenPhim + " - " + theLoai +
                " - " + thoiLuong + "p - " + giaVe + " VND - Do tuoi xem: " + doTuoiXem +
                " - Phim nghe thuat: " + (coPhimNgheThuat ? "Co" : "Khong") +
                " - Dao dien: " + daoDien + " - NSX: " + namSX +
                " - Ngon ngu: " + ngonNgu +
                " - DG: " + danhGia);
    }

    @Override
    public String toData() {
        return "HH;" + super.toData() + ";" + doTuoiXem + ";" + coPhimNgheThuat;
    }
}