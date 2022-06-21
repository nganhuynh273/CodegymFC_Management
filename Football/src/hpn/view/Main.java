package hpn.view;

import hpn.model.Footballer;
import hpn.utils.DateUtils;
import hpn.utils.ValidationUtils;
import hpn.view.ManagerFootball.SortView.SortView;
import hpn.view.ManagerSchedule.ScheduleView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static hpn.view.ManagerFootball.AddView.add;
import static hpn.view.ManagerFootball.InputView.nhapDuLieuTuDong;
import static hpn.view.ManagerSchedule.CreateScheduleView.createSchedule;
import static hpn.view.ManagerSchedule.ShowScheduleView.showSchedule;
import static hpn.view.Menu.scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
       Menu.startMenu();
//        SortView.hienThiSapXep();
//  showSchedule();
//        nhapDuLieuTuDong();
    }
}
