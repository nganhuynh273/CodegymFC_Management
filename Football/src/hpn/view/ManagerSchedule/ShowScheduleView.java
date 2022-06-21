package hpn.view.ManagerSchedule;

import hpn.model.Coach;
import hpn.model.Footballer;
import hpn.model.Schedule;
import hpn.service.Impl.ScheduleServiceImpl;
import hpn.utils.DateUtils;
import hpn.view.ManagerFootball.FootballView;
import hpn.view.ManagerFootball.ShowView;
import hpn.view.Menu;

import java.util.List;
import java.util.Scanner;

public class ShowScheduleView {
    public static ScheduleServiceImpl scheduleService = new ScheduleServiceImpl();
    public static Scanner scanner = new Scanner(System.in);

    public static void showSchedule() {
        List<Schedule> scheduleList = scheduleService.getScheduleItem();
        try {
            System.out.println("\n------------------------------ TRẬN ĐẤU ------------------------------------------\n");
            for (Schedule schedule : scheduleList) {
                String leftAlignFormat = "│ %-7s │ %-13s│ %-13s │ %-9s │%n";
                String line = "+ꟷꟷꟷꟷꟷꟷꟷ+ꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷ+ꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷ+ꟷꟷꟷꟷꟷꟷꟷꟷꟷ+ꟷꟷꟷꟷꟷꟷꟷꟷꟷ+ꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷ+ꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷ+ꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷ+ꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷ+ꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷ+ꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷ+ꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷ+%n";
                System.out.format(line);
                System.out.format("│   Trận đấu   │ Ngày thi đấu │ Giờ thi đấu   │ Sân thi đấu  │%n");
                System.out.format(line);
                System.out.format(leftAlignFormat, schedule.getTranThiDau(), DateUtils.dateToString(schedule.getNgayThidau(), DateUtils.DATE_PATTERN), schedule.getGioThiDau(), schedule.getSanThiDau());
                System.out.format(line);
                System.out.println("\n");
            }
            boolean is = true;
            do {
                System.out.println("\n=================================================");
                System.out.printf("\n|         Nhấn 'c' để quay trở lại          |");
                System.out.printf("\n|         Nhấn 'e' để thoát                 |");
                System.out.println("\n=================================================");
                System.out.println(" ➨ \t");
                String choice = scanner.nextLine();
                switch (choice) {
                    case "c":
                        ScheduleView.start();
                        break;
                    case "e":
                        Menu.exit();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Không hợp lệ. Xin vui lòng nhập lại");
                }
            } while (!is);
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}

//    public void showProduct() {
//        boolean flag = true;
//        do {
//            System.out.println("\n=================================================");
//            System.out.println("\n|         Nhấn 'c' để quay trở lại          |");
//            System.out.println("\n|         Nhấn 'e' để thoát                 |");
//            System.out.println("\n=================================================");
//            System.out.println(" ➨ \t");
//            String choice = scanner.nextLine();
//            try {
//                switch (choice) {
//                    case "c":
//                        ScheduleView.start();
//                        break;
//                    case "e":
//                        Menu.exit();
//                        System.exit(0);
//                        break;
//                    default:
//                        System.out.println("Vui lòng nhập lại!");
//                        flag = false;
//                }
//            } catch (Exception e) {
//                System.out.println("Chưa hợp lệ! Xin vui lòng nhập lại!");
//            }
//        } while (!flag);
//    }
//
//}
