package hpn.view.ManagerFootball.SortView;

import hpn.model.Footballer;
import hpn.service.Impl.FootballerServiceImpl;
import hpn.sort.sortFootballer.*;

import java.util.List;
import java.util.Scanner;

import static hpn.view.ManagerFootball.EditView.showFootballer;

public class SortFootballer {
    static Scanner scanner = new Scanner(System.in);
    static FootballerServiceImpl footballerService = new FootballerServiceImpl();
    static List<Footballer> footballerList;

    public SortFootballer() {
        footballerList = footballerService.getFootballerItem();
    }

    public static void sortFootballer() {
        System.out.print("╔══════════════════════════════════════════════════════════════════╗\n" +
                "║                                                                  ║\n" +
                "║                     HIỂN THỊ SẮP XẾP CẦU THỦ                     ║\n" +
                "║                                                                  ║\n" +
                "║            [1] Hiển thị sắp xếp theo vị trí thi đấu              ║\n" +
                "║            [2] Hiển thị sắp xếp theo lượt tham gia thi đấu       ║\n" +
                "║            [3] Hiển thị sắp xếp theo lượt ghi bàn thắng          ║\n" +
                "║            [4] Hiển thị sắp xếp theo lương thỏa thuận            ║\n" +
                "║            [2] Quay lại                                          ║\n" +
                "║            [0] Quay về menu                                      ║\n" +
                "║                                                                  ║\n" +
                "╚══════════════════════════════════════════════════════════════════╝\n");
        System.out.print("➨ \t");
    }

    public static void optionFootballer() {
        boolean flag = true;
        int choice;
        do {
            sortFootballer();
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    sortViTriThiDau();
                    break;
                case 2:
                    sortLuotThamGia();
                    break;
                case 3:
                    sortBanThang();
                    break;
                case 4:
                    sortLuongThoaThuan();
                    break;
                case 5:
                    SortFootballer.sortFootballer();
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

    public static void sortLuongThoaThuan() {
        boolean flag = true;
        int choice;
        do {
            System.out.print("╔══════════════════════════════════════════════════════════════════╗\n" +
                    "║                                                                  ║\n" +
                    "║                    SẮP XẾP THEO LƯƠNG THỎA THUẬN                 ║\n" +
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
                        List<Footballer> footballerList = footballerService.getFootballerItem();
                        System.out.println("Sắp xếp mức lương thỏa thuận theo thứ tự tăng dần");
                        LuongThoaThuanASC luongThoaThuanASC = new LuongThoaThuanASC();
                        footballerList.sort(luongThoaThuanASC);
                        showFootballer(footballerList);
                        optionFootballer();
                        break;
                    case 2:
                        List<Footballer> footballersList = footballerService.getFootballerItem();
                        System.out.println("Sắp xếp mức lương thỏa thuận theo thứ tự giảm dần");
                        LuongThoaThuanESC luongThoaThuanESC = new LuongThoaThuanESC();
                        footballersList.sort(luongThoaThuanESC);
                        showFootballer(footballersList);
                        optionFootballer();
                        break;
                    case 0:
                        SortFootballer.sortFootballer();
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

    public static void sortBanThang() {
        boolean flag = true;
        int choice;
        do {
            System.out.print("╔══════════════════════════════════════════════════════════════════╗\n" +
                    "║                                                                  ║\n" +
                    "║                  SẮP XẾP THEO LƯỢT GHI BÀN THẮNG                 ║\n" +
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
                        List<Footballer> footballerList = footballerService.getFootballerItem();
                        System.out.println("Sắp xếp lượt ghi bàn thắng theo thứ tự tăng dần");
                        BanThangASC banThangASC = new BanThangASC();
                        footballerList.sort(banThangASC);
                        showFootballer(footballerList);
                        optionFootballer();
                        break;
                    case 2:
                        List<Footballer> footballersList = footballerService.getFootballerItem();
                        System.out.println("Sắp xếp lượt ghi bàn thắng theo thứ tự giảm dần");
                        BanThangESC banThangESC = new BanThangESC();
                        footballersList.sort(banThangESC);
                        showFootballer(footballersList);
                        optionFootballer();
                        break;
                    case 0:
                        SortFootballer.sortFootballer();
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

    public static void sortLuotThamGia() {
        boolean flag = true;
        int choice;
        do {
            System.out.print("╔══════════════════════════════════════════════════════════════════╗\n" +
                    "║                                                                  ║\n" +
                    "║                  SẮP XẾP THEO LƯỢT THAM GIA THI ĐẤU              ║\n" +
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
                        List<Footballer> footballerList = footballerService.getFootballerItem();
                        System.out.println("Sắp xếp lượt tham gia thi đấu theo thứ tự tăng dần");
                        SoLuotTranThamGiaASC soLuotTranThamGiaASC = new SoLuotTranThamGiaASC();
                        footballerList.sort(soLuotTranThamGiaASC);
                        showFootballer(footballerList);
                        optionFootballer();
                        break;
                    case 2:
                        List<Footballer> footballersList = footballerService.getFootballerItem();
                        System.out.println("Sắp xếp lượt tham gia thi đấu theo thứ tự giảm dần");
                        SoLuotTranThamGiaESC soLuotTranThamGiaESC = new SoLuotTranThamGiaESC();
                        footballersList.sort(soLuotTranThamGiaESC);
                        showFootballer(footballersList);
                        optionFootballer();
                        break;
                    case 0:
                        SortFootballer.sortFootballer();
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

    public static void sortViTriThiDau() {
        boolean flag = true;
        int choice;
        do {
            System.out.print("╔══════════════════════════════════════════════════════════════════╗\n" +
                    "║                                                                  ║\n" +
                    "║                    SẮP XẾP THEO VỊ TRÍ THI ĐẤU                   ║\n" +
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
                        List<Footballer> footballerList = footballerService.getFootballerItem();
                        System.out.println("Sắp xếp theo vị trí tăng dần");
                        ViTriThiDauASC viTriThiDauASC = new ViTriThiDauASC();
                        footballerList.sort(viTriThiDauASC);
                        showFootballer(footballerList);
                        optionFootballer();
                        break;
                    case 2:
                        List<Footballer> footballersList = footballerService.getFootballerItem();
                        System.out.println("Sắp xếp theo vị trí giảm dần");
                        ViTriThiDauESC viTriThiDauESC = new ViTriThiDauESC();
                        footballersList.sort(viTriThiDauESC);
                        showFootballer(footballersList);
                        optionFootballer();
                        break;
                    case 0:
                        SortFootballer.sortFootballer();
                        break;
                    default:
                        System.out.println("Chọn lại !");
                        flag = false;
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } while (!flag);

    }
}
