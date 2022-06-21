//package hpn.view.ManagerFootball;
//
//import hpn.model.Coach;
//import hpn.model.Footballer;
//import hpn.model.Staff;
//import hpn.service.Impl.CoachServiceImpl;
//import hpn.service.Impl.FootballerServiceImpl;
//import hpn.utils.DateUtils;
//
//import java.text.DecimalFormat;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import java.util.Scanner;
//
//public class InputView {
//    static Scanner scanner = new Scanner(System.in);
//    static CoachServiceImpl coachServiceImpl = new CoachServiceImpl();
//    static FootballerServiceImpl footballerServiceImpl = new FootballerServiceImpl();
//    static DecimalFormat format = new DecimalFormat("###,###,###" + " VNĐ");
//    public static ArrayList<Staff> listNVs;
//    public static void nhapDuLieuTuDong() {
//        Footballer footballer;
//        Coach coach;
//        try {
//            footballer = new Footballer(266, "CT76", "Bò Ăn Cỏ", "Viet Nam", "Nam", new SimpleDateFormat("dd/MM/yyyy").parse("28/12/1994"), new SimpleDateFormat("dd/MM/yyyy").parse("27-02-2018"), "Hậu vệ", 12, 23, 45750000);
////            footballerServiceImpl.addFootballerItem(footballer);
//            listNVs.add(footballer);
//            Footballer footballer1 = new Footballer(277, "CT72", "Cục Than Đen Thui", "Lao", "Nam", new SimpleDateFormat("dd/MM/yyyy").parse("09/05/1995"), new SimpleDateFormat("dd/MM/yyyy").parse("31-07-2015"), "Thủ môn", 33, 16, 65950000);
//            listNVs.add(footballer1);
//            coach = new Coach(722, "HLV06", "Anh Minh", "Hoa Ky", "Nam", new SimpleDateFormat("dd/MM/yyyy").parse("15/08/1995"), new SimpleDateFormat("dd/MM/yyyy").parse("23/12/2021"), 12, 6.5, 7005000);
//            listNVs.add(coach);
//            Coach coach1 = new Coach(466, "HLV08", "Xinh Xấu Xí", "Trung Quoc", "Nam", new SimpleDateFormat("dd/MM/yyyy").parse("30/10/2000"), new SimpleDateFormat("dd/MM/yyyy").parse("24/04/2021"), 7, 2.3, 2005000);
//            listNVs.add(coach1);
//            System.out.println("Nạp dữ liệu thành công!");
//        } catch (Exception e) {
//            System.out.println("Nạp dữ liệu thất bại!");
//        }
//    }
//}
