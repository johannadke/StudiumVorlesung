package Pogrammieren.chapter8.UebungSkript;

public class AutoSitze {
    private boolean ledersitze;
    private String farbe;

    public static final String COLOR_SCHWARZ = "Schwarz";
    public static final String COLOR_WEIß = "Weiß";

    public AutoSitze(boolean bezug, String color) throws FalscheParameter{
        if(bezug && !(color == COLOR_SCHWARZ || color == COLOR_WEIß)){
            throw new FalscheParameter(color);
        } else {
            this.farbe = color;
            this.ledersitze = bezug;
        }
    }

    public String getFarbe(){
        return this.farbe;
    }

    public boolean isLedersitze(){
        return this.ledersitze;
    }
}
