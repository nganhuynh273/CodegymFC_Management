package hpn.view.ManagerFootball.SortView;

import hpn.view.ManagerFootball.FootballView;

import java.util.Scanner;

public class SortView {
    static Scanner scanner = new Scanner(System.in);
    public static void hienThiSapXep() {
        boolean isChoice = true;
        int choice = -1;
        do {
            System.out.print("╔══════════════════════════════════════════════════════════════════╗\n" +
                    "║                                                                  ║\n" +
                    "║                  HIỂN THỊ SẮP XẾP NHÂN VIÊN                      ║\n" +
                    "║                                                                  ║\n" +
                    "║            [1] Hiển thị sắp xếp thông tin Cầu thủ                ║\n" +
                    "║            [2] Hiển thị sắp xếp thông tin Huấn luyện viên        ║\n" +
                    "║            0] Quay lại                                           ║\n" +
                    "║                                                                  ║\n" +
                    "╚══════════════════════════════════════════════════════════════════╝\n");

            System.out.print("Chọn\t➨ ");
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
            }
            switch (choice) {
                case 1:
                    SortFootballer.optionFootballer();
                    break;
                case 2:
                    SortCoach.optionCoach();
                    break;
                case 0:
                    FootballView.create();
                    isChoice = false;
                    break;
                default:
                    System.out.println("Chưa hợp lệ! Xin vui lòng nhập lại!");
            }
        } while (!isChoice);
    }
}
