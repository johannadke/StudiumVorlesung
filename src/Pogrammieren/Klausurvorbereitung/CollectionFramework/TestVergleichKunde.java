package Pogrammieren.Klausurvorbereitung.CollectionFramework;

public class TestVergleichKunde {
    public static void main(String[] args) {
        Kunde[] kundenArray = {new Kunde("Mustermann", "Klaus", 4711),
                new Kunde("Beispiel", "Hans", 5180),
                new Kunde("Mustermann", "Hilde", 4712),
                new Kunde("Vorbild", "Theodor", 8278),
                new Kunde("Mustermann", "Hilde", 4712),
                new Kunde("Mustermann", "Hilde", 4712),
                new Kunde("Dummy", "Jimmy", 1111) };
        for(int i = 0; i < kundenArray.length - 1; i++ ){
            for(int j = i+1; j < kundenArray.length - 1; j++ ) {
                if (kundenArray[i].equals(kundenArray[j])) {
                    System.out.println("Kunden sind gleich.");
                } else {
                    System.out.println("Kunden unterscheiden sich");
                }
                System.out.println(kundenArray[i].hashCode());
                System.out.println(kundenArray[j].hashCode());
                System.out.println(kundenArray[i].compareTo(kundenArray[j]));
            }
        }

    }
}
