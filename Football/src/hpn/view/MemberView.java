package hpn.view;

import hpn.utils.AppUtils;
import hpn.view.ManagerFootball.SearchView;
import hpn.view.ManagerFootball.ShowView;
import hpn.view.ManagerFootball.SortView.SortView;
import hpn.view.ManagerSchedule.PlayerPrice;
import hpn.view.ManagerSchedule.ResultsView;
import hpn.view.ManagerSchedule.ShowScheduleView;

import java.util.Scanner;

public class MemberView {
    public static void launch() {
        int option;
        do {
            System.out.print("╔═══════════════════════════════════════════════════════════════════════════════════╗\n" +
                    "║                                                                                   ║\n" +
                    "║                            USER MENU                                              ║\n" +
                    "║                                                                                   ║\n" +
                    "║                   [1] Hiển thị danh sách đội bóng                                 ║\n" +
                    "║                   [2] Tìm kiếm nhân viên đội bóng                                 ║\n" +
                    "║                   [3] Hiển thị sắp xếp nhân viên đội bóng                         ║\n" +
                    "║                   [4] Xem lịch thi đấu                                            ║\n" +
                    "║                   [5] Xem kết quả thi đấu                                         ║\n" +
                    "║                   [6] Bảng giá chuyển nhượng cầu thủ                              ║\n" +
                    "║                   [0] Thoát                                                       ║\n" +
                    "║                                                                                   ║\n" +
                    "╚═══════════════════════════════════════════════════════════════════════════════════╝\n");
            Scanner scanner = new Scanner(System.in);
            System.out.println("\nChọn chức năng: ");
            option = AppUtils.retryChoose(0,6);
            switch (option) {
                case 1:
                    ShowView.show();
                    break;
                case 2:
                    SearchView.timKiemNhanVien();
                    break;
                case 3:
                    SortView.hienThiSapXep();
                    break;
                case 4:
                    ShowScheduleView.showSchedule();
                    break;
                case 5:
                    ResultsView.results();
                    break;
                case 6:
                    PlayerPrice.playerPrice();
                    break;
                case 0:
                    AppUtils.exit();
                    break;
                default:
                    System.err.println("Chọn chức năng không đúng! Vui lòng chọn lại");
                    launch();
            }
        } while (true);
    }
}
