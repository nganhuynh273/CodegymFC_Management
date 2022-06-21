package hpn.service.Impl;

import hpn.model.Coach;
import hpn.model.Footballer;
import hpn.model.Staff;
import hpn.service.ICoachService;
import hpn.service.IStaffService;
import hpn.utils.CSVUtils;

import java.util.ArrayList;
import java.util.List;

public class CoachServiceImpl extends StaffServiceImpl implements ICoachService {
    List<Coach> coaches = new ArrayList<>();
    IStaffService iStaffService = new StaffServiceImpl();
    public static String path = "data/coach.csv";

    public static String pathS = "data/staff.csv";

    @Override
    public List<Coach> getCoachItem() {
        List<Coach> newCoachs = new ArrayList<>();
        List<String> records = CSVUtils.readData(path);
        List<Staff> staffs = iStaffService.getItem();

        for (String record : records) {
            Coach coach = new Coach(record);
            for (int i = 0; i < staffs.size(); i++) {
                if (staffs.get(i).getStaffID() == coach.getStaffID()) {
                    coach.setStaffInfo(staffs.get(i));
                    break;
                }
            }
            newCoachs.add(coach);
        }
        return coaches = newCoachs;
    }

    @Override
    public void addCoachItem(Coach newCoach) {
        List<Coach> coachs = getCoachItem();
        List<Staff> staffs = iStaffService.getItem();
        Staff staff = new Staff();
        staff.setStaffID(newCoach.getStaffID());
        staff.setMaNhanvien(newCoach.getMaNhanvien());
        staff.setTen(newCoach.getTen());
        staff.setQuocTich(newCoach.getQuocTich());
        staff.setGioiTinh(newCoach.getGioiTinh());
        staff.setNgaySinh(newCoach.getNgaySinh());
        staff.setNgayVaoLam(newCoach.getNgayVaoLam());
        coachs.add(newCoach);
        staffs.add(staff);
        CSVUtils.writeData(path, coachs);
        CSVUtils.writeData(pathS, staffs);

//        CSVUtils.writeData(path, staffs);
    }

    @Override
    public void updateCoach(Coach newCoach) {
        List<Coach> coaches = getCoachItem();
        for (Coach coach : coaches) {
            if (coach.getStaffID() == newCoach.getStaffID()) {
                coach.setHeSoLuong(newCoach.getHeSoLuong());
                coach.setPhuCap(newCoach.getPhuCap());
                coach.setSoNamKinhNghiem(newCoach.getSoNamKinhNghiem());
            }
        }
        CSVUtils.writeData(path, coaches);
    }

    @Override
    public void removeCoach(long staffID) {
        List<Coach> coachs = getCoachItem();
        for (int i = 0; i < coachs.size(); i++) {
            if (coachs.get(i).getStaffID() == staffID) {
                coachs.remove(i);
                break;
            }
        }
        CSVUtils.writeData(path, coachs);
    }

    @Override
    public boolean exists(int staffID) {
        return getStaffByID(staffID) != null;
    }

    @Override
    public boolean existsbyIDStaff(String maNhanvien) {
        for (Coach coach : coaches) {
            if (coach.getMaNhanvien().equals(maNhanvien))
                return true;
        }
        return false;
    }

    @Override
    public Coach getStaffByID(int staffID) {
        List<Coach> coaches = getCoachItem();
        for (Coach coach : coaches) {
            if (coach.getStaffID() == staffID) {
                return coach;
            }
        }
        return null;
    }
}
