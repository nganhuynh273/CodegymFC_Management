package hpn.model;

import java.time.Instant;
import java.util.Comparator;
import java.util.Date;

public class Footballer extends Staff implements Comparator<Footballer> {
    //private long staffID;
    private String viTriThiDau;
    private int soLuotTranThamGia;
    private int banThang;
    private double luongThoaThuan;

    public Footballer(long staffID, String maNhanvien, String ten, String quocTich, String gioiTinh, Date ngaySinh, Date ngayVaoLam, String viTriThiDau, int soLuotTranThamGia, int banThang, double luongThoaThuan) {
        super(staffID, maNhanvien, ten, quocTich, gioiTinh, ngaySinh, ngayVaoLam);
        this.staffID = staffID;
        this.viTriThiDau = viTriThiDau;
        this.soLuotTranThamGia = soLuotTranThamGia;
        this.banThang = banThang;
        this.luongThoaThuan = luongThoaThuan;
    }

    public Footballer() {
    }



    public Footballer(String record) {
        try{
            String[] fields = record.split(",");
            staffID = Long.parseLong(fields[0]);
            viTriThiDau = fields[1];
            soLuotTranThamGia = Integer.parseInt(fields[2]);
            banThang = Integer.parseInt(fields[3]);
            luongThoaThuan = Double.parseDouble(fields[4]);
            //tinhLuong() = Double.parseDouble(fields[5]);
        }catch (Exception e){
            System.out.println("Footballer contructor.............");
            e.printStackTrace();
        }


    }



    public String getViTriThiDau() {

        return viTriThiDau;
    }

    public void setViTriThiDau(String viTriThiDau) {

        this.viTriThiDau = viTriThiDau;
    }

    public int getSoLuotTranThamGia() {

        return soLuotTranThamGia;
    }

    public void setSoLuotTranThamGia(int soLuotTranThamGia) {

        this.soLuotTranThamGia = soLuotTranThamGia;
    }

    public int getBanThang() {

        return banThang;
    }

    public void setBanThang(int banThang) {

        this.banThang = banThang;
    }

    public double getLuongThoaThuan() {

        return luongThoaThuan;
    }

    public void setLuongThoaThuan(double luongThoaThuan) {
        this.luongThoaThuan = luongThoaThuan;
    }

    public double tinhLuong() {
        return this.luongThoaThuan + super.tinhPhuCapThamNien();
    }

    @Override
    public String toString() {
        return staffID + "," + viTriThiDau + "," +
                soLuotTranThamGia +
                "," + banThang +
                "," + luongThoaThuan +
                "," + tinhLuong();
    }

    @Override
    public int compare(Footballer o1, Footballer o2) {
        return (int) (o1.getStaffID()
                - o2.getStaffID());
    }

    public void setStaffInfo(Staff staff) {
        this.setMaNhanvien(staff.getMaNhanvien());
        this.setTen(staff.getTen());
        this.setQuocTich(staff.getQuocTich());
        this.setGioiTinh(staff.getGioiTinh());
        this.setNgaySinh(staff.getNgaySinh());
        this.setNgayVaoLam(staff.getNgayVaoLam());
    }
}
