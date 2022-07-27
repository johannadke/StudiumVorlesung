package Pogrammieren.Klausurvorbereitung.CollectionFramework;

public class Kunde implements Comparable<Kunde>{
    private String name;
    private String vorname;
    private int kundenNummer;

    public Kunde(String name, String vorname, int number){
        setName(name);
        setVorname(vorname);
        setKundenNummer(number);
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setVorname(String vorname){
        this.vorname = vorname;
    }

    public String getVorname(){
        return this.vorname;
    }

    public void setKundenNummer(int nummer){
        this.kundenNummer = nummer;
    }

    public int getKundenNummer(){
        return this.kundenNummer;
    }

    @Override
    public int compareTo(Kunde o) {
        return this.getKundenNummer() - o.getKundenNummer();
    }

    public boolean equals(Kunde k){
        //Alias-Check
        if(this == k){
            return true;
        }

        //Null-Check
        if(k == null){
            return false;
        }

        //Typverträglichkeit
        if(!this.getClass().equals(k.getClass())){
            return false;
        }

        //Feldvergleich
        if(!this.getName().equals(k.getName())){
            return false;
        }

        if(!this.getVorname().equals(k.getVorname())){
            return false;
        }

        if(this.getKundenNummer() != k.getKundenNummer()){
            return false;
        }

        return true;
    }

    public int hashCode(){
        int hc = 5;
        int hcMultiplier = 13;
        return hc * hcMultiplier + this.getName().hashCode() ^ this.getVorname().hashCode() ^ this.getKundenNummer();
    }

    public void printKunde(){
        System.out.println(this.getName() + ", " + this.getVorname() + ": " + this.getKundenNummer());
    }
}
