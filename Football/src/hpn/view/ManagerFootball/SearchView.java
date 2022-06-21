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
            String leftAlignFormat = "| %-2s | %-50s | %n";
            String line = "+----+----------------------------------------------------+%n";
            System.out.format(line);
            System.out.format("| #  | TÌM KIẾM THÔNG TIN NHÂN VIÊN                                         |%n");
            System.out.format(line);
            System.out.format(leftAlignFormat, 1, "Tìm kiếm Cầu thủ");
            System.out.format(leftAlignFormat, 2, "Tìm kiếm Huấn luyện viên");
            System.out.format(leftAlignFormat, 0, "Quay lại");
            System.out.format(line);
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
            System.out.println("✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪");
            System.out.println("✪                  TÌM KIẾM HUẤN LUYỆN VIÊN                 ✪");
            System.out.println("✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪");
            System.out.println("✪                                                           ✪");
            System.out.println("✪                    1. Tìm kiếm theo ID                    ✪");
            System.out.println("✪                    2. Tìm kiếm theo mã nhân viên          ✪");
            System.out.println("✪                    3. Tìm kiếm theo tên                   ✪");
            System.out.println("✪                    4. Quay lại                            ✪");
            System.out.println("✪                    0. Quay về menu                        ✪");
            System.out.println("✪                                                           ✪");
            System.out.println("✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪");
            System.out.println();
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
        try {
            String search = scanner.nextLine();
            System.out.println("Kết quả tìm kiếm của từ khóa '" + search + "' là : ");
            search = search.toLowerCase();
            System.out.println("\n------------------------------HUẤN LUYỆN VIÊN ------------------------------------------\n");
            for (Coach coach : coachList) {
                if (coach.getTen().toLowerCase().contains(search)) {
                    count++;
                    System.out.println("\n----------------------------------------------------------------------------------------\n");
                    System.out.printf("%-30s %-12d\n", "1. ID:", coach.getStaffID());
                    System.out.printf("%-30s %-12s\n", "2. Mã nhân viên", coach.getMaNhanvien());
                    System.out.printf("%-30s %-12s\n", "3. Họ và tên:", coach.getTen());
                    System.out.printf("%-30s %-12s\n", "4. Quốc tịch:", coach.getGioiTinh());
                    System.out.printf("%-30s %-12s\n", "5. Giới tính:", coach.getGioiTinh());
                    System.out.printf("%-30s %-12s\n", "6. Ngày sinh:", DateUtils.dateToString(coach.getNgaySinh()));
                    System.out.printf("%-30s %-12s\n", "7. Ngày vào làm:", DateUtils.dateToString(coach.getNgayVaoLam()));
                    System.out.printf("%-30s %-12s\n", "8. Số năm kinh nghiệm:", coach.getSoNamKinhNghiem());
                    System.out.printf("%-30s %-12s\n", "9. Hệ số lương:", coach.getHeSoLuong());
                    System.out.printf("%-30s %-12s\n", "10. Lương phụ cấp:", format.format(coach.getPhuCap()));
                    System.out.printf("%-30s %-12s\n", "11. Lương thực nhận:", format.format(coach.tinhLuong()));
                    System.out.println("\n----------------------------------------------------------------------------------------\n");
                }
                System.out.println("\n----------------------------------------------------------------------------------------\n");
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
        try {
            String search = scanner.nextLine();
            System.out.println("Kết quả tìm kiếm của từ khóa '" + search + "' là : ");
            search = search.toLowerCase();
            System.out.println("\n------------------------------HUẤN LUYỆN VIÊN ------------------------------------------\n");
            for (Coach coach : coachList) {
                if (coach.getMaNhanvien().toLowerCase().contains(search)) {
                    count++;
                    System.out.println("\n----------------------------------------------------------------------------------------\n");
                    System.out.printf("%-30s %-12d\n", "1. ID:", coach.getStaffID());
                    System.out.printf("%-30s %-12s\n", "2. Mã nhân viên", coach.getMaNhanvien());
                    System.out.printf("%-30s %-12s\n", "3. Họ và tên:", coach.getTen());
                    System.out.printf("%-30s %-12s\n", "4. Quốc tịch:", coach.getGioiTinh());
                    System.out.printf("%-30s %-12s\n", "5. Giới tính:", coach.getGioiTinh());
                    System.out.printf("%-30s %-12s\n", "6. Ngày sinh:", DateUtils.dateToString(coach.getNgaySinh()));
                    System.out.printf("%-30s %-12s\n", "7. Ngày vào làm:", DateUtils.dateToString(coach.getNgayVaoLam()));
                    System.out.printf("%-30s %-12s\n", "8. Số năm kinh nghiệm:", coach.getSoNamKinhNghiem());
                    System.out.printf("%-30s %-12s\n", "9. Hệ số lương:", coach.getHeSoLuong());
                    System.out.printf("%-30s %-12s\n", "10. Lương phụ cấp:", format.format(coach.getPhuCap()));
                    System.out.printf("%-30s %-12s\n", "11. Lương thực nhận:", format.format(coach.tinhLuong()));
                    System.out.println("\n----------------------------------------------------------------------------------------\n");
                }
                System.out.println("\n----------------------------------------------------------------------------------------\n");
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
            System.out.println("\n------------------------------HUẤN LUYỆN VIÊN ------------------------------------------\n");
            for (Coach coach : coachList) {
                if (coach.getStaffID() == search) {
                    count++;
                    System.out.println("\n----------------------------------------------------------------------------------------\n");
                    System.out.printf("%-30s %-12d\n", "1. ID:", coach.getStaffID());
                    System.out.printf("%-30s %-12s\n", "2. Mã nhân viên", coach.getMaNhanvien());
                    System.out.printf("%-30s %-12s\n", "3. Họ và tên:", coach.getTen());
                    System.out.printf("%-30s %-12s\n", "4. Quốc tịch:", coach.getGioiTinh());
                    System.out.printf("%-30s %-12s\n", "5. Giới tính:", coach.getGioiTinh());
                    System.out.printf("%-30s %-12s\n", "6. Ngày sinh:", DateUtils.dateToString(coach.getNgaySinh()));
                    System.out.printf("%-30s %-12s\n", "7. Ngày vào làm:", DateUtils.dateToString(coach.getNgayVaoLam()));
                    System.out.printf("%-30s %-12s\n", "8. Số năm kinh nghiệm:", coach.getSoNamKinhNghiem());
                    System.out.printf("%-30s %-12s\n", "9. Hệ số lương:", coach.getHeSoLuong());
                    System.out.printf("%-30s %-12s\n", "10. Lương phụ cấp:", format.format(coach.getPhuCap()));
                    System.out.printf("%-30s %-12s\n", "11. Lương thực nhận:", format.format(coach.tinhLuong()));
                    System.out.println("\n----------------------------------------------------------------------------------------\n");
                }
                System.out.println("\n----------------------------------------------------------------------------------------\n");
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
            System.out.print("Nhấn 'r' để về trở lại! \n "
                    + "Nhấn 'c' để về menu tìm kiếm ");
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
            System.out.println("✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪");
            System.out.println("✪                       TÌM KIẾM CẦU THỦ                    ✪");
            System.out.println("✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪");
            System.out.println("✪                                                           ✪");
            System.out.println("✪                    1. Tìm kiếm theo ID                    ✪");
            System.out.println("✪                    2. Tìm kiếm theo mã nhân viên          ✪");
            System.out.println("✪                    3. Tìm kiếm theo tên                   ✪");
            System.out.println("✪                    4. Quay lại                            ✪");
            System.out.println("✪                    0. Quay về menu                        ✪");
            System.out.println("✪                                                           ✪");
            System.out.println("✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪");
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
            System.out.println("\n------------------------------ CẦU THỦ ------------------------------------------\n");
            String leftAlignFormat = "| %-7s | %-7s| %-13s | %-9s | %-9s | %-10s | %-13s | %-13s | %-7s | %-9s | %-16s | %-16%s |%n";
            String line = "+---------+---------+---------------+-----------+-----------+------------+---------------+---------------+---------+-----------+------------------+------------------+%n";
            System.out.format(line);
            System.out.format("| ID   | Mã nhân viên | Họ và tên    | Quốc tịch | Giới tính | Ngày sinh  | Ngày vào làm  | Số bàn thắng ghi vào lưới | Vị trí thi đấu | Số lượt tham gia thi đấu | Lương thỏa thuận | Lương thỏa thuận |%n");
            for (Footballer footballer : footballerList) {
                if (footballer.getTen().toLowerCase().contains(search)) {
                    count++;
                    System.out.format(line);
                    System.out.format(leftAlignFormat, footballer.getStaffID(), footballer.getMaNhanvien(), footballer.getTen(), footballer.getQuocTich(), footballer.getGioiTinh(), footballer.getNgaySinh(), footballer.getNgayVaoLam(), footballer.getBanThang(),
                            footballer.getViTriThiDau(), footballer.getSoLuotTranThamGia(), format.format(footballer.getLuongThoaThuan()), format.format(footballer.tinhLuong()));
                    System.out.format(line);
                    System.out.println("\n----------------------------------------------------------------------------------------\n");
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
            System.out.println("\n------------------------------ CẦU THỦ ------------------------------------------\n");
            for (Footballer footballer : footballerList) {
                if (footballer.getTen().toLowerCase().contains(search)) {
                    count++;
                    System.out.println("\n----------------------------------------------------------------------------------------\n");
                    System.out.printf("%-30s %-12d\n", "1. ID:", footballer.getStaffID());
                    System.out.printf("%-30s %-12s\n", "2. Mã nhân viên", footballer.getMaNhanvien());
                    System.out.printf("%-30s %-12s\n", "3. Họ và tên:", footballer.getTen());
                    System.out.printf("%-30s %-12s\n", "4. Quốc tịch:", footballer.getGioiTinh());
                    System.out.printf("%-30s %-12s\n", "5. Giới tính:", footballer.getGioiTinh());
                    System.out.printf("%-30s %-12s\n", "6. Ngày sinh:", DateUtils.dateToString(footballer.getNgaySinh()));
                    System.out.printf("%-30s %-12s\n", "7. Ngày vào làm:", DateUtils.dateToString(footballer.getNgayVaoLam()));
                    System.out.printf("%-30s %-12s\n", "8. Số bàn thắng ghi vào lưới:", footballer.getBanThang());
                    System.out.printf("%-30s %-12s\n", "9. Vị trí thi đấu:", footballer.getViTriThiDau());
                    System.out.printf("%-30s %-12s\n", "10. Số lượt tham gia thi đấu):", footballer.getSoLuotTranThamGia());
                    System.out.printf("%-30s %-12s\n", "11. Lương thỏa thuận:", footballer.getLuongThoaThuan());
                    System.out.printf("%-30s %-12s\n", "12. Lương thực nhận:", format.format(footballer.tinhLuong()));
                    System.out.println("\n----------------------------------------------------------------------------------------\n");
                }
                System.out.println("\n----------------------------------------------------------------------------------------\n");
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
            System.out.println("\n------------------------------ CẦU THỦ ------------------------------------------\n");
            for (Footballer footballer : footballerList) {
                if (footballer.getMaNhanvien().toLowerCase().contains(search)) {
                    count++;
                    System.out.println("\n----------------------------------------------------------------------------------------\n");
                    System.out.printf("%-30s %-12d\n", "1. ID:", footballer.getStaffID());
                    System.out.printf("%-30s %-12s\n", "2. Mã nhân viên", footballer.getMaNhanvien());
                    System.out.printf("%-30s %-12s\n", "3. Họ và tên:", footballer.getTen());
                    System.out.printf("%-30s %-12s\n", "4. Quốc tịch:", footballer.getGioiTinh());
                    System.out.printf("%-30s %-12s\n", "5. Giới tính:", footballer.getGioiTinh());
                    System.out.printf("%-30s %-12s\n", "6. Ngày sinh:", DateUtils.dateToString(footballer.getNgaySinh()));
                    System.out.printf("%-30s %-12s\n", "7. Ngày vào làm:", DateUtils.dateToString(footballer.getNgayVaoLam()));
                    System.out.printf("%-30s %-12s\n", "8. Số bàn thắng ghi vào lưới:", footballer.getBanThang());
                    System.out.printf("%-30s %-12s\n", "9. Vị trí thi đấu:", footballer.getViTriThiDau());
                    System.out.printf("%-30s %-12s\n", "10. Số lượt tham gia thi đấu):", footballer.getSoLuotTranThamGia());
                    System.out.printf("%-30s %-12s\n", "11. Lương thỏa thuận:", footballer.getLuongThoaThuan());
                    System.out.printf("%-30s %-12s\n", "12. Lương thực nhận:", format.format(footballer.tinhLuong()));
                    System.out.println("\n----------------------------------------------------------------------------------------\n");
                }
                System.out.println("\n----------------------------------------------------------------------------------------\n");
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
            System.out.println("\n------------------------------ CẦU THỦ ------------------------------------------\n");
            for (Footballer footballer : footballerList) {
                if (footballer.getStaffID() == search) {
                    count++;
                    System.out.printf("%-30s %-12d\n", "1. ID:", footballer.getStaffID());
                    System.out.printf("%-30s %-12s\n", "2. Mã nhân viên", footballer.getMaNhanvien());
                    System.out.printf("%-30s %-12s\n", "3. Họ và tên:", footballer.getTen());
                    System.out.printf("%-30s %-12s\n", "4. Quốc tịch:", footballer.getGioiTinh());
                    System.out.printf("%-30s %-12s\n", "5. Giới tính:", footballer.getGioiTinh());
                    System.out.printf("%-30s %-12s\n", "6. Ngày sinh:", DateUtils.dateToString(footballer.getNgaySinh()));
                    System.out.printf("%-30s %-12s\n", "7. Ngày vào làm:", DateUtils.dateToString(footballer.getNgayVaoLam()));
                    System.out.printf("%-30s %-12s\n", "8. Số bàn thắng ghi vào lưới:", footballer.getBanThang());
                    System.out.printf("%-30s %-12s\n", "9. Vị trí thi đấu:", footballer.getViTriThiDau());
                    System.out.printf("%-30s %-12s\n", "10. Số lượt tham gia thi đấu):", footballer.getSoLuotTranThamGia());
                    System.out.printf("%-30s %-12s\n", "11. Lương thỏa thuận:", footballer.getLuongThoaThuan());
                    System.out.printf("%-30s %-12s\n", "12. Lương thực nhận:", format.format(footballer.tinhLuong()));
                    System.out.println("\n----------------------------------------------------------------------------------------\n");
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
            System.out.print("Nhấn 'r' để về trở lại! \n "
                    + "Nhấn 'c' để về menu tìm kiếm ");
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
