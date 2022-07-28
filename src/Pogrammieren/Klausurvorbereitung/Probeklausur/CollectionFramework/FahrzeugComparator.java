package Pogrammieren.Klausurvorbereitung.Probeklausur.CollectionFramework;

import java.util.Comparator;

public class FahrzeugComparator implements Comparator<Fahrzeug> {
    @Override
    public int compare(Fahrzeug o1, Fahrzeug o2) {
        if(o1.getPs() != o2.getPs()){
            return o1.getPs() - o2.getPs();
        } else if(!o1.getMarke().equals(o2.getMarke())){
            return o1.getMarke().compareTo(o2.getMarke());
        } else {
            return o1.getKfzKz().compareTo(o2.getKfzKz());
        }

    }
}
