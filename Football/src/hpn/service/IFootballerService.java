package hpn.service;

import hpn.model.Footballer;
import hpn.model.Staff;


import java.util.ArrayList;
import java.util.List;

public interface IFootballerService {
    List<Footballer> getFootballerItem();


    void addFootballerItem(Footballer newFootballer);


    void updateFootballer(Footballer newFootballer);

    void removeFootballer(long staffID);

    boolean exists(int staffID);

    boolean existsbyIDStaff(String maNhanvien);

    Staff getStaffByID(int staffID);

}
