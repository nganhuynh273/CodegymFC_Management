package hpn.view;

import hpn.model.Footballer;
import hpn.utils.DateUtils;
import hpn.utils.ValidationUtils;
import hpn.view.ManagerFootball.SortView.SortView;
import hpn.view.ManagerSchedule.ScheduleView;

import java.text.ParseException;

import static hpn.utils.AppUtils.isRetry;
import static hpn.view.MainLauncher.userMenu;
import static hpn.view.ManagerFootball.SearchView.searchByTenCoach;
import static hpn.view.ManagerFootball.ShowView.showCoachs;
import static hpn.view.ManagerFootball.ShowView.showFootballers;
import static hpn.view.ManagerSchedule.ShowScheduleView.showSchedule;
import static hpn.view.MemberView.launch;
import static hpn.view.Menu.mainMenu;
import static sun.security.jgss.GSSUtil.login;


public class Main {
    public static void main(String[] args) throws ParseException {
//       Menu.startMenu();
//        SortView.hienThiSapXep();
//  showSchedule();
//        nhapDuLieuTuDong();
//        MainLauncher.launch();
////        mainMenu();
        showSchedule();
    }
}
