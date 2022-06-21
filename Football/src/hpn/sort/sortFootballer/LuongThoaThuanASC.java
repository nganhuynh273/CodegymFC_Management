package hpn.sort.sortFootballer;

import hpn.model.Footballer;

import java.util.Comparator;

public class LuongThoaThuanASC implements Comparator<Footballer> {
    @Override
    public int compare(Footballer o1, Footballer o2) {
        if(o1.getLuongThoaThuan() > o2.getLuongThoaThuan()){
            return 1;
        }else if(o1.getLuongThoaThuan() == o2.getLuongThoaThuan()){
            return 0;
        }else{
            return -1;
        }
    }
}
