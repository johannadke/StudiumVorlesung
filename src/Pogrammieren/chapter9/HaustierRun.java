package Pogrammieren.chapter9;

public class HaustierRun {
    public static void main(String[] args) {
        Haustier haustier = new Haustier(35,"Hund", 1000000000000000l, 4.3);
        Haustier haustier2 = new Haustier(35,"Katze", 20000000000000000l, 4.3);

        System.out.println(haustier.getArt() + " Hash-Code: " + haustier.hashCode());
        System.out.println(haustier.getArt() + " Hash-Code Art: " + haustier.getArt().hashCode());
        System.out.println(haustier.getArt() + " Gewicht: " + haustier.getGewicht());
        System.out.println(haustier.getArt() + " Groesse: " + haustier.getGroesse());
        System.out.println(haustier.getArt() + " GroesseInt: " + haustier.getGroesseInt());
        System.out.println(haustier.getArt() + " Breite: " + haustier.getBreite());
        System.out.println(haustier.getArt() + " BreiteInt: " + haustier.getBreiteInt());
        System.out.println(haustier2.getArt() + " Hash-Code: " + haustier2.hashCode());
        System.out.println(haustier2.getArt() + " Hash-Code Art: " + haustier2.getArt().hashCode());
        System.out.println(haustier2.getArt() + " Gewicht: " + haustier2.getGewicht());
        System.out.println(haustier2.getArt() + " Groesse: " + haustier2.getGroesse());
        System.out.println(haustier2.getArt() + " GroesseInt: " + haustier2.getGroesseInt());
        System.out.println(haustier2.getArt() + " Breite: " + haustier2.getBreite());
        System.out.println(haustier2.getArt() + " BreiteInt: " + haustier2.getBreiteInt());
    }
}
