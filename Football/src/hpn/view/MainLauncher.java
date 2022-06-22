package hpn.view;

import hpn.utils.AppUtils;
import hpn.view.ManagerFootball.FootballView;
import hpn.view.ManagerSchedule.ScheduleView;

import java.util.InputMismatchException;
import java.util.Scanner;

import static hpn.view.Menu.mainMenu;

public class MainLauncher {
    public static void launch() {
        LoginView loginView = new LoginView();
        loginView.login();
    }

    public static void menuOption() {
        do {
            mainMenu();
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("\nChọn chức năng ");
                System.out.print("⭆ ");
                int number = scanner.nextInt();
                switch (number) {
                    case 1:
                        UserViewLauncher.launch();
                        break;
                    case 2:
                        FootballView.create();
                        break;
                    case 3:
                        ScheduleView.start();
                        break;
                    case 0:
                        AppUtils.exit();
                    default:
                        System.out.println("Chọn chức năng không đúng! Vui lòng chọn lại");
                        menuOption();
                }

            } catch (InputMismatchException io) {
                System.out.println("Nhập sai! Vui lòng nhập lại");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }
    public static void userMenu() {
        System.out.print("╔═══════════════════════════════════════════════════════════════════════════════════╗\n" +
                "║                                                                                   ║\n" +
                "║                            USER MANGEMENT                                         ║\n" +
                "║                                                                                   ║\n" +
                "║                   [1] Thêm người dùng                                             ║\n" +
                "║                   [2] Sửa thông thông tin người dùng                              ║\n" +
                "║                   [3] Hiển thị danh sách người dùng                               ║\n" +
                "║                   [4] Xóa người dùng                                              ║\n" +
                "║                   [0] Thoát                                                       ║\n" +
                "║                                                                                   ║\n" +
                "╚═══════════════════════════════════════════════════════════════════════════════════╝\n");
    }
}
