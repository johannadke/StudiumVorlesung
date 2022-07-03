package Pogrammieren.chapter8.UebungSkript;

public class FalscheParameter extends Exception{
    public FalscheParameter(String color){
        super("Der Autositz mit Lederbezug ist nicht in der Farbe " + color + " erhältlich. " +
                "\nDer Lederbezug ist nur in " + AutoSitze.COLOR_SCHWARZ +
                " oder " + AutoSitze.COLOR_WEIß + " erhätlich.");
    }
}
