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
            String leftAlignFormat = "| %-2s | %-50s | %n";
            String line = "+----+----------------------------------------------------+%n";
            System.out.format(line);
            System.out.format("| #  | HIỂN THỊ DANH SÁCH                                 |%n");
            System.out.format(line);
            System.out.format(leftAlignFormat, 1, "Hiển thị danh sách Cầu thủ");
            System.out.format(leftAlignFormat, 2, "Hiển thị danh sách Huấn luyện viên");
            System.out.format(leftAlignFormat, 0, "Quay lại");
            System.out.format(line);
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
            System.out.println("\n------------------------------HUẤN LUYỆN VIÊN ------------------------------------------\n");
            for (Coach coach : coachList) {
                System.out.printf("%-30s %-12d\n", "1. ID:", coach.getStaffID());
                System.out.printf("%-30s %-12s\n", "2. Mã nhân viên", coach.getMaNhanvien());
                System.out.printf("%-30s %-12s\n", "3. Họ và tên:", coach.getTen());
                System.out.printf("%-30s %-12s\n", "4. Quốc tịch:", coach.getQuocTich());
                System.out.printf("%-30s %-12s\n", "5. Giới tính:", coach.getGioiTinh());
                System.out.printf("%-30s %-12s\n", "6. Ngày sinh:", DateUtils.dateToString(coach.getNgaySinh()));
                System.out.printf("%-30s %-12s\n", "7. Ngày vào làm:", DateUtils.dateToString(coach.getNgayVaoLam()));
                System.out.printf("%-30s %-12s\n", "8. Số năm kinh nghiệm:", coach.getSoNamKinhNghiem());
                System.out.printf("%-30s %-12s\n", "9. Hệ số lương:", coach.getHeSoLuong());
                System.out.printf("%-30s %-12s\n", "10. Lương phụ cấp:", format.format(coach.getPhuCap()));
                System.out.printf("%-30s %-12s\n", "11. Lương thực nhận:", format.format(coach.tinhLuong()));
                System.out.println("\n----------------------------------------------------------------------------------------\n");
            }
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


    public  static void showFootballers() {
        List<Footballer> footballerList = footballerServiceImpl.getFootballerItem();

        try {
            System.out.println("\n------------------------------ CẦU THỦ ------------------------------------------\n");
            String leftAlignFormat = "│ %-7s │ %-13s│ %-13s │ %-9s │ %-9s │ %-10s │ %-13s │                %-10s │ %-14s │              %-11s │ %-16s │ %-14s │%n";
            String line = "+ꟷꟷꟷꟷꟷꟷꟷ+ꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷ+ꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷ+ꟷꟷꟷꟷꟷꟷꟷꟷꟷ+ꟷꟷꟷꟷꟷꟷꟷꟷꟷ+ꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷ+ꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷ+ꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷ+ꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷ+ꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷ+ꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷ+ꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷꟷ+%n";
            System.out.format(line);
            System.out.format("│   ID    │ Mã nhân viên │ Họ và tên   │ Quốc tịch  │ Giới tính │          Ngày sinh           │         Ngày vào làm         │ Số bàn thắng ghi vào lưới │ Vị trí thi đấu │ Số lượt tham gia thi đấu │ Lương thỏa thuận │ Lương thực nhận│%n");
            for (Footballer footballer : footballerList) {
                System.out.format(line);
                System.out.format(leftAlignFormat, footballer.getStaffID(), footballer.getMaNhanvien(), footballer.getTen(), footballer.getQuocTich(), footballer.getGioiTinh(), DateUtils.dateToString(footballer.getNgaySinh(), DateUtils.DATE_PATTERN), DateUtils.dateToString(footballer.getNgayVaoLam(), DateUtils.DATE_PATTERN), footballer.getBanThang(),
                        footballer.getViTriThiDau(), footballer.getSoLuotTranThamGia(), format.format(footballer.getLuongThoaThuan()), format.format(footballer.tinhLuong()));
                System.out.format(line);
                System.out.println("\n");
            }
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
//    public void showCoach(List<Coach> coachList) {
//        System.out.println("\n------------------------------HUẤN LUYỆN VIÊN ------------------------------------------\n");
//        for (Coach coach : coachList) {
//            System.out.println("\n----------------------------------------------------------------------------------------\n");
//            System.out.printf("%-30s %-12d\n", "1. ID:", coach.getStaffID());
//            System.out.printf("%-30s %-12s\n", "2. Mã nhân viên", coach.getMaNhanvien());
//            System.out.printf("%-30s %-12s\n", "3. Họ và tên:", coach.getTen());
//            System.out.printf("%-30s %-12s\n", "4. Quốc tịch:", coach.getGioiTinh());
//            System.out.printf("%-30s %-12s\n", "5. Giới tính:", coach.getGioiTinh());
//            System.out.printf("%-30s %-12s\n", "6. Ngày sinh:", DateUtils.dateToString(coach.getNgaySinh()));
//            System.out.printf("%-30s %-12s\n", "7. Ngày vào làm:", DateUtils.dateToString(coach.getNgayVaoLam()));
//            System.out.printf("%-30s %-12s\n", "8. Số năm kinh nghiệm:", coach.getSoNamKinhNghiem());
//            System.out.printf("%-30s %-12s\n", "9. Hệ số lương:", coach.getHeSoLuong());
//            System.out.printf("%-30s %-12s\n", "10. Lương phụ cấp:", format.format(coach.getPhuCap()));
//            System.out.printf("%-30s %-12s\n", "11. Lương thực nhận:", format.format(coach.tinhLuong()));
//            System.out.println("\n----------------------------------------------------------------------------------------\n");
//        }
//        System.out.println("\n----------------------------------------------------------------------------------------\n");
//    }
//    public void showFootballer(List<Footballer> footballerList) {
//        System.out.println("\n------------------------------ CẦU THỦ ------------------------------------------\n");
//        for (Footballer footballer : footballerList) {
//            System.out.println("\n----------------------------------------------------------------------------------------\n");
//            System.out.printf("%-30s %-12d\n", "1. ID:", footballer.getStaffID());
//            System.out.printf("%-30s %-12s\n", "2. Mã nhân viên", footballer.getMaNhanvien());
//            System.out.printf("%-30s %-12s\n", "3. Họ và tên:", footballer.getTen());
//            System.out.printf("%-30s %-12s\n", "4. Quốc tịch:", footballer.getGioiTinh());
//            System.out.printf("%-30s %-12s\n", "5. Giới tính:", footballer.getGioiTinh());
//            System.out.printf("%-30s %-12s\n", "6. Ngày sinh:", DateUtils.dateToString(footballer.getNgaySinh()));
//            System.out.printf("%-30s %-12s\n", "7. Ngày vào làm:", DateUtils.dateToString(footballer.getNgayVaoLam()));
//            System.out.printf("%-30s %-12s\n", "8. Số bàn thắng ghi vào lưới:", footballer.getBanThang());
//            System.out.printf("%-30s %-12s\n", "9. Vị trí thi đấu:", footballer.getViTriThiDau());
//            System.out.printf("%-30s %-12s\n", "10. Số lượt tham gia thi đấu):", footballer.getSoLuotTranThamGia());
//            System.out.printf("%-30s %-12s\n", "11. Lương thỏa thuận:", footballer.getLuongThoaThuan());
//            System.out.printf("%-30s %-12s\n", "12. Lương thực nhận:", format.format(footballer.tinhLuong()));
//            System.out.println("\n----------------------------------------------------------------------------------------\n");
//        }
//        System.out.println("\n----------------------------------------------------------------------------------------\n");
//    }
}
