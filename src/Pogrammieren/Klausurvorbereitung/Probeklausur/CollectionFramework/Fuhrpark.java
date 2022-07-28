package Pogrammieren.Klausurvorbereitung.Probeklausur.CollectionFramework;

import java.util.Collections;
import java.util.Iterator;
import java.util.Vector;

public class Fuhrpark {
    public static void main(String[] args) {
        Vector fuhrpark = new Vector();
        Fahrzeug kfz1 = new Fahrzeug("Audi","HD-XX 246",180);
        Fahrzeug kfz2 = new Fahrzeug("BMW","MA-LU 845",170);
        Fahrzeug kfz3 = new Fahrzeug("VW","MA-BA 563",170);
        Fahrzeug kfz4 = new Fahrzeug("Saab","MOS-FK 74",90);
        fuhrpark.add(kfz1);
        fuhrpark.add(kfz2);
        fuhrpark.add(kfz3);
        fuhrpark.add(kfz4);

        Collections.sort(fuhrpark, new FahrzeugComparator());

        Iterator<Fahrzeug> i = fuhrpark.iterator();
        while (i.hasNext()) {
            Fahrzeug currentFahrzeug = i.next();
            System.out.println(currentFahrzeug.getMarke() + ", " + currentFahrzeug.getKfzKz() + ", " + currentFahrzeug.getPs() + " PS.");
        }
    }
}
