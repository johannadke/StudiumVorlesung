package Pogrammieren.Klausurvorbereitung.CollectionFramework;

import java.lang.reflect.Array;
import java.util.*;

public class TestKunde {
    public static void main(String[] args) {
        Kunde[] kundenArray = {new Kunde("Mustermann", "Klaus", 4711),
                                new Kunde("Beispiel", "Hans", 5180),
                                new Kunde("Mustermann", "Hilde", 4712),
                                new Kunde("Vorbild", "Theodor", 8278),
                                new Kunde("Dummy", "Jimmy", 1111) };

        TreeSet<Kunde> kundenSet = new TreeSet(Arrays.asList(kundenArray));

        System.out.println("Sortierung nach Kundennummer:");
        Iterator<Kunde> i = kundenSet.iterator();
        while (i.hasNext()){
            i.next().printKunde();
        }

        System.out.println("------------------------------------");

        Vector<Kunde> kundenVector = new Vector<>(Arrays.asList(kundenArray));
        Collections.sort(kundenVector, new KundenComparator());

        System.out.println("Sortierung nach Name:");
        Iterator<Kunde> iv = kundenVector.iterator();
        while (iv.hasNext()){
            iv.next().printKunde();
        }
    }
}
