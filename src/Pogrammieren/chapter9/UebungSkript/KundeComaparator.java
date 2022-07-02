package Pogrammieren.chapter9.UebungSkript;

import java.util.Comparator;

public class KundeComaparator implements Comparator<Kunde> {

    @Override
    public int compare(Kunde o1, Kunde o2) {
          if (!o1.getName().equals(o2.getName())) {
            return o1.getName().compareTo(o2.getName());
        } else {
            return o1.getVorname().compareTo(o2.getVorname());
        }

    }
}
