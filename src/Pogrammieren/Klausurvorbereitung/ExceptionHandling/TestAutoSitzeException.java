package Pogrammieren.Klausurvorbereitung.ExceptionHandling;

public class TestAutoSitzeException {
    public static void main(String[] args) {
        try{
            AutoSitze autoSitze1 = new AutoSitze(false, "rot");
            AutoSitze autoSitze = new AutoSitze(true, "rot");
        } catch (FalscheParameter p){
            System.out.println("Das Beziehen ist fehlgeschlagen!!!");
            p.printStackTrace();
        }
    }


}
