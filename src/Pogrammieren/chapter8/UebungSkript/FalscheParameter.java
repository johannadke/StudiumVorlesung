package Pogrammieren.chapter8.UebungSkript;

public class FalscheParameter extends Exception{
    String color;
    public FalscheParameter(String color){
        this.color = color;
    }

    @Override
    public String getMessage() {
        String message = "Der Autositz mit Lederbezug ist nicht in der Farbe " + this.color + " erhältlich. " +
                "\nDer Lederbezug ist nur in " + AutoSitze.COLOR_SCHWARZ +
                " oder " + AutoSitze.COLOR_WEIß + " erhätlich.";
        System.out.println(message);
        return message;
    }
}
