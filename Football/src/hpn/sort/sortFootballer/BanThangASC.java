package hpn.sort.sortFootballer;

import hpn.model.Footballer;

import java.util.Comparator;

public class BanThangASC implements Comparator<Footballer> {
    @Override
    public int compare(Footballer o1, Footballer o2) {
        return o1.getBanThang() - o2.getBanThang();
    }
}
