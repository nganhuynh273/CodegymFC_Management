package hpn.view.ManagerSchedule;

import hpn.model.Schedule;
import hpn.service.Impl.ScheduleServiceImpl;
import hpn.utils.DateUtils;
import hpn.utils.ValidationUtils;
import hpn.view.Menu;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class CreateScheduleView {
    static ScheduleServiceImpl scheduleService = new ScheduleServiceImpl();
    static Scanner scanner = new Scanner(System.in);

    public static void createSchedule() {
        try {
            int id;
            Random r = new Random();
            int low = 1;
            int high = 9999;
            do {
                id = r.nextInt(high - low) + low;
            } while (scheduleService.exists(id));
            System.out.println("Nhập trận thi đấu \n➨");
            String tranThiDau = scanner.nextLine().trim();
            while (!ValidationUtils.isNameValid(tranThiDau)) {
                System.out.println("Nhập sai. Vui lòng nhập lại! \n" +
                        "Lưu ý: Tên trận đấu phải viết hoa chữ cái đầu và không dấu");
                System.out.println("Nhập trận đấu (vd: Vietel - SLNA) ");
                System.out.print("➨ ");
                tranThiDau = scanner.nextLine();
            }

            System.out.println("Nhập ngày thi đấu: ");
            String ngayThiDau = scanner.nextLine().trim();
            if (!ValidationUtils.isDateValid(ngayThiDau) || !DateUtils.isDateToString(ngayThiDau)) {
                System.out.println("Ngày không hợp lệ. Xin vui lòng nhập lại!");
                System.out.print("➨ ");
                ngayThiDau = scanner.nextLine().trim();
            }
            Date ngayThiDauHopLe = new SimpleDateFormat("dd-MM-yyyy").parse(ngayThiDau);

            System.out.println("Nhập giờ thi đấu \n➨ ");
            String gioThiDau = scanner.nextLine().trim();
            while (!ValidationUtils.isTime(gioThiDau)) {
                System.out.println("Nhập sai. Vui lòng nhập lại! \n" +
                        "Lưu ý: Nhập giờ thi đấu phải bắt đầu bằng số");
                System.out.println("Nhập giờ thi đấu (vd: 15:30) ");
                System.out.print("➨ ");
            }


            System.out.println("Nhập sân thi đấu");
            String sanThiDau = scanner.nextLine().trim();
            while (!ValidationUtils.isNameValid(sanThiDau)) {
                System.out.println("Nhập sai. Vui lòng nhập lại! \n" +
                        "Lưu ý: Nhập sân thi đấu phải viết hoa chữ cái đầu và không dấu");
                System.out.println("Nhập sân thi đấu (vd: My Dinh) ");
                System.out.print("➨ ");
                sanThiDau = scanner.nextLine();
            }

            Schedule schedule = new Schedule(id,tranThiDau, ngayThiDauHopLe, gioThiDau, sanThiDau);
            scheduleService.addScheduleItem(schedule);
            System.out.println("Lịch thi đấu được tạo thành công!");
            do {
                System.out.print("╔══════════════════════════════════════════════════════════════════╗\n" +
                        "║                                                                  ║\n" +
                        "║                                                                  ║\n" +
                        "║                   [1] Nhấn 'y' để tạo thêm danh sách             ║\n" +
                        "║                   [2] Nhấn 'c' để trở lại                        ║\n" +
                        "║                   [3] Nhấp 'p' để in danh sách                   ║\n" +
                        "║                   [4] Nhấn 't' để thoát                          ║\n" +
                        "║                                                                  ║\n" +
                        "╚══════════════════════════════════════════════════════════════════╝\n");
                System.out.print("➨ ");
                String choice = scanner.nextLine();
                switch (choice) {
                    case "y":
                        createSchedule();
                        break;
                    case "c":
                        ScheduleView.start();
                        break;
                    case "p":
                        showScheduleInfo(schedule);
                        break;
                    case "t":
                        Menu.exit();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Không hợp lệ! Xin vui lòng nhập lại!");
                }
            } while (true);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Nhập sai. Xin vui lòng nhập lại!");

        }

    }

    public static void showScheduleInfo(Schedule schedule) {
        try {
            System.out.print("╔══════════════════════════════════════════════════════════════════╗\n" +
                    "║                                                                  ║\n" +
                    "║                     TRẬN ĐẤU                  ║\n" +
                    "║                                                                  ║\n" +
                    "║                   [1] Trận d                 ║\n" +
                    "║                   [2] Hiển thị danh sách Huấn luyện viên         ║\n" +
                    "║                   [0] Quay lại                                   ║\n" +
                    "║                                                                  ║\n" +
                    "╚══════════════════════════════════════════════════════════════════╝\n");
            System.out.println("\n══════════════════════════════════ TRẬN ĐẤU ══════════════════════════════════n");
            System.out.printf("%-30s %-12s\n", "1. Trận đấu:", schedule.getTranThiDau());
            System.out.printf("%-30s %-12s\n", "2. Ngày thi đấu", DateUtils.dateToString(schedule.getNgayThidau()));
            System.out.printf("%-30s %-12s\n", "3. Giờ thi đấu:", schedule.getGioThiDau());
            System.out.printf("%-30s %-12s\n", "4. Sân thi đấu:", schedule.getSanThiDau());
            System.out.println("\n----------------------------------------------------------------------------------\n");


            boolean is = true;
            do {
                System.out.println("Nhấn 'q' để trở lại \n" +
                        "Nhấn 'c' để quay về menu \n" +
                        "Nhấn 't' để thoát chương trình");
                System.out.println("Nhấn ");
                System.out.print("➨ \t ");
                String choice = scanner.nextLine();
                switch (choice) {
                    case "q":
                        CreateScheduleView.createSchedule();
                        break;
                    case "c":
                        ScheduleView.start();
                        break;
                    case "t":
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
