package hpn.service;

import hpn.model.Coach;
import hpn.model.Staff;

import java.util.List;

public interface ICoachService {
    List<Coach> getCoachItem();

    void addCoachItem (Coach newCoach);

    void updateCoach (Coach newCoach);

    void removeCoach (long staffID);

    boolean exists (int staffID);

    boolean existsbyIDStaff(String maNhanvien);

    Staff getStaffByID(int staffID);

}
