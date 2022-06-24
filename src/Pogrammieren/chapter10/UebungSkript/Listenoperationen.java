package Pogrammieren.chapter10.UebungSkript;

import java.util.Iterator;
import java.util.TreeSet;

public class Listenoperationen {
    private TreeSet<Einwohner> liste = new TreeSet<>();

    private Einwohner ermittleObjekt(String name, String vorname){
        /*Einwohner einwohner = new Einwohner("name")
        liste.contains()*/
        Iterator<Einwohner> einwohnerIterator = liste.iterator();
        while(einwohnerIterator.hasNext()){
            Einwohner aktuellerEinwohner = einwohnerIterator.next(); // ersten beiden werden nicht mitenander verglichen
           if(aktuellerEinwohner.getName().equals(name) && aktuellerEinwohner.getVorname().equals(vorname)){
               return aktuellerEinwohner;
           }
        }
        return null;
    }

    public  boolean hinzufuegen(String anrede, String name, String vorname, String geburtsname, String eMail, String familienstand){
        return liste.add(new Einwohner(name, vorname, geburtsname, eMail, anrede, familienstand));
    }

    public boolean anzeigen(String name, String vorname){
        Einwohner einwohner = ermittleObjekt(name, vorname); //??????????????????????
        if(einwohner != null) {
            System.out.println(einwohner.getAnrede() + " " + vorname + " " + name + " "
                    + " geb. " + einwohner.getGeburtsname() + ", Familienstand: " + einwohner.getFamilienstand()
                    + ", EMail: " + einwohner.geteMail());
            return true;
        } else {
            return false;
        }
    }

    public boolean suchen(String name, String vorname){
        if(ermittleObjekt(name, vorname) != null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean loeschen(String name, String vorname){
        Einwohner einwohner = ermittleObjekt(name, vorname);
        if(einwohner != null){
            return liste.remove(einwohner);
        } else {
            return false;
        }
    }

    public void listeAusgeben(){
        Iterator<Einwohner> i = liste.iterator();
        while (i.hasNext()){
            Einwohner einwohner = i.next();
            System.out.println(einwohner.getAnrede() + " " + einwohner.getVorname() + " " + einwohner.getName() + " "
                    + " geb. " + einwohner.getGeburtsname() + ", Familienstand: " + einwohner.getFamilienstand()
                    + ", EMail: " + einwohner.geteMail());
        }
    }
}
