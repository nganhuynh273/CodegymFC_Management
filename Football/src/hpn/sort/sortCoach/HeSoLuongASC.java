package hpn.sort.sortCoach;

import hpn.model.Coach;

import java.util.Comparator;

public class HeSoLuongASC implements Comparator<Coach> {
    @Override
    public int compare(Coach o1, Coach o2) {
        if(o1.getHeSoLuong() > o2.getHeSoLuong()){
            return 1;
        }else if(o1.getHeSoLuong() == o2.getHeSoLuong()){
            return 0;
        }else{
            return -1;
        }
    }
}
