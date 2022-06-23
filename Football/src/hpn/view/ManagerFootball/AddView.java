package hpn.view.ManagerFootball;

import hpn.model.Coach;
import hpn.model.Footballer;
import hpn.service.Impl.CoachServiceImpl;
import hpn.service.Impl.FootballerServiceImpl;
import hpn.utils.ConvertUtils;
import hpn.utils.DateUtils;
import hpn.utils.ValidationUtils;
import hpn.view.Menu;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class AddView {
    static Scanner scanner = new Scanner(System.in);
    static CoachServiceImpl coachServiceImpl = new CoachServiceImpl();
    static FootballerServiceImpl footballerServiceImpl = new FootballerServiceImpl();
    static DecimalFormat format = new DecimalFormat("###,###,###" + " VNĐ");

    public static void add() {
        boolean isChoice = true;
        int choice = -1;
        do {
            System.out.print("╔══════════════════════════════════════════════════════════════════╗\n" +
                    "║                                                                  ║\n" +
                    "║                        THÊM DANH SÁCH                            ║\n" +
                    "║                                                                  ║\n" +
                    "║                       [1] Thêm Cầu thủ                           ║\n" +
                    "║                       [2] Thêm Huấn luận viên                    ║\n" +
                    "║                       [0] Quay lại                               ║\n" +
                    "║                                                                  ║\n" +
                    "╚══════════════════════════════════════════════════════════════════╝\n");
            System.out.print("Chọn\t➨ ");
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
            }
            switch (choice) {
                case 1:
                    addFootballer();
                    break;
                case 2:
                    addCoach();
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

    public static void addFootballer() {
        try {
            int staffID;
            Random r = new Random();
            int low = 1;
            int high = 9999;
            do {
                staffID = r.nextInt(high - low) + low;
            } while (footballerServiceImpl.exists(staffID));

            System.out.println("Nhập mã nhân viên (Ví dụ: HLV02 hoặc CT273): ");
            System.out.print("➨ ");
            String maNhanvien = scanner.nextLine().trim();
            while (!ValidationUtils.isCT(maNhanvien)) {
                System.out.println("Mã nhân viên " + maNhanvien + " chưa hợp lệ. Vui lòng nhập lại!\n" +
                        "Mã nhân viên phải bắt đầu bằng chữ in hoa CT. (Ví dụ: CTV02 hoặc CT273)");
                maNhanvien = scanner.nextLine();
            }
            while (footballerServiceImpl.existsbyIDStaff(maNhanvien)) {
                System.out.println("Mã nhân viên đã tồn tại, xin vui lòng nhập lại!");
                maNhanvien = scanner.nextLine();
                System.out.print("➨ ");
            }

            System.out.println("Nhập họ và tên: (Ví dụ: Huỳnh Phương Ngân) ");
            System.out.print("➨ ");
            String ten = scanner.nextLine().trim();
            String namecheck;
            namecheck = ConvertUtils.removeAccent(ten);
            while (!ValidationUtils.isNameValid(namecheck)) {
                System.out.println("Tên " + namecheck + " không đúng." + " Vui lòng nhập lại!" + " (Tên phải viết hoa chữ cái đầu)");
                System.out.println("Nhập tên (Ví dụ: Huỳnh Phương Ngân) ");
                System.out.print("➨ ");
                ten = scanner.nextLine().trim();
            }
            System.out.println("Nhập quốc tịch (Ví dụ: Viet Nam) ");
            System.out.print("➨ ");
            String quocTich;
            while (!ValidationUtils.isNameValid(quocTich = scanner.nextLine().trim())) {
                System.out.println("Nhập sai. Vui lòng nhập lại! \n" +
                        "Lưu ý: Tên phải viết hoa chữ cái đầu và không dấu");
                System.out.println("Nhập quốc tịch (vd: Viet Nam) ");
                System.out.print("➨ ");
                ten = scanner.nextLine();
            }
            System.out.println("Nhập giới tính (Ví dụ: Nam hoặc Nữ) ");
            System.out.print("➨ ");
            String gioiTinh = scanner.nextLine();
            while (!ValidationUtils.isGioitinh(gioiTinh)) {
                System.out.println("Giới tính " + gioiTinh + " không đúng." + " Vui lòng nhập lại!" + " (Tên phải viết hoa chữ cái đầu và có dấu)");
                System.out.println("Nhập giới tính (ví dụ: Nam hoặc Nữ");
                System.out.print("➨ ");
                gioiTinh = scanner.nextLine();
            }
            System.out.println("Nhập ngày sinh (Ví dụ: 27-03-1996)");
            System.out.print("➨ ");
            String ngaySinh = scanner.nextLine().trim();
            if (!ValidationUtils.isDateValid(ngaySinh) || !DateUtils.isDateToString(ngaySinh)) {
                System.out.println("Ngày không hợp lệ. Xin vui lòng nhập lại!");
                System.out.print("➨ ");
                ngaySinh =scanner.nextLine().trim();
            }
            Date ngaySinhHopLe = new SimpleDateFormat("dd-MM-yyyy").parse(ngaySinh);

            System.out.println("Nhập ngày vào làm (Ví dụ: 27-03-1996)");
            System.out.print("➨ ");
            String ngayVaoLam = scanner.nextLine().trim();
            if (!ValidationUtils.isDateValid(ngayVaoLam) || !DateUtils.isDateToString(ngayVaoLam)) {
                System.out.println("Nhập không hợp lệ. Xin vui lòng nhập lại!");
                System.out.print("➨ ");
                ngayVaoLam =scanner.nextLine().trim();
            }
            Date ngayVaoLamHopLe = new SimpleDateFormat("dd-MM-yyyy").parse(ngayVaoLam);

            System.out.println("Nhập vị trí thi đấu: (Ví dụ: Cầu thủ) ");
            System.out.print("➨ ");
            String viTriThiDau = scanner.nextLine().trim();
            namecheck = ConvertUtils.removeAccent(viTriThiDau);
            while (!ValidationUtils.isNameValid(namecheck)) {
                System.out.println("Vị trí " + namecheck + " không đúng." + " Vui lòng nhập lại!" + " (Vị trí phải viết hoa chữ cái đầu)");
                System.out.println("Nhập tên: (Ví dụ: Thủ môn) ");
                System.out.print("➨ ");
                viTriThiDau = scanner.nextLine();
            }

            System.out.println("Số trận đã thi đấu: ");
            int soLuotTranThamGia;
            do {
                soLuotTranThamGia = Integer.parseInt(scanner.nextLine());
                if (!(soLuotTranThamGia >= 0)) {
                    System.out.println("! ERROR ! \n" +
                            " \t Xin vui lòng nhập lại! \n ➨ \t ");
                    System.out.print("➨ \t ");
                }
            } while (!(soLuotTranThamGia >= 0));

            System.out.println("Số lượt ghi bàn thắng: ");
            int banThang;
            do {
                banThang = Integer.parseInt(scanner.nextLine());
                if (!(banThang >= 0)) {
                    System.out.println("! ERROR ! \n" +
                            " \t Xin vui lòng nhập lại! \n ➨ \t ");
                    System.out.print("➨ \t ");
                }
            } while (!(banThang >= 0));


            System.out.println("Nhập lương thỏa thuận: ");
            System.out.print("➨ ");
            double luongThoaThuan;
            do {
                luongThoaThuan = Double.parseDouble(scanner.nextLine());
                if (!(luongThoaThuan > 0)) {
                    System.out.println("! ERROR ! \n" +
                            " \t Xin vui lòng nhập lại! \n ➨ \t ");
                    System.out.print("➨ \t ");
                    luongThoaThuan = Double.parseDouble(scanner.nextLine());
                }
            } while (!(luongThoaThuan > 0));

            Footballer footballer = new Footballer(staffID, maNhanvien, ten, quocTich, gioiTinh, ngaySinhHopLe, ngayVaoLamHopLe,
                    viTriThiDau, soLuotTranThamGia, banThang, luongThoaThuan);
            footballerServiceImpl.addFootballerItem(footballer);
            System.out.println("Cầu thủ đã được thêm vào danh sách!");

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
                        addFootballer();
                        break;
                    case "c":
                        FootballView.create();
                        break;
                    case "p":
                        showFootballerInfo(footballer);
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


    public static void showFootballerInfo(Footballer footballer) {
        List<Footballer> footballerList = footballerServiceImpl.getFootballerItem();
        try {
            System.out.println("════════════════════════════════════════════════════ DANH SÁCH CẦU THỦ ════════════════════════════════════════════════════════════════");
                System.out.printf("%-12s %-10s %-20s %-20s %-20s %-20s %-20s %-20s\n",
                        "Thông tin cá nhân: \n", "ID", "Mã nhân viên", "Họ và tên", "Quốc tịch", "Giới tính", "Ngày sinh", "Ngày vào làm");
                System.out.printf("%-11s %-13s %17s %18s %15s %27s %20s\n", footballer.getStaffID(), footballer.getMaNhanvien(), footballer.getTen(), footballer.getQuocTich(), footballer.getGioiTinh(), DateUtils.dateToString(footballer.getNgaySinh(), DateUtils.DATE_PATTERN), DateUtils.dateToString(footballer.getNgayVaoLam(), DateUtils.DATE_PATTERN));

                System.out.printf("%-12s %-31s %-20s %-30s %-27s %-15s\n",
                        "Thông tin thi đấu:\n", "Số bàn thắng ghi vào lưới", "Vị trí thi đấu", "Lượt tham gia thi đấu", "Lương thỏa thuận", "Lương thực nhận");
                System.out.printf("%3s %36s %15s %42s %27s\n", footballer.getBanThang(),
                        footballer.getViTriThiDau(), footballer.getSoLuotTranThamGia(), format.format(footballer.getLuongThoaThuan()), format.format(footballer.tinhLuong()));
                System.out.println("═══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════");


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
                        AddView.add();
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


    public static void addCoach() {

        try {
            int staffID;
            Random r = new Random();
            int low = 1;
            int high = 9999;
            do {
                staffID = r.nextInt(high - low) + low;
            } while (coachServiceImpl.exists(staffID));

            System.out.println("Nhập mã nhân viên (Ví dụ: HLV02 hoặc CT273): ");
            System.out.print("➨ ");
            String maNhanvien = scanner.nextLine().trim();
            while (!ValidationUtils.isHLV(maNhanvien)) {
                System.out.println("Mã nhân viên " + maNhanvien + " chưa hợp lệ. Vui lòng nhập lại!\n" +
                        "Mã nhân viên phải bắt đầu bằng chữ in hoa HLV. (Ví dụ: HLV02 hoặc HLV273)");
                maNhanvien = scanner.nextLine();
            }
            while (coachServiceImpl.existsbyIDStaff(maNhanvien)) {
                System.out.println("Mã nhân viên đã tồn tại, xin vui lòng nhập lại!");
                maNhanvien = scanner.nextLine();
                System.out.print("➨ ");
            }

            System.out.println("Nhập họ và tên: (Ví dụ: Huỳnh Phương Ngân) ");
            System.out.print("➨ ");
            String ten = scanner.nextLine().trim();
            String namecheck;
            namecheck = ConvertUtils.removeAccent(ten);
            while (!ValidationUtils.isNameValid(namecheck)) {
                System.out.println("Tên " + namecheck + " không đúng." + " Vui lòng nhập lại!" + " (Tên phải viết hoa chữ cái đầu)");
                System.out.println("Nhập tên (Ví dụ: Huỳnh Phương Ngân) ");
                System.out.print("➨ ");
                ten = scanner.nextLine().trim();
                System.out.print("➨ ");
            }
            System.out.println("Nhập quốc tịch (Ví dụ: Viet Nam) ");
            System.out.print("➨ ");
            String quocTich = scanner.nextLine().trim();
            while (!ValidationUtils.isNameValid(quocTich)) {
                System.out.println("Nhập sai. Vui lòng nhập lại! \n" +
                        "Lưu ý: Tên phải viết hoa chữ cái đầu và không dấu");
                System.out.print("Nhập quốc tịch (vd: Viet Nam) ");
                System.out.print("➨ ");
                ten = scanner.nextLine();
            }
            System.out.println("Nhập giới tính (Ví dụ: Nam hoặc Nữ) ");
            System.out.print("➨ ");
            String gioiTinh = scanner.nextLine();
            while (!ValidationUtils.isGioitinh(gioiTinh)) {
                System.out.println("Giới tính " + gioiTinh + " không đúng." + " Vui lòng nhập lại!" + " (Tên phải viết hoa chữ cái đầu và có dấu)");
                System.out.println("Nhập giới tính (ví dụ: Nam hoặc Nữ");
                System.out.println("➨ ");
                gioiTinh = scanner.nextLine();
            }
//
            System.out.println("Nhập ngày sinh (Ví dụ: 27-03-1996)");
            System.out.print("➨ ");
            String ngaySinh = scanner.nextLine().trim();
            if (!ValidationUtils.isDateValid(ngaySinh) || !DateUtils.isDateToString(ngaySinh)) {
                System.out.println("Ngày không hợp lệ. Xin vui lòng nhập lại!");
                System.out.println("➨ ");
                ngaySinh =scanner.nextLine().trim();
            }
            Date ngaySinhHopLe = new SimpleDateFormat("dd-MM-yyyy").parse(ngaySinh);

            System.out.println("Nhập ngày vào làm (Ví dụ: 27-03-1996)");
            System.out.print("➨ ");
            String ngayVaoLam = scanner.nextLine().trim();
            if (!ValidationUtils.isDateValid(ngayVaoLam) || !DateUtils.isDateToString(ngayVaoLam)) {
                System.out.println("Nhập không hợp lệ. Xin vui lòng nhập lại!");
                System.out.print("➨ ");
                ngayVaoLam =scanner.nextLine().trim();
            }
            Date ngayVaoLamHopLe = new SimpleDateFormat("dd-MM-yyyy").parse(ngayVaoLam);

            System.out.println("Số năm kinh nghiệm: ");
            System.out.print("➨ ");
            int soNamKinhNghiem;
            do {
                soNamKinhNghiem = Integer.parseInt(scanner.nextLine());
                if (!(soNamKinhNghiem >= 0)) {
                    System.out.println("Nhập sai. Xin vui lòng nhập lại!");
                    System.out.print("➨ \t ");
                }
            } while (!(soNamKinhNghiem >= 0));


            System.out.println("Hệ số lương cơ bản: ");
            System.out.printf("➨ ");
            double heSoLuong;
            do {
                heSoLuong = Double.parseDouble(scanner.nextLine());
                if (!(heSoLuong > 0)) {
                    System.out.print("Nhập sai. Xin vui lòng nhập lại!");
                    heSoLuong = Double.parseDouble(scanner.nextLine());
                }
            } while (!(heSoLuong > 0));

            System.out.println("Phụ cấp được nhận: ");
            System.out.printf("➨ ");
            double phuCap;
            do {
                phuCap = Double.parseDouble(scanner.nextLine());
                if (!(phuCap > 0)) {
                    System.out.println("! ERROR ! \n" +
                            " \t Xin vui lòng nhập lại! \n ➨ \t ");
                    System.out.print("➨ \t ");
                    phuCap = Double.parseDouble(scanner.nextLine());
                }
            } while (!(phuCap > 0));


            Coach coach = new Coach(staffID, maNhanvien, ten, quocTich, gioiTinh, ngaySinhHopLe, ngayVaoLamHopLe,
                    soNamKinhNghiem, heSoLuong, phuCap);
            coachServiceImpl.addCoachItem(coach);
            System.out.println("Huấn luyện viên đã được thêm vào danh sách!");
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
                System.out.print(" ➨ ");
                String choice = scanner.nextLine();
                switch (choice) {
                    case "y":
                        addCoach();
                        break;
                    case "c":
                        FootballView.create();
                        break;
                    case "p":
                        showCoachInfo(coach);
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
            System.out.println("Nhập sai. Xin vui lòng nhập lại!");

        }
    }

    public static void showCoachInfo(Coach coach) {
        try {
            System.out.println("════════════════════════════════════════════════════ DANH SÁCH HUẤN LUYỆN VIÊN ═══════════════════════════════════════════════════════");
                System.out.printf("%-12s %-10s %-20s %-20s %-20s %-20s %-20s %-20s\n",
                        "Thông tin cá nhân: \n", "ID", "Mã nhân viên", "Họ và tên", "Quốc tịch", "Giới tính", "Ngày sinh", "Ngày vào làm");
                System.out.printf("%-11s %-13s %17s %18s %15s %27s %20s\n", coach.getStaffID(), coach.getMaNhanvien(), coach.getTen(), coach.getQuocTich(), coach.getGioiTinh(), DateUtils.dateToString(coach.getNgaySinh(), DateUtils.DATE_PATTERN), DateUtils.dateToString(coach.getNgayVaoLam(), DateUtils.DATE_PATTERN));

                System.out.printf("%-12s %-31s %-20s %-20s %-27s\n",
                        "Kinh nghiệm làm việc:\n", "Số năm kinh nghiệm", "Hệ số lương", "Lương phụ cấp", "Lương thực nhận");
                System.out.printf("%3s %32s %30s %21s\n", coach.getSoNamKinhNghiem(),
                        coach.getHeSoLuong(), format.format(coach.getPhuCap()), format.format(coach.tinhLuong()));
                System.out.println("═══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════");


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
                        AddView.add();
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

