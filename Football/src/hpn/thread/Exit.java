package hpn.thread;

public class Exit implements Runnable {
    public static final String E1 = "ex1";
    public static final String E2 = "ex2";
    public static final String E3 = "ex3";
    public static final String E4 = "ex4";
    public static final String E5 = "ex5";
    public void exit() {
        String[] string = {
                "☪ ☪ ☪ ☪ ☪ ☪ ☪ ☪ ☪ ☪ ☪ ☪ ☪ ☪ ☪ ☪",
                "☪           Have a nice day!         ☪",
                "☪------------------------------------☪",
                "☪                                    ☪",
                "☪   CÙNG CODEGYM VƯƠN TẦM THẾ GIỚI   ☪",
                "☪                                    ☪",
                "☪ ☪ ☪ ☪ ☪ ☪ ☪ ☪ ☪ ☪ ☪ ☪ ☪ ☪ ☪ ☪",
        };
        for (int i = 0; i < string.length; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(string[i]);
        }
        System.exit(0);
        return;
    }

    @Override
    public void run() {

    }
}
