package hpn.service;

import hpn.model.Staff;

import java.util.List;

public interface IStaffService {
    List<Staff> getItem();

    void addItem(Staff newStaff);

    void update(Staff newStaff);

    void remove(long id);

    boolean exists(int id);


    Staff getStaffByID(int staffID);
}
