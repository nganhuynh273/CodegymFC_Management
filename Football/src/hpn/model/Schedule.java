package hpn.model;

import hpn.utils.DateUtils;

import java.util.Date;

public class Schedule {
    private long ID;
    private String maDoi;
    private String tenDoi;
    private String tenHLV;
    private String tranThiDau;
    private Date ngayThidau;
    private String gioThiDau;
    private String sanThiDau;

    public Schedule() {
    }

    public Schedule(String record) {
        String[] fields = record.split(",");
        ID = Long.parseLong(fields[0]);
        tranThiDau = fields[1];
        ngayThidau = DateUtils.stringToDate(fields[2], DateUtils.DATE_PATTERN);
        gioThiDau = fields[3];
        sanThiDau = fields[4];
    }

    public Schedule(long ID,String tranThiDau, Date ngayThiDau, String gioThiDau, String sanThiDau) {
        this.ID = ID;
        this.tranThiDau = tranThiDau;
        this.ngayThidau = ngayThiDau;
        this.gioThiDau = gioThiDau;
        this.sanThiDau = sanThiDau;

    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getMaDoi() {
        return maDoi;
    }

    public void setMaDoi(String maDoi) {
        this.maDoi = maDoi;
    }

    public String getTenDoi() {
        return tenDoi;
    }

    public void setTenDoi(String tenDoi) {
        this.tenDoi = tenDoi;
    }

    public String getTenHLV() {
        return tenHLV;
    }

    public void setTenHLV(String tenHLV) {
        this.tenHLV = tenHLV;
    }

    public String getTranThiDau() {
        return tranThiDau;
    }

    public void setTranThiDau(String tranThiDau) {
        this.tranThiDau = tranThiDau;
    }

    public Date getNgayThidau() {
        return ngayThidau;
    }

    public void setNgayThidau(Date ngayThidau) {
        this.ngayThidau = ngayThidau;
    }

    public String getGioThiDau() {
        return gioThiDau;
    }

    public void setGioThiDau(String gioThiDau) {
        this.gioThiDau = gioThiDau;
    }

    public String getSanThiDau() {
        return sanThiDau;
    }

    public void setSanThiDau(String sanThiDau) {
        this.sanThiDau = sanThiDau;
    }

    @Override
    public String toString() {
        String fdateNgayThiDau = DateUtils.dateToString(ngayThidau, DateUtils.DATE_PATTERN);
        return ID + "," + tranThiDau +
                "," + ngayThidau +
                "," + gioThiDau +
                "," + sanThiDau;
    }

}
