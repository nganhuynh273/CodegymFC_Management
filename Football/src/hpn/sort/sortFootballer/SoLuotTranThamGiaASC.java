package hpn.sort.sortFootballer;

import hpn.model.Footballer;

import java.util.Comparator;

public class SoLuotTranThamGiaASC implements Comparator<Footballer> {
    @Override
    public int compare(Footballer o1, Footballer o2) {
        return o1.getSoLuotTranThamGia() - o2.getSoLuotTranThamGia();
    }
}
