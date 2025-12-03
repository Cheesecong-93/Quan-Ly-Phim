package BT_Quan_Ly_Phim;

import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        QuanLyPhimImpl ql = new QuanLyPhimImpl();
        int chon;

        while (true) {
            System.out.println("\n===== MENU QUAN LY PHIM =====");
            System.out.println("1. Them phim");
            System.out.println("2. Xoa phim");
            System.out.println("3. Cap nhat phim");
            System.out.println("4. Tim kiem phim");
            System.out.println("5. Hien thi danh sach phim");
            System.out.println("6. Ghi file");
            System.out.println("7. Doc file");
            System.out.println("8. Loc phim theo the loai");
            System.out.println("9. Loc phim theo dao dien");
            System.out.println("10. Sap xep phim theo gia ve");
            System.out.println("11. Tim phim co danh gia cao nhat");
            System.out.println("0. Thoat");
            System.out.print("Chon: ");
            chon = Integer.parseInt(sc.nextLine());

            switch (chon) {
                case 1 -> themPhim(ql);
                case 2 -> {
                    System.out.print("Nhap ma phim can xoa: ");
                    String ma = sc.nextLine();
                    System.out.println(ql.xoa(ma) ? "Xoa thanh cong!" : "Khong tim thay!");
                }
                case 3 -> {
                    System.out.print("Nhap ma phim can cap nhat: ");
                    String ma = sc.nextLine();
                    ql.capNhat(ma);
                }
                case 4 -> {
                    System.out.print("Nhap tu khoa: ");
                    String key = sc.nextLine();
                    ql.timKiem(key).forEach(Phim::hienThiThongTin);
                }
                case 5 -> ql.hienThi();
                case 6 -> ql.ghiFile("output.txt");
                case 7 -> ql.docFile("\"E:\\java\\phim.txt\""); // Windows

                case 8 -> {
                    System.out.print("Nhap the loai: ");
                    String tl = sc.nextLine();
                    ql.locTheoTheLoai(tl).forEach(Phim::hienThiThongTin);
                }
                case 9 -> {
                    System.out.print("Nhap dao dien: ");
                    String dd = sc.nextLine();
                    ql.locTheoDaoDien(dd).forEach(Phim::hienThiThongTin);
                }
                case 10 -> {
                    System.out.print("Sap xep tang dan? (true/false): ");
                    boolean tang = Boolean.parseBoolean(sc.nextLine());
                    ql.sapXepTheoGiaVe(tang).forEach(Phim::hienThiThongTin);
                }
                case 11 -> {
                    Phim p = ql.timPhimCoDanhGiaCaoNhat();
                    if (p != null) p.hienThiThongTin();
                    else System.out.println("Danh sach phim rong!");
                }
                case 0 -> { return; }
                default -> System.out.println("Lua chon sai!");
            }
        }
    }

    public static void themPhim(QuanLyPhimImpl ql) {
        System.out.print("Ma phim: ");
        String ma = sc.nextLine();
        System.out.print("Ten phim: ");
        String ten = sc.nextLine();
        System.out.print("The loai: ");
        String tl = sc.nextLine();
        System.out.print("Thoi luong: ");
        int tg = Integer.parseInt(sc.nextLine());
        System.out.print("Gia ve: ");
        double gia = Double.parseDouble(sc.nextLine());
        System.out.print("Dao dien: ");
        String dd = sc.nextLine();
        System.out.print("Nam san xuat: ");
        int nsx = Integer.parseInt(sc.nextLine());
        System.out.print("Ngon ngu: ");
        String nn = sc.nextLine();
        System.out.print("Danh gia: ");
        double dg = Double.parseDouble(sc.nextLine());

        System.out.println("Chon loai phim:");
        System.out.println("1. Hanh dong");
        System.out.println("2. Tinh cam");
        System.out.println("3. Hoat hinh");
        int loai = Integer.parseInt(sc.nextLine());

        switch (loai) {
            case 1 -> {
                System.out.print("Gioi han tuoi: ");
                int tuoi = Integer.parseInt(sc.nextLine());
                System.out.print("Co canh bao bao luc (true/false): ");
                boolean baoLuc = Boolean.parseBoolean(sc.nextLine());
                ql.them(new PhimHanhDong(ma, ten, tl, tg, gia, dd, nsx, nn, dg, tuoi, baoLuc));
            }
            case 2 -> {
                System.out.print("Quoc gia: ");
                String qg = sc.nextLine();
                System.out.print("Tuoi kham pha: ");
                int tuoi = Integer.parseInt(sc.nextLine());
                ql.them(new PhimTinhCam(ma, ten, tl, tg, gia, dd, nsx, nn, dg, qg, tuoi));
            }
            case 3 -> {
                System.out.print("Do tuoi xem: ");
                int tuoi = Integer.parseInt(sc.nextLine());
                System.out.print("Co phim nghe thuat (true/false): ");
                boolean ngheThuat = Boolean.parseBoolean(sc.nextLine());
                ql.them(new PhimHoatHinh(ma, ten, tl, tg, gia, dd, nsx, nn, dg, tuoi, ngheThuat));
            }
            default -> System.out.println("Loai khong hop le!");
        }
    }
}
