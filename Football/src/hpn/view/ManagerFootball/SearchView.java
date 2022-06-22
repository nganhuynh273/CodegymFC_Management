package hpn.view.ManagerFootball;

import hpn.model.Coach;
import hpn.model.Footballer;
import hpn.service.Impl.CoachServiceImpl;
import hpn.service.Impl.FootballerServiceImpl;
import hpn.utils.DateUtils;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Scanner;

public class SearchView {
    static Scanner scanner = new Scanner(System.in);
    static CoachServiceImpl coachServiceImpl = new CoachServiceImpl();
    static FootballerServiceImpl footballerServiceImpl = new FootballerServiceImpl();
    static DecimalFormat format = new DecimalFormat("###,###,###" + " VNĐ");

    public static void timKiemNhanVien() {
        boolean isChoice = true;
        int choice = -1;
        do {
            System.out.print("╔══════════════════════════════════════════════════════════════════╗\n" +
                    "║                                                                  ║\n" +
                    "║                     TÌM KIẾM THÔNG TIN NHÂN VIÊN                 ║\n" +
                    "║                                                                  ║\n" +
                    "║                   [1] Tìm kiếm Cầu thủ                           ║\n" +
                    "║                   [2] Tìm kiếm Huấn luyện viên                   ║\n" +
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
                    searchFootballer();
                    break;
                case 2:
                    searchCoach();
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

    public static void searchCoach() {
        boolean isChoose = true;
        int choose = -1;
        do {
            System.out.print("╔══════════════════════════════════════════════════════════════════╗\n" +
                    "║                                                                  ║\n" +
                    "║                     TÌM KIẾM HUẤN LUYỆN VIÊN                     ║\n" +
                    "║                                                                  ║\n" +
                    "║                   [1] Tìm kiếm theo ID                           ║\n" +
                    "║                   [2] Tìm kiếm theo mã nhân viên                 ║\n" +
                    "║                   [3] Tìm kiếm theo tên                          ║\n" +
                    "║                   [4] Quay lại                                   ║\n" +
                    "║                   [0] Quay về menu                               ║\n" +
                    "║                                                                  ║\n" +
                    "╚══════════════════════════════════════════════════════════════════╝\n");
            System.out.print("Chọn\t➨ ");
            try {
                choose = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
            }
            switch (choose) {
                case 1:
                    searchByIdCoach();
                    break;
                case 2:
                    searchByMaNhanVienCoach();
                    break;
                case 3:
                    searchByTenCoach();
                    break;
                case 4:
                    timKiemNhanVien();
                    break;
                case 0:
                    FootballView.create();
                    isChoose = false;
                    break;
                default:
                    System.out.println("Nhập sai. Vui lòng nhập lại!");
            }
        } while (isChoose);
    }

    public static void searchByTenCoach() {
        List<Coach> coachList = coachServiceImpl.getCoachItem();
        int count = 0;
        System.out.println();
        System.out.print("Nhập tên huấn luyện viên cần tìm kiếm: ");
        System.out.print("Chọn ➨ ");
        try {
            String search = scanner.nextLine();
            System.out.println("Kết quả tìm kiếm của từ khóa '" + search + "' là : ");
            search = search.toLowerCase();
            System.out.println("════════════════════════════════════════════════════ DANH SÁCH HUẤN LUYỆN VIÊN ═══════════════════════════════════════════════════════");
            for (Coach coach : coachList) {
                if (coach.getTen().toLowerCase().contains(search)) {
                    count++;
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
            showReturnSearchCoach(count);
        } catch (Exception e) {
            System.out.println("Không hợp lệ. Vui lòng nhập lại!");
        }
    }


    public static void searchByMaNhanVienCoach() {
        List<Coach> coachList = coachServiceImpl.getCoachItem();
        int count = 0;
        System.out.println();
        System.out.print("Nhập mã huấn luyện viên cần tìm kiếm: ");
        System.out.print("Chọn ➨ ");
        try {
            String search = scanner.nextLine();
            System.out.println("Kết quả tìm kiếm của từ khóa '" + search + "' là : ");
            search = search.toLowerCase();
            System.out.println("════════════════════════════════════════════════════ DANH SÁCH HUẤN LUYỆN VIÊN ═══════════════════════════════════════════════════════");
            for (Coach coach : coachList) {
                if (coach.getMaNhanvien().toLowerCase().contains(search)) {
                    count++;
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
            showReturnSearchCoach(count);
        } catch (Exception e) {
            System.out.println("Không hợp lệ. Vui lòng nhập lại!");
        }
    }

    public static void searchByIdCoach() {
        List<Coach> coachList = coachServiceImpl.getCoachItem();
        int count = 0;
        System.out.println();
        System.out.print("Nhập ID huấn luyện viên cần tìm kiếm: ");
        try {
            int search = Integer.parseInt(scanner.nextLine());
            System.out.println("Kết quả tìm kiếm của từ khóa '" + search + "' là : ");
            System.out.println("════════════════════════════════════════════════════ DANH SÁCH HUẤN LUYỆN VIÊN ═══════════════════════════════════════════════════════");
            for (Coach coach : coachList) {
                if (coach.getStaffID() == search) {
                    count++;
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
            showReturnSearchCoach(count);
        } catch (Exception e) {
            System.out.println("Không hợp lệ. Vui lòng nhập lại!");
        }
    }

    public static void showReturnSearchCoach(int count) {
        System.out.println("Có '" + count + "' huấn luyện viên được tìm thấy!");
        char press = ' ';
        boolean isChoice = false;
        System.out.println();
        do {
            System.out.print("╔══════════════════════════════════════════════════════════════════╗\n" +
                    "║                                                                  ║\n" +
                    "║                   [1] Nhấn 'r' để về trở lại                     ║\n" +
                    "║                   [2] Nhấn 'c' để về menu tìm kiếm               ║\n" +
                    "║                                                                  ║\n" +
                    "╚══════════════════════════════════════════════════════════════════╝\n");
            System.out.print("➨ ");
            try {
                press = scanner.nextLine().charAt(0);
            } catch (Exception e) {
                press = ' ';
            }
            switch (press) {
                case 'r':
                    searchCoach();
                    break;
                case 'c': {
                    timKiemNhanVien();
                    isChoice = false;
                    break;
                }
                default:
                    isChoice = true;
            }
        } while (isChoice);
    }


    public static void searchFootballer() {
        boolean isChoose = true;
        int choose = -1;
        do {
            System.out.print("╔══════════════════════════════════════════════════════════════════╗\n" +
                    "║                                                                  ║\n" +
                    "║                         TÌM KIẾM CẦU THỦ                         ║\n" +
                    "║                                                                  ║\n" +
                    "║                   [1] Tìm kiếm theo ID                           ║\n" +
                    "║                   [2] Tìm kiếm theo mã nhân viên                 ║\n" +
                    "║                   [3] Tìm kiếm theo tên                          ║\n" +
                    "║                   [4] Quay lại                                   ║\n" +
                    "║                   [0] Quay về menu                               ║\n" +
                    "║                                                                  ║\n" +
                    "╚══════════════════════════════════════════════════════════════════╝\n");

            System.out.println();
            System.out.print("Chọn\t➨ ");
            try {
                choose = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
            }
            switch (choose) {
                case 1:
                    searchByIdFootball();
                    break;
                case 2:
                    searchByMaNhanVienFootball();
                    break;
                case 3:
                    searchByTenFootball();
                    break;
                case 4:
                    searchByViTriThiDau();
                    break;
                case 5:
                    timKiemNhanVien();
                    break;
                case 0:
                    FootballView.create();
                    isChoose = false;
                    break;
                default:
                    System.out.println("Nhập sai. Vui lòng nhập lại!");
            }
        } while (isChoose);
    }

    public static void searchByViTriThiDau() {
        List<Footballer> footballerList = footballerServiceImpl.getFootballerItem();
        int count = 0;
        System.out.println();
        System.out.print("Nhập vị trí thi đấu của cầu thủ cần tìm kiếm: ");
        try {
            String search = scanner.nextLine();
            System.out.println("Kết quả tìm kiếm của từ khóa '" + search + "' là : ");
            search = search.toLowerCase();
            System.out.println("════════════════════════════════════════════════════ DANH SÁCH CẦU THỦ ════════════════════════════════════════════════════════════════");
            for (Footballer footballer : footballerList) {
                if (footballer.getTen().toLowerCase().contains(search)) {
                    count++;
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
            showReturnSearchCoach(count);
        } catch (Exception e) {
            System.out.println("Không hợp lệ. Vui lòng nhập lại!");
        }
    }

    public static void searchByTenFootball() {
        List<Footballer> footballerList = footballerServiceImpl.getFootballerItem();
        int count = 0;
        System.out.println();
        System.out.print("Nhập tên cầu thủ cần tìm kiếm: ");
        try {
            String search = scanner.nextLine();
            System.out.println("Kết quả tìm kiếm của từ khóa '" + search + "' là : ");
            search = search.toLowerCase();
            System.out.println("════════════════════════════════════════════════════ DANH SÁCH CẦU THỦ ════════════════════════════════════════════════════════════════");
            for (Footballer footballer : footballerList) {
                if (footballer.getTen().toLowerCase().contains(search)) {
                    count++;
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
            showReturnSearchCoach(count);
        } catch (Exception e) {
            System.out.println("Không hợp lệ. Vui lòng nhập lại!");
        }

    }

    public static void searchByMaNhanVienFootball() {
        List<Footballer> footballerList = footballerServiceImpl.getFootballerItem();
        int count = 0;
        System.out.println();
        System.out.print("Nhập mã cầu thủ cần tìm kiếm: ");
        try {
            String search = scanner.nextLine();
            System.out.println("Kết quả tìm kiếm của từ khóa '" + search + "' là : ");
            search = search.toLowerCase();
            System.out.println("════════════════════════════════════════════════════ DANH SÁCH CẦU THỦ ════════════════════════════════════════════════════════════════");
            for (Footballer footballer : footballerList) {
                if (footballer.getMaNhanvien().toLowerCase().contains(search)) {
                    count++;
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
            showReturnSearchCoach(count);
        } catch (Exception e) {
            System.out.println("Không hợp lệ. Vui lòng nhập lại!");
        }

    }

    public static void searchByIdFootball() {
        List<Footballer> footballerList = footballerServiceImpl.getFootballerItem();
        int count = 0;
        System.out.println();
        System.out.print("Nhập ID cầu thủ cần tìm kiếm: ");
        try {
            int search = Integer.parseInt(scanner.nextLine());
            System.out.println("Kết quả tìm kiếm của từ khóa '" + search + "' là : ");
            System.out.println("════════════════════════════════════════════════════ DANH SÁCH CẦU THỦ ════════════════════════════════════════════════════════════════");
            for (Footballer footballer : footballerList) {
                if (footballer.getStaffID() == search) {
                    count++;
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
            showReturnSearchFootball(count);
        } catch (Exception e) {
            System.out.println("Không hợp lệ. Vui lòng nhập lại!");
        }

    }

    public static void showReturnSearchFootball(int count) {
        System.out.println("Có '" + count + "' cầu thủ được tìm thấy!");
        char press = ' ';
        boolean isChoice = false;
        System.out.println();
        do {
            System.out.print("╔══════════════════════════════════════════════════════════════════╗\n" +
                    "║                                                                  ║\n" +
                    "║                   [1] Nhấn 'r' để về trở lại                     ║\n" +
                    "║                   [2] Nhấn 'c' để về menu tìm kiếm               ║\n" +
                    "║                                                                  ║\n" +
                    "╚══════════════════════════════════════════════════════════════════╝\n");
            System.out.print("➨ ");
            try {
                press = scanner.nextLine().charAt(0);
            } catch (Exception e) {
                press = ' ';
            }
            switch (press) {
                case 'r':
                    searchFootballer();
                    break;
                case 'c': {
                    timKiemNhanVien();
                    isChoice = false;
                    break;
                }
                default:
                    isChoice = true;
            }
        } while (isChoice);
    }
}
