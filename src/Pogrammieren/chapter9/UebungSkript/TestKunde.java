package Pogrammieren.chapter9.UebungSkript;

import java.util.Iterator;
import java.util.TreeSet;
import java.util.Vector;

public class TestKunde {
    public static void main(String[] args) {
        Kunde kunde1 = new Kunde("Mustermann", "Klaus", 4711);
        Kunde kunde2 = new Kunde("Beispiel", "Hans", 5180);
        Kunde kunde3 = new Kunde("Mustermann", "Hilde", 4712);
        Kunde kunde4 = new Kunde("Vorbild", "Theodor", 8278);
        Kunde kunde5 = new Kunde("Dummy", "Jimmy", 1111);

        TreeSet<Kunde> myTreeSet = new TreeSet<>();

        myTreeSet.add(kunde1);
        myTreeSet.add(kunde2);
        myTreeSet.add(kunde3);
        myTreeSet.add(kunde4);
        myTreeSet.add(kunde5);

        Iterator<Kunde> i = myTreeSet.iterator();
        while (i.hasNext()){
            i.next().printKunde();
        }

        System.out.println("---------------------------------");

        Vector myVector = new Vector(myTreeSet);
        myVector.sort(new KundeComaparator());

        Iterator<Kunde> iv = myVector.iterator();
        while (iv.hasNext()){
            iv.next().printKunde();
        }
    }
}
