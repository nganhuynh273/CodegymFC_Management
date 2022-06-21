package hpn.view.ManagerFootball;

import hpn.model.Coach;
import hpn.model.Footballer;
import hpn.service.Impl.CoachServiceImpl;
import hpn.service.Impl.FootballerServiceImpl;
import hpn.view.Menu;

import java.util.List;
import java.util.Scanner;

import static hpn.view.ManagerFootball.EditView.showCoach;
import static hpn.view.ManagerFootball.EditView.showFootballer;



public class RemoveView {
    static Scanner scanner = new Scanner(System.in);
    static CoachServiceImpl coachServiceImpl = new CoachServiceImpl();
    static FootballerServiceImpl footballerServiceImpl = new FootballerServiceImpl();

    public static void xoaNhanVien() {
        boolean isChoice = true;
        int choice = -1;
        do {
            String leftAlignFormat = "| %-2s | %-50s | %n";
            String line = "+----+----------------------------------------------------+%n";
            System.out.format(line);
            System.out.format("| #  | XÓA THÔNG TIN NHÂN VIÊN                                         |%n");
            System.out.format(line);
            System.out.format(leftAlignFormat, 1, "Xóa thông tin Cầu thủ");
            System.out.format(leftAlignFormat, 2, "Xóa thông tin Huấn luyện viên");
            System.out.format(leftAlignFormat, 0, "Quay lại");
            System.out.format(line);
            System.out.print("Chọn\t➨ ");
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
            }
            switch (choice) {
                case 1:
                    removeFootballer();
                    break;
                case 2:
                    removeCoach();
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

    public static void removeCoach() {
//        List<Coach> coachList = coachServiceImpl.getCoachItem();
        showCoach(coachServiceImpl.getCoachItem());
        System.out.printf("Nhập ID sản phẩm \n➨ ");
        int staffID = Integer.parseInt(scanner.nextLine());
        Coach coach = coachServiceImpl.getStaffByID(staffID);
        if (coach != null) {
            boolean check = true;
            Menu.removeConfirm();
            String chon = scanner.nextLine();
            try {
                switch (chon) {
                    case "y":
                        coachServiceImpl.removeCoach(coach.getStaffID());
                        System.out.println("Đã xóa thành công Huấn luyện viên khỏi danh sách!");
                        showCoach(coachServiceImpl.getCoachItem());
                        do {
                            System.out.println("❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂");
                            System.out.println("❂   Nhấn '1' để quay lại           ❂");
                            System.out.println("❂   Nhấn '2' để quay lại menu      ❂");
                            System.out.println("❂   Nhấn '3' để về menu chính      ❂");
                            System.out.println("❂   Nhấn '0' để thoát              ❂");
                            System.out.println("❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂");
                            System.out.printf("➨ \t");
                            byte choice = Byte.parseByte(scanner.nextLine());
                            switch (choice) {
                                case 1:
                                    xoaNhanVien();
                                    break;
                                case 2:
                                    FootballView.create();
                                    break;
                                case 3:
                                    Menu.startMenu();
                                    break;
                                case 0:
                                    Menu.exit();
                                    System.exit(0);
                                default:
                                    System.out.println("Mời nhập lại");
                                    check = false;
                            }
                        } while (!check);
                        break;
                    case "c":
                        FootballView.create();
                        break;
                    default:
                        System.out.println("Vui lòng nhập lại!");
                }
            } catch (Exception e) {
                System.out.println("Không hợp lệ. Vui lòng nhập lại");
            }
        }
    }




    public static void removeFootballer() {

        showFootballer(footballerServiceImpl.getFootballerItem());
        System.out.printf("Nhập ID Cầu thủ \n➨ ");
        int staffID = Integer.parseInt(scanner.nextLine());
        Footballer footballer = footballerServiceImpl.getStaffByID(staffID);
        if (footballer != null) {
            boolean check = true;
            Menu.removeConfirm();
            String chon = scanner.nextLine();
            try {
                switch (chon) {
                    case "y":
                        footballerServiceImpl.removeFootballer(footballer.getStaffID());
                        System.out.println("Đã xóa thành công Cầu thủ khỏi danh sách!");
                        showFootballer(footballerServiceImpl.getFootballerItem());
                        do {
                            System.out.println("❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂");
                            System.out.println("❂   Nhấn '1' để quay lại           ❂");
                            System.out.println("❂   Nhấn '2' để quay lại menu      ❂");
                            System.out.println("❂   Nhấn '3' để về menu chính      ❂");
                            System.out.println("❂   Nhấn '0' để thoát              ❂");
                            System.out.println("❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂❂");
                            System.out.printf("➨ \t");
                            byte choice = Byte.parseByte(scanner.nextLine());
                            switch (choice) {
                                case 1:
                                    xoaNhanVien();
                                    break;
                                case 2:
                                    FootballView.create();
                                    break;
                                case 3:
                                    Menu.startMenu();
                                    break;
                                case 0:
                                    Menu.exit();
                                    System.exit(0);
                                default:
                                    System.out.println("Mời nhập lại");
                                    check = false;
                            }
                        } while (!check);
                        break;
                    case "c":
                        FootballView.create();
                        break;
                    default:
                        System.out.println("Vui lòng nhập lại!");
                }
            } catch (Exception e) {
                System.out.println("Không hợp lệ. Vui lòng nhập lại");
            }
        }
    }
}

