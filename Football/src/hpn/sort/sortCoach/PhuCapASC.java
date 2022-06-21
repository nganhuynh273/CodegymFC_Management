package hpn.sort.sortCoach;

import hpn.model.Coach;

import java.util.Comparator;

public class PhuCapASC implements Comparator<Coach> {
    @Override
    public int compare(Coach o1, Coach o2) {
        if(o1.getPhuCap() > o2.getPhuCap()){
            return 1;
        }else if(o1.getPhuCap() == o2.getPhuCap()){
            return 0;
        }else{
            return -1;
        }
    }
}
