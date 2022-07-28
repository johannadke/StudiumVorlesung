package Pogrammieren.Klausurvorbereitung.Probeklausur.CollectionFramework;

public class Fahrzeug {
    private String marke, kfzKz;
    private int ps;

    public Fahrzeug(String marke, String kfzKz, int ps){
        this.marke = marke;
        this.kfzKz = kfzKz;
        this.ps = ps;
    }

    public String getMarke() {
        return marke;
    }

    public String getKfzKz() {
        return kfzKz;
    }

    public int getPs() {
        return ps;
    }
}
