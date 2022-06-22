package hpn.view;

import hpn.model.Role;
import hpn.model.User;
import hpn.service.IUserService;
import hpn.service.Impl.UserServiceImpl;
import hpn.utils.AppUtils;

import java.util.Scanner;

public class LoginView {
    private final IUserService userService;
    private final Scanner scanner = new Scanner(System.in);
    User user = new User();

    public LoginView() {
        userService = UserServiceImpl.getInstance();
    }
    public void login() {
        boolean isRetry = false;
        System.out.print("╔══════════════════════════════════════════════════════════════╗\n" +
                "║                                                              ║\n" +
                "║                                                              ║\n" +
                "║                   | ĐĂNG NHẬP HỆ THỐNG |                     ║\n" +
                "║                                                              ║\n" +
                "║                                                              ║\n" +
                "╚══════════════════════════════════════════════════════════════╝\n");
        do {
            System.out.println("Username");
            String username = AppUtils.retryString();
            System.out.println("Mật khẩu");
            String password = AppUtils.retryString();
            user = userService.login(username, password);
            if (user == null) {
                System.out.println("Tài khoản không hợp lệ! ");
                isRetry = isRetry();
                login();
            }
            if (user.getRole()== Role.ADMIN){
                System.out.println("Bạn đã đăng nhập với quyền Admin thành công!");
                System.out.println("WELCOME TO CODEGYM FC\n");
                MainLauncher.menuOption();
            }
            else {
                System.out.println("Bạn đã đăng nhập với quyền User thành công!");
                System.out.println("WELCOME TO CODEGYM FC\n");
                MemberView.launch();
            }
        } while (isRetry);
    }

    private boolean isRetry() {
        do {
            try {
                System.out.print("╔══════════════════════════════════════════════════════════════════════╗\n" +
                        "║                                                                          ║\n" +
                        "║                          MENU                                            ║\n" +
                        "║                                                                          ║\n" +
                        "║             [1] Nhập 'y' để tiếp tục đăng nhập                           ║\n" +
                        "║             [2] Nhập 'n' để thoát khỏi chương trình                      ║\n" +
                        "║                                                                          ║\n" +
                        "╚══════════════════════════════════════════════════════════════════════════╝\n");

                System.out.print(" ⭆ ");
                String option = scanner.nextLine();
                switch (option) {
                    case "y":
                        return true;
                    case "n":
                        AppUtils.exit();
                        break;
                    default:
                        System.out.println("Chọn chức năng không đúng! Vui lòng chọn lại");
                        break;
                }

            } catch (Exception ex) {
                System.out.println("Nhập sai! vui lòng nhập lại");
                ex.printStackTrace();
            }
        } while (true);
    }
}
