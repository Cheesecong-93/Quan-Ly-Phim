package BT_Quan_Ly_Phim;

import java.io.Serializable;

public abstract class Phim implements Serializable {
    protected String maPhim;
    protected String tenPhim;
    protected String theLoai;
    protected int thoiLuong;
    protected double giaVe;
    protected String daoDien;
    protected int namSX;
    protected String ngonNgu;
    protected double danhGia;

    public Phim(String maPhim, String tenPhim, String theLoai, int thoiLuong, double giaVe,
                String daoDien, int namSX, String ngonNgu, double danhGia) {
        this.maPhim = maPhim;
        this.tenPhim = tenPhim;
        this.theLoai = theLoai;
        this.thoiLuong = thoiLuong;
        this.giaVe = giaVe;
        this.daoDien = daoDien;
        this.namSX = namSX;
        this.ngonNgu = ngonNgu;
        this.danhGia = danhGia;
    }

    public String getMaPhim() { return maPhim; }
    public String getTheLoai() { return theLoai; }
    public String getDaoDien() { return daoDien; }
    public double getGiaVe() { return giaVe; }
    public double getDanhGia() { return danhGia; }

    public abstract void hienThiThongTin();

    public String toData() {
        return maPhim + ";" + tenPhim + ";" + theLoai + ";" + thoiLuong + ";" + giaVe + ";" +
               daoDien + ";" + namSX + ";" + ngonNgu + ";" + danhGia;
    }
}
