package Pogrammieren.Klausurvorbereitung.ExceptionHandling;

public class FalscheParameter extends Exception {
    public FalscheParameter(String farbe){
        super("Ledersitze können nicht in der Farbe " + farbe + " geliefert werden, sondern nur in "
                + AutoSitze.FARBE_SCHWARZ + " oder" +
                " in " + AutoSitze.FARBE_WEIß + " geliefert werden.");
    }
}
