package Pogrammieren.Klausurvorbereitung.ExceptionHandling;

public class AutoSitze {
    private boolean ledersitze;
    private String farbe;

    public static final String FARBE_SCHWARZ = "Schwarz";
    public static final String FARBE_WEIß = "Weiß";

    public AutoSitze(boolean bezug, String color) throws FalscheParameter{
        if (bezug && !(color == FARBE_SCHWARZ || color == FARBE_WEIß)) {
            throw new FalscheParameter(color);
        } else {
            this.ledersitze = bezug;
            this.farbe = color;
            System.out.println("Die Autositze wurden in " + this.farbe + " bezogen.");
        }
    }

    public String getFarbe(){
        return this.farbe;
    }

    public boolean isLedersitze(){
        return this.ledersitze;
    }
}
