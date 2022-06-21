package hpn.sort.sortFootballer;

import hpn.model.Footballer;

import java.util.Comparator;

public class SoLuotTranThamGiaESC implements Comparator<Footballer> {
    @Override
    public int compare(Footballer o1, Footballer o2) {
        return o2.getSoLuotTranThamGia() - o1.getSoLuotTranThamGia();
    }
}
