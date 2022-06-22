package hpn.service.Impl;

import hpn.model.Schedule;
import hpn.service.ISchedule;
import hpn.utils.CSVUtils;

import java.util.ArrayList;
import java.util.List;

public class ScheduleServiceImpl implements ISchedule {

    List<Schedule> schedules = new ArrayList<>();
    public static String path = "data/schedule.csv";

    @Override
    public List<Schedule> getScheduleItem() {
        List<Schedule> newSchedules = new ArrayList<>();
        List<String> records = CSVUtils.readData(path);
        for (String record : records) {
            newSchedules.add(new Schedule(record));
        }
        return schedules = newSchedules;
    }

    @Override
    public void addScheduleItem(Schedule newSchedule) {
        List<Schedule> schedules = getScheduleItem();
        schedules.add(newSchedule);
        CSVUtils.writeData(path, schedules);
    }

    @Override
    public void updateSchedule(Schedule newSchedule) {
        List<Schedule> schedules = getScheduleItem();
        for (Schedule schedule : schedules) {
            if (schedule.getID() == newSchedule.getID()) {
                schedule.setTranThiDau(newSchedule.getTranThiDau());
                schedule.setGioThiDau(newSchedule.getGioThiDau());
                schedule.setNgayThidau(newSchedule.getNgayThidau());
                schedule.setSanThiDau(newSchedule.getSanThiDau());
        }
        }
        CSVUtils.writeData(path, schedules);
    }



//    @Override
//    public void removeSchedule(long id) {
//
//    }
//
    @Override
    public boolean exists(int id) {
        return getScheduleByID(id) != null;
    }

    @Override
    public Schedule getScheduleByID(int id) {
        List<Schedule> schedules = getScheduleItem();
        for (Schedule schedule : schedules) {
            if (schedule.getID() == id) {
                return schedule;
            }
        }
        return null;
    }

}
