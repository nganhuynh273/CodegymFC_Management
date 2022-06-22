package hpn.view.ManagerFootball;

import hpn.model.Coach;
import hpn.model.Footballer;
import hpn.service.Impl.CoachServiceImpl;
import hpn.service.Impl.FootballerServiceImpl;
import hpn.utils.DateUtils;
import hpn.view.Menu;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Scanner;

import static hpn.view.ManagerFootball.ShowView.showCoachs;
import static hpn.view.ManagerFootball.ShowView.showFootballers;


public class EditView {
    static Scanner scanner = new Scanner(System.in);
    static CoachServiceImpl coachServiceImpl = new CoachServiceImpl();
    static FootballerServiceImpl footballerServiceImpl = new FootballerServiceImpl();
    static DecimalFormat format = new DecimalFormat("###,###,###" + " VNĐ");

    public static void suaNhanVien() {
        boolean isChoice = true;
        int choice = -1;
        do {
            System.out.print("╔══════════════════════════════════════════════════════════════════╗\n" +
                    "║                                                                  ║\n" +
                    "║                  CẬP NHẬT THÔNG TIN NHÂN VIÊN                    ║\n" +
                    "║                                                                  ║\n" +
                    "║                 [1] Chỉnh sửa thông tin Cầu thủ                  ║\n" +
                    "║                 [2] Chỉnh sửa thông tin Huấn luyện viên          ║\n" +
                    "║                 [0] Quay lại                                     ║\n" +
                    "║                                                                  ║\n" +
                    "╚══════════════════════════════════════════════════════════════════╝\n");
            System.out.print("Chọn\t➨ ");
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
            }
            switch (choice) {
                case 1:
                    editFootballer();
                    break;
                case 2:
                    editCoach();
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

    public static void editFootballer() {
        showFootballer(footballerServiceImpl.getFootballerItem());
        System.out.println("Nhập ID cần sửa\n➨ ");
        try {
            int staffID = Integer.parseInt(scanner.nextLine());
            if (footballerServiceImpl.exists(staffID)) {
                Menu.inputUpdateFootballer();
                boolean is = true;
                do {
                    try {
                        int choice = Integer.parseInt(scanner.nextLine());
                        switch (choice) {
                            case 1:
                                inputViTriThiDau(staffID);
                                break;
                            case 2:
                                inputSoLuotTranThamGia(staffID);
                                break;
                            case 3:
                                inputBanThang(staffID);
                                break;
                            case 4:
                                inputLuongThoaThuan(staffID);
                                break;
                            case 5:
                                EditView.suaNhanVien();
                                break;
                            case 6:
                                FootballView.create();
                                break;
                            case 0:
                                Menu.exit();
                                System.exit(0);
                                break;
                            default:
                                System.out.print("Nhập sai. Vui lòng nhập lại! \n");
                                is = false;
                        }
                    } catch (Exception e) {
                        suaNhanVien();
                    }
                } while (!is);
                boolean flag = true;
                do {
                    System.out.print("╔══════════════════════════════════════════════════════════════════╗\n" +
                            "║                                                                  ║\n" +
                            "║                                                                  ║\n" +
                            "║                   [1] Nhấn 'c' để tiếp tục cập nhật              ║\n" +
                            "║                   [2] Nhấn 'q' để quay trở lại                   ║\n" +
                            "║                   [3] Nhấn 'b' để quay về menu                   ║\n" +
                            "║                   [4] Nhấn 't' để thoát chương trình             ║\n" +
                            "║                                                                  ║\n" +
                            "╚══════════════════════════════════════════════════════════════════╝\n");
//                    System.out.print("Nhấn 'c' để tiếp tục cập nhật \nNhấn 'q' để quay lại \nNhấn 'b' để quay về menu\nNhấn 't' để thoát... \n=> \t");
                    String chon = scanner.nextLine();
                    switch (chon) {
                        case "c":
                            editFootballer();
                            break;
                        case "q":
                            suaNhanVien();
                            break;
                        case "b":
                            FootballView.create();
                            break;
                        case "t":
                            Menu.exit();
                            System.exit(0);
                        default:
                            System.out.println("Mời nhập lại");
                            flag = false;
                    }
                } while (!flag);
            } else {
                System.out.println("Nhập sai. Vui lòng nhập lại!");
                suaNhanVien();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void inputLuongThoaThuan(int staffID) {
        Footballer footballer = footballerServiceImpl.getStaffByID(staffID);
        System.out.print("Nhập bàn thắng: \n➨");
        int luongThoaThuan = Integer.parseInt(scanner.nextLine());
        footballer.setLuongThoaThuan(luongThoaThuan);
        footballerServiceImpl.updateFootballer(footballer);
        showFootballer(footballerServiceImpl.getFootballerItem());
        System.out.println("Cập nhật thành công!");
    }

    public static void inputBanThang(int staffID) {
        Footballer footballer = footballerServiceImpl.getStaffByID(staffID);
        System.out.print("Nhập bàn thắng: \n➨");
        int banThang = Integer.parseInt(scanner.nextLine());
        footballer.setBanThang(banThang);
        footballerServiceImpl.updateFootballer(footballer);
        showFootballer(footballerServiceImpl.getFootballerItem());
        System.out.println("Cập nhật thành công!");

    }

    public static void inputSoLuotTranThamGia(int staffID) {
        Footballer footballer = footballerServiceImpl.getStaffByID(staffID);
        System.out.print("Nhập số lượt trận tham gia: \n➨ ");
        int soLuotTranThamGia = Integer.parseInt(scanner.nextLine());
        footballer.setSoLuotTranThamGia(soLuotTranThamGia);
        footballerServiceImpl.updateFootballer(footballer);
        showFootballer(footballerServiceImpl.getFootballerItem());
        System.out.println("Cập nhật thành công!");

    }

    public static void inputViTriThiDau(int staffID) {
        Footballer footballer = footballerServiceImpl.getStaffByID(staffID);
        System.out.print("Nhập vị trí thi đấu: \n➨ ");
        String viTriThiDau = scanner.nextLine();
        footballer.setViTriThiDau(viTriThiDau);
        footballerServiceImpl.updateFootballer(footballer);
        showFootballer(footballerServiceImpl.getFootballerItem());
        System.out.println("Cập nhật thành công!");
    }


    public static void editCoach() {
        showCoach(coachServiceImpl.getCoachItem());
        System.out.println("Nhập ID cần sửa\n➨ ");
        try {
            int staffID = Integer.parseInt(scanner.nextLine());
            if (coachServiceImpl.exists(staffID)) {
                Menu.inputUpdateCoach();
                boolean is = true;
                do {
                    try {
                        int choice = Integer.parseInt(scanner.nextLine());
                        switch (choice) {
                            case 1:
                                inputSoNamKinhNghiem(staffID);
                                break;
                            case 2:
                                inputHeSoLuong(staffID);
                                break;
                            case 3:
                                inputPhuCap(staffID);
                                break;
                            case 4:
                                EditView.suaNhanVien();
                                break;
                            case 5:
                                FootballView.create();
                                break;
                            case 0:
                                Menu.exit();
                                System.exit(0);
                                break;
                            default:
                                System.out.print("Nhập sai. Vui lòng nhập lại! \n");
                                is = false;
                        }
                    } catch (Exception e) {
                        suaNhanVien();
                    }
                } while (!is);
                boolean flag = true;
                do {
                    System.out.print("╔══════════════════════════════════════════════════════════════════╗\n" +
                        "║                                                                  ║\n" +
                        "║                                                                  ║\n" +
                        "║                   [1] Nhấn 'c' để tiếp tục cập nhật              ║\n" +
                        "║                   [2] Nhấn 'q' để quay trở lại                   ║\n" +
                        "║                   [3] Nhấn 'b' để quay về menu                   ║\n" +
                        "║                   [4] Nhấn 't' để thoát chương trình             ║\n" +
                        "║                                                                  ║\n" +
                        "╚══════════════════════════════════════════════════════════════════╝\n");
                    System.out.println("Nhấn ");
                    System.out.print("➨ \t ");
                    String chon = scanner.nextLine();
                    switch (chon) {
                        case "c":
                            editCoach();
                            break;
                        case "q":
                            suaNhanVien();
                            break;
                        case "b":
                            FootballView.create();
                            break;
                        case "t":
                            Menu.exit();
                            System.exit(0);
                        default:
                            System.out.println("Mời nhập lại");
                            flag = false;
                    }
                } while (!flag);
            } else {
                System.out.println("Nhập sai. Vui lòng nhập lại!");
                suaNhanVien();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void inputPhuCap(int staffID) {
        Coach coach = coachServiceImpl.getStaffByID(staffID);
        System.out.print("Nhập lương phụ cấp: \n➨");
        double phuCap = Double.parseDouble(scanner.nextLine());
        coach.setPhuCap(phuCap);
        coachServiceImpl.updateCoach(coach);
        showCoach(coachServiceImpl.getCoachItem());
        System.out.println("Cập nhật thành công!");
    }

    public static void inputHeSoLuong(int staffID) {
        Coach coach = coachServiceImpl.getStaffByID(staffID);
        System.out.print("Nhập hệ số lương: \n➨");
        double heSoLuong = Double.parseDouble(scanner.nextLine());
        coach.setHeSoLuong(heSoLuong);
        coachServiceImpl.updateCoach(coach);
        showCoach(coachServiceImpl.getCoachItem());
        System.out.println("Cập nhật thành công!");
    }

    public static void inputSoNamKinhNghiem(int staffID) {
        Coach coach = coachServiceImpl.getStaffByID(staffID);
        System.out.print("Nhập số năm kinh nghiệm: \n➨");
        int soNamKinhNghiem = Integer.parseInt(scanner.nextLine());
        coach.setSoNamKinhNghiem(soNamKinhNghiem);
        coachServiceImpl.updateCoach(coach);
        showCoach(coachServiceImpl.getCoachItem());
        System.out.println("Cập nhật thành công!");
    }

    public static void showFootballer(List<Footballer> footballerList) {
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
    }
    public static void showCoach(List<Coach> coachList) {
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
    }
}





