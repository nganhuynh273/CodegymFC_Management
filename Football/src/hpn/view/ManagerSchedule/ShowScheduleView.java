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
            System.out.println("════════════════════════════════════════════════════ LỊCH THI ĐẤU ═══════════════════════════════════════════════════════");
            for (Schedule schedule : scheduleList) {
                System.out.printf(" %-31s %-20s %-20s %-27s\n", "Trận đấu", "Ngày thi đấu", "Giờ thi đấu", "Sân thi đấu");
                System.out.printf("%3s %26s %15s %22s\n", schedule.getTranThiDau(),
                        DateUtils.dateToString(schedule.getNgayThidau(), DateUtils.DATE_PATTERN), schedule.getGioThiDau(), schedule.getSanThiDau());
                System.out.println("═════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════");
            }
            boolean is = true;
            do {
                System.out.print("╔══════════════════════════════════════════════════════════════════╗\n" +
                        "║                                                                  ║\n" +
                        "║                                                                  ║\n" +
                        "║                   [1] Nhấn 'c' để trở lại                        ║\n" +
                        "║                   [2] Nhấn 'e' để thoát chương trình             ║\n" +
                        "║                                                                  ║\n" +
                        "╚══════════════════════════════════════════════════════════════════╝\n");

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

