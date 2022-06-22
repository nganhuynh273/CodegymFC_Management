
package hpn.view;

import hpn.thread.Exit;
import hpn.view.ManagerFootball.FootballView;
import hpn.view.ManagerSchedule.ScheduleView;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    static Scanner scanner = new Scanner(System.in);

    public Menu() {
        startMenu();
    }

    public static void mainMenu() {
        System.out.print("╔══════════════════════════════════════════════════════════════════╗\n" +
                "║                                                                  ║\n" +
                "║                            MAIN MENU                             ║\n" +
                "║                                                                  ║\n" +
                "║                   [1] Quản lý người dùng                         ║\n" +
                "║                   [2] Quản lý danh sách đội bóng                 ║\n" +
                "║                   [3] Quản lý thi đấu                            ║\n" +
                "║                   [0] Thoát                                      ║\n" +
                "║                                                                  ║\n" +
                "╚══════════════════════════════════════════════════════════════════╝\n");
    }

    public static void ManagerFootball() {
        System.out.print("╔══════════════════════════════════════════════════════════════════╗\n" +
                "║                                                                  ║\n" +
                "║                  QUẢN LÝ DANH SÁCH ĐỘI BÓNG                      ║\n" +
                "║                                                                  ║\n" +
                "║               [1] Hiển thị danh sách đội bóng                    ║\n" +
                "║               [2] Thêm danh sách đội bóng                        ║\n" +
                "║               [3] Cập nhật danh sách đội bóng                    ║\n" +
                "║               [4] Xóa danh sách                                  ║\n" +
                "║               [5] Tìm kiếm nhân viên đội bóng                    ║\n" +
                "║               [6] Hiển thị sắp xếp nhân viên đội bóng            ║\n" +
                "║               [7] Quay về menu chính                             ║\n" +
                "║               [0] Thoát chương trình                             ║\n" +
                "║                                                                  ║\n" +
                "╚══════════════════════════════════════════════════════════════════╝\n");
    }

    public static void ManagerSchedule() {
        System.out.print("╔══════════════════════════════════════════════════════════════════╗\n" +
                "║                                                                  ║\n" +
                "║                         QUẢN LÝ THI ĐẤU                          ║\n" +
                "║                                                                  ║\n" +
                "║                   [1] Xem lịch thi đấu                           ║\n" +
                "║                   [2] Cập nhật lịch thi đấu                      ║\n" +
                "║                   [3] Tạo lịch thi đấu                           ║\n" +
                "║                   [4] Xem kết quả thi đấu                        ║\n" +
                "║                   [5] Bảng giá chuyển nhượng cầu thủ             ║\n" +
                "║                   [6] Quay về menu chính                         ║\n" +
                "║                   [0] Thoát chương trình                         ║\n" +
                "║                                                                  ║\n" +
                "╚══════════════════════════════════════════════════════════════════╝\n");
    }

    public static void startMenu() {
        try {
            boolean flag = true;
            do {
                mainMenu();
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        FootballView.create();
                        break;
                    case 2:
                        ScheduleView.start();
                        break;
                    default:
                        System.out.println("Không hợp lệ, xin vui lòng nhập lại!");
                        flag = false;
                }
            } while (!flag);
        } catch (InputMismatchException io) {
            io.printStackTrace();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public static void exit() {
        Exit exit = new Exit();
        Thread thread1 = new Thread(exit);
        thread1.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.print("\t Bạn vừa thoát khỏi chương trình");
        System.exit(0);
    }

    public static void inputUpdateFootballer() {
        System.out.print("╔══════════════════════════════════════════════════════════════════╗\n" +
                "║                                                                  ║\n" +
                "║                                                                  ║\n" +
                "║                   [1] Cập nhật vị trí thi đấu                    ║\n" +
                "║                   [2] Cập nhật lượt tham gia thi đấu             ║\n" +
                "║                   [3] Cập nhật bàn thắng                         ║\n" +
                "║                   [4] Cập nhật lương thỏa thuận                  ║\n" +
                "║                   [5] Quay lại                                   ║\n" +
                "║                   [6] Quay lại menu chính                        ║\n" +
                "║                   [0] THoát chương trình                         ║\n" +
                "║                                                                  ║\n" +
                "╚══════════════════════════════════════════════════════════════════╝\n");
        System.out.println("Chọn chức năng");
        System.out.printf("➨ \t");

    }

    public static void inputUpdateCoach() {
        System.out.print("╔══════════════════════════════════════════════════════════════════╗\n" +
                "║                                                                  ║\n" +
                "║                                                                  ║\n" +
                "║                   [1] Cập nhật số năm kinh nghiệm                ║\n" +
                "║                   [2] Cập nhật hệ số lương                       ║\n" +
                "║                   [3] Cập nhật lương phụ cấp                     ║\n" +
                "║                   [4] Quay lại                                   ║\n" +
                "║                   [5] Quay lại menu chính                        ║\n" +
                "║                   [0] THoát chương trình                         ║\n" +
                "║                                                                  ║\n" +
                "╚══════════════════════════════════════════════════════════════════╝\n");
        System.out.println("Chọn chức năng");
        System.out.printf("➨ \t");
    }


    public static void removeConfirm() {
        System.out.print("╔══════════════════════════════════════════════════════════════════╗\n" +
                "║                                                                  ║\n" +
                "║                    BẠN CHẮC CHẮN MUỐN XÓA                        ║\n" +
                "║                                                                  ║\n" +
                "║                   [1] Nhấn 'y' để xác nhận xóa                   ║\n" +
                "║                   [2] Nhấn 'c' để quay lại                       ║\n" +
                "║                                                                  ║\n" +
                "╚══════════════════════════════════════════════════════════════════╝\n");
        System.out.printf("➨ \t");
    }

//    public static void menuUser() {
//        System.out.println("⚪ ⚪ ⚪ ⚪ ⚪  USERS MANAGER  ⚪ ⚪ ⚪ ⚪ ⚪");
//        System.out.println("⚪                                      ⚪");
//        System.out.println("⚪     1. Thêm người dùng               ⚪");
//        System.out.println("⚪     2. Sửa thông tin người dùng      ⚪");
//        System.out.println("⚪     3. Hiện danh sách người dùng     ⚪");
//        System.out.println("⚪                                      ⚪");
//        System.out.println("⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪");
//    }
    public static void inputUpdate() {
        System.out.print("╔══════════════════════════════════════════════════════════════════╗\n" +
                "║                                                                  ║\n" +
                "║                                                                  ║\n" +
                "║                   [1] Cập nhật trận thi đấu                      ║\n" +
                "║                   [2] Cập nhật ngày thi đấu                      ║\n" +
                "║                   [3] Cập nhật giờ thi đấu                       ║\n" +
                "║                   [4] Cập nhật sân thi đấu                       ║\n" +
                "║                   [0] Quay lại                                   ║\n" +
                "║                                                                  ║\n" +
                "╚══════════════════════════════════════════════════════════════════╝\n");
        System.out.println("Chọn chức năng");
        System.out.printf("➨ \t");
    }
}

