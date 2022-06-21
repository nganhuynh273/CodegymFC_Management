package hpn.service;

import hpn.model.Coach;
import hpn.model.Schedule;

import java.util.List;

public interface ISchedule {

    List<Schedule> getScheduleItem();

    void addScheduleItem (Schedule newSchedule);

    void updateSchedule (Schedule newSchedule);

//    void removeSchedule (long id);
//
//    boolean exists (int id);
}
