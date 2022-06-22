package hpn.view.ManagerSchedule;

import hpn.model.Schedule;
import hpn.service.Impl.ScheduleServiceImpl;
import hpn.utils.DateUtils;
import hpn.utils.ValidationUtils;
import hpn.view.Menu;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class UpdateScheduleView {
    static ScheduleServiceImpl scheduleService = new ScheduleServiceImpl();
    static Scanner scanner = new Scanner(System.in);
    public static void updateSchedule() {
        show(scheduleService.getScheduleItem());
        System.out.print("Nhập ID cần sửa\n➨ \t ");
        try {
            int id = Integer.parseInt(scanner.nextLine());
            if (scheduleService.exists(id)) {
                Menu.inputUpdate();
                boolean is = true;
                do {
                    try {
                        int choice = Integer.parseInt(scanner.nextLine());
                        switch (choice) {
                            case 1:
                                inputTranThiDau(id);
                                break;
                            case 2:
                                inputNgayThiDau(id);
                                break;
                            case 3:
                                inputGioThiDau(id);
                                break;
                            case 4:
                                inputSanThiDau(id);
                            case 0:
                                ScheduleView.start();
                                break;
                            default:
                                System.out.print("Chưa hợp lệ!! Mời Nhập Lại\n");
                                is = false;
                        }
                    } catch (Exception e) {
                        updateSchedule();
                    }
                } while (!is);
                boolean flag = true;
                do {
                    System.out.print("Nhấn 'c' để tiếp tục cập nhật \nNhấn 'b' để quay lại \nNhấn 'e' để thoát... \n=> \t");
                    String chon = scanner.nextLine();
                    switch (chon) {
                        case "c":
                            updateSchedule();
                            break;
                        case "b":
                            ScheduleView.start();
                            break;
                        case "e":
                            Menu.exit();
                            System.exit(0);
                            break;
                        default:
                            System.out.println("Mời Nhập Lại");
                            flag = false;
                    }
                } while (!flag);
            } else {
                System.out.println("Mời Nhập Lại");
                updateSchedule();
            }

        } catch (Exception ex) {
            ex.printStackTrace();

        }
    }

    public static void inputSanThiDau(int id) {
        Schedule schedule = scheduleService.getScheduleByID(id);
        System.out.printf("Cập nhật sân thi đấu: \n➨ \t");
        String sanThiDau = scanner.nextLine();
        schedule.setSanThiDau(sanThiDau);
        scheduleService.updateSchedule(schedule);
        show(scheduleService.getScheduleItem());
        System.out.println("Cập nhật thành công!");
    }

    public static void inputGioThiDau(int id) {
        Schedule schedule = scheduleService.getScheduleByID(id);
        System.out.printf("Cập nhật giờ thi đấu: \n➨ \t");
        String gioThiDau = scanner.nextLine();
        schedule.setGioThiDau(gioThiDau);
        scheduleService.updateSchedule(schedule);
        show(scheduleService.getScheduleItem());
        System.out.println("Cập nhật thành công!");
    }

    public static void inputNgayThiDau(int id) throws ParseException {
        Schedule schedule = scheduleService.getScheduleByID(id);
        System.out.printf("Cập nhật ngày thi đấu: \n➨ \t");
        String ngayThiDau = scanner.nextLine().trim();
        if (!ValidationUtils.isDateValid(ngayThiDau) || !DateUtils.isDateToString(ngayThiDau)) {
            System.out.println("Ngày không hợp lệ. Xin vui lòng nhập lại!");
            System.out.print("➨ ");
            ngayThiDau =scanner.nextLine().trim();
        }
        Date ngayThiDauHopLe = new SimpleDateFormat("dd-MM-yyyy").parse(ngayThiDau);
    }

    public static void inputTranThiDau(int id) {
        Schedule schedule = scheduleService.getScheduleByID(id);
        System.out.printf("Cập nhật trận thi đấu: \n➨ \t");
        String tranThiDau = scanner.nextLine();
        schedule.setTranThiDau(tranThiDau);
        scheduleService.updateSchedule(schedule);
        show(scheduleService.getScheduleItem());
        System.out.println("Cập nhật thành công!");
    }

    public static void show(List<Schedule> scheduleList) {
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
    }
    public void showSchedule() {
        show(scheduleService.getScheduleItem());
        boolean flag = true;
        do {
            System.out.print("╔══════════════════════════════════════════════════════════════════╗\n" +
                "║                                                                  ║\n" +
                "║                                                                  ║\n" +
                "║                   [1] Nhấn 'c' để trở lại                        ║\n" +
                "║                   [2] Nhấn 'e' để thoát chương trình             ║\n" +
                "║                                                                  ║\n" +
                "╚══════════════════════════════════════════════════════════════════╝\n");
            System.out.printf(" ➨ \t");
            String choice = scanner.nextLine();
            try {
                switch (choice) {
                    case "c":
                        ScheduleView.start();
                        break;
                    case "e":
                        Menu.exit();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Vui lòng nhập lại!");
                        flag = false;
                }
            } catch (Exception e) {
                System.out.println("Chưa hợp lệ! Xin vui lòng nhập lại!");
            }
        } while (!flag);
    }


}
