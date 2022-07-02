package Pogrammieren.chapter8.UebungSkript;

public class TestAutoSitzeException {
    public static void main(String[] args) {
        try {
            AutoSitze myCar = new AutoSitze(true, "Grau");

            String mitOhne = "ohne";
            if (myCar.isLedersitze()){
                mitOhne = "mit";
            }
            System.out.println("Der Sitz wurde " + mitOhne + " Leder in der Farbe " + myCar.getFarbe() + " bezogen.");
        } catch (FalscheParameter e) {
            e.getMessage();
            System.out.println("Das Beziehen ist fehlgeschlagen");
        }

    }
}
