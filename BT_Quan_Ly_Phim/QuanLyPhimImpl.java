package BT_Quan_Ly_Phim;

import java.io.*;
import java.util.*;

class QuanLyPhimImpl implements IQuanLyPhim {
    private List<Phim> ds = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    @Override
    public void them(Phim p) { ds.add(p); }

    @Override
    public boolean xoa(String ma) { return ds.removeIf(p -> p.getMaPhim().equalsIgnoreCase(ma)); }

    @Override
    public void capNhat(String ma) {
        for (Phim p : ds) {
            if (p.getMaPhim().equalsIgnoreCase(ma)) {
                System.out.print("Nhap ten moi: ");
                p.tenPhim = sc.nextLine();
                System.out.print("Nhap thoi luong moi: ");
                p.thoiLuong = Integer.parseInt(sc.nextLine());
                System.out.print("Nhap gia ve moi: ");
                p.giaVe = Double.parseDouble(sc.nextLine());
                System.out.print("Nhap dao dien moi: ");
                p.daoDien = sc.nextLine();
                System.out.print("Nhap nam san xuat moi: ");
                p.namSX = Integer.parseInt(sc.nextLine());
                System.out.print("Nhap ngon ngu: ");
                p.ngonNgu = sc.nextLine();
                System.out.print("Nhap danh gia: ");
                p.danhGia = Double.parseDouble(sc.nextLine());
                System.out.println("Cap nhat thanh cong!");
                return;
            }
        }
        System.out.println("Khong tim thay ma phim!");
    }

    @Override
    public List<Phim> timKiem(String key) {
        List<Phim> kq = new ArrayList<>();
        for (Phim p : ds) {
            if (p.tenPhim.toLowerCase().contains(key.toLowerCase()) ||
                p.maPhim.equalsIgnoreCase(key)) kq.add(p);
        }
        return kq;
    }

    @Override
    public List<Phim> locTheoTheLoai(String theLoai) {
        List<Phim> kq = new ArrayList<>();
        for (Phim p : ds)
            if (p.getTheLoai().equalsIgnoreCase(theLoai)) kq.add(p);
        return kq;
    }

    @Override
    public List<Phim> locTheoDaoDien(String daoDien) {
        List<Phim> kq = new ArrayList<>();
        for (Phim p : ds)
            if (p.getDaoDien().equalsIgnoreCase(daoDien)) kq.add(p);
        return kq;
    }

    @Override
    public List<Phim> sapXepTheoGiaVe(boolean tangDan) {
        List<Phim> kq = new ArrayList<>(ds);
        kq.sort((a,b) -> tangDan ? Double.compare(a.getGiaVe(), b.getGiaVe()) : Double.compare(b.getGiaVe(), a.getGiaVe()));
        return kq;
    }

    @Override
    public Phim timPhimCoDanhGiaCaoNhat() {
        return ds.stream().max(Comparator.comparingDouble(Phim::getDanhGia)).orElse(null);
    }

    @Override
    public void hienThi() { ds.forEach(Phim::hienThiThongTin); }

    @Override
    public void ghiFile(String tenFile) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(tenFile))) {
            for (Phim p : ds) pw.println(p.toData());
            System.out.println("Ghi file thanh cong!");
        } catch (Exception e) { System.out.println("Loi ghi file!"); }
    }

    @Override
    public void docFile(String tenFile) {
        ds.clear();
        try {
            File fullPath = new File("E:\\Quan-Ly-Phim\\phim.txt");

            if (!fullPath.exists()) {
                System.out.println("File khong ton tai: " + fullPath.getAbsolutePath());
                return;
            }

            try (BufferedReader br = new BufferedReader(new FileReader(fullPath))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] a = line.split(";");
                    String loai = a[0];
                    String ma = a[1];
                    String ten = a[2];
                    String tl = a[3];
                    int tg = Integer.parseInt(a[4]);
                    double g = Double.parseDouble(a[5]);
                    String daoDien = a[6];
                    int namSX = Integer.parseInt(a[7]);
                    String ngonNgu = a[8];
                    double danhGia = Double.parseDouble(a[9]);

                    if (loai.equals("HD"))
                        ds.add(new PhimHanhDong(ma, ten, tl, tg, g, daoDien, namSX, ngonNgu, danhGia,
                                Integer.parseInt(a[10]), Boolean.parseBoolean(a[11])));
                    else if (loai.equals("TC"))
                        ds.add(new PhimTinhCam(ma, ten, tl, tg, g, daoDien, namSX, ngonNgu, danhGia,
                                a[10], Integer.parseInt(a[11])));
                    else if (loai.equals("HH"))
                        ds.add(new PhimHoatHinh(ma, ten, tl, tg, g, daoDien, namSX, ngonNgu, danhGia,
                                Integer.parseInt(a[10]), Boolean.parseBoolean(a[11])));
                }
                System.out.println("Doc file thanh cong!");
            }
        } catch (Exception e) {
            System.out.println("Loi doc file!");
            e.printStackTrace();
        }
    }
}