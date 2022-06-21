package hpn.view.ManagerFootball;

import hpn.view.ManagerFootball.SortView.SortView;
import hpn.view.Menu;

import java.util.Scanner;

public class FootballView {
private static Scanner scanner = new Scanner(System.in);

public static void create() {
    Menu.ManagerFootball();
    FootballView footballView = new FootballView();
    System.out.println("Chọn chức năng \n ➨ ");
    try {
        int choice = Integer.parseInt(scanner.nextLine());
        boolean flag = true;
        do {
            switch (choice) {
                case 1:
                    ShowView.show();
                    break;
                case 2:
                    AddView.add();
                    break;
                case 3:
                    EditView.suaNhanVien();
                    break;
                case 4:
                    RemoveView.xoaNhanVien();
                    break;
                case 5:
                    SearchView.timKiemNhanVien();
                    break;
                case 6:
                    SortView.hienThiSapXep();
                    break;
//                case 7:
//                    InputView.nhapDuLieuTuDong();
//                    break;
                case 7:
                    Menu.startMenu();
                    break;
                case 0:
                    Menu.exit();
                    System.exit(0);
                default:
                    System.out.println("Không hợp lệ, xin vui lòng nhập lại");
                    flag = false;
            }
        } while (!flag);
    } catch (Exception ex) {
        ex.printStackTrace();
    }
}
}
