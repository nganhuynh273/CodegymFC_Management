package hpn.view.ManagerFootball;

import hpn.model.Coach;
import hpn.model.Footballer;
import hpn.model.Staff;
import hpn.service.Impl.CoachServiceImpl;
import hpn.service.Impl.FootballerServiceImpl;
import hpn.service.Impl.StaffServiceImpl;
import hpn.utils.DateUtils;
import hpn.view.Menu;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Scanner;


public class ShowView {
    static DecimalFormat format = new DecimalFormat("###,###,###" + " VNĐ");
    static Scanner scanner = new Scanner(System.in);
    static CoachServiceImpl coachServiceImpl = new CoachServiceImpl();
    static FootballerServiceImpl footballerServiceImpl = new FootballerServiceImpl();
    static StaffServiceImpl staffService = new StaffServiceImpl();

    public static void show() {
        boolean isChoice = true;
        int choice = -1;
        do {
            System.out.print("╔══════════════════════════════════════════════════════════════════╗\n" +
                    "║                                                                  ║\n" +
                    "║                     HIỂN THỊ DANH SÁCH ĐỘI BÓNG                  ║\n" +
                    "║                                                                  ║\n" +
                    "║                   [1] Hiển thị danh sách Cầu thủ                 ║\n" +
                    "║                   [2] Hiển thị danh sách Huấn luyện viên         ║\n" +
                    "║                   [0] Quay lại                                   ║\n" +
                    "║                                                                  ║\n" +
                    "╚══════════════════════════════════════════════════════════════════╝\n");

            System.out.print("Chọn\t➨ ");
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
            }
            switch (choice) {
                case 1:
                    showFootballers();
                    break;
                case 2:
                    showCoachs();
                    break;
                case 0:
                    FootballView.create();
                    isChoice = false;
                    break;
                default:
                    System.out.println("Chưa hợp lệ! Xin vui lòng nhập lại!");
            }
        } while (isChoice);
    }


    public static void showCoachs() {
        List<Coach> coachList = coachServiceImpl.getCoachItem();
        try {
            System.out.println("════════════════════════════════════════════════════ DANH SÁCH HUẤN LUYỆN VIÊN ═══════════════════════════════════════════════════════");
            for (Coach coach : coachList) {
                System.out.printf("%-12s %-10s %-20s %-20s %-20s %-20s %-20s %-20s\n",
                        "Thông tin cá nhân: \n", "ID", "Mã nhân viên", "Họ và tên", "Quốc tịch", "Giới tính", "Ngày sinh", "Ngày vào làm");
                System.out.printf("%-11s %-13s %17s %18s %15s %27s %20s\n", coach.getStaffID(), coach.getMaNhanvien(), coach.getTen(), coach.getQuocTich(), coach.getGioiTinh(), DateUtils.dateToString(coach.getNgaySinh(), DateUtils.DATE_PATTERN), DateUtils.dateToString(coach.getNgayVaoLam(), DateUtils.DATE_PATTERN));

                System.out.printf("%-12s %-31s %-20s %-20s %-27s\n",
                        "Kinh nghiệm làm việc:\n", "Số năm kinh nghiệm", "Hệ số lương", "Lương phụ cấp", "Lương thực nhận");
                System.out.printf("%3s %32s %30s %21s\n", coach.getSoNamKinhNghiem(),
                        coach.getHeSoLuong(), format.format(coach.getPhuCap()), format.format(coach.tinhLuong()));
                System.out.println("═══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════");

            }
            boolean is = true;
            do {
                System.out.print("╔══════════════════════════════════════════════════════════════════╗\n" +
                        "║                                                                  ║\n" +
                        "║                   [1] Nhấn 'q' để trở lại                        ║\n" +
                        "║                   [2] Nhấn 'c' để quay về menu                   ║\n" +
                        "║                   [3] Nhấn 't' để thoát chương trình             ║\n" +
                        "║                                                                  ║\n" +
                        "╚══════════════════════════════════════════════════════════════════╝\n");
                System.out.println("Nhấn ");
                System.out.print("➨ \t ");
                String choice = scanner.nextLine();
                switch (choice) {
                    case "q":
                        ShowView.show();
                        break;
                    case "c":
                        FootballView.create();
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


    public static void showFootballers() {
        List<Footballer> footballerList = footballerServiceImpl.getFootballerItem();

        try {
            System.out.println("════════════════════════════════════════════════════ DANH SÁCH CẦU THỦ ════════════════════════════════════════════════════════════════");
            for (Footballer footballer : footballerList) {
                System.out.printf("%-12s %-10s %-20s %-20s %-20s %-20s %-20s %-20s\n",
                        "Thông tin cá nhân: \n", "ID", "Mã nhân viên", "Họ và tên", "Quốc tịch", "Giới tính", "Ngày sinh", "Ngày vào làm");
                System.out.printf("%-11s %-13s %17s %18s %15s %27s %20s\n", footballer.getStaffID(), footballer.getMaNhanvien(), footballer.getTen(), footballer.getQuocTich(), footballer.getGioiTinh(), DateUtils.dateToString(footballer.getNgaySinh(), DateUtils.DATE_PATTERN), DateUtils.dateToString(footballer.getNgayVaoLam(), DateUtils.DATE_PATTERN));

                System.out.printf("%-12s %-31s %-20s %-30s %-27s %-15s\n",
                        "Thông tin thi đấu:\n", "Số bàn thắng ghi vào lưới", "Vị trí thi đấu", "Lượt tham gia thi đấu", "Lương thỏa thuận", "Lương thực nhận");
                System.out.printf("%3s %36s %15s %42s %27s\n", footballer.getBanThang(),
                        footballer.getViTriThiDau(), footballer.getSoLuotTranThamGia(), format.format(footballer.getLuongThoaThuan()), format.format(footballer.tinhLuong()));
                System.out.println("═══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════");
            }


            boolean is = true;
            do {
                System.out.print("╔══════════════════════════════════════════════════════════════════╗\n" +
                        "║                                                                  ║\n" +
                        "║                   [1] Nhấn 'q' để trở lại                        ║\n" +
                        "║                   [2] Nhấn 'c' để quay về menu                   ║\n" +
                        "║                   [3] Nhấn 't' để thoát chương trình             ║\n" +
                        "║                                                                  ║\n" +
                        "╚══════════════════════════════════════════════════════════════════╝\n");
                System.out.println("Nhấn ");
                System.out.print("➨ \t ");
                String choice = scanner.nextLine();
                switch (choice) {
                    case "q":
                        ShowView.show();
                        break;
                    case "c":
                        FootballView.create();
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
