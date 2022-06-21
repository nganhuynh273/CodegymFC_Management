package hpn.view.ManagerSchedule;

import hpn.view.ManagerSchedule.*;
import hpn.view.Menu;

import java.util.Scanner;

import static hpn.view.ManagerSchedule.CreateScheduleView.scheduleService;

public class ScheduleView {
    private static Scanner scanner = new Scanner(System.in);

    public static void start() {
        Menu.ManagerSchedule();
        ScheduleView scheduleView = new ScheduleView();
        System.out.println("Chọn chức năng \n ➨ ");
        try {
            boolean flag = true;
            int choice = Integer.parseInt(scanner.nextLine());
            do {
                switch (choice) {
                    case 1:
                        ShowScheduleView.showSchedule();
                        break;
                    case 2:
                        UpdateScheduleView.updateSchedule();
                        break;
                    case 3:
                        CreateScheduleView.createSchedule();
                        break;
                    case 4:
                        ResultsView.results();
                        break;
                    case 5:
                        PlayerPrice.playerPrice();
                        break;
                    case 6:
                        Menu.startMenu();
                        break;
                    default:
                        System.out.println("Không hợp lệ, xin vui lòng nhập lại");
                        flag = false;
                }
            } while (!flag);
        } catch (Exception e) {
            System.out.println("Không hợp lệ, vui lòng nhập lại!");
        }
    }
    
}
