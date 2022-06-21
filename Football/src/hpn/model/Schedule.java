package hpn.model;

import hpn.utils.DateUtils;

import java.util.Date;

public class Schedule {
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
        tranThiDau = fields[0];
        ngayThidau = DateUtils.stringToDate(fields[1], DateUtils.DATE_PATTERN);
        gioThiDau = fields[2];
        sanThiDau = fields[3];
    }

    public Schedule(String tranThiDau, Date ngayThiDau, String gioThiDau, String sanThiDau) {
        this.tranThiDau = tranThiDau;
        this.ngayThidau = ngayThiDau;
        this.gioThiDau = gioThiDau;
        this.sanThiDau = sanThiDau;

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
        return tranThiDau +
                ", " + ngayThidau +
                ", " + gioThiDau +
                ", " + sanThiDau;
    }

}
