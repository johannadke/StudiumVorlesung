package Pogrammieren.Klausurvorbereitung.Probeklausur.Datenstrukturen;

public class TreeRun {
    public static void main(String[] args) {
        Tree baum = new Tree();

        baum.insert("1");
        baum.insert("2");
        baum.insert("3");
        baum.insert("4");
        baum.insert("5");


        baum.toString();
        System.out.println(baum.toString());
    }
}
