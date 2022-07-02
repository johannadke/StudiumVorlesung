package Pogrammieren.chapter9.UebungSkript;

public class TestVergleichKunde {
    public static void main(String[] args) {
        Kunde originalKunde = new Kunde("Beispiel", "Hans", 5180);
        Kunde clonedKunde = new Kunde("Beispiel", "Hans", 5180);

        System.out.println("Kunde 1 = Kunde 2 ? " + originalKunde.compareTo(clonedKunde));
        System.out.println("Kunde 1 = Kunde 2 ? " + originalKunde.equals(clonedKunde));
        System.out.println("Kunde 1 HashCode: " + originalKunde.hashCode());
        System.out.println("Kunde 1 HashCode: " + clonedKunde.hashCode());
    }
}
