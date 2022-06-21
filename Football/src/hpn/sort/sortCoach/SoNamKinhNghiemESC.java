package hpn.sort.sortCoach;

import hpn.model.Coach;

import java.util.Comparator;

public class SoNamKinhNghiemESC implements Comparator<Coach> {
    @Override
    public int compare(Coach o1, Coach o2) {
        return o2.getSoNamKinhNghiem() - o1.getSoNamKinhNghiem();
    }
}
