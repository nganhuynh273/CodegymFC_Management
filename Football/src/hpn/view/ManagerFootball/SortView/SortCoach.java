package hpn.view.ManagerFootball.SortView;

import hpn.model.Coach;
import hpn.service.Impl.CoachServiceImpl;
import hpn.sort.sortCoach.*;

import java.util.List;
import java.util.Scanner;

import static hpn.view.ManagerFootball.EditView.showCoach;
import static hpn.view.ManagerFootball.EditView.showFootballer;
import static hpn.view.ManagerFootball.ShowView.showCoachs;


public class SortCoach {
    static Scanner scanner = new Scanner(System.in);
    static CoachServiceImpl coachService = new CoachServiceImpl();
    static List<Coach> coachList;

    public SortCoach() {
        coachList = coachService.getCoachItem();
    }

    public static void sortCoach() {
        System.out.print("╔══════════════════════════════════════════════════════════════════╗\n" +
                "║                                                                  ║\n" +
                "║                  HIỂN THỊ SẮP XẾP HUẤN LUYỆN VIÊN                ║\n" +
                "║                                                                  ║\n" +
                "║            [1] Hiển thị sắp xếp theo số năm kinh nghiệm          ║\n" +
                "║            [2] Hiển thị sắp xếp theo hệ số lương                 ║\n" +
                "║            [3] Hiển thị sắp xếp theo lương phụ cấp               ║\n" +
                "║            [4] Quay lại                                          ║\n" +
                "║            [0] Quay về menu                                      ║\n" +
                "║                                                                  ║\n" +
                "╚══════════════════════════════════════════════════════════════════╝\n");
        System.out.print("➨ \t");
    }

    public static void optionCoach() {
        boolean flag = true;
        int choice;
        do {
            sortCoach();
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    sortSoNamKInhNghiem();
                    break;
                case 2:
                    sortHeSoLuong();
                    break;
                case 3:
                    sortPhuCap();
                    break;
                case 4:
                    SortCoach.sortCoach();
                    break;
                case 0:
                    SortView.hienThiSapXep();
                    break;
                default:
                    System.out.println("Không hợp lệ, vui lòng nhập lại");
                    flag = false;
            }
        } while (!flag);
    }

    public static void sortPhuCap() {
        boolean flag = true;
        int choice;
        do {
            System.out.print("╔══════════════════════════════════════════════════════════════════╗\n" +
                    "║                                                                  ║\n" +
                    "║                    SẮP XẾP THEO LƯƠNG PHỤ CẤP                    ║\n" +
                    "║                                                                  ║\n" +
                    "║            [1] Theo thứ tự từ tăng dần                           ║\n" +
                    "║            [2] Theo thứ tự từ giảm dần                           ║\n" +
                    "║            [0] Quay lại                                          ║\n" +
                    "║                                                                  ║\n" +
                    "╚══════════════════════════════════════════════════════════════════╝\n");
            System.out.print("➨ \t");
            try {
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:

                        List<Coach> coachList = coachService.getCoachItem();
                        System.out.println("Sắp xếp mức lương phụ cấp theo thứ tự tăng dần");
                        PhuCapASC phuCapASC = new PhuCapASC();
                        coachList.sort(phuCapASC);
                        showCoach(coachList);
                        optionCoach();
                        break;
                    case 2:
                        List<Coach> coachsList = coachService.getCoachItem();
                        System.out.println("Sắp xếp mức lương thỏa thuận theo thứ tự giảm dần");
                        PhuCapESC phuCapESC = new PhuCapESC();
                        coachsList.sort(phuCapESC);
                        showCoach(coachsList);
                        optionCoach();
                        break;
                    case 0:
                        SortCoach.sortCoach();
                        break;
                    default:
                        System.out.println("Chọn lại!");
                        flag = false;
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } while (!flag);
    }

    public static void sortHeSoLuong() {
        boolean flag = true;
        int choice;
        do {
            System.out.print("╔══════════════════════════════════════════════════════════════════╗\n" +
                    "║                                                                  ║\n" +
                    "║                    SẮP XẾP THEO HỆ SỐ LƯƠNG                      ║\n" +
                    "║                                                                  ║\n" +
                    "║            [1] Theo thứ tự từ tăng dần                           ║\n" +
                    "║            [2] Theo thứ tự từ giảm dần                           ║\n" +
                    "║            [0] Quay lại                                          ║\n" +
                    "║                                                                  ║\n" +
                    "╚══════════════════════════════════════════════════════════════════╝\n");
            System.out.print("➨ \t");
            try {
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:

                        List<Coach> coachList = coachService.getCoachItem();
                        System.out.println("Sắp xếp hệ số lương theo thứ tự tăng dần");
                        HeSoLuongASC heSoLuongASC = new HeSoLuongASC();
                        coachList.sort(heSoLuongASC);
                        showCoach(coachList);
                        optionCoach();
                        break;
                    case 2:
                        List<Coach> coachsList = coachService.getCoachItem();
                        System.out.println("Sắp xếp hệ số lương theo thứ tự giảm dần");
                        HeSoLuongESC heSoLuongESC = new HeSoLuongESC();
                        coachsList.sort(heSoLuongESC);
                        showCoach(coachsList);
                        optionCoach();
                        break;
                    case 0:
                        SortCoach.sortCoach();
                        break;
                    default:
                        System.out.println("Chọn lại!");
                        flag = false;
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } while (!flag);
    }

    public static void sortSoNamKInhNghiem() {
        boolean flag = true;
        int choice;
        do {
            System.out.print("╔══════════════════════════════════════════════════════════════════╗\n" +
                    "║                                                                  ║\n" +
                    "║                    SẮP XẾP THEO SỐ NĂM KINH NGHIỆM               ║\n" +
                    "║                                                                  ║\n" +
                    "║            [1] Theo thứ tự từ tăng dần                           ║\n" +
                    "║            [2] Theo thứ tự từ giảm dần                           ║\n" +
                    "║            [0] Quay lại                                          ║\n" +
                    "║                                                                  ║\n" +
                    "╚══════════════════════════════════════════════════════════════════╝\n");
            System.out.print("➨ \t");
            try {
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:

                        List<Coach> coachList = coachService.getCoachItem();
                        System.out.println("Sắp xếp số năm kinh nghiệm theo thứ tự tăng dần");
                        SoNamKinhNghiemASC soNamKinhNghiemASC = new SoNamKinhNghiemASC();
                        coachList.sort(soNamKinhNghiemASC);
                        showCoach(coachList);
                        optionCoach();
                        break;
                    case 2:
                        List<Coach> coachsList = coachService.getCoachItem();
                        System.out.println("Sắp xếp số năm kinh nghiệm theo thứ tự giảm dần");
                        SoNamKinhNghiemESC soNamKinhNghiemESC = new SoNamKinhNghiemESC();
                        coachsList.sort(soNamKinhNghiemESC);
                        showCoach(coachsList);
                        optionCoach();
                        break;
                    case 0:
                        SortCoach.sortCoach();
                        break;
                    default:
                        System.out.println("Chọn lại!");
                        flag = false;
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } while (!flag);
    }

}
