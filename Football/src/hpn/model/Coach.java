package hpn.model;

import hpn.utils.DateUtils;

import java.util.Comparator;
import java.util.Date;

public class Coach extends Staff implements Comparator<Coach> {
//    private long staffID;
    private int soNamKinhNghiem;
    private double heSoLuong;
    private double phuCap;

    public Coach(long staffID, String maNhanVien, String ten, String quocTich, String gioiTinh, Date ngaySinh, Date ngayVaoLam,
                 int soNamKinhNghiem, double heSoLuong, double phuCap) {
        super(staffID, maNhanVien, ten, quocTich, gioiTinh, ngaySinh, ngayVaoLam);
        this.staffID = staffID;
        this.soNamKinhNghiem = soNamKinhNghiem;
        this.heSoLuong = heSoLuong;
        this.phuCap = phuCap;
    }
    public Coach(){
    }

    public Coach(String record) {
        try {
            String[] fields = record.split(",");
            staffID = Long.parseLong(fields[0]);
            soNamKinhNghiem = Integer.parseInt(fields[1]);
            heSoLuong = Double.parseDouble((fields[2]));
            phuCap = Double.parseDouble(fields[3]);
        } catch (Exception e) {
            System.out.println("Footballer contructor.............");
            e.printStackTrace();
        }
    }

//    @Override
//    public long getStaffID() {
//        return staffID;
//    }
//
//    @Override
//    public void setStaffID(long staffID) {
//        this.staffID = staffID;
//    }

    public int getSoNamKinhNghiem() {

        return soNamKinhNghiem;
    }

    public void setSoNamKinhNghiem(int soNamKinhNghiem) {

        this.soNamKinhNghiem = soNamKinhNghiem;
    }

    public double getHeSoLuong() {

        return heSoLuong;
    }

    public void setHeSoLuong(double heSoLuong) {

        this.heSoLuong = heSoLuong;
    }

    public double getPhuCap() {
        return phuCap;
    }

    public void setPhuCap(double phuCap) {

        this.phuCap = phuCap;
    }

    public double tinhLuong(){
        return (this.heSoLuong * 1050000) + this.phuCap + super.tinhPhuCapThamNien();
    }

    @Override
    public String toString() {
        return staffID + "," +soNamKinhNghiem +
                "," + heSoLuong +
                "," + phuCap +
                "," + tinhLuong();
    }

    @Override
    public int compare(Coach o1, Coach o2) {
        return (int) (o1.getStaffID()
                - o2.getStaffID());
    }
    public void setStaffInfo(Staff staff) {
        //4964,CT23,Quang Đặng,Viet Nam,Nam,Sat Sep 12 00:00:00 ICT 1992,Mon Mar 22 00:00:00 ICT 2021
        this.setMaNhanvien(staff.getMaNhanvien());
        this.setTen(staff.getTen());
        this.setQuocTich(staff.getQuocTich());
        this.setGioiTinh(staff.getGioiTinh());
        this.setNgaySinh(staff.getNgaySinh());
        this.setNgayVaoLam(staff.getNgayVaoLam());
    }
}
