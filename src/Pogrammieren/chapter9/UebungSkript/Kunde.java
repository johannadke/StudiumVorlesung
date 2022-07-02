package Pogrammieren.chapter9.UebungSkript;

public class Kunde implements Comparable<Kunde>{
    private String name;
    private String vorname;
    private int kundenNummer;

    public Kunde(String name, String vorname, int nummer){
        this.setName(name);
        this.setVorname(vorname);
        this.setKundeNummer(nummer);
    }

    public void printKunde(){
        System.out.println(this.getVorname() + " " + this.getName() + ": " + this.getKundenNummer());
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

    public void setKundeNummer(int nummer){
        this.kundenNummer = nummer;
    }

    public int getKundenNummer(){
        return this.kundenNummer;
    }

    @Override
    public int compareTo(Kunde o) {
        return this.getKundenNummer() - o.kundenNummer;
    }

    public boolean equals(Kunde o){
        if (this.getKundenNummer() == o.getKundenNummer() //|| this.getName() == o.getName() || this.getVorname() == o.getVorname()
        ){
            return true;
        }
        return false;
    }

    public int hashCode(){
        return this.getKundenNummer(); //.hashCode()
    }
}
