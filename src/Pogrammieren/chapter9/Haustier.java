package Pogrammieren.chapter9;

public class Haustier {
    private int gewicht;
    private String art;
    private long groesse;
    private double breite;

    Haustier(int gewicht, String art, long groesse, double breite){
        this.art = art;
        this.gewicht = gewicht;
        this.groesse = groesse;
        this.breite = breite;
    }

    public int getGewicht(){
        return this.gewicht;
    }

    public String getArt(){
        return this.art;
    }

    public long getGroesse(){
        return this.groesse;
    }

    public int getGroesseInt(){
        int groesseInt = (int) (this.getGroesse()>>>32) ^ (int) (this.getGroesse() & 0xFFFFFFFF);
        return groesseInt;
    }

    public double getBreite() {
        return breite;
    }

    public int getBreiteInt(){
        long breiteLong = ((this.getBreite() == 0.0) ? 0L : Double.doubleToLongBits(this.getBreite()));
        int breiteInt = (int) (breiteLong>>>32) ^ (int) (breiteLong & 0xFFFFFFFF);
        return breiteInt;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o){
            return false;
        }
        //Null
        if(o == null){
            return false;
        }
        //Typverträglichkeit
        if(this.getClass() != o.getClass()){
            return false;
        }
        //Attribute
        if(this.getArt() != ((Haustier) o).getArt()){
            return false;
        }
        if(this.getGewicht() != ((Haustier) o).getGewicht()){
            return false;
        }
        if(this.getGroesse() != (((Haustier) o).getGroesse())){
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        //int groesseInt = (int) (this.getGroesse()>>>32) ^ (int) (this.getGroesse() & 0xFFFFFFFF);
        //int breiteInt = 0; //------------------------------------
        return this.getArt().hashCode() ^ this.getGewicht() ^ this.getGroesseInt() ^ this.getBreiteInt();
    }
}
