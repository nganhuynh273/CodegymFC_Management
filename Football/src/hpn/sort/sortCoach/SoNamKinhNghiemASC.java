package hpn.sort.sortCoach;

import hpn.model.Coach;

import java.util.Comparator;

public class SoNamKinhNghiemASC implements Comparator<Coach> {
    @Override
    public int compare(Coach o1, Coach o2) {
        return o1.getSoNamKinhNghiem() - o2.getSoNamKinhNghiem();
    }
}
