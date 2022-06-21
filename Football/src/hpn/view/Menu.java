
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
        System.out.println("✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤");
        System.out.println("✤                      MAIN MENU                       ✤");
        System.out.println("✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤");
        System.out.println("✤                                                      ✤");
        System.out.println("✤                 1. Quản lý danh sách đội bóng        ✤");
        System.out.println("✤                 2. Quản lý thi đấu                   ✤");
        System.out.println("✤                 3. Thoát                             ✤");
        System.out.println("✤                                                      ✤");
        System.out.println("✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤");
        System.out.print("Chọn chức năng \n➨ ");

    }

    public static void ManagerFootball() {
        System.out.println("✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷");
        System.out.println("✷                QUẢN LÝ DANH SÁCH ĐỘI BÓNG            ✷");
        System.out.println("✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷");
        System.out.println("✷                                                      ✷");
        System.out.println("✷           1. Hiển thị danh sách                      ✷");
        System.out.println("✷           2. Thêm danh sách                          ✷");
        System.out.println("✷           3. Cập nhật danh sách                      ✷");
        System.out.println("✷           4. Xóa danh sách                           ✷");
        System.out.println("✷           5. Tìm kiếm nhân viên                      ✷");
        System.out.println("✷           6. Hiển thị sắp sếp nhân viên              ✷");
        System.out.println("✷           7. Quay về menu chính                      ✷");
        System.out.println("✷           0. Thoát chương trình                      ✷");
        System.out.println("✷                                                      ✷");
        System.out.println("✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷");
        System.out.println();
        System.out.printf("Chọn chức năng  \n➨ ");
    }

    public static void ManagerSchedule() {
        System.out.println("✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷");
        System.out.println("✷                QUẢN LÝ THI ĐẤU                       ✷");
        System.out.println("✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷");
        System.out.println("✷                                                      ✷");
        System.out.println("✷           1. Xem lịch thi đấu                        ✷");
        System.out.println("✷           2. Cập nhật lịch thi đấu                   ✷");
        System.out.println("✷           3. Tạo lịch thi đấu                        ✷");
        System.out.println("✷           4. Xem kết quả thi đấu                     ✷");
        System.out.println("✷           5. Bảng giá chuyển nhượng cầu thủ          ✷");
        System.out.println("✷           6. Quay về menu chính                      ✷");
        System.out.println("✷           0. Thoát chương trình                      ✷");
        System.out.println("✷                                                      ✷");
        System.out.println("✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷");
        System.out.println();
        System.out.printf("Chọn chức năng  \n➨ ");
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
        System.out.println("✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷");
        System.out.println("✷   1. Cập nhật vị trí thi đấu          ✷");
        System.out.println("✷   2. Cập nhật lượt tham gia thi đấu   ✷");
        System.out.println("✷   3. Cập nhật bàn thắng               ✷");
        System.out.println("✷   4. Cập nhật lương thỏa thuận        ✷");
        System.out.println("✷   5. Quay lại                         ✷");
        System.out.println("✷   6. Quay lại menu chính              ✷");
        System.out.println("✷   0. THoát chương trình               ✷");
        System.out.println("✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷");
        System.out.println("Chọn chức năng");
        System.out.printf("➨ \t");
    }

    public static void inputUpdateCoach() {
        System.out.println("✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷");
        System.out.println("✷   1. Cập nhật số năm kinh nghiệm      ✷");
        System.out.println("✷   2. Cập nhật hệ số lương             ✷");
        System.out.println("✷   3. Cập nhật phụ cấp                 ✷");
        System.out.println("✷   4. Quay lại                         ✷");
        System.out.println("✷   5. Quay lại menu chính              ✷");
        System.out.println("✷   0. THoát chương trình               ✷");
        System.out.println("✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷✷");
        System.out.println("Chọn chức năng");
        System.out.printf("➨ \t");
    }


    public static void removeConfirm() {
        System.out.println("❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂");
        System.out.println("❂                  BẠN CHẮC CHẮN MUỐN XÓA            ❂");
        System.out.println("❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂");
        System.out.println("❂                                                    ❂");
        System.out.println("❂              1. Nhấn 'y' để xác nhận xóa             ❂");
        System.out.println("❂              2. Nhấn 'c' để quay lại                 ❂");
        System.out.println("❂                                                    ❂");
        System.out.println("❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂");
        System.out.printf("➨ \t");
    }
}

