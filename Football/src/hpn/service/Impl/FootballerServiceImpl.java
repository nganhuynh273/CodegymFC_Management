package hpn.service.Impl;

import hpn.model.Footballer;
import hpn.model.Staff;
import hpn.service.IFootballerService;
import hpn.service.IStaffService;
import hpn.utils.CSVUtils;

import java.util.ArrayList;
import java.util.List;

public class FootballerServiceImpl implements IFootballerService {
    List<Footballer> footballers = new ArrayList<>();
    IStaffService iStaffService = new StaffServiceImpl();

    public static String path = "data/footballer.csv";
    public static String pathS = "data/staff.csv";

    @Override
    public List<Footballer> getFootballerItem() {
        List<Footballer> newFootballers = new ArrayList<>();
        List<String> records = CSVUtils.readData(path);
        List<Staff> staffs = iStaffService.getItem();

        for (String record : records) {
            Footballer footballer = new Footballer(record);
            //System.out.println("Thông tin cầu thủ: " + footballer);
//            System.out.println(footballer);
            for (int i=0;i<staffs.size();i++){
//                System.out.println("staffid" + staffs.get(i).getStaffID());
//                System.out.println("footballerid" + footballer.getStaffID());
                if(staffs.get(i).getStaffID()== footballer.getStaffID()){
                    footballer.setStaffInfo(staffs.get(i));
                    break ;
                }
            }
            newFootballers.add(footballer);
        }
        return footballers = newFootballers;
    }

    @Override
    public void addFootballerItem(Footballer newFootballer) {
        List<Footballer> footballers = getFootballerItem();
        List<Staff> staffs = iStaffService.getItem();

        Staff staff = new Staff();
        staff.setStaffID(newFootballer.getStaffID());
        staff.setMaNhanvien(newFootballer.getMaNhanvien());
        staff.setTen(newFootballer.getTen());
        staff.setQuocTich(newFootballer.getQuocTich());
        staff.setGioiTinh(newFootballer.getGioiTinh());
        staff.setNgaySinh(newFootballer.getNgaySinh());
        staff.setNgayVaoLam(newFootballer.getNgayVaoLam());

        footballers.add(newFootballer);
        staffs.add(staff);


        CSVUtils.writeData(path, footballers);
        CSVUtils.writeData(pathS, staffs);
    }


    @Override
    public void updateFootballer(Footballer newFootballer) {
        List<Footballer> footballers = getFootballerItem();
        for (Footballer footballer : footballers) {
            if (footballer.getStaffID() == newFootballer.getStaffID()) {
                footballer.setLuongThoaThuan(newFootballer.getLuongThoaThuan());
                footballer.setSoLuotTranThamGia(newFootballer.getSoLuotTranThamGia());
                footballer.setBanThang(newFootballer.getBanThang());
                footballer.setViTriThiDau(newFootballer.getViTriThiDau());

            }
        }
        CSVUtils.writeData(path, footballers);
    }

    @Override
    public void removeFootballer(long id) {
        List<Footballer> footballers = getFootballerItem();
        for (int i = 0; i < footballers.size(); i++) {
            if (footballers.get(i).getStaffID() == id) {
                footballers.remove(i);
                break;
            }
        }
        CSVUtils.writeData(path, footballers);
    }

    @Override
    public boolean exists(int staffID) {
        return getStaffByID(staffID) != null;
    }

    @Override
    public boolean existsbyIDStaff(String maNhanvien) {
        for (Footballer footballer : footballers) {
            if (footballer.getMaNhanvien().equals(maNhanvien))
                return true;
        }
        return false;
    }


    @Override
    public Footballer getStaffByID(int staffID) {
        List<Footballer> footballers = getFootballerItem();
        for (Footballer footballer : footballers) {
            if (footballer.getStaffID() == staffID) {
                return footballer;
            }
        }
        return null;
    }
}
