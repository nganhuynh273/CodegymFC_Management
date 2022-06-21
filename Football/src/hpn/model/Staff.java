package hpn.model;

import hpn.utils.DateUtils;

import java.time.Instant;
import java.util.Calendar;
import java.util.Date;

public  class Staff {
    protected long staffID;
    private String maNhanvien;
    private String ten;
    private String quocTich;
    private String gioiTinh;
    private Date ngaySinh;
    private Date ngayVaoLam;

    public Staff(){
    }

    public Staff(String record) {
        String[] fields = record.split(",");
        staffID = Long.parseLong(fields[0]);
        maNhanvien = fields[1];
        ten = fields[2];
        quocTich = fields[3];
        gioiTinh = fields[4];
        ngaySinh = DateUtils.stringToDate(fields[5], DateUtils.DATE_PATTERN);
        ngayVaoLam = DateUtils.stringToDate(fields[6], DateUtils.DATE_PATTERN);

    }

    public Staff(long staffID, String maNhanvien, String ten, String quocTich, String gioiTinh, Date ngaySinh, Date ngayVaoLam) {
        this.staffID = staffID;
        this.maNhanvien = maNhanvien;
        this.ten = ten;
        this.quocTich = quocTich;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.ngayVaoLam = ngayVaoLam;
    }

    public long getStaffID() {
        return staffID;
    }

    public void setStaffID(long staffID) {
        this.staffID = staffID;
    }

    public String getMaNhanvien() {
        return maNhanvien;
    }

    public void setMaNhanvien(String maNhanvien) {
        this.maNhanvien = maNhanvien;
    }

    public String getTen() {

        return ten;
    }

    public void setTen(String ten) {

        this.ten = ten;
    }

    public String getQuocTich() {

        return quocTich;
    }

    public void setQuocTich(String quocTich) {

        this.quocTich = quocTich;
    }

    public String getGioiTinh() {

        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {

        this.gioiTinh = gioiTinh;
    }

    public Date getNgaySinh() {

        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {

        this.ngaySinh = ngaySinh;
    }

    public Date getNgayVaoLam() {

        return ngayVaoLam;
    }

    public void setNgayVaoLam(Date ngayVaoLam) {

        this.ngayVaoLam = ngayVaoLam;
    }

    public double tinhPhuCapThamNien() {
        Calendar calHienTai = Calendar.getInstance();
        Calendar calNgayLam = Calendar.getInstance();
        calHienTai.getTime();
        calNgayLam.setTime(ngayVaoLam);
        int soNamCongTac = calHienTai.get(Calendar.YEAR) - calNgayLam.get(Calendar.YEAR);
        return soNamCongTac * 1000000;
    }

    @Override
    public String toString() {
        String fdateNgaySinh = DateUtils.dateToString(ngaySinh, DateUtils.DATE_PATTERN);
        String fdateNgayVaoLam = DateUtils.dateToString(ngayVaoLam, DateUtils.DATE_PATTERN);
        return staffID +
                "," + maNhanvien +
                "," + ten +
                "," + quocTich +
                "," + gioiTinh +
                "," + fdateNgaySinh +
                "," + fdateNgayVaoLam;
    }
}
