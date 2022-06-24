package Pogrammieren.chapter10.UebungSkript;

public class Einwohner implements Comparable<Einwohner>{
    private String name;
    private String vorname;
    private String geburtsname;
    private String eMail;
    private String anrede;
    private String familienstand;

    public Einwohner(String name, String vorname, String geburtsname, String eMail, String anrede, String familienstand){
        setName(name);
        setVorname(vorname);
        setGeburtsname(geburtsname);
        seteMail(eMail);
        setAnrede(anrede);
        setFamilienstand(familienstand);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getGeburtsname() {
        return geburtsname;
    }

    public void setGeburtsname(String geburtsname) {
        this.geburtsname = geburtsname;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getAnrede() {
        return anrede;
    }

    public void setAnrede(String anrede) {
        this.anrede = anrede;
    }

    public String getFamilienstand() {
        return familienstand;
    }

    public void setFamilienstand(String familienstand) {
        this.familienstand = familienstand;
    }

    @Override
    public int compareTo(Einwohner einwohner) {
        if (!this.getName().equals(einwohner.getName())) {
            return this.getName().compareTo(einwohner.getName()) * (-1);
        } else {
            return this.getVorname().compareTo(einwohner.getVorname()) * (-1);
        }
    }
}
