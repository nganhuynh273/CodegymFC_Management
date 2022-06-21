package hpn.service.Impl;

import hpn.model.Staff;
import hpn.service.IStaffService;
import hpn.utils.CSVUtils;

import java.util.ArrayList;
import java.util.List;

public class StaffServiceImpl implements IStaffService {
    List<Staff> staffs = new ArrayList<>();
    public static String path = "data/staff.csv";


    @Override

    public List<Staff> getItem() {
        List<Staff> newStaffs = new ArrayList<>();
        List<String> records = CSVUtils.readData(path);
        for (String record : records) {
            newStaffs.add(new Staff(record));
        }
        return staffs = newStaffs;
    }

    @Override
    public void addItem(Staff newStaff) {
        List<Staff> staffs = getItem();
        staffs.add(newStaff);
        CSVUtils.writeData(path, staffs);
    }

    @Override
    public void update(Staff newStaff) {
        List<Staff> staffs = getItem();
        for (Staff staff : staffs) {
            if (staff.getStaffID() == newStaff.getStaffID()) {
                staff.setMaNhanvien(newStaff.getMaNhanvien());
                staff.setNgaySinh(newStaff.getNgaySinh());
                staff.setQuocTich(newStaff.getQuocTich());
                staff.setTen(newStaff.getTen());
                staff.setNgayVaoLam(newStaff.getNgayVaoLam());
                staff.setGioiTinh(newStaff.getGioiTinh());
            }
        }
        CSVUtils.writeData(path, staffs);
    }

    @Override
    public void remove(long id) {
        List<Staff> staffs = getItem();
        for (int i = 0; i < staffs.size(); i++) {
            if (staffs.get(i).getStaffID() == id) {
                staffs.remove(i);
                break;
            }
        }
        CSVUtils.writeData(path, staffs);
    }

    @Override
    public boolean exists(int id) {
        return getStaffByID(id) != null;
    }

    @Override
    public Staff getStaffByID(int id) {
        List<Staff> staffs = getItem();
        for (Staff staff : staffs) {
            if (staff.getStaffID() == id) {
                return staff;
            }
        }
        return null;
    }
}
